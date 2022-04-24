package laboratorio2;

import java.util.List;
import laboratorio2.helper.SimpleLogger;

public class MenuUi {

    private final List<ItemMenu> itensMenu;
    private final SimpleLogger logger;
    private boolean sair = false;

    public MenuUi(List<ItemMenu> opcoes, SimpleLogger logger) {
        itensMenu = opcoes;
        this.logger = logger;
    }

    public void mostrarOpcoes() {
        for (int i = 0; i < itensMenu.size(); i++) {
            logger.imprimirLinha(i + " - " + itensMenu.get(i).getDescricao());
        }
    }

    public void selecionar(int i) {
        try {
            itensMenu.get(i).executar();
        } catch (IndexOutOfBoundsException ex) {
            logger.imprimirLinha("Opcão invalida");
        } catch (Exception exception) {
            logger.imprimirLinha(exception.getMessage());
        }
    }

    public void setSaida(boolean deveSair) {
        this.sair = deveSair;
    }

    public boolean getSaida() {
        return this.sair;
    }
}
