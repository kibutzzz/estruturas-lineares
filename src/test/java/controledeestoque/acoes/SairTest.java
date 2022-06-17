package controledeestoque.acoes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;

import controledeestoque.Ui;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SairTest {

    @InjectMocks private Sair acao;

    @Mock private Ui ui;

    @Test
    void deveDelegarParaUi() {

        acao.accept(null);

        then(ui).should().sair();
    }

    @Test
    void deveTerNomeCorreto() {
        assertEquals("Sair", acao.getNome());
    }
}
