package org.desviante.exercicios.adventofcode2025.AOC25_01_Secret_Entrance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SecretEntrance {

    private static final int MODULO = 100;
    static final int startPosition = 50;
    static long actualCounter = startPosition;
    private static long vezesTerminouEmZero = 0;

    /**
     * Processa uma única instrução de rotação (L ou R).
     * O foco é apenas calcular a nova posição final, pois o problema
     * exige a contagem do '0' APENAS se ele for o resultado final da rotação.
     * * @param side 'L' para Esquerda (Subtração) ou 'R' para Direita (Adição)
     * @param rotations O número de 'clicks' para girar o dial
     */
    public static void processInstructions(char side, long rotations) {
        if (rotations == 0) return;

        if (side == 'R') { // Rotação para a DIREITA (Incremento)

            // Simplesmente soma e aplica o módulo 100
            actualCounter = (actualCounter + rotations) % MODULO;

        } else if (side == 'L') { // Rotação para a ESQUERDA (Decremento)

            long valorFuturo = actualCounter - rotations;

            // Calcula o novo valor, garantindo que seja positivo (0 a 99)
            actualCounter = (valorFuturo % MODULO + MODULO) % MODULO;
        }

        // Verifica o dial parou na posição zero
        if (actualCounter == 0) {
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

            System.out.println("Posição final do contador: " + actualCounter);
            System.out.println("Total de vezes que o dial terminou em Zero: " + vezesTerminouEmZero);
        }
        catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado no caminho especificado: " + filePath);
        }
        catch (NumberFormatException e) {
            System.err.println("Erro de formato. Linha com rotação não numérica.");
        }
    }
}
