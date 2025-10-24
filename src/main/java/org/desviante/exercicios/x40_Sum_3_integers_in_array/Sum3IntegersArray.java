package org.desviante.exercicios.x40_Sum_3_integers_in_array;

public class Sum3IntegersArray {

    public int sum3(int[] nums)
    {
        if (nums == null || nums.length < 3){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < 3; i++){
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args){
        Sum3IntegersArray sum3IntegersArray = new Sum3IntegersArray();
        System.out.println("Case 1: "+sum3IntegersArray.sum3(new int[]{1, 2, 3}));
        System.out.println("Case 2: "+sum3IntegersArray.sum3(new int[]{323,-99,93871}));
    }

}
