package laboratorio2.acao;

import static org.mockito.BDDMockito.then;

import laboratorio2.Mapa;
import laboratorio2.helper.SimpleLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AcaoMostrarTest {

    @InjectMocks private AcaoMostrar acaoMostrar;
    @Mock private Mapa mapa;
    @Mock private SimpleLogger logger;

    @Test
    void shouldDelegateToMapa() {
        acaoMostrar.accept(mapa);

        final var order = Mockito.inOrder(logger, mapa);

        then(logger).should(order).imprimirLinha("Assentos da sala:");
        then(mapa).should(order).mostrar();
    }
}
