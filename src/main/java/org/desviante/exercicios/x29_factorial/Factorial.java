package org.desviante.exercicios.x29_factorial;

public class Factorial {
    public int factorial(int n)
    {
        // Condição de parada (caso base): 0! = 1
        if (n == 0) {
            return 1;
        }

        // Passo recursivo: n! = n * (n-1)!
        return n * factorial(n - 1);
    }
}
