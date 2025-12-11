package org.desviante.exercicios.CodeWorkout.x69_fix34;

import java.util.Arrays;

public class Fix34 {

    public int[] fix34(int[] nums)
    {

        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int nextFourIndex = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // 1. Encontramos um 3 que PRECISA ser seguido por um 4
            if (nums[i] == 3 && nums[i + 1] != 4) {

                // 2. BUSCA índice que deve receber o próximo 4
                // Condições:
                // 1. a busca começa em zero e vai até o tamanho do vetor
                // 2. O valor do elemento localizado em nextFourIndex deve ser diferente de 4
                // 3. O valor do elemento anterior de fourIndex deve ser diferente de 3, porque se tiver um 4 com um 3 antes, esse 4 não deve ser alterado
                while (nextFourIndex < nums.length && (nums[nextFourIndex] != 4 || (nextFourIndex > 0 && nums[nextFourIndex - 1] == 3))) {
                    nextFourIndex++;
                }

                // Verifica se existem mais 3 do que 4
                if (nextFourIndex >= nums.length) {
                    // Não há mais 4s para mover. Sai do loop principal.
                    break;
                }

                // 4. Realiza a troca
                int temp = nums[i + 1];
                nums[i + 1] = 4;
                nums[nextFourIndex] = temp;

                // Opcional: Avança fourIndex para a próxima iteração
                nextFourIndex++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] teste = {4, 4, 3, 5, 3, 5};
        Fix34 fix34 = new Fix34();
        System.out.println(Arrays.toString(fix34.fix34(teste)));
    }
}
