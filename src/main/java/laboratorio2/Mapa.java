package laboratorio2;

import java.util.Optional;
import laboratorio2.helper.SimpleLogger;

public class Mapa {

    private final Assento[][] assentos;
    private final SimpleLogger logger;

    public Mapa(SimpleLogger logger, int tamanho) {
        if (tamanho <= 0) {
            throw new IllegalArgumentException("Tamanho deve ser maior que 0");
        }
        assentos = new Assento[tamanho][tamanho];
        for (int fileira = 0; fileira < tamanho; fileira++) {
            for (int coluna = 0; coluna < tamanho; coluna++) {
                assentos[fileira][coluna] = new Assento();
            }
        }
        this.logger = logger;
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
        for (final var fileira : assentos) {
            for (final var assento : fileira) {
                final var nome = Optional.ofNullable(assento.getNome()).orElse("");
                logger.imprimir(String.format("[%12s]\t", nome));
            }
            logger.imprimirLinha("");
        }
    }
}
