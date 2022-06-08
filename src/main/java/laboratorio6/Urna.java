package laboratorio6;

import static java.util.Comparator.comparingInt;

import java.util.ArrayList;
import java.util.List;

public class Urna {

    public static final String NO_CANDIDATES_MESSAGE = "Nenhum candidato cadastrado";
    private List<Candidato> candidatos = new ArrayList<>();

    public void addCandidate(Candidato candidato) {
        candidatos.add(candidato);
    }

    public Candidato readMostVoted() {
        return candidatos.stream()
                .max(comparingInt(Candidato::getVotos))
                .orElseThrow(() -> new IllegalStateException(NO_CANDIDATES_MESSAGE));
    }

    public Candidato readLeastVoted() {
        return candidatos.stream()
                .min(comparingInt(Candidato::getVotos))
                .orElseThrow(() -> new IllegalStateException(NO_CANDIDATES_MESSAGE));
    }

    public Candidato readOldest() {
        return candidatos.stream()
                .max(comparingInt(Candidato::getIdade))
                .orElseThrow(() -> new IllegalStateException(NO_CANDIDATES_MESSAGE));
    }

    public Candidato readYoungest() {
        return candidatos.stream()
                .min(comparingInt(Candidato::getIdade))
                .orElseThrow(() -> new IllegalStateException(NO_CANDIDATES_MESSAGE));
    }

    public Integer calculateTotalVotes() {
        return candidatos.stream().map(Candidato::getVotos).reduce(0, Integer::sum);
    }

    public Double calculateAverageVotesPerCandidate() {
        return this.calculateTotalVotes() / (double) this.candidatos.size();
    }
}
