package org.desviante.exercicios.CodeWorkout.x100_zeroMax;

public class ZeroMax {

    /**
     * Retorna uma versão do array fornecido onde cada valor zero no array é
     * substituído pelo maior valor ímpar à direita do zero.
     * Se não houver nenhum valor ímpar à direita do zero, o zero permanece zero.
     *
     * @param nums O array de entrada.
     * @return O array modificado.
     */
    public int[] zeroMax(int[] nums) {
        int n = nums.length;
        // Variável para rastrear o maior ímpar encontrado à direita
        int maxOddToTheRight = 0;

        // Loop de trás para frente
        for (int i = n - 1; i >= 0; i--) {
            int current = nums[i];

            // Se o elemento atual for ímpar, ele é o novo maior ímpar para os zeros à sua esquerda
            if (current % 2 != 0) {
                if (current > maxOddToTheRight) {
                    maxOddToTheRight = current;
                }
            }

            // Se o elemento atual for 0, substitua-o pelo maior ímpar que já encontramos à direita
            else if (current == 0) {
                // Se maxOddToTheRight for 0, o zero permanece 0. Se for > 0, ele é substituído.
                nums[i] = maxOddToTheRight;
            }
            // Se for um número par e diferente de 0, ele é ignorado e mantido como está.
        }

        return nums;
    }

    /**
     * Imprime o array em formato de string.
     * @param arr O array a ser impresso.
     * @return A representação em string.
     */
    public static String arrayToString(int[] arr) {
        if (arr == null) {
            return "null";
        }
        if (arr.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // --- Método Main para Teste ---

    public static void main(String[] args) {
        ZeroMax zeroMax = new ZeroMax();

        // Exemplo 1: {0, 5, 0, 3} -> {5, 5, 3, 3}
        int[] input1 = {0, 5, 0, 3};
        int[] result1 = zeroMax.zeroMax(input1);
        System.out.println("Input: " + arrayToString(input1) + " -> Output: " + arrayToString(result1));

        // Exemplo 2: {0, 4, 0, 9, 0, 7} -> {9, 4, 9, 9, 7, 7}
        int[] input2 = {0, 4, 0, 9, 0, 7};
        int[] result2 = zeroMax.zeroMax(input2);
        System.out.println("Input: " + arrayToString(input2) + " -> Output: " + arrayToString(result2));

        // Exemplo 3: {0, 2, 8, 4} -> {0, 2, 8, 4}
        int[] input3 = {0, 2, 8, 4};
        int[] result3 = zeroMax.zeroMax(input3);
        System.out.println("Input: " + arrayToString(input3) + " -> Output: " + arrayToString(result3));
    }
}