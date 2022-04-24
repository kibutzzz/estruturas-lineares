package laboratorio2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doThrow;

import java.util.List;
import laboratorio2.helper.SimpleLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MenuUiTest {

    @InjectMocks private MenuUi ui;
    @Mock private List<ItemMenu> items;
    @Mock private SimpleLogger logger;
    @Mock private ItemMenu dummyMenuItem;

    @Test
    void shouldSetExitCorreclty() {

        assertFalse(ui.getSaida());

        ui.setSaida(true);

        assertTrue(ui.getSaida());
    }

    @Test
    void shouldHandleInvalidOptionCorrectly() {

        given(items.get(1)).willThrow(new IndexOutOfBoundsException());

        ui.selecionar(1);

        then(logger).should().imprimirLinha("Opcão invalida");
    }

    @Test
    void shouldHandleGenericException() {
        given(items.get(anyInt())).willReturn(dummyMenuItem);
        doThrow(new RuntimeException("Erro desconhecido")).when(dummyMenuItem).executar();

        ui.selecionar(2);

        then(logger).should().imprimirLinha("Erro desconhecido");
    }

    @Test
    void shouldShowOptionsCorrectly() {
        given(items.size()).willReturn(3);
        given(items.get(anyInt())).willReturn(dummyMenuItem);
        given(dummyMenuItem.getDescricao()).willReturn("primeiro", "segundo", "terceiro");

        ui.mostrarOpcoes();

        then(logger).should().imprimirLinha("0 - primeiro");
        then(logger).should().imprimirLinha("1 - segundo");
        then(logger).should().imprimirLinha("2 - terceiro");
    }
}
