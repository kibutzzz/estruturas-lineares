package laboratorio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssentoTest {

    @Test
    void shouldCreateCorrectly() {
        final var assento = new Assento();
        assertNull(assento.getNome());
    }

    @Test
    void shouldBeAbleToMakeReservationWhenEmpty() {
        final var assento = new Assento();

        assento.reservar("Nome da pessoa");

        assertEquals("Nome da pessoa", assento.getNome());
        assertTrue(assento.estaOcupado());
    }

    @Test
    void shouldNotBeAbleToMakeReservationWhenOccupied() {
        final var assento = new Assento();

        assento.reservar("Primeiro a reservar");

        final var exception =
                assertThrows(IllegalStateException.class, () -> assento.reservar("Segunda pessoa"));

        assertEquals(
                "Este assento já está ocupado por: Primeiro a reservar", exception.getMessage());

        assertEquals("Primeiro a reservar", assento.getNome());
    }

    @Test
    void shouldNotBeAbleToMakeReservationWithEmptyName() {
        final var assento = new Assento();

        final var exception =
                assertThrows(IllegalArgumentException.class, () -> assento.reservar(""));

        assertEquals("Nome não pode ser vazio", exception.getMessage());
        assertFalse(assento.estaOcupado());
    }
}
