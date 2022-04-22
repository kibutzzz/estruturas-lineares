package laboratorio2;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Assento {
    private String nome;

    public String getNome() {
        return nome;
    }

    public boolean estaOcupado() {
        return nonNull(nome);
    }

    public void reservar(String nome) {
        if (isNull(nome) || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if (estaOcupado()) {
            throw new IllegalStateException("Este assento já está ocupado por: " + this.nome);
        }

        this.nome = nome;
    }
}
