package org.desviante.exercicios.CodeWorkout.x102_sameEnds;

public class SameEnds {

    // verificar se os n primeiros elementos do vetor são iguais aos n elementos finais do vetor
    public boolean sameEnds(int[] nums, int n)
    {
        // O loop deve percorrer de 0 até n-1.
        for (int i = 0; i < n; i++) {

            // Determina o índice do elemento que está 'i' posições depois do início.
            int indiceInicio = i;

            // Determina o índice do elemento que está 'i' posições depois do (tamanho - n)
            // que é o ponto de início do último segmento de tamanho 'n'.
            int indiceFim = nums.length - n + i;

            // Se os elementos correspondentes não forem iguais, retorna false imediatamente.
            if (nums[indiceInicio] != nums[indiceFim]) {
                return false;
            }
        }

        // Se o loop terminou sem retornar false, todos os n elementos são iguais.
        return true;
    }

    public static void main(String[] args) {
        SameEnds sameEnds = new SameEnds();
        int[] teste = new int[]{5, 6, 45, 99, 13, 5, 6};
        System.out.println(sameEnds.sameEnds(teste, 2));
    }

}
