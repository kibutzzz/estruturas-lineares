package aula17.listas.exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Aluno {

    private static final BigDecimal TOTAL_DE_NOTAS = BigDecimal.valueOf(2);
    private static final int CASAS_DECIMAIS = 2;

    private String nome;
    private BigDecimal notaGrauA;
    private BigDecimal notaGrauB;

    public Aluno(String nome, BigDecimal notaGrauA, BigDecimal notaGrauB) {
        this.nome = nome;
        this.notaGrauA = notaGrauA;
        this.notaGrauB = notaGrauB;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getNotaGrauA() {
        return notaGrauA;
    }

    public BigDecimal getNotaGrauB() {
        return notaGrauB;
    }

    public BigDecimal getMedia() {
        return notaGrauA
                .add(notaGrauB)
                .divide(TOTAL_DE_NOTAS, CASAS_DECIMAIS, RoundingMode.HALF_EVEN);
    }
}
