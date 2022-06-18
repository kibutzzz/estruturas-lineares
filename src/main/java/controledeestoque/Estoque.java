package controledeestoque;

import static java.lang.String.format;
import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Estoque {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        if (isNull(produto)) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }

        if (existeProdutoComCodigo(produto.getCodigo())) {
            throw new IllegalArgumentException("Já existe um produto cadastrado com este código");
        }

        produtos.add(produto);
    }

    public void alterarQuantidadeDeProduto(String codigo, int novaQuantidade) {
        final var produto =
                buscarProdutoPorCodigo(codigo)
                        .orElseThrow(() -> new IllegalStateException("Produto inexistente"));

        if (novaQuantidade < 0) {
            throw new IllegalArgumentException(
                    format("Não é possivel alterar quantidade para %d", novaQuantidade));
        }

        produto.alterarQuantidade(novaQuantidade);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public List<Produto> listarProdutosAbaixoMinimo() {
        return produtos.stream().filter(porAbaixoMinimo()).collect(Collectors.toList());
    }

    private Predicate<Produto> porAbaixoMinimo() {
        return produto -> produto.getQuantidade() < produto.getQuantidadeMinima();
    }

    private Optional<Produto> buscarProdutoPorCodigo(String codigo) {
        return produtos.stream().filter(porCodigo(codigo)).findFirst();
    }

    private Predicate<Produto> porCodigo(String codigo) {
        return produto -> produto.getCodigo().equals(codigo);
    }

    private boolean existeProdutoComCodigo(String codigo) {
        return produtos.stream().anyMatch(porCodigo(codigo));
    }
}
