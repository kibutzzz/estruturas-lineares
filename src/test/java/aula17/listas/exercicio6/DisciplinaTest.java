package aula17.listas.exercicio6;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisciplinaTest {

    private Disciplina disciplina;

    @BeforeEach
    void setup() {
        disciplina =
                new Disciplina(
                        List.of(
                                new Aluno("Aluno 1", valueOf(6.8), valueOf(2.4)),
                                new Aluno("Aluno 2", valueOf(0.5), valueOf(8.6)),
                                new Aluno("Aluno 3", valueOf(0.0), valueOf(10)),
                                new Aluno("Aluno 4", valueOf(9.5), valueOf(9.9)),
                                new Aluno("Aluno 5", valueOf(8.2), valueOf(8.0)),
                                new Aluno("Aluno 6", valueOf(6), valueOf(7.8))));
    }

    @Test
    void shouldGetGeneralAverageCorrectly() {
        assertTrue(bigDecimalEquals(valueOf(6.475), disciplina.getMediaGeral()));
    }

    @Test
    void shouldGetGreatestAverageCorrectly() {
        assertTrue(bigDecimalEquals(valueOf(9.7), disciplina.getMaiorMedia()));
    }

    @Test
    void shouldGetLowestAverageCorrectly() {
        assertTrue(bigDecimalEquals(valueOf(4.55), disciplina.getMenorMedia()));
    }

    @Test
    void shouldGetGreatestGradeCorrectly() {
        assertTrue(bigDecimalEquals(TEN, disciplina.getMaiorNota()));
    }

    @Test
    void shouldGetLowestGradeCorrectly() {
        assertTrue(bigDecimalEquals(ZERO, disciplina.getMenorNota()));
    }

    private boolean bigDecimalEquals(BigDecimal valueA, BigDecimal valueB) {
        return valueA.compareTo(valueB) == 0;
    }
}
