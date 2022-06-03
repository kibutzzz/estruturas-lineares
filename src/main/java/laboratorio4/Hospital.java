package laboratorio4;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import laboratorio2.helper.SimpleLogger;

public class Hospital {

    private SimpleLogger logger;

    private Queue<Paciente> filaDeVacinacao = new PriorityQueue<>();

    private List<Paciente> pacientesVacinados = new ArrayList<>();

    public Hospital(SimpleLogger logger) {
        this.logger = logger;
    }

    public void adicionarPaciente(Paciente paciente) {
        filaDeVacinacao.add(paciente);
    }

    public void vacinarProximo() {
        final var pacienteVacinado = filaDeVacinacao.poll();
        if (isNull(pacienteVacinado)) {
            throw new IllegalStateException("Fila vazia! Não há pacientes para vacinar");
        }
        pacientesVacinados.add(pacienteVacinado);
    }

    public void mostrarFilaDeVacinacao() {
        filaDeVacinacao.forEach(paciente -> logger.imprimirLinha(paciente.getNome()));
    }

    public void mostrarVacinados() {
        pacientesVacinados.forEach(paciente -> logger.imprimirLinha(paciente.getNome()));
    }
}
