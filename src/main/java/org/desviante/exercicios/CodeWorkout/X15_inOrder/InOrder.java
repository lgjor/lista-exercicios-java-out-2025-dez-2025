package org.desviante.exercicios.CodeWorkout.X15_inOrder;

public class InOrder {

    public boolean inOrder(int a, int b, int c, boolean bOk)
    {
        if (bOk){
            return c>b;
        }
        else if (b>a){
            return c>b;
        }
        return false;
    }
}
