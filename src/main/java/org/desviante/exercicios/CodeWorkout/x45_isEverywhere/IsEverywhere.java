package org.desviante.exercicios.CodeWorkout.x45_isEverywhere;

public class IsEverywhere {

    public boolean isEverywhere(int[] nums, int val)
    {
        boolean isEverywhere = false;

        if (nums == null ){
            return false;
        }

        if (nums.length <= 1){
            return true;
        }

        for (int i=0; i<nums.length-1; i++){
            if ( ( nums[i] == val ) || ( nums[i+1] == val ) ){
                isEverywhere = true;
            }
            else {
                return false;
            }
        }

        return isEverywhere;
    }

    public static void main(String[] args) {
        IsEverywhere isEverywhere = new IsEverywhere();
        System.out.println(isEverywhere.isEverywhere(new int[]{3, 1}, 3));
    }
}
