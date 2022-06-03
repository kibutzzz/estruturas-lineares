package laboratorio4;

public class Paciente implements Comparable<Paciente> {

    private String nome;

    private int idade;

    @Override
    public int compareTo(Paciente outro) {
        return outro.idade - idade;
    }

    public Paciente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
}
