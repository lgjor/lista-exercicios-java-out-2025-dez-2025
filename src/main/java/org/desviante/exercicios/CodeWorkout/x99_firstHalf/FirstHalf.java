package org.desviante.exercicios.CodeWorkout.x99_firstHalf;

public class FirstHalf {

    public String firstHalf(String str)
    {
        return str.substring(0,str.length()/2);
    }

    public static void main(String[] args) {
        FirstHalf firstHalf = new FirstHalf();
        System.out.println(firstHalf.firstHalf("WooHooha"));
    }
}
