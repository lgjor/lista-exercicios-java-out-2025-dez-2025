package org.desviante.exercicios.x59_only14;

public class Only14 {

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
