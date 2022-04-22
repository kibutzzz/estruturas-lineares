package laboratorio2.acao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;

import laboratorio2.MenuUi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AcaoSairTest {

    @InjectMocks private AcaoSair acaoSair;
    @Mock private MenuUi menuUi;

    @Test
    void shouldSetSairToTrueWhenAccept() {
        acaoSair.accept(null);

        then(menuUi).should().setSaida(true);
    }
}
