package laboratorio2;

import java.util.ArrayList;
import java.util.Scanner;
import laboratorio2.acao.AcaoCancelar;
import laboratorio2.acao.AcaoMostrar;
import laboratorio2.acao.AcaoReservar;
import laboratorio2.acao.AcaoSair;
import laboratorio2.helper.ExtratorDeCoordenadas;
import laboratorio2.helper.SimpleInput;
import laboratorio2.helper.SimpleLogger;

public class Boostrap {

    private static final String MENSAGEM_MOSTRAR = "mostrar";
    private static final String MENSAGEM_RESERVAR = "reservar";
    private static final String MENSAGEM_CANCELAR = "cancelar";
    private static final String MENSAGEM_SAIR = "Sair";

    public static void main(String[] args) {
        final var input = new SimpleInput(new Scanner(System.in));
        final var logger = new SimpleLogger(System.out);

        final var extratorDeCoordenadas = new ExtratorDeCoordenadas();
        final var mapa = new Mapa(logger, 10);

        final var opcoes = new ArrayList<ItemMenu>();

        opcoes.add(new ItemMenu(MENSAGEM_MOSTRAR, new AcaoMostrar(logger), mapa));

        opcoes.add(
                new ItemMenu(
                        MENSAGEM_RESERVAR,
                        new AcaoReservar(input, logger, extratorDeCoordenadas),
                        mapa));

        opcoes.add(
                new ItemMenu(
                        MENSAGEM_CANCELAR,
                        new AcaoCancelar(input, logger, extratorDeCoordenadas),
                        mapa));
        final var ui = new MenuUi(opcoes, logger);

        opcoes.add(new ItemMenu(MENSAGEM_SAIR, new AcaoSair(ui), mapa));

        while (!ui.getSaida()) {
            ui.mostrarOpcoes();
            logger.imprimirLinha("Selecione a opcão: ");
            final var selecao = input.lerInteiro();
            ui.selecionar(selecao);
        }
    }
}
