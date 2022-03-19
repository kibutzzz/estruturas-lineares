package aula5.arrays.e.matrizes.exercicio3;

import static java.lang.String.*;

public class GraficoNotas {

    public static final String FORMATO_LIMITE = "%02d";
    private final Impressora impressora;
    private final Divisao[] divisoes;

    public GraficoNotas(Impressora impressora) {
        this.impressora = impressora;
        this.divisoes =
                new Divisao[] {
                    new Divisao(0, 9),
                    new Divisao(10, 19),
                    new Divisao(20, 29),
                    new Divisao(30, 39),
                    new Divisao(40, 49),
                    new Divisao(50, 59),
                    new Divisao(60, 69),
                    new Divisao(70, 79),
                    new Divisao(80, 89),
                    new Divisao(90, 99),
                    new Divisao(100)
                };
    }

    public void adicionarNota(double nota) {
        for (final var divisao : divisoes) {
            if (divisao.tentarAdicionar(nota)) {
                return;
            }
        }
    }

    public void imprimir() {
        for (final var divisao : divisoes) {
            final var builderLinha =
                    new StringBuilder().append(format(FORMATO_LIMITE, divisao.getLimiteInferior()));

            if (divisao.getLimiteInferior() != divisao.getLimiteSuperior()) {
                builderLinha
                        .append(" - ")
                        .append(format(FORMATO_LIMITE, divisao.getLimiteSuperior()));
            }
            builderLinha.append(": ");

            builderLinha.append("*".repeat(Math.max(0, divisao.getTotal())));

            impressora.imprimir(builderLinha.toString());
        }
    }
}
