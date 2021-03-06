package controledeestoque.acoes;

import static java.lang.String.format;

import controledeestoque.Estoque;
import laboratorio2.helper.SimpleLogger;

public class ListarProdutos implements ItemDeMenu<Estoque> {

    public static final String FORMATO_IMPRESSAO = "%10s - %15s - %10s - %10s";
    private SimpleLogger logger;

    public ListarProdutos(SimpleLogger logger) {
        this.logger = logger;
    }

    @Override
    public void accept(Estoque estoque) {
        final var produtos = estoque.listarProdutos();

        if (produtos.isEmpty()) {
            logger.imprimirLinha("Não há produtos cadastrados");
            return;
        }

        logger.imprimirLinha(format(FORMATO_IMPRESSAO, "Código", "Nome", "Qtd.", "Qtd. Min."));
        produtos.forEach(
                produto ->
                        logger.imprimirLinha(
                                format(
                                        FORMATO_IMPRESSAO,
                                        produto.getCodigo(),
                                        produto.getNome(),
                                        produto.getQuantidade(),
                                        produto.getQuantidadeMinima())));
    }

    @Override
    public String getNome() {
        return "Listar produtos";
    }
}
