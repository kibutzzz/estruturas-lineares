package aula5.arrays.e.matrizes.exercicio3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisaoTest {

    @Test
    void shouldCreateCorreclty() {
        final var divisao = new Divisao(10, 12);

        assertEquals(10, divisao.getLimiteInferior());
        assertEquals(12, divisao.getLimiteSuperior());
        assertEquals(0, divisao.getTotal());
    }

    @Test
    void shouldNotAllowLowerBoundaryGreaterThanUpper() {
        final var exception = assertThrows(IllegalArgumentException.class, () -> new Divisao(1, 0));

        final var expectedMessage = "Limite inferior não pode ser maior que o superior";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void shouldAllowEqualBoundaries() {
        final var divisao = new Divisao(0, 0);
        assertEquals(divisao.getLimiteInferior(), divisao.getLimiteSuperior());
    }

    @Test
    void shouldAddWhenValueIsEqualLowerBoundary() {
        final var divisao = new Divisao(0, 10);

        divisao.tentarAdicionar(0);

        assertEquals(1, divisao.getTotal());
    }

    @Test
    void shouldAddWhenValueIsBetweenBoundaries() {
        final var divisao = new Divisao(0, 10);

        divisao.tentarAdicionar(5);

        assertEquals(1, divisao.getTotal());
    }

    @Test
    void shouldAddWhenValueIsEqualUpperBoundary() {
        final var divisao = new Divisao(0, 10);

        divisao.tentarAdicionar(10);

        assertEquals(1, divisao.getTotal());
    }

    @Test
    void shouldNotAddWhenValueIsLowerThanLowerBoundary() {
        final var divisao = new Divisao(5, 10);

        divisao.tentarAdicionar(4.9);

        assertEquals(0, divisao.getTotal());
    }

    @Test
    void shouldNotAddWHenValueIsGreaterThanUpperBoundary() {
        final var divisao = new Divisao(0, 7);

        divisao.tentarAdicionar(7.1);

        assertEquals(0, divisao.getTotal());
    }
}
