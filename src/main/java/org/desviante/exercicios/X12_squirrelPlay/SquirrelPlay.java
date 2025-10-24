package org.desviante.exercicios.X12_squirrelPlay;

public class SquirrelPlay {
    public boolean squirrelPlay(int temp, boolean isSummer)
    {
        // Determina o limite superior (maxTemp) usando o operador ternário.
        // Se isSummer for true, maxTemp é 100. Caso contrário, maxTemp é 90.
        int maxTemp = isSummer ? 100 : 90;
        
        // Retorna true apenas se a temperatura estiver no intervalo [60, maxTemp].
        return (temp >= 60 && temp <= maxTemp);
    }
}