package aula5.arrays.e.matrizes.exercicio3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Executador {

  public static void main(String[] args) throws IOException {
    final var scanner = new Scanner(System.in);

    final var impressora = new ImpressoraTerminal();
    final var grafico = new GraficoNotas(impressora);

    String resposta = "s";
    do {
      impressora.imprimir("digite mais uma nota");

      grafico.adicionarNota(scanner.nextDouble());
      scanner.nextLine();

      impressora.imprimir("deseja adicionar mais uma nota? (s/n)");
      resposta = scanner.nextLine();
    } while ("s".equals(resposta));

    impressora.imprimir("resultado: ");

    grafico.imprimir();

  }
}
