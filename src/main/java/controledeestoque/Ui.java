package controledeestoque;

import controledeestoque.acoes.ItemDeMenu;
import java.util.List;
import laboratorio2.helper.SimpleInput;
import laboratorio2.helper.SimpleLogger;

public class Ui<T> {

    private List<ItemDeMenu<T>> acoes;
    private SimpleLogger logger;
    private SimpleInput input;
    private T modelo;

    private boolean deveSair = false;

    public Ui(List<ItemDeMenu<T>> acoes, SimpleLogger logger, SimpleInput input, T modelo) {
        this.acoes = acoes;
        this.logger = logger;
        this.input = input;
        this.modelo = modelo;
    }

    public void executar() {

        while (!deveSair) {
            listarOpcoes();

            final var opcao = input.lerInteiro();
            try {
                acoes.get(opcao).accept(modelo);
            } catch (IllegalArgumentException | IllegalStateException e) {
                logger.imprimirLinha(e.getMessage());
            }
        }
    }

    public void sair() {
        this.deveSair = true;
    }

    private void listarOpcoes() {
        logger.imprimirLinha("Menu principal");
        for (int i = 0; i < acoes.size(); i++) {
            logger.imprimirLinha(i + " - " + acoes.get(i).getNome());
        }
    }
}
