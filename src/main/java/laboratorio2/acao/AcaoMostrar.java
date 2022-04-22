package laboratorio2.acao;

import java.util.function.Consumer;
import laboratorio2.Mapa;

public class AcaoMostrar implements Consumer<Mapa> {

    @Override
    public void accept(Mapa mapa) {
        System.out.println("Mapa:");
        mapa.mostrar();
    }
}
