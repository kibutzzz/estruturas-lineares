package aula17.listas.exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Disciplina {

    private static final int CASAS_DECIMAIS = 3;
    private final List<Aluno> alunos;

    public Disciplina(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public BigDecimal getMediaGeral() {
        return alunos.stream()
                .map(Aluno::getMedia)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(alunos.size()), CASAS_DECIMAIS, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getMenorMedia() {
        return getMenorValor(Aluno::getMedia);
    }

    public BigDecimal getMaiorMedia() {
        return getMaiorValor(Aluno::getMedia);
    }

    public BigDecimal getMenorNota() {
        return getMenorValor(pelaMenorNotaDoAluno());
    }

    public BigDecimal getMaiorNota() {

        return getMaiorValor(pelaMaiorNotaDoAluno());
    }

    private BigDecimal getMaiorValor(Function<Aluno, BigDecimal> funcaoMapeadora) {
        return alunos.stream().map(funcaoMapeadora).max(Comparator.naturalOrder()).orElseThrow();
    }

    private BigDecimal getMenorValor(Function<Aluno, BigDecimal> funcaoMapeadora) {
        return alunos.stream().map(funcaoMapeadora).min(Comparator.naturalOrder()).orElseThrow();
    }

    private Function<Aluno, BigDecimal> pelaMenorNotaDoAluno() {
        return paraNota(resultadoComparacao -> resultadoComparacao < 0);
    }

    private Function<Aluno, BigDecimal> pelaMaiorNotaDoAluno() {
        return paraNota(resultadoComparacao -> resultadoComparacao > 0);
    }

    private Function<Aluno, BigDecimal> paraNota(Predicate<Integer> comparador) {
        return aluno -> {
            if (comparador.test(aluno.getNotaGrauA().compareTo(aluno.getNotaGrauB()))) {
                return aluno.getNotaGrauA();
            }
            return aluno.getNotaGrauB();
        };
    }
}
