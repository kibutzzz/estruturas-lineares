package laboratorio2.acao;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;

import laboratorio2.Mapa;
import laboratorio2.helper.ExtratorDeCoordenadas;
import laboratorio2.helper.SimpleInput;
import laboratorio2.helper.SimpleLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AcaoCancelarTest {

    @InjectMocks private AcaoCancelar acaoCancelar;
    @Mock private SimpleInput input;
    @Mock private SimpleLogger logger;
    @Mock private ExtratorDeCoordenadas extratorDeCoordenadas;
    @Mock private Mapa mapa;

    @Test
    void shouldPrintAnyGenericExceptionAndExit() {
        given(input.lerLinha()).willThrow(new RuntimeException("Excecão generica"));

        acaoCancelar.accept(mapa);

        final var order = inOrder(logger, input);
        then(logger).should(order).imprimirLinha("Selecione um assento: ");
        then(logger).should(order).imprimirLinha("Erro ao selecionar o assento. Cancelando ação");

        then(logger).shouldHaveNoMoreInteractions();
        then(input).shouldHaveNoMoreInteractions();

        then(mapa).shouldHaveZeroInteractions();
        then(extratorDeCoordenadas).shouldHaveZeroInteractions();
    }

    @Test
    void shouldRetryWhenUsingAnInvalidPosition() {
        given(input.lerLinha()).willReturn("posicao invalida").willReturn("A20");
        given(extratorDeCoordenadas.extrair(anyString()))
                .willThrow(new IllegalArgumentException())
                .willReturn(new int[] {0, 19});

        acaoCancelar.accept(mapa);

        final var order = inOrder(logger, input, extratorDeCoordenadas, mapa);
        then(logger).should(order).imprimirLinha("Selecione um assento: ");
        then(input).should(order).lerLinha();
        then(extratorDeCoordenadas).should(order).extrair("posicao invalida");
        then(logger).should(order).imprimirLinha("Posicão invalida. Tente novamente");
        then(logger).should(order).imprimirLinha("Selecione um assento: ");
        then(input).should(order).lerLinha();
        then(extratorDeCoordenadas).should(order).extrair("A20");
        then(mapa).should(order).cancelar(0, 19);

        then(logger).shouldHaveNoMoreInteractions();
        then(input).shouldHaveNoMoreInteractions();
        then(mapa).shouldHaveNoMoreInteractions();
        then(extratorDeCoordenadas).shouldHaveNoMoreInteractions();
    }
}
