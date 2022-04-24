package laboratorio2.helper;

import java.util.Scanner;

// TODO Achar uma maneira de mocar o scanner para possibilitar testes
public class SimpleInput {

    private final Scanner scanner;

    public SimpleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String lerLinha() {
        return scanner.nextLine();
    }

    public int lerInteiro() {
        final var inteiro = scanner.nextInt();
        scanner.nextLine();
        return inteiro;
    }
}
