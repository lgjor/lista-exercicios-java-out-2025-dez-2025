package org.desviante.exercicios.x51_bigDiff;

import java.security.InvalidParameterException;

public class BigDiff {

    public int bigDiff(int[] nums)
    {
        if (nums==null || nums.length<1){
            throw new InvalidParameterException("Array teve ter mais de um elemento");
        }
        int valorMinimo = Integer.MAX_VALUE;
        int valorMaximo = Integer.MIN_VALUE;
        for (int num: nums){
            if (num<valorMinimo){
                valorMinimo=num;
            }
            if (num>valorMaximo){
                valorMaximo=num;
            }
        }
        return valorMaximo-valorMinimo;
    }

    public static void main(String[] args) {
        int[] input = new int[]{};
        BigDiff bigDiff = new BigDiff();
        System.out.println(bigDiff.bigDiff(input));
    }
}
