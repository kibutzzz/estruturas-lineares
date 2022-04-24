package laboratorio2.helper;

import static java.util.Objects.isNull;

import java.util.regex.Pattern;

public class ExtratorDeCoordenadas {

    public static final int OFFSET_ASCII = 97;

    public int[] extrair(String posicao) {
        if (!posicaoEValida(posicao)) {
            throw new IllegalArgumentException("Posição invalida");
        }

        return new int[] {getFileira(posicao), getColuna(posicao)};
    }

    private int getColuna(String posicao) {
        return Integer.parseInt(posicao.replaceAll("\\D*", "")) - 1;
    }

    // TODO Feature - implementar conversao base 26 para permitir posicoes como AF, BL, ZEF
    private int getFileira(String posicao) {
        final var fileira = posicao.replaceAll("\\d*", "").toLowerCase();
        return calcularNumeroDaFileira(fileira);
    }

    private int calcularNumeroDaFileira(String codigo) {
        return codigo.chars().findFirst().orElseThrow() - OFFSET_ASCII;
    }

    private boolean posicaoEValida(String posicao) {
        if (isNull(posicao)) {
            return false;
        }
        return Pattern.compile("^[a-zA-Z][0-9]+$").matcher(posicao).matches();
    }
}
