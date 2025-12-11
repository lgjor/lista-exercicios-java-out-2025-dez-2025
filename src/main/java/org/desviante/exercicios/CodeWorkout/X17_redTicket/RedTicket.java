package org.desviante.exercicios.CodeWorkout.X17_redTicket;

public class RedTicket {

    public int redTicket(int a, int b, int c) {
        if (a == b && b == c) {
            if (c == 2) {
                return 10;
            } else {
                return 5;
            }
        }
        if (b != a && c != a) {
            return 1;
        } else {
            return 0;
        }
    }
}
