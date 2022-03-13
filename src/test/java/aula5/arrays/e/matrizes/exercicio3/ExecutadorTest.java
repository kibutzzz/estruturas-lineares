package aula5.arrays.e.matrizes.exercicio3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ExecutadorTest {

  private final PrintStream standardOut = System.out;
  private final InputStream standardIn = System.in;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
    System.setIn(standardIn);
  }

  @Test
  void shouldIntegrateCorrectly() throws IOException {
    final var data = "20.0 \ns\n45.0 \ns\n55.0 \ns\n42.0 \ns\n49.0 \nn \n";
    System.setIn(new ByteArrayInputStream(data.getBytes()));


    Executador.main(new String[0]);


    final var expectedResult = "digite mais uma nota\n" +
        "deseja adicionar mais uma nota? (s/n)\n" +
        "digite mais uma nota\n" +
        "deseja adicionar mais uma nota? (s/n)\n" +
        "digite mais uma nota\n" +
        "deseja adicionar mais uma nota? (s/n)\n" +
        "digite mais uma nota\n" +
        "deseja adicionar mais uma nota? (s/n)\n" +
        "digite mais uma nota\n" +
        "deseja adicionar mais uma nota? (s/n)\n" +
        "resultado: \n" +
        "00 - 09: \n" +
        "10 - 19: \n" +
        "20 - 29: *\n" +
        "30 - 39: \n" +
        "40 - 49: ***\n" +
        "50 - 59: *\n" +
        "60 - 69: \n" +
        "70 - 79: \n" +
        "80 - 89: \n" +
        "90 - 99: \n" +
        "100: \n";
    assertEquals(expectedResult, outputStreamCaptor.toString());
  }


}