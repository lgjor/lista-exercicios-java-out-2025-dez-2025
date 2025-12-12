package org.desviante.exercicios.CodeWorkout.x101_pre4;

import java.util.Arrays;

public class Pre04 {

    public int[] pre4(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return new int[0]; // Retorna um array vazio se a entrada for nula ou vazia
        }

        int indexOfFirstFour = -1;

        for (int i=0; i<nums.length; i++){
            if (nums[i]==4){
                indexOfFirstFour = i;
                break;
            }
        }
                // O tamanho do novo array será o mínimo entre 4 e o comprimento do array de entrada
        int tamanhoNovoArray = Math.min(indexOfFirstFour, nums.length);

        // Cria o novo array com o tamanho determinado
        int[] subArray = new int[tamanhoNovoArray];

        // Copia os elementos do array original para o novo array
        // System.arraycopy(src, srcPos, dest, destPos, length)
        System.arraycopy(nums, 0, subArray, 0, tamanhoNovoArray);

        return subArray;
    }

    public static void main(String[] args) {
        Pre04 pre04 = new Pre04();
        int[] nums = new int[]{1, 4, 4};
        System.out.println(Arrays.toString(pre04.pre4(nums)));
    }

}
