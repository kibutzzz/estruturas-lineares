package laboratorio2;

import java.util.Scanner;

public class Boostrap {

    public static void main(String[] args) {

        final var scanner = new Scanner(System.in);
        final var mapa = new Mapa(10);

        final ItemMenu[] opcoes = new ItemMenu[10];

        opcoes[0] =
                new ItemMenu(
                        "mostrar",
                        m -> {
                            System.out.println("mostrar");
                        },
                        mapa);
        final var ui = new MenuUi(opcoes);

        opcoes[opcoes.length - 1] =
                new ItemMenu(
                        "Sair",
                        m -> {
                            System.out.println("Saindo");
                            ui.setSaida(true);
                        },
                        mapa);

        while (!ui.getSaida()) {
            ui.mostrarOpcoes();
            System.out.println("Selecione a opcão: ");
            final var selecao = scanner.nextInt();
            ui.selecionar(selecao);
        }
    }
}
