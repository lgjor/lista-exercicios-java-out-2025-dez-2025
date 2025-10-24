package org.desviante.exercicios.x25_evenlySpaced;

import java.util.Arrays;

public class EvenlySpaced {

	public boolean evenlySpacedFirstTry(int a, int b, int c) {
		if (a==b && b==c){
			return true;
		}

		int max = 0;
		int min = 0;
		int mid = 0;

		if (a>b){
			max = a;
			min = b;
		} else {
			max = b;
			min = a;
		}

		if (c>max){
		 	mid = max;
			max = c;
		} else if (c<min){
			mid = min;
			min = c;
		} else {
			mid = c;
		}

		return (max - mid) == (mid - min);
	}

	// Código otimizado
	public boolean evenlySpaced(int a, int b, int c) {
		// Encontra o mínimo e o máximo
		int min = Math.min(a, Math.min(b, c));
		int max = Math.max(a, Math.max(b, c));
		
		// O valor do meio é a soma total menos o min e o max
		// Isso é garantido porque só há 3 números
		int mid = a + b + c - min - max;
		
		// Verifica se as diferenças são iguais
		return (max - mid) == (mid - min);
	}
	
	// Código otimizado com array
	public boolean evenlySpacedThirdTry(int a, int b, int c) {
		// Coloca os valores em um array
		int[] nums = {a, b, c};
		
		// Ordena o array: nums[0] é o menor, nums[1] é o médio, nums[2] é o maior
		Arrays.sort(nums);
		
		// O espaçamento uniforme existe se a diferença (médio - menor)
		// for igual à diferença (maior - médio)
		return (nums[1] - nums[0]) == (nums[2] - nums[1]);
	}
}


