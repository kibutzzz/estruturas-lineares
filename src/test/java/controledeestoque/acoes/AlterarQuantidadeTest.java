package controledeestoque.acoes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;

import controledeestoque.Estoque;
import laboratorio2.helper.SimpleInput;
import laboratorio2.helper.SimpleLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AlterarQuantidadeTest {

    @InjectMocks private AlterarQuantidade acao;

    @Mock private SimpleLogger logger;
    @Mock private SimpleInput input;

    @Mock private Estoque estoque;

    @Test
    void deveAlterarProduto() {

        given(input.lerLinha()).willReturn("ABC");
        given(input.lerInteiro()).willReturn(1);

        acao.accept(estoque);

        final var order = inOrder(input, estoque, logger);

        then(logger).should(order).imprimirLinha("Digite o codigo do produto: ");
        then(input).should(order).lerLinha();
        then(logger).should(order).imprimirLinha("Digite a nova quantidade do produto: ");
        then(input).should(order).lerInteiro();
        then(estoque).should(order).alterarQuantidadeDeProduto("ABC", 1);
    }

    @Test
    void deveTerNomeCorreto() {
        assertEquals("Alterar quantidade de um produto existente", acao.getNome());
    }
}
