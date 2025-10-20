package org.desviante.exercicios.x23_closeFar;

public class CloseFar {

	public boolean closeFar(int a, int b, int c) {

		// Verifico a distância de a e b
		if (Math.abs(a - b) <=1){
			if (Math.abs(b - c) >= 2 && Math.abs(a - c) >= 2) {
				return true;
			}
		// Verifico a distância de a e c
		} else if (Math.abs(a - c)<=1){
			if (Math.abs(b - c) >= 2 && Math.abs(a - b) >= 2) {
				return true;
			}
		}		
		return false;
	}
}


