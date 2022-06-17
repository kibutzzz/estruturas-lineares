package laboratorio5;

import java.util.Objects;

public class Chamada {

    private String numero;

    public Chamada(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    @Override
    public String toString() {
        return "Número: " + getNumero();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Chamada other = (Chamada) obj;
        return Objects.equals(numero, other.numero);
    }
}
