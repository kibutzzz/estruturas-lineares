package controledeestoque.acoes;

import controledeestoque.Estoque;
import laboratorio2.helper.SimpleInput;
import laboratorio2.helper.SimpleLogger;

public class AdicionarQuantidade implements ItemDeMenu<Estoque> {

  private SimpleLogger logger;
  private SimpleInput input;

  public AdicionarQuantidade(SimpleLogger logger, SimpleInput input) {
    this.logger = logger;
    this.input = input;
  }

  @Override
  public String getNome() {
    return "Adicionar quantidade a um produto existente";
  }

  @Override
  public void accept(Estoque estoque) {

    logger.imprimirLinha("Digite o codigo do produto: ");
    final var codigo = input.lerLinha();

    logger.imprimirLinha("Digite a quantidade do produto: ");
    final var quantidade = input.lerInteiro();

    estoque.alterarQuantidadeDeProduto(codigo, quantidade);

  }
}
