package org.desviante.exercicios.CodeWorkout.X11_teenSum;

public class TeenSum {
    public int teenSum(int a, int b)
    {
        return a >= 13 && a <= 19 || b >= 13 && b <= 19? 19 : a + b;
    }
}
