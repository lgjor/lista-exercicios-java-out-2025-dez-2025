package org.desviante.exercicios.CodeWorkout.x67_canBalance;

public class CanBalance {

    public boolean canBalance(int[] nums)
    {
        int sumFirstHalf = 0;
        int sumSecondHalf = 0;
        for (int i=1; i<nums.length; i++){
            for (int firstHalfIndex = 0; firstHalfIndex<i; firstHalfIndex++){
                sumFirstHalf+=nums[firstHalfIndex];
            }
            for (int secondHalfIndex = i; secondHalfIndex<nums.length; secondHalfIndex++){
                sumSecondHalf+=nums[secondHalfIndex];
            }
            if (sumFirstHalf==sumSecondHalf){
                return true;
            }
            sumFirstHalf=0;
            sumSecondHalf=0;
        }
        return false;
    }

    /** Acumula a soma total do array e depois compara a soma do lado esquerdo com direito, verificando se é igual ao total
    * Com essa otimização, a complexidade de tempo cai de $O(n^3)$ para $O(n)$, tornando-a ideal para qualquer tamanho de array.
    * @param nums
    * @return boolean
    */
    public boolean canBalanceOptimzed(int[] nums) {
        if (nums.length == 0) {
            return false; // Array vazio não pode ser balanceado
        }

        // 1. Calcular a soma total (Passo O(n))
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // 2. Percorrer o array uma vez para verificar o equilíbrio (Passo O(n))
        // O ponto de divisão está sempre ANTES do elemento nums[i]
        for (int i = 0; i < nums.length; i++) {
            // A soma do lado direito é o Total menos a soma acumulada do lado esquerdo
            int rightSum = totalSum - leftSum;

            // Verifica se o ponto de divisão anterior a nums[i] é o ponto de equilíbrio
            if (leftSum == rightSum) {
                return true;
            }

            // Atualiza a soma esquerda para incluir o elemento atual para a próxima iteração
            leftSum += nums[i];
        }

        // Adicionalmente, você precisa verificar o ponto de divisão após o último elemento
        // (A verificação do loop não inclui a divisão após o último elemento).
        // Neste ponto, leftSum == totalSum e rightSum == 0.
        if (leftSum == 0 && totalSum == 0) {
            // Isso cobre o caso onde leftSum acumulou todos os elementos e totalSum é 0.
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] teste = new int[]{3, 1, 2,99};
        CanBalance canBalance = new CanBalance();
        System.out.println(canBalance.canBalance(teste));
        System.out.println(canBalance.canBalanceOptimzed(teste));
    }
}
