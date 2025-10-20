package org.desviante.exercicios.x20_loneSum;

public class LoneSum {

	public int loneSum(int a, int b, int c) {
		// Caso 1: a = b = c. Se todos são iguais, o resultado é 0.
        if (a == b && a == c) {
            return 0;
        } 

		// Caso 2: Dois valores são iguais. Apenas o valor restante conta.
        // A ordem é importante aqui para não contarmos o Caso 1 (já resolvido).
        
        // Se a e b são iguais (e sabemos que c é diferente de pelo menos um deles)
        else if (a == b) {
            return c;
        }
		
		// Se a e c são iguais (e sabemos que a é diferente de b)
        else if (a == c) {
            return b;
        } 

		// Se b e c são iguais (e sabemos que a é diferente de b e c)
        else if (b == c) {
            return a;
        } 

		// Caso 3: Não há duplicatas. Todos os valores contam.
        else {
            return a + b + c;
        }
	}
}


