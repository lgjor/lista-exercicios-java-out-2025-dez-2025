package org.desviante.exercicios.CodeWorkout.x62_either24;

public class Either24 {

    public boolean either24(int[] nums)
    {
        boolean hasTwo = false;
        boolean hasFour = false;
        for (int i=0; i<nums.length-1; i++){
            if (nums[i]==2 && nums[i+1]==2){
                hasTwo = true;
            }
            if (nums[i]==4 && nums[i+1]==4){
                hasFour = true;
            }
        }
        // return (hasTwo ^ hasFour); condição xor em java, ou exclusivo, o mesmo que:
        return (hasTwo != hasFour);
    }

    public static void main(String[] args) {
        int[] teste = new int[]{1, 2, 3, 4};
        Either24 either24 = new Either24();
        System.out.println(either24.either24(teste));
    }
}
