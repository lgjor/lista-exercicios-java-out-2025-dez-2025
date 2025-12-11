package org.desviante.exercicios.CodeWorkout.x24_blackjack;

public class Blackjack {
	public int blackjack(int a, int b) {
		// Se um score é maior que 21, ele não conta
		// Isso torna a comparação o mais simples possível
		int valA = (a > 21) ? 0 : a;
		int valB = (b > 21) ? 0 : b;

		// Em seguida retornamos a maior pontuação
		// - Se ambos forem zero (22, 23) -> max(0, 0) = 0
		// - Se A for zero, retorna B (22, 19) -> max(0, 19) = 19
		// - Se B for zero, retorna A (20, 25) -> max(20, 0) = 20
		// - Se nenhum estourar, retorna o maior
		return Math.max(valA, valB);
	}
}