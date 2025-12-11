package org.desviante.exercicios.CodeWorkout.x50_tenRun;

import java.util.Arrays;

public class TenRun {

    public static int[] tenRun(int[] nums)
    {
        if (nums==null){
            return null;
        }
        if (nums.length<2){
            return nums;
        }
        for (int i = 0; i<nums.length-1; i++){
            if (nums[i]%10==0 && i<nums.length-1){
                for (int j = i+1; i<nums.length-1; j++){
                    if (nums[j]%10==0){
                        break;
                    } else {
                        nums[j]=nums[i];
                        i=j;
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] teste01 = new int[]{2, 10, 3, 4, 20, 5};
        int[] teste02 = new int[]{10, 1, 20, 2};
        int[] teste03 = new int[]{10, 1, 9, 20};
        System.out.println(Arrays.toString(tenRun(teste01)));
        System.out.println(Arrays.toString(tenRun(teste02)));
        System.out.println(Arrays.toString(tenRun(teste03)));
    }
}
