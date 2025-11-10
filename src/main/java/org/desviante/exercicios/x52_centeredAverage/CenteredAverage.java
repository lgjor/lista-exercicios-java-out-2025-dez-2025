package org.desviante.exercicios.x52_centeredAverage;

public class CenteredAverage {

    public int centeredAverage(int[] nums)
    {
        int valorMinimo = Integer.MAX_VALUE;
        int valorMaximo = Integer.MIN_VALUE;
        int sum = 0;
        for (int num: nums){
            if (num<valorMinimo){
                valorMinimo=num;
            }
            if (num>valorMaximo){
                valorMaximo=num;
            }
            sum+=num;
        }
        sum = sum - valorMaximo - valorMinimo;
        int mediaCentralizada = sum/(nums.length-2);
        return mediaCentralizada;
    }

    public static void main(String[] args) {
        int[] teste01 = new int[]{1, 2, 3, 4, 100};
        CenteredAverage mediaCentralizada = new CenteredAverage();
        System.out.println(mediaCentralizada.centeredAverage(teste01));
    }
}
