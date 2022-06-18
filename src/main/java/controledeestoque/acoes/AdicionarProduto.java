package controledeestoque.acoes;

import controledeestoque.Estoque;
import controledeestoque.Produto;
import laboratorio2.helper.SimpleInput;
import laboratorio2.helper.SimpleLogger;

public class AdicionarProduto implements ItemDeMenu<Estoque> {
    private SimpleInput input;
    private SimpleLogger logger;

    public AdicionarProduto(SimpleInput input, SimpleLogger logger) {
        this.input = input;
        this.logger = logger;
    }

    @Override
    public String getNome() {
        return "Adicionar Produto";
    }

    @Override
    public void accept(Estoque estoque) {

        logger.imprimirLinha("Digite o nome do produto");
        final var nome = input.lerLinha();
        logger.imprimirLinha("Digite a quantidade em estoque do produto");
        final var quantidade = input.lerInteiro();
        logger.imprimirLinha("Digite a quantidade minima do produto");
        final var quantidadeMinima = input.lerInteiro();
        logger.imprimirLinha("Digite o codigo do produto");
        final var codigo = input.lerLinha();

        try {
            estoque.adicionarProduto(new Produto(codigo, nome, quantidade, quantidadeMinima));
        } catch (IllegalArgumentException e) {
            logger.imprimirLinha("produto invalido: " + e.getMessage());
            logger.imprimirLinha("Tente novamente: ");
            accept(estoque);
        }
    }
}
