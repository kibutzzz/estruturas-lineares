package laboratorio2.helper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExtratorDeCoordenadasTest {

    @InjectMocks private ExtratorDeCoordenadas extrator;

    @Test
    void shouldBeAbleToExtractWellFormedPosition() {
        final var coordinates = extrator.extrair("A12");

        assertArrayEquals(makeExpected(0, 11), coordinates);
    }

    @Test
    void shouldBeAbleToExtractAnotheraWellFormedPosition() {
        final var coordinates = extrator.extrair("H2");

        assertArrayEquals(makeExpected(7, 1), coordinates);
    }

    @Test()
    void shouldThrowExceptionForMultipleLetters() {
        final var exception =
                assertThrows(IllegalArgumentException.class, () -> extrator.extrair("AB1"));

        assertEquals("Posição invalida", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForEmptyPosition() {
        final var exception =
                assertThrows(IllegalArgumentException.class, () -> extrator.extrair(""));

        assertEquals("Posição invalida", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullPosition() {
        final var exception =
                assertThrows(IllegalArgumentException.class, () -> extrator.extrair(null));

        assertEquals("Posição invalida", exception.getMessage());
    }

    private int[] makeExpected(int line, int column) {
        return new int[] {line, column};
    }
}
