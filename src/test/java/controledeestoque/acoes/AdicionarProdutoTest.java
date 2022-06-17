package controledeestoque.acoes;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.inOrder;

import controledeestoque.Estoque;
import controledeestoque.Produto;
import laboratorio2.helper.SimpleInput;
import laboratorio2.helper.SimpleLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AdicionarProdutoTest {

    @InjectMocks private AdicionarProduto acao;

    @Mock private SimpleLogger logger;
    @Mock private SimpleInput input;
    @Spy private Estoque estoque;

    @Test
    void deveAdicionarProduto() {

        given(input.lerLinha()).willReturn("nome", "codigo");
        given(input.lerInteiro()).willReturn(1, 2);

        acao.accept(estoque);

        final var order = inOrder(logger, input, estoque);

        then(logger).should(order).imprimirLinha("Digite o nome do produto");
        then(input).should(order).lerLinha();
        then(logger).should(order).imprimirLinha("Digite a quantidade em estoque do produto");
        then(input).should(order).lerInteiro();
        then(logger).should(order).imprimirLinha("Digite a quantidade minima do produto");
        then(input).should(order).lerInteiro();
        then(logger).should(order).imprimirLinha("Digite o codigo do produto");
        then(input).should(order).lerLinha();
        then(estoque).should(order).adicionarProduto(new Produto("codigo", "nome", 1, 2));
    }

    @Test
    void deveTentarNovamenteQuandoArgumentosInvalidos() {

        given(input.lerLinha()).willReturn("nome", "invalido", "produto", "codigo");
        given(input.lerInteiro()).willReturn(0, 0, 1, 2);

        willThrow(new IllegalArgumentException("Invalido"))
                .given(estoque)
                .adicionarProduto(new Produto("invalido", "nome", 0, 0));

        acao.accept(estoque);

        final var order = inOrder(logger, input, estoque);

        then(logger).should(order).imprimirLinha("Digite o nome do produto");
        then(input).should(order).lerLinha();
        then(logger).should(order).imprimirLinha("Digite a quantidade em estoque do produto");
        then(input).should(order).lerInteiro();
        then(logger).should(order).imprimirLinha("Digite a quantidade minima do produto");
        then(input).should(order).lerInteiro();
        then(logger).should(order).imprimirLinha("Digite o codigo do produto");
        then(input).should(order).lerLinha();
        then(estoque).should(order).adicionarProduto(new Produto("invalido", "nome", 0, 0));

        then(logger).should(order).imprimirLinha("produto invalido: Invalido");
        then(logger).should(order).imprimirLinha("Tente novamente: ");

        then(logger).should(order).imprimirLinha("Digite o nome do produto");
        then(input).should(order).lerLinha();
        then(logger).should(order).imprimirLinha("Digite a quantidade em estoque do produto");
        then(input).should(order).lerInteiro();
        then(logger).should(order).imprimirLinha("Digite a quantidade minima do produto");
        then(input).should(order).lerInteiro();
        then(logger).should(order).imprimirLinha("Digite o codigo do produto");
        then(input).should(order).lerLinha();
        then(estoque).should(order).adicionarProduto(new Produto("codigo", "produto", 1, 2));
    }
}
