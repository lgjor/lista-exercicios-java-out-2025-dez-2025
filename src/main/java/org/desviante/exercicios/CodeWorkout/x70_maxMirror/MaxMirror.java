package org.desviante.exercicios.CodeWorkout.x70_maxMirror;

public class MaxMirror {

    public int maxMirror(int[] nums) {
        // N é o comprimento do array.
        int N = nums.length;
        // Variável para armazenar o maior comprimento de espelho encontrado.
        int maxLength = 0;

        // Loop 1 (i): Itera sobre todos os possíveis índices de início
        // do subarray "original" (da esquerda para a direita).
        for (int i = 0; i < N; i++) {

            // Loop 2 (j): Itera sobre todos os possíveis índices de início
            // do subarray "reverso". Na verdade, j representa o índice do
            // primeiro elemento do espelho reverso lido de trás para frente.
            for (int j = 0; j < N; j++) {

                // Variável para contar o comprimento da correspondência atual.
                int currentLength = 0;
                // k é o deslocamento (offset) do início (i e j).
                int k = 0;

                // Loop 3 (while): Verifica a correspondência entre os elementos
                // e continua enquanto estivermos dentro dos limites do array.
                while (i + k < N && j + k < N) {

                    // --- A Lógica da Comparação de Espelho ---

                    // Elemento Original: O k-ésimo elemento a partir de i.
                    int originalElement = nums[i + k];

                    // Elemento Reverso: O k-ésimo elemento a partir de j lido de trás para frente.
                    // O array lido de trás para frente tem seu "início" em N-1.
                    // O elemento na posição j da leitura reversa é N - 1 - j.
                    // O k-ésimo elemento a partir desse ponto é: N - 1 - (j + k).
                    int reverseElement = nums[N - 1 - (j + k)];

                    // Se os elementos correspondem, incrementamos o comprimento.
                    if (originalElement == reverseElement) {
                        currentLength++;
                        k++;
                    } else {
                        // Se não houver correspondência, quebramos o loop 'while'
                        // e passamos para o próximo par (i, j).
                        break;
                    }
                }

                // Atualiza o maior comprimento encontrado até agora.
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] teste = new int[]{1, 2, 3, 8, 9, 3, 2, 1};
        MaxMirror maxMirrorObject = new MaxMirror();
        System.out.println(maxMirrorObject.maxMirror(teste));
    }

}
