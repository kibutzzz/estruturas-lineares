package laboratorio1;

public class Conta {

    private double saldo;
    private final String numero;

    public Conta(String numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("valor a depositar deve ser positivo");
        }

        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("valor a sacar deve ser positivo");
        }

        if (this.saldo - valor < 0) {
            throw new IllegalStateException("Saldo insuficiente para a operação");
        }

        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return String.format("Conta #%s: Saldo atual R$%.2f", this.numero, this.saldo);
    }
}
