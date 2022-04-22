package laboratorio2.acao;

import static org.mockito.BDDMockito.then;

import laboratorio2.Mapa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AcaoMostrarTest {

    @InjectMocks private AcaoMostrar acaoMostrar;
    @Mock private Mapa mapa;

    @Test
    void shouldDelegateToMapa() {
        acaoMostrar.accept(mapa);

        then(mapa).should().mostrar();
    }
}
