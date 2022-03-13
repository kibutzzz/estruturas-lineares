package aula5.arrays.e.matrizes.exercicio3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraficoNotasTest {

  private List<String> prints = new ArrayList<>();
  private Impressora impressora = valor -> prints.add(valor);


  @Test
  void shouldPrintEmptyGraphWhenNoNotesWereAdded() {
    final var graficoNotas = new GraficoNotas(impressora);

    graficoNotas.imprimir();

    final var expectedPrints = List.of(
        "00 - 09: ",
        "10 - 19: ",
        "20 - 29: ",
        "30 - 39: ",
        "40 - 49: ",
        "50 - 59: ",
        "60 - 69: ",
        "70 - 79: ",
        "80 - 89: ",
        "90 - 99: ",
        "100: "
    );

    assertEquals(expectedPrints, prints);
  }

  @Test
  void shouldIgnoreNotesOutOfTheRanges() {
    final var graficoNotas = new GraficoNotas(impressora);
    graficoNotas.adicionarNota(-1);
    graficoNotas.adicionarNota(101);
    graficoNotas.imprimir();

    final var expectedPrints = List.of(
        "00 - 09: ",
        "10 - 19: ",
        "20 - 29: ",
        "30 - 39: ",
        "40 - 49: ",
        "50 - 59: ",
        "60 - 69: ",
        "70 - 79: ",
        "80 - 89: ",
        "90 - 99: ",
        "100: "
    );

    assertEquals(expectedPrints, prints);
  }

  @Test
  void shouldPrintCorrectGraphWhenNotesArePresent() {
    final var graficoNotas = new GraficoNotas(impressora);

    graficoNotas.adicionarNota(2);
    graficoNotas.adicionarNota(29);
    graficoNotas.adicionarNota(98);
    graficoNotas.adicionarNota(67);
    graficoNotas.adicionarNota(64);
    graficoNotas.adicionarNota(83);
    graficoNotas.adicionarNota(100);
    graficoNotas.adicionarNota(100);
    graficoNotas.adicionarNota(100);
    graficoNotas.imprimir();

    final var expectedPrints = List.of(
        "00 - 09: *",
        "10 - 19: ",
        "20 - 29: *",
        "30 - 39: ",
        "40 - 49: ",
        "50 - 59: ",
        "60 - 69: **",
        "70 - 79: ",
        "80 - 89: *",
        "90 - 99: *",
        "100: ***"
    );

    assertEquals(expectedPrints, prints);
  }
}