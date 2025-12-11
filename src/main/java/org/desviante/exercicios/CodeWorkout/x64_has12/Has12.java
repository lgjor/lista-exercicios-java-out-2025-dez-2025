package org.desviante.exercicios.CodeWorkout.x64_has12;

public class Has12 {

    public boolean has12(int[] nums)
    {
        boolean has1 = false;
        for (int num: nums){
            if (num==1){
                has1 = true;
            }
            else if (num==2 && has1){
                return true;
            }
        }
        return false;
    }
}
