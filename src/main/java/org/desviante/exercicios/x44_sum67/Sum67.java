package org.desviante.exercicios.x44_sum67;

public class Sum67 {


    public int sum67(int[] nums)
    {
        int soma = 0;
        boolean ignorar = false;
        for (int num: nums){
            if (num==6) {
                ignorar = true;
            }
            if (!ignorar) {
                soma += num;
            }
            if (num==7 && ignorar){
                ignorar=false;
            }
        }

        return soma;
    }

    public static void main(String[] args) {
        Sum67 sum67 = new Sum67();
        System.out.println(sum67.sum67(new int[]{2, 7, 6, 2, 6, 7, 2, 7}));
    }

}
