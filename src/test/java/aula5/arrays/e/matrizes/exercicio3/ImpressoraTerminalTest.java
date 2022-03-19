package aula5.arrays.e.matrizes.exercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImpressoraTerminalTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void shouldPrintOnTheTerminal() {
        final var impressoraTerminal = new ImpressoraTerminal();
        impressoraTerminal.imprimir("valor");
        impressoraTerminal.imprimir("outro valor");

        assertEquals("valor\noutro valor\n", outputStreamCaptor.toString());
    }
}
