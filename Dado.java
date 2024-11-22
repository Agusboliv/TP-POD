package main;
import java.util.Random;

public class Dado {
    private int numCaras;
    private double[] probabilidades;
    private Random random;

    // Constructor
    public Dado(int numCaras, double[] probabilidades) {
        if (probabilidades.length != numCaras) {
            throw new IllegalArgumentException("El tamaño del arreglo de probabilidades debe coincidir con el número de caras.");
        }

        this.numCaras = numCaras;
        this.probabilidades = probabilidades;
        this.random = new Random();
    }

    public int tirarDado() {
        double rand = random.nextDouble(); // Genera un número aleatorio entre 0 y 1
        double acumulado = 0.0;

        for (int i = 0; i < numCaras; i++) {
            acumulado += probabilidades[i];
            if (rand <= acumulado) {
                return i + 1; // Las caras empiezan desde 1
            }
        }

        
        return numCaras;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        double[] probabilidades = {0.1, 0.2, 0.3, 0.4}; // Probabilidades para un dado de 4 caras
        Dado dado = new Dado(4, probabilidades);

        System.out.println("Resultado del lanzamiento: " + dado.tirarDado());
    }
}

