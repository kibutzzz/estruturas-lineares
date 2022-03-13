package aula5.arrays.e.matrizes.exercicio3;

public class Divisao {

  public static final String MENSAGEM_LIMITES_INVALIDOS = "Limite inferior não pode ser maior que o superior";
  private final int limiteInferior;
  private final int limiteSuperior;
  private int total = 0;

  public Divisao(int limiteUnico) {
    this.limiteInferior = limiteUnico;
    this.limiteSuperior = limiteUnico;
  }

  public Divisao(int limiteInferior, int limiteSuperior) {
    if (limiteInferior > limiteSuperior) {
      throw new IllegalArgumentException(MENSAGEM_LIMITES_INVALIDOS);
    }

    this.limiteInferior = limiteInferior;
    this.limiteSuperior = limiteSuperior;
  }

  public boolean tentarAdicionar(double valor) {
    if (valor >= limiteInferior && valor <= limiteSuperior) {
      this.total++;
      return true;
    }

    return false;
  }

  public int getLimiteInferior() {
    return limiteInferior;
  }

  public int getLimiteSuperior() {
    return limiteSuperior;
  }

  public int getTotal() {
    return total;
  }
}
