package controledeestoque;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return quantidade == produto.quantidade
                && quantidadeMinima == produto.quantidadeMinima
                && Objects.equals(codigo, produto.codigo)
                && Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, quantidade, quantidadeMinima);
    }
}
