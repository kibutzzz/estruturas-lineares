package laboratorio6;

public class Candidato {

    private String nome;

    private int idade;

    private String partido;

    private int votos;

    public Candidato(String nome, int idade, String partido, int votos) {
        this.nome = nome;
        this.idade = idade;
        this.partido = partido;
        this.votos = votos;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getPartido() {
        return partido;
    }

    public int getVotos() {
        return votos;
    }
}
