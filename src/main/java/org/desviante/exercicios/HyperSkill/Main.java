package org.desviante.exercicios.HyperSkill;

public class Main {
    public static void main(String[] args) {
        int fibonacciPrevious = 1;
        int fibonacciCurrent = 1;
        while (true) {
            int tmp = fibonacciPrevious + fibonacciCurrent;
            fibonacciPrevious = fibonacciCurrent;
            fibonacciCurrent = tmp;
        }
    }
}
