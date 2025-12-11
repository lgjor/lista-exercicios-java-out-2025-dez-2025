package org.desviante.exercicios.CodeWorkout.x26_atFirst;

public class AtFirst {

    public String atFirst(String str)
    {
        int size = str.length();
        if ( size >= 2 ) {
            return str.substring(0, 2);
        } else if ( size == 1 ) {
            return str + "@";
        }
        return "@@";
    }

}
