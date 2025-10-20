package org.desviante.exercicios.x18_blueTicket;

public class BlueTicket {

    public int blueTicket(int a, int b, int c)
    {
        int ab = a + b;
        if (ab == 10)
        {
            return 10;
        }
        int bc = b + c;
        if (bc == 10)
        {
            return 10;
        }

        if (ab == bc+10){
            return 5;
        }

        int ac = a + c;
        if (ac == 10)
        {
            return 10;
        }
        if (ab == ac+10){
            return 5;
        }
        return 0;
    }
}