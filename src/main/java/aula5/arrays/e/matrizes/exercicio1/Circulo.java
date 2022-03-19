package aula5.arrays.e.matrizes.exercicio1;

public class Circulo {
    private int x;
    private int y;
    private double raio;

    public Circulo(int x, int y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public double getArea() {
        return Math.PI * raio * raio;
    }

    public double getCircunferencia() {
        return 2 * Math.PI * raio;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getRaio() {
        return raio;
    }

    @Override
    public String toString() {
        return "Circulo [" + "x=" + x + ", y=" + y + ", raio=" + raio + ']';
    }
}
