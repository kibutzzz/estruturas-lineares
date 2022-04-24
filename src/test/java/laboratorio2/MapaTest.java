package laboratorio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;

import laboratorio2.helper.SimpleLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MapaTest {

    @Mock private SimpleLogger logger;
    private Mapa mapa;

    @BeforeEach
    void setup() {
        mapa = new Mapa(logger, 2, 2);
    }

    @Test
    void shouldShowEmptyMapCorrectly() {
        mapa.mostrar();

        final var order = inOrder(logger);
        then(logger).should(order, times(1)).imprimirLinha("            1\t            2\t");
        then(logger).should(order).imprimir("  A ");
        then(logger).should(order, times(2)).imprimir("[            ]\t");
        then(logger).should(order).imprimirLinha("");
        then(logger).should(order).imprimir("  B ");
        then(logger).should(order, times(2)).imprimir("[            ]\t");
    }

    @Test
    void shouldThrowExceptionWhenSizeIsInvalid() {
        final var verticalException =
                assertThrows(IllegalArgumentException.class, () -> new Mapa(logger, 0, 1));
        final var horizontalException =
                assertThrows(IllegalArgumentException.class, () -> new Mapa(logger, 1, 0));

        assertEquals("Tamanho deve ser maior que 0", verticalException.getMessage());
        assertEquals("Tamanho deve ser maior que 0", horizontalException.getMessage());
    }

    @Test
    void shouldBeAbleToReserve() {
        mapa.reservar("Bianca", 1, 1);
        mapa.reservar("Leonardo", 0, 0);

        mapa.mostrar();

        final var order = inOrder(logger);
        then(logger).should(order).imprimir("[    Leonardo]\t");
        then(logger).should(order).imprimir("[            ]\t");
        then(logger).should(order).imprimirLinha("");
        then(logger).should(order).imprimir("[            ]\t");
        then(logger).should(order).imprimir("[      Bianca]\t");
    }

    @Test
    void shouldBeAbleToCancel() {
        mapa.mostrar();
        mapa.reservar("Reserva 1", 0, 0);
        mapa.cancelar(0, 0);

        final var order = inOrder(logger);
        then(logger).should(order, times(2)).imprimir("[            ]\t");
        then(logger).should(order).imprimirLinha("");
        then(logger).should(order, times(2)).imprimir("[            ]\t");
    }

    @Test
    void shouldHandleInvalidPosition() {
        final var exception =
            assertThrows(IllegalArgumentException.class, () -> mapa.reservar("bla", 0, 3));

        assertEquals("Posição selecionada não é valida", exception.getMessage());
    }

    @Test
    void shouldCountTotalsCorrectly() {
        final var mapaGrande = new Mapa(logger, 12,14);

        mapaGrande.reservar("reservado", 4,4);
        assertEquals(167, mapaGrande.getTotalDeAssentosLivres());
        assertEquals(1, mapaGrande.getTotalDeAssentosOcupados());
    }
}
