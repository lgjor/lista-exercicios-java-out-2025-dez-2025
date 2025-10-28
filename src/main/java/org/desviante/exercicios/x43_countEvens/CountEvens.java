package org.desviante.exercicios.x43_countEvens;

public class CountEvens {

    public static int countEvens(int[] nums)
    {
        if (nums == null) {
            return 0;
        }
        int pares=0;
        for (int num: nums){
            if ( num % 2 == 0 ) {
                pares++;
            }
        }
        return pares;
    }

    public static void main(String[] args) {
        System.out.println(countEvens((new int[]{2, 1, 2, 3, 4})));
    }

}
