package controledeestoque.acoes;

import controledeestoque.Estoque;
import controledeestoque.Ui;

public class Sair implements ItemDeMenu<Estoque> {

    private Ui ui;

    public Sair(Ui ui) {
        this.ui = ui;
    }

    @Override
    public String getNome() {
        return "Sair";
    }

    @Override
    public void accept(Estoque estoque) {
        ui.sair();
    }
}
