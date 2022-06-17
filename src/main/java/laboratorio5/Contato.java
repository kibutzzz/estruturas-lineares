package laboratorio5;

import java.util.Objects;

public class Contato {

    private String nome;
    private String numero;

    public Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return this.nome;
    }

    public String getNumero() {
        return this.numero;
    }

    @Override
    public String toString() {
        return "Contato [nome=" + nome + ", numero=" + numero + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Contato other = (Contato) obj;
        return Objects.equals(nome, other.nome) && Objects.equals(numero, other.numero);
    }
}
