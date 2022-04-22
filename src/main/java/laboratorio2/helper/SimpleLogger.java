package laboratorio2.helper;

import java.io.PrintStream;

public class SimpleLogger {

    private final PrintStream printStream;

    public SimpleLogger(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void imprimirLinha(String texto) {
        printStream.println(texto);
    }

    public void imprimir(String texto) {
        printStream.print(texto);
    }

    public void quebrarLinha() {
        printStream.println();
    }
}
