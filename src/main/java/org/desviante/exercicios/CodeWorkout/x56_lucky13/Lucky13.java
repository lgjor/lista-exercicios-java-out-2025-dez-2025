package org.desviante.exercicios.CodeWorkout.x56_lucky13;

public class Lucky13 {

    public boolean lucky13(int[] nums)
    {
        for (int i=0; i<nums.length; i++){
            if (nums[i]==1 || nums[i]==3){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arrayTeste = new int[]{0, 2, 4};
        Lucky13 lucky13 = new Lucky13();
        System.out.println(lucky13.lucky13(arrayTeste));
    }
}
