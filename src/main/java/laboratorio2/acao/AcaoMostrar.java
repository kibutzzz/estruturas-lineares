package laboratorio2.acao;

import java.util.function.Consumer;
import laboratorio2.Mapa;
import laboratorio2.helper.SimpleLogger;

public class AcaoMostrar implements Consumer<Mapa> {

    private static final String TITULO = "Assentos da sala:";

    private final SimpleLogger logger;

    public AcaoMostrar(SimpleLogger logger) {
        this.logger = logger;
    }

    @Override
    public void accept(Mapa mapa) {
        logger.imprimirLinha(TITULO);
        mapa.mostrar();
    }
}
