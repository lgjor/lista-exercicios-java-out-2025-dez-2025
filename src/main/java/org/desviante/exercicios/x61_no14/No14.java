package org.desviante.exercicios.x61_no14;

import org.desviante.exercicios.x55_has22.Has22;

public class No14 {

    public boolean no14(int[] nums)
    {
        boolean hasFour = false;
        boolean hasOne = false;

        for (int num: nums){
            if (num==1){
                hasOne = true;
            }
            if (num==4){
                hasFour = true;
            }

            // Se contém os 2 retorna false
            if (hasOne && hasFour){
                return false;
            }
        }

        // Caso não contenha os 2 é true
        return true;
    }

    public static void main(String[] args) {
        int[] teste = new int[]{2};
        No14 no14 = new No14();
        System.out.println(no14.no14(teste));
    }
}
