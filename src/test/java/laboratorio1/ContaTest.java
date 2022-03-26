package laboratorio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContaTest {

    @Test
    void shouldCreateEmptyConta() {
        final var conta = new Conta("123");

        assertEquals("Conta #123: Saldo atual R$0.00", conta.toString());
    }

    @Test
    void shouldBeAbleToDepositPositiveAmount() {
        final var conta = new Conta("312");
        conta.depositar(1);

        assertEquals(1, conta.getSaldo());
    }

    @Test
    void shouldNotBeAbleToDepositZero() {
        final var conta = new Conta("312");
        final var exception =
                assertThrows(IllegalArgumentException.class, () -> conta.depositar(0));

        assertEquals("valor a depositar deve ser positivo", exception.getMessage());
    }

    @Test
    void shouldNotBeAbleToDepositNegativeAmount() {
        final var conta = new Conta("312");
        final var exception =
                assertThrows(IllegalArgumentException.class, () -> conta.depositar(-1));

        assertEquals("valor a depositar deve ser positivo", exception.getMessage());
    }

    @Test
    void shouldBeAbleToWithdrawAvailableBalance() {
        final var conta = new Conta("789");
        conta.depositar(10);

        conta.sacar(9);

        assertEquals(1, conta.getSaldo());
    }

    @Test
    void shouldBeAbleToWithdrawAllAvailableBalance() {
        final var conta = new Conta("192");
        conta.depositar(5);
        conta.sacar(5);

        assertEquals(0, conta.getSaldo());
    }

    @Test
    void shouldNotBeAbleToWithdrawMoreThanAvailableBalance() {
        final var conta = new Conta("023");
        final var exception = assertThrows(IllegalStateException.class, () -> conta.sacar(1));

        assertEquals("Saldo insuficiente para a operação", exception.getMessage());
    }

    @Test
    void shouldNotBeAbleToWithdrawNegativeAmount() {
        final var conta = new Conta("72372");
        final var exception = assertThrows(IllegalArgumentException.class, () -> conta.sacar(-1));

        assertEquals("valor a sacar deve ser positivo", exception.getMessage());
    }

    @Test
    void shouldNotBeAbleToWithdrawZero() {
        final var conta = new Conta("723");
        final var exception = assertThrows(IllegalArgumentException.class, () -> conta.sacar(0));

        assertEquals("valor a sacar deve ser positivo", exception.getMessage());
    }
}
