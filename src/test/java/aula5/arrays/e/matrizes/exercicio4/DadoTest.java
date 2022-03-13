package aula5.arrays.e.matrizes.exercicio4;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DadoTest {
  private static final Dado DADO = new Dado();

  @RepeatedTest(100)
  void shouldOnlyGenerateBetweenOneAndSix() {
    final var valor = DADO.lancar();
    assertTrue(valor >= 1 && valor <= 6);
  }

  @Test
  void shouldGenerateAllNumbersOnRange() {
    final var options = new HashSet<>();


    for (var i = 0; i < 100; i++) {
      options.add(DADO.lancar());
    }

    assertTrue(options.contains(1));
    assertTrue(options.contains(2));
    assertTrue(options.contains(3));
    assertTrue(options.contains(4));
    assertTrue(options.contains(5));
    assertTrue(options.contains(6));
  }

}