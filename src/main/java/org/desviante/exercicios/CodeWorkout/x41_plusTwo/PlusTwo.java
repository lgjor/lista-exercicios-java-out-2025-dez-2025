package org.desviante.exercicios.CodeWorkout.x41_plusTwo;

import java.util.Arrays;

public class PlusTwo {

    public int[] plusTwo(int[] a, int[] b)
    {
        int[] newArray = new int[a.length+b.length];
        System.arraycopy(
                a,          // Array de origem
                0,          // Posição inicial no array de origem (começa no 10)
                newArray,   // Array de destino
                0,          // Posição inicial no array de destino (começa no 0)
                a.length    // Número de elementos a serem copiados (2)
        );
        System.arraycopy(
                b,          // Array de origem
                0,          // Posição inicial no array de origem (começa no 10)
                newArray,   // Array de destino
                a.length,   // Posição inicial no array de destino (começa no 0)
                b.length    // Número de elementos a serem copiados (2)
        );
        return newArray;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};

        PlusTwo plusTwo = new PlusTwo();
        int[] result = new int[4];
        result = plusTwo.plusTwo(a, b);
        System.out.println(Arrays.toString(result));
    }
}
