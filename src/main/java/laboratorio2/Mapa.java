package laboratorio2;

import static java.lang.String.format;

import java.util.Optional;
import java.util.stream.IntStream;
import laboratorio2.helper.SimpleLogger;

public class Mapa {

    private final Assento[][] assentos;
    private final SimpleLogger logger;

    public Mapa(SimpleLogger logger, int tamanhoVertical, int tamanhoHorizontal) {
        validarTamanho(tamanhoVertical, tamanhoHorizontal);
        assentos = new Assento[tamanhoVertical][tamanhoHorizontal];
        for (int fileira = 0; fileira < tamanhoVertical; fileira++) {
            for (int coluna = 0; coluna < tamanhoHorizontal; coluna++) {
                assentos[fileira][coluna] = new Assento();
            }
        }
        this.logger = logger;
    }

    private void validarTamanho(int tamanhoVertical, int tamanhoHorizontal) {
        if (tamanhoVertical <= 0 || tamanhoHorizontal <= 0) {
            throw new IllegalArgumentException("Tamanho deve ser maior que 0");
        }
    }

    public void reservar(String nome, int fileira, int coluna) {
        try {
            final var assento = assentos[fileira][coluna];
            assento.reservar(nome);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new IllegalArgumentException("Posição selecionada não é valida");
        }
    }

    public void cancelar(int fileira, int coluna) {
        assentos[fileira][coluna] = new Assento();
    }

    public void mostrar() {
        logger.imprimirLinha(calcularCabecalho());
        for (int i = 0; i < assentos.length; i++) {
            logger.imprimir(format("%3s ", calcularLetra(i)));
            for (final var assento : assentos[i]) {
                final var nome = Optional.ofNullable(assento.getNome()).orElse("");
                logger.imprimir(format("[%12s]\t", nome));
            }
            logger.imprimirLinha("");
        }
    }

    private String calcularCabecalho() {
        return format("%13s\t".repeat(assentos[0].length), getColunas());
    }

    private Object calcularLetra(int i) {
        return (char) (i + (65));
    }

    private Object[] getColunas() {
        return IntStream.range(1, assentos[0].length + 1).boxed().toArray();
    }
}
