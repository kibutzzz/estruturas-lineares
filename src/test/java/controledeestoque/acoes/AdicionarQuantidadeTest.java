package controledeestoque.acoes;

import controledeestoque.Estoque;
import laboratorio2.helper.SimpleInput;
import laboratorio2.helper.SimpleLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
class AdicionarQuantidadeTest {

  @InjectMocks private AdicionarQuantidade acao;

  @Mock private SimpleLogger logger;
  @Mock private SimpleInput input;

  @Mock private Estoque estoque;

  @Test
  void deveAlterarProduto() {

    given(input.lerLinha()).willReturn("ABC");
    given(input.lerInteiro()).willReturn(1);

    acao.accept(estoque);

    final var order = inOrder(input, estoque, logger);

    then(logger).should(order).imprimirLinha("Digite o codigo do produto: ");
    then(input).should(order).lerLinha();
    then(logger).should(order).imprimirLinha("Digite a quantidade do produto: ");
    then(input).should(order).lerInteiro();
    then(estoque).should(order).alterarQuantidadeDeProduto("ABC", 1);

  }

  @Test
  void deveTerNomeCorreto() {
    assertEquals("Adicionar quantidade a um produto existente", acao.getNome());
  }

}