package org.desviante.exercicios.x22_noTeenSum;

public class NoTeenSum {

	public int fixTeenSum(int toFix){
		// Se está entre 13 e 19
		if (toFix >= 13 && toFix <= 19){
			// Mas, não é 15 ou 16
			if (toFix != 15 && toFix != 16){
				// retorne zero
				return 0;
			}
		}
		// caso contrário, retorne o valor original
		return toFix;
	}

	public int noTeenSum(int a, int b, int c) {
		return fixTeenSum(a)+fixTeenSum(b)+fixTeenSum(c);
	}
}


