package controledeestoque;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class EstoqueTest {

    private Estoque estoque = new Estoque();

    @Test
    void naoDeveAdicionarProdutosNulo() {
        final var exception =
                assertThrows(IllegalArgumentException.class, () -> estoque.adicionarProduto(null));

        assertEquals("Produto não pode ser nulo", exception.getMessage());
        assertEquals(emptyList(), estoque.listarProdutos());
    }

    @Test
    void naoDeveAdicionarProdutoComCodigoRepetido() {
        final var batata = new Produto("1", "Batata", 10, 10);
        final var feijao = new Produto("1", "Feijão", 20, 10);

        estoque.adicionarProduto(batata);
        final var exception =
                assertThrows(
                        IllegalArgumentException.class, () -> estoque.adicionarProduto(feijao));

        assertEquals("Já existe um produto cadastrado com este código", exception.getMessage());
        assertEquals(List.of(batata), estoque.listarProdutos());
    }

    @Test
    void naoDevePoderAlterarQuantidadeParaMenosQueZero() {
        final var batata = new Produto("1", "Batata", 10, 10);

        estoque.adicionarProduto(batata);
        final var exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> estoque.alterarQuantidadeDeProduto("1", -1));

        assertEquals("Não é possivel alterar quantidade para -1", exception.getMessage());
        assertEquals(10, batata.getQuantidade());
    }

    @Test
    void devePoderAlterarQuantidadeParaZero() {
        final var batata = new Produto("1", "Batata", 10, 10);

        estoque.adicionarProduto(batata);
        estoque.alterarQuantidadeDeProduto("1", 0);

        assertEquals(0, batata.getQuantidade());
    }

    @Test
    void devePoderAlterarQuantidadeParaMaisQueZero() {
        var batata = new Produto("1", "Batata", 10, 10);

        estoque.adicionarProduto(batata);
        estoque.alterarQuantidadeDeProduto("1", 1);

        assertEquals(1, batata.getQuantidade());
    }

    @Test
    void deveListarApenasProdutosAbaixoDoMinimo() {
        final var batata = new Produto("1", "Batata", 10, 10);
        final var arroz = new Produto("2", "Arroz", 5, 10);
        final var feijao = new Produto("112", "Feijão", 20, 10);

        estoque.adicionarProduto(batata);
        estoque.adicionarProduto(arroz);
        estoque.adicionarProduto(feijao);

        assertEquals(List.of(arroz), estoque.listarProdutosAbaixoMinimo());
    }
}
