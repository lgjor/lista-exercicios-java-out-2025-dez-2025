package org.desviante.exercicios.x28_theEnd;

public class TheEnd {
    public String theEnd(String str, boolean front)
    {
        // Uso de operador ternário: Caso front, retorne o índice zero, caso contrário, retorne o último índice
        return front ? str.substring(0, 1) : str.substring(str.length() - 1);
    }
}
