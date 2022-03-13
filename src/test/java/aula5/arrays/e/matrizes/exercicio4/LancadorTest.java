package aula5.arrays.e.matrizes.exercicio4;

import aula5.arrays.e.matrizes.exercicio3.Impressora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class LancadorTest {

  @Mock
  private Impressora impressora;

  @Mock
  private Dado dado;

  @InjectMocks
  private Lancador lancador;

  @Test
  void shouldPrintCorrectly() {
    final var inOrder = Mockito.inOrder(impressora);
    given(dado.lancar()).willReturn(1)
        .willReturn(4)
        .willReturn(4)
        .willReturn(6)
        .willReturn(3);

    lancador.gerarLancamentos(5);

    then(impressora).should(inOrder).imprimir("Face\tQuantidade");
    then(impressora).should(inOrder).imprimir("1\t1");
    then(impressora).should(inOrder).imprimir("2\t0");
    then(impressora).should(inOrder).imprimir("3\t1");
    then(impressora).should(inOrder).imprimir("4\t2");
    then(impressora).should(inOrder).imprimir("5\t0");
    then(impressora).should(inOrder).imprimir("6\t1");
  }

}