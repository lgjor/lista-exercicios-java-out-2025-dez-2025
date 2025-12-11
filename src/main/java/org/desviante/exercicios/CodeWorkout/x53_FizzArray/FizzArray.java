package org.desviante.exercicios.CodeWorkout.x53_FizzArray;

public class FizzArray {

    public int[] fizzArray(int n)
    {
        int[] newArray = new int[n];
        for (int i=0; i<n; i++){
            newArray[i]=i;
        }
        return newArray;
    }
}
