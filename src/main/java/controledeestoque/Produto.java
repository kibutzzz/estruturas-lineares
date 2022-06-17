package controledeestoque;

public class Produto {

  private String codigo;
  private String nome;
  private int quantidade;
  private int quantidadeMinima;

  public Produto(String codigo, String nome, int quantidade, int quantidadeMinima) {
    this.codigo = codigo;
    this.nome = nome;
    this.quantidade = quantidade;
    this.quantidadeMinima = quantidadeMinima;
  }

  public void alterarQuantidade(int novaQuantidade) {
    this.quantidade = novaQuantidade;
  }

  public String getNome() {
    return nome;
  }

  public String getCodigo() {
    return codigo;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public int getQuantidadeMinima() {
    return quantidadeMinima;
  }
}
