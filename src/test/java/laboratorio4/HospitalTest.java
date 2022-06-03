package laboratorio4;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import laboratorio2.helper.SimpleLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class HospitalTest {

    @InjectMocks private Hospital hospital;

    @Mock private SimpleLogger logger;

    @Test
    void shouldNotAllowVaccinationWithoutPacients() {
        final var exception =
                assertThrows(IllegalStateException.class, () -> hospital.vacinarProximo());

        assertEquals("Fila vazia! Não há pacientes para vacinar", exception.getMessage());
    }

    @Test
    void shouldBeAbleToVaccinateWhenQueueHasPacients() {
        hospital.adicionarPaciente(new Paciente("paciente", 22));

        hospital.vacinarProximo();

        hospital.mostrarFilaDeVacinacao();
        then(logger).shouldHaveZeroInteractions();

        hospital.mostrarVacinados();
        then(logger).should().imprimirLinha("paciente");
    }

    @Test
    void shouldBeAbleToVaccinateTheElderlyFirst() {
        hospital.adicionarPaciente(new Paciente("adulto", 35));
        hospital.adicionarPaciente(new Paciente("idoso", 76));
        hospital.adicionarPaciente(new Paciente("criança", 9));

        hospital.vacinarProximo();

        hospital.mostrarFilaDeVacinacao();

        final var order = Mockito.inOrder(logger);
        then(logger).should(order).imprimirLinha("adulto");
        then(logger).should(order).imprimirLinha("criança");

        hospital.mostrarVacinados();
        then(logger).should(order).imprimirLinha("idoso");
    }
}
