package org.desviante.exercicios.x02_in1To10;

public class In1To10 {
    public boolean in1To10(int n, boolean outsideMode) {
        // 1. Define a condição para o MODO NORMAL (1..10, inclusive)
        boolean inNormalRange = (n >= 1 && n <= 10);
    
        // 2. Define a condição para o MODO OUTSIDE (<= 1 OU >= 10)
        boolean inOutsideRange = (n <= 1 || n >= 10);
    
        if (outsideMode) {
            // Se outsideMode for true, retornamos true se estiver em outsideRange
            return inOutsideRange;
        } else {
            // Se outsideMode for false (normal), retornamos true se estiver em normalRange
            return inNormalRange;
        }
    }
}
