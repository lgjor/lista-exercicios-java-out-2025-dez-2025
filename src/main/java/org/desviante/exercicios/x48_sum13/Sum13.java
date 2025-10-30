package org.desviante.exercicios.x48_sum13;

public class Sum13 {

    public int sum13(int[] nums)
    {
        if (nums==null){
            return 0;
        }
        int sum = 0;
        boolean skipNext = false;
        for (int i=0; i<nums.length; i++){
            if (skipNext){
                // Se o elemento atual também for 13, manter o skip para o próximo
                skipNext = (nums[i] == 13);
                continue;
            }
            if (nums[i] == 13){
                skipNext = true;
                continue;
            }
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Sum13 instanceOfSum13 = new Sum13();
        System.out.println(instanceOfSum13.sum13(new int[]{13, 1, 2, 13, 2, 1, 13}));
    }

}
