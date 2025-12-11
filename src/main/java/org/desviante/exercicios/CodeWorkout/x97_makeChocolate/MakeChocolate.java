package org.desviante.exercicios.CodeWorkout.x97_makeChocolate;

public class MakeChocolate {

    /**
     * Calcula o número de barras pequenas (1kg) necessárias para atingir o peso 'goal',
     * priorizando o uso máximo de barras grandes (5kg) disponíveis.
     *
     * @param numberOfSmallBars A quantidade máxima de barras de 1kg disponíveis.
     * @param numberOfBigBars   A quantidade máxima de barras de 5kg disponíveis.
     * @param goal              O peso total em kg que deve ser alcançado.
     * @return A quantidade de barras pequenas (1kg) a serem usadas, ou -1 se não for possível atingir o goal.
     */
    public int makeChocolate(int numberOfSmallBars, int numberOfBigBars, int goal) {
        final int BIG_WEIGHT = 5;

        // --- 1. Calcular o máximo de barras grandes que PODEMOS usar ---

        // Calculamos quantas barras grandes o GOAL precisa
        int bigNeededByGoal = goal / BIG_WEIGHT;

        // O número real de barras grandes (nBig) que usaremos é o menor valor entre:
        // a) O que o objetivo realmente PRECISA (bigNeededByGoal)
        // b) O que temos em ESTOQUE (numberOfBigBars)
        int nBigUsed = Math.min(bigNeededByGoal, numberOfBigBars);

        // --- 2. Calcular o peso restante (que deve ser coberto pelas barras pequenas) ---
        int remainingGoal = goal - (nBigUsed * BIG_WEIGHT);

        // --- 3. Calcular barras pequenas necessárias e verificar estoque ---

        // O peso restante deve ser totalmente coberto pelas barras pequenas.
        // Como cada barra pequena pesa 1kg, a quantidade necessária é igual ao peso restante.
        int nSmallNeeded = remainingGoal;

        // --- 4. Verificação de Possibilidade ---

        // Se a quantidade necessária de barras pequenas (nSmallNeeded)
        // for maior do que a que temos em estoque (numberOfSmallBars), não é possível.
        if (nSmallNeeded > numberOfSmallBars) {
            return -1;
        }

        // Se passarmos na verificação, retornamos a quantidade de barras pequenas necessárias.
        return nSmallNeeded;
    }

    public static void main(String[] args) {
        MakeChocolate makeChocolate = new MakeChocolate();

        // Exemplo 1: 33 Small, 2 Big, Goal 15
        // (Goal precisa de 3 Big, mas só temos 2. Usamos 2*5=10kg. Resta 5kg. Precisamos de 5 Small.)
        System.out.println("Caso 1 (Resultado esperado: 5): " + makeChocolate.makeChocolate(33, 2, 15)); // Saída: 5

        // Exemplo 2: 1 Small, 1 Big, Goal 6
        // (Goal precisa de 1 Big. Usamos 1*5=5kg. Resta 1kg. Precisamos de 1 Small. OK.)
        System.out.println("Caso 2 (Resultado esperado: 1): " + makeChocolate.makeChocolate(1, 1, 6)); // Saída: 1

        // Exemplo 3: 1 Small, 1 Big, Goal 7
        // (Goal precisa de 1 Big. Usamos 1*5=5kg. Resta 2kg. Precisamos de 2 Small, mas só temos 1. FAIL.)
        System.out.println("Caso 3 (Resultado esperado: -1): " + makeChocolate.makeChocolate(1, 1, 7)); // Saída: -1
    }

}
