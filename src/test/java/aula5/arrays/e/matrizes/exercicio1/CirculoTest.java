package aula5.arrays.e.matrizes.exercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CirculoTest {

    private static final double TOLERABLE_DIFFERENCE = 0.0001;

    @Test
    void shouldCreateObjectCorrectly() {
        final var circulo = new Circulo(0, 1, 2);

        assertEquals(0, circulo.getX());
        assertEquals(1, circulo.getY());
        assertEquals(2, circulo.getRaio());
    }

    @Test
    void shouldCalculateAreaCorrectly() {
        final var circulo = new Circulo(0, 0, 3);

        assertEquals(28.2743, circulo.getArea(), TOLERABLE_DIFFERENCE);
    }

    @Test
    void shouldCalculateCircumference() {
        final var circulo = new Circulo(0, 0, 4);

        assertEquals(25.1327, circulo.getCircunferencia(), TOLERABLE_DIFFERENCE);
    }

    @Test
    void shouldConvertToStringCorrectly() {
        final var circulo = new Circulo(1, 2, 3);

        final var expected = "Circulo [x=1, y=2, raio=3.0]";
        assertEquals(expected, circulo.toString());
    }
}
