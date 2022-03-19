package aula5.arrays.e.matrizes.exercicio4;

import java.util.Random;

public class Dado {

    private Random random;

    public Dado() {
        this.random = new Random();
    }

    public int lancar() {
        return random.nextInt(6) + 1;
    }
}
