package laboratorio6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UrnaTest {

    private final Urna urna = new Urna();

    @BeforeEach
    void setup() {
        urna.addCandidate(new Candidato("Lula Molusco", 70, "Arbeiter Partei", 210));
        urna.addCandidate(new Candidato("Planktonaro", 62, "Talkeys", 215));
        urna.addCandidate(new Candidato("Bob Esponja", 44, "Siri cascudo", 605));
    }

    @Test
    void shouldBeAbleToCalculateTotalVotes() {
        assertEquals(1030, urna.calculateTotalVotes());
    }

    @Test
    void shouldBeAbleToCalculateAverage() {
        assertEquals(343.333, urna.calculateAverageVotesPerCandidate(), 0.001);
    }

    @Test
    void shouldGetCorrectOldestCandidate() {
        assertEquals("Lula Molusco", urna.readOldest().getNome());
    }

    @Test
    void shouldGetCorrectYougestCandidate() {
        assertEquals("Bob Esponja", urna.readYoungest().getNome());
    }

    @Test
    void shouldGetMostVoted() {
        assertEquals("Bob Esponja", urna.readMostVoted().getNome());
    }

    @Test
    void mostVotedShouldThrowWhenNoCandidatesAreAvailable() {
        final var exception = assertThrows(IllegalStateException.class, new Urna()::readMostVoted);

        assertEquals("Nenhum candidato cadastrado", exception.getMessage());
    }

    @Test
    void shouldGetLeastVoted() {
        assertEquals("Lula Molusco", urna.readLeastVoted().getNome());
    }

    @Test
    void readLeastVotedShouldThrowWhenNoCandidatesAreAvailable() {
        final var exception = assertThrows(IllegalStateException.class, new Urna()::readLeastVoted);

        assertEquals("Nenhum candidato cadastrado", exception.getMessage());
    }

    @Test
    void readMostVotedShouldThrowWhenNoCandidatesAreAvailable() {
        final var exception = assertThrows(IllegalStateException.class, new Urna()::readMostVoted);

        assertEquals("Nenhum candidato cadastrado", exception.getMessage());
    }

    @Test
    void readYougestShouldThrowWhenNoCandidatesAreAvailable() {
        final var exception = assertThrows(IllegalStateException.class, new Urna()::readYoungest);

        assertEquals("Nenhum candidato cadastrado", exception.getMessage());
    }

    @Test
    void readOldestShouldThrowWhenNoCandidatesAreAvailable() {
        final var exception = assertThrows(IllegalStateException.class, new Urna()::readOldest);

        assertEquals("Nenhum candidato cadastrado", exception.getMessage());
    }
}
