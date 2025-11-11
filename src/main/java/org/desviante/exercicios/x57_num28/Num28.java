package org.desviante.exercicios.x57_num28;

public class Num28 {
    public boolean sum28(int[] nums)
    {
        int sum = 0;
        for (int num: nums){
            if (num==2){
                sum+=num;
            }
        }
        return sum==8;
    }
}
