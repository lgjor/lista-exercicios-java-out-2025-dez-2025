package org.desviante.exercicios.x19_makeBricks;

public class MakeBricks {

	public boolean makeBricks(int small, int big, int goal) {

		// 1. Calculo a quantidade máxima de tijolos grandes que posso utilizar sem ultrapassar o tamanho máximo.
		int maxBigBricksToUse = goal / 5;

		// O número real de tijolos grandes usados é o mínimo entre o que temos e o que precisamos.
		int usedBigBricks = Math.min(big, maxBigBricksToUse);

		// 2. Calculo qual a largura restante que seria necessário preencher com tijolos pequenos
		int remainingLength = goal - (usedBigBricks * 5);

		// Verifico se a quantidade de tijolos pequens é suficiente para preencher esse comprimento restante.
		return small >= remainingLength;
	}
}


