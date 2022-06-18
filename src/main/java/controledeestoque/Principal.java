package controledeestoque;

import controledeestoque.acoes.AdicionarProduto;
import controledeestoque.acoes.AlterarQuantidade;
import controledeestoque.acoes.ItemDeMenu;
import controledeestoque.acoes.ListarProdutos;
import controledeestoque.acoes.ListarProdutosAbaixoMinimo;
import controledeestoque.acoes.Sair;
import laboratorio2.helper.SimpleInput;
import laboratorio2.helper.SimpleLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

  public static void main(String[] args) {
    final var logger = new SimpleLogger(System.out);
    final var input = new SimpleInput(new Scanner(System.in));

    final var estoque = new Estoque();

    final var acoes = new ArrayList<ItemDeMenu<Estoque>>();
    acoes.add(new AdicionarProduto(input, logger));
    acoes.add(new AlterarQuantidade(logger, input));
    acoes.add(new ListarProdutos(logger));
    acoes.add(new ListarProdutosAbaixoMinimo(logger));

    final var ui = new Ui<>(acoes, logger, input, estoque);
    acoes.add(new Sair(ui));

    ui.executar();
  }
}
