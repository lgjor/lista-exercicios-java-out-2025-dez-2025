package org.desviante.exercicios.x58_moni14;

public class Moni14 {

    public boolean more14(int[] nums)
    {
        int cont1=0;
        int cont4=0;
        for (int num: nums){
            if (num==1){
                cont1++;
            }
            if (num==4){
                cont4++;
            }
        }
        return cont1>cont4;
    }
}
