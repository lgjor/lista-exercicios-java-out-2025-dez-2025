package org.desviante.exercicios.CodeWorkout.x63_has77;

public class Has77 {

    public boolean has77(int[] nums)
    {
        int size = nums.length;
        int lastIndex = size-1;

        for (int i = 0; i < lastIndex - 1; i++){
            // Checa (7, 7)
            if (nums[i] == 7 && nums[i+1] == 7){
                return true;
            }
            // Checa (7, X, 7)
            if (nums[i] == 7 && nums[i+2] == 7) {
                return true;
            }
        }
        // Checa o penúltimo e último elemento
        if (lastIndex >= 1 && nums[lastIndex] == 7 && nums[lastIndex - 1] == 7) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] teste = new int[]{7,1,5,7,7};
        Has77 has77 = new Has77();
        System.out.println(has77.has77(teste));
    }

}
