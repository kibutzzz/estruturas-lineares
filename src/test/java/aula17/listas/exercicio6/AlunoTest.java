package aula17.listas.exercicio6;

import static java.math.BigDecimal.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class AlunoTest {

    @Test
    void shouldInitializeCorrectly() {
        final var aluno = new Aluno("Leonardo", ONE, TEN);

        assertAll(
                () -> assertEquals("Leonardo", aluno.getNome()),
                () -> assertEquals(ONE, aluno.getNotaGrauA()),
                () -> assertEquals(TEN, aluno.getNotaGrauB()));
    }

    @Test
    void shouldCalculateAverageCorrectly() {
        final var aluno = new Aluno("Leonardo", TEN, ONE);

        assertTrue(bigDecimalEquals(valueOf(5.5), aluno.getMedia()));
    }

    private boolean bigDecimalEquals(BigDecimal valueA, BigDecimal valueB) {
        return valueA.compareTo(valueB) == 0;
    }
}
