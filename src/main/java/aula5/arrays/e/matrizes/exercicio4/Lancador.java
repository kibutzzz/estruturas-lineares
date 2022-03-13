package aula5.arrays.e.matrizes.exercicio4;

import aula5.arrays.e.matrizes.exercicio3.Impressora;

public class Lancador {

  public static final int LADOS = 6;
  private final Dado dado;
  private final Impressora impressora;

  public Lancador(Dado dado, Impressora impressora) {
    this.dado = dado;
    this.impressora = impressora;
  }

  public void gerarLancamentos(int vezes) {

    final var lancamentos = new int[LADOS];

    for(int i = 0; i < vezes; i ++) {
      lancamentos[dado.lancar() -1] ++;
    }

    impressora.imprimir("Face\tQuantidade");
    for (int i = 0; i < LADOS; i ++) {
      impressora.imprimir((i+1) + "\t" + lancamentos[i]);
    }

  }
}
