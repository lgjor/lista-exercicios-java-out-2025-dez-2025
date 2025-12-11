package org.desviante.exercicios.CodeWorkout.x47_withoutTen;

import java.util.Arrays;

public class WithoutTen {

    public int[] withoutTen(int[] nums)
    {
        if ( nums== null ){
            return null;
        }
        if (nums.length==0 ){
            return nums;
        }

        int[] novoArray = new int[nums.length];
        int indiceDeEscrita = 0;

        for (int i=0; i<nums.length; i++){
            if (nums[i] != 10) {
                novoArray[indiceDeEscrita] = nums[i];
                indiceDeEscrita++;
            }
        }

        while (indiceDeEscrita < novoArray.length) {
            novoArray[indiceDeEscrita] = 0;
            indiceDeEscrita++;
        }

        return novoArray;
    }

    public static void main(String[] args) {
        WithoutTen withoutTen = new WithoutTen();
        System.out.println(Arrays.toString(withoutTen.withoutTen(new int[]{1, 10, 10, 2})));
    }

}
