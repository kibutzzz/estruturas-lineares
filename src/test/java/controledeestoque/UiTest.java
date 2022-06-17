package controledeestoque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willAnswer;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.inOrder;

import controledeestoque.acoes.ItemDeMenu;
import java.util.ArrayList;
import java.util.List;
import laboratorio2.helper.SimpleInput;
import laboratorio2.helper.SimpleLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UiTest {

    @InjectMocks private Ui<Estoque> ui;

    @Spy private List<ItemDeMenu<Estoque>> acoes = new ArrayList<>();
    @Mock private SimpleLogger logger;
    @Mock private SimpleInput input;
    @Mock private Estoque modelo;

    @Mock private ItemDeMenu<Estoque> acao;

    @BeforeEach
    void setup() {
        acoes.add(acao);
    }

    @Test
    void deveSairQuandoChamarSair() {

        given(input.lerInteiro()).willReturn(0);
        given(acao.getNome()).willReturn("Opcao");
        willAnswer(
                        o -> {
                            ui.sair();
                            return null;
                        })
                .given(acao)
                .accept(any());

        ui.executar();
        final var order = inOrder(logger, input, acoes, acao);
        then(logger).should(order).imprimirLinha("Menu principal");
        then(acoes).should(order).get(0);
        then(acao).should(order).getNome();
        then(logger).should(order).imprimirLinha("0 - Opcao");
        then(input).should(order).lerInteiro();
        then(acoes).should(order).get(0);
        then(acao).should(order).accept(any());
        then(input).shouldHaveNoMoreInteractions();
        then(logger).shouldHaveNoMoreInteractions();
        then(acao).shouldHaveNoMoreInteractions();
    }

    @Test
    void deveMostrarMensagemDeExcecaoDeEstadoIlegal() {
        given(input.lerInteiro()).willReturn(0);
        given(acao.getNome()).willReturn("Opcao");
        willThrow(new IllegalStateException("mensagem"))
                .willAnswer(
                        o -> {
                            ui.sair();
                            return null;
                        })
                .given(acao)
                .accept(any());

        ui.executar();

        then(logger).should().imprimirLinha("mensagem");
    }

    @Test
    void deveMostrarMensagemDeExcecaoDeArgumentoIlegal() {
        given(input.lerInteiro()).willReturn(0);
        given(acao.getNome()).willReturn("Opcao");
        willThrow(new IllegalArgumentException("mensagem"))
                .willAnswer(
                        o -> {
                            ui.sair();
                            return null;
                        })
                .given(acao)
                .accept(any());

        ui.executar();

        then(logger).should().imprimirLinha("mensagem");
    }

    @Test
    void naoDeveTratarExcecaoGenerica() {
        given(input.lerInteiro()).willReturn(0);
        given(acao.getNome()).willReturn("Opcao");
        willThrow(new RuntimeException("mensagem")).given(acao).accept(any());

        final var exception = assertThrows(Exception.class, () -> ui.executar());

        assertEquals("mensagem", exception.getMessage());
    }
}
