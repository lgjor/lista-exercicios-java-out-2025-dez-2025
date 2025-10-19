package org.desviante.exercicios.X15_inOrder;

public class InOrder {

    public boolean inOrder(int a, int b, int c, boolean bOk)
    {
        // TODO
        if (bOk){
            return c>b;
        }
        else if (b>a){
            return c>b;
        }
        return false;
    }
}
