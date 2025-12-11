package org.desviante.exercicios.CodeWorkout.x49_modThree;

public class ModThree {

    public boolean modThree(int[] nums) {
        // 1. Tratamento de casos nulos ou insuficientes (mantido)
        if (nums == null || nums.length < 3) {
            return false;
        }

        // Loop atende o requisito: garantir que i+2 seja um índice válido.
        for (int i = 0; i <= nums.length - 3; i++) {

            // 0 se for Par, 1 se for Ímpar (ou qualquer valor não zero).
            int paridade = nums[i] % 2;

            // Caso 3 elementos próximos tenham a mesma paridade, retorna true
            if ((nums[i + 1] % 2 == paridade) && (nums[i + 2] % 2 == paridade)) {
                return true;
            }
        }

        // Se o loop terminar sem encontrar a sequência
        return false;
    }

    public static void main(String[] args) {
        ModThree instanceOfModThree = new ModThree();
        System.out.println(instanceOfModThree.modThree(new int[]{3, 2, 3, 2, 2, 3, 7, 5}));
    }
}
