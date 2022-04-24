package laboratorio2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;

import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ItemMenuTest {

    @Mock private Consumer<Mapa> consumer;
    @Mock private Mapa mapa;

    @Test
    void shouldHoldAttributesAndExecuteCorrectly() {
        final var item = new ItemMenu("descricao", consumer, mapa);

        item.executar();
        assertEquals("descricao", item.getDescricao());

        then(consumer).should().accept(mapa);
    }
}
