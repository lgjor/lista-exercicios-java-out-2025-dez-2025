package org.desviante.exercicios.CodeWorkout.x66_twoTwo;

public class TwoTwo {

    public boolean twoTwo(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 1. Encontramos um '2'
            if (nums[i] == 2) {

                boolean hasNeighbor = false;

                // 2. Verificamos o vizinho anterior (se não for o primeiro elemento)
                if (i > 0 && nums[i-1] == 2) {
                    hasNeighbor = true;
                }

                // 3. Verificamos o vizinho posterior (se não for o último elemento)
                // Usamos 'else if' para evitar re-verificar se já encontramos um vizinho.
                // Mas 'if' simples também funciona
                if (i < nums.length - 1 && nums[i+1] == 2) {
                    hasNeighbor = true;
                }

                // 4. Se o '2' for encontrado E ele não tiver vizinho, retornamos false
                if (!hasNeighbor) {
                    return false;
                }
            }
        }

        // Se todos os '2's forem vizinhos (ou se não houver '2's), retorna true
        return true;
    }

    public static void main(String[] args) {
        int[] teste = new int[]{2, 2, 4, 2};
        TwoTwo twoTwo = new TwoTwo();
        System.out.println(twoTwo.twoTwo(teste));
    }
}
