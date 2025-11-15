package org.desviante.exercicios.x65_hasOneThree;

import org.desviante.exercicios.x55_has22.Has22;

public class HasOneThree {

    public boolean haveThree(int[] nums)
    {
        int count = 0;
        // Percorre até o penúltimo elemento para poder verificar o próximo (i+1)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                count++;

                // Verifica a condição de adjacência
                // Se i não é o último elemento E o próximo elemento também é 3
                if (i < nums.length - 1 && nums[i+1] == 3) {
                    return false; // Dois 3s adjacentes, retorna false imediatamente
                }
            }
        }

        // Retorna true apenas se a contagem exata for 3
        return count == 3;
    }

    public static void main(String[] args) {
        int[] teste = new int[]{1, 3, 1, 3, 1, 3, 4, 3};
        HasOneThree hasOneThree = new HasOneThree();
        System.out.println(hasOneThree.haveThree(teste));
    }
}
