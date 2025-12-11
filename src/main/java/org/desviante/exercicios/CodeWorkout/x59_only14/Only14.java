package org.desviante.exercicios.CodeWorkout.x59_only14;

public class Only14 {

    public boolean only14(int[] nums)
    {
        for (int num: nums){
            if (num!=1 && num!=4){
                return false;
            }
        }
        return true;
    }
}
