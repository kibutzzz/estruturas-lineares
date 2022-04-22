package laboratorio2.helper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;

import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SimpleLoggerTest {

    @InjectMocks private SimpleLogger logger;

    @Mock private PrintStream printer;

    @Test
    void shouldCallPrintlnWhenImprimirLinha() {
        logger.imprimirLinha("Texto aleatorio");

        then(printer).should().println("Texto aleatorio");
    }

    @Test
    void shouldCallPrintlnWhenQuebrarLinha() {
        logger.quebrarLinha();

        then(printer).should().println();
    }

    @Test
    void shouldCallPrintWhenImprimir() {
        logger.imprimir("Outro texto");

        then(printer).should().print("Outro texto");
    }
}
