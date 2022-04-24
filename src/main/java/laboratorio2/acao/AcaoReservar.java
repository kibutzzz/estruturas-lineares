package laboratorio2.acao;

import java.util.function.Consumer;
import laboratorio2.Mapa;
import laboratorio2.helper.ExtratorDeCoordenadas;
import laboratorio2.helper.SimpleInput;
import laboratorio2.helper.SimpleLogger;

public class AcaoReservar implements Consumer<Mapa> {

    private final SimpleInput input;
    private final SimpleLogger logger;
    private final ExtratorDeCoordenadas extratorDeCoordenadas;

    public AcaoReservar(
            SimpleInput input, SimpleLogger logger, ExtratorDeCoordenadas extratorDeCoordenadas) {
        this.input = input;
        this.logger = logger;
        this.extratorDeCoordenadas = extratorDeCoordenadas;
    }

    @Override
    public void accept(Mapa mapa) {
        logger.imprimirLinha("Digite o nome: ");
        final var nome = input.lerLinha();

        logger.imprimirLinha("Selecione um assento: ");

        try {
            final var posicaoAssento = input.lerLinha();
            final var coordenadas = extratorDeCoordenadas.extrair(posicaoAssento);
            mapa.reservar(nome, coordenadas[0], coordenadas[1]);
        } catch (IllegalArgumentException exception) {
            logger.imprimirLinha("Posicão invalida. Tente novamente");
            accept(mapa);
        } catch (IllegalStateException exception) {
            logger.imprimirLinha(exception.getMessage());
            accept(mapa);
        } catch (Exception e) {
            logger.imprimirLinha("Erro ao selecionar o assento. Cancelando ação");
        }
    }
}
