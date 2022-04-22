package laboratorio2.acao;

import java.util.function.Consumer;
import laboratorio2.Mapa;
import laboratorio2.MenuUi;

public class AcaoSair implements Consumer<Mapa> {

    private final MenuUi ui;

    public AcaoSair(MenuUi ui) {
        this.ui = ui;
    }

    @Override
    public void accept(Mapa mapa) {
        System.out.println("Saindo");
        ui.setSaida(true);
    }
}
