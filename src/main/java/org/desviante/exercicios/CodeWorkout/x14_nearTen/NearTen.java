package org.desviante.exercicios.CodeWorkout.x14_nearTen;

public class NearTen {
    public boolean nearTen(int num) {
        // Calcula o resto da divisão de 'num' por 10.
        int resto = num % 10;

        // Se o resto for 0, 1 ou 2, 'num' está perto do múltiplo de 10 abaixo dele.
        // Lembrando que zero é múltiplo de praticamente todos os números inteiros positivos.
        // Se o resto for 8 ou 9, 'num' está perto do múltiplo de 10 acima dele.

        // Usa 'resto <= 2' para cobrir 0, 1, 2.
        // Usa 'resto >= 8' para cobrir 8, 9 (pois 10 - resto <= 2)

        return (resto <= 2) || (resto >= 8);
    }
}