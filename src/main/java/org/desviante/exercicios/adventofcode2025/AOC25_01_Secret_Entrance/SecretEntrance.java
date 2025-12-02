package org.desviante.exercicios.adventofcode2025.AOC25_01_Secret_Entrance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecretEntrance {

    private static final int MODULO = 100;
    static final int startPosition = 50;
    static long actualCounter = startPosition;

    // Contagem de vezes que o dial aponta para zero (após rotação - Parte 1)
    private static long vezesTerminouEmZero = 0;

    // Contagem de vezes que o dial aponta para zero (qualquer clique - Parte 2)
    private static long vezesQueApontouParaZeroP2 = 0; // Nome alterado para evitar confusão

    /**
     * Processa uma única instrução de rotação (L ou R),
     * calculando a nova posição e as duas contagens.
     */
    public static void processInstructions(char side, long rotations) {
        if (rotations == 0) return;

        long oldCounter = actualCounter;
        long clicksParaPrimeiroZero;

        // --- 1. Determina a distância até o primeiro acerto em 0 ---
        if (side == 'R') {
            // Se Posição Inicial = 52, o primeiro 0 é em 48 cliques (100 - 52).
            clicksParaPrimeiroZero = MODULO - oldCounter;
        } else { // side == 'L'
            // Se Posição Inicial = 50, o primeiro 0 é em 50 cliques.
            clicksParaPrimeiroZero = oldCounter;
        }

        // Nota: Se oldCounter é 0, L: 0 cliques, R: 100 cliques.
        // No contexto do problema (0-99), o primeiro acerto deve ser:
        if (oldCounter == 0) {
            clicksParaPrimeiroZero = MODULO; // Se começa em 0, o 0 será atingido em 100 cliques.
        }

        // --- 2. Calcula a nova posição ---
        if (side == 'R') {
            actualCounter = (oldCounter + rotations) % MODULO;
        } else { // side == 'L'
            long valorFuturo = oldCounter - rotations;
            actualCounter = (valorFuturo % MODULO + MODULO) % MODULO;
        }

        // --- 3. Calcula os Acertos Totais (Parte 2) ---
        long totalAcertosNaRotacao = 0;

        if (rotations >= clicksParaPrimeiroZero) {
            // O primeiro 0 foi atingido (conta 1 acerto)
            totalAcertosNaRotacao += 1;

            // Calcula os acertos adicionais (ciclos completos de 100 cliques).
            long rotacoesRestantes = rotations - clicksParaPrimeiroZero;
            totalAcertosNaRotacao += rotacoesRestantes / MODULO;
        }

        vezesQueApontouParaZeroP2 += totalAcertosNaRotacao;

        // --- 4. Contagem da Parte 1 (Terminou em 0) ---
        // Se a posição final for 0 E houve pelo menos 1 acerto (movimento)
        if (actualCounter == 0 && totalAcertosNaRotacao > 0) {
            vezesTerminouEmZero++;
        }
    }

    public static void main(String[] args) {
        final String filePath = "src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_01_Secret_Entrance/input.txt";

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.length() >= 2) {
                    char instruction = line.charAt(0);
                    long rotations = Long.parseLong(line.substring(1));
                    processInstructions(instruction, rotations);
                }
            }

            System.out.println("--- Resultados ---");
            System.out.println("Posição final do contador: " + actualCounter);
            System.out.println("Total de vezes que o dial terminou em Zero (Parte 1): " + vezesTerminouEmZero);
            System.out.println("Total de vezes que o dial apontou para Zero (Parte 2): " + vezesQueApontouParaZeroP2);
        }
        catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado no caminho especificado: " + filePath);
        }
        catch (NumberFormatException e) {
            System.err.println("Erro de formato. Linha com rotação não numérica.");
        }
    }
}