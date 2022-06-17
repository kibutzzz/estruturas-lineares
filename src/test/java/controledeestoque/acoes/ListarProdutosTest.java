package controledeestoque.acoes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;

import controledeestoque.Estoque;
import controledeestoque.Produto;
import laboratorio2.helper.SimpleLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListarProdutosTest {

    @InjectMocks private ListarProdutos acao;

    @Mock private SimpleLogger logger;

    @Test
    void deveMostrarQueNaoHaProdutos() {
        final var estoque = new Estoque();

        acao.accept(estoque);

        then(logger).should().imprimirLinha("Não há produtos cadastrados");
        then(logger).shouldHaveNoMoreInteractions();
    }

    @Test
    void deveMostrarTabelaDeProdutos() {

        final var estoque = new Estoque();
        estoque.adicionarProduto(new Produto("1", "Arroz", 10, 5));
        estoque.adicionarProduto(new Produto("2", "Feijão", 2, 10));

        acao.accept(estoque);

        final var order = inOrder(logger);

        then(logger)
                .should(order)
                .imprimirLinha("    Código -            Nome -       Qtd. -  Qtd. Min.");
        then(logger)
                .should(order)
                .imprimirLinha("         1 -           Arroz -         10 -          5");
        then(logger)
                .should(order)
                .imprimirLinha("         2 -          Feijão -          2 -         10");
        then(logger).shouldHaveNoMoreInteractions();
    }
}
