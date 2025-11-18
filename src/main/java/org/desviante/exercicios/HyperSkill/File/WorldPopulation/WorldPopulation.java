package org.desviante.exercicios.HyperSkill.File.WorldPopulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WorldPopulation {
    public static void main(String[] args) throws FileNotFoundException {
        // Caminho relativo do arquivo
        final String path = "src/main/java/org/desviante/exercicios/HyperSkill/File/WorldPopulation/dataset_91069.txt";

        // Tento ler o arquivo e caso falhe lanço uma exceção
        // É melhor usar long para armazenar a população
        long maxDiff = 0;
        int yearWithMaxDiff = 0;
        long previousPopulation = 0;
        boolean isFirstLine = true;

        // Usa try-with-resources para garantir o fechamento do recurso
        try (Scanner scanner = new Scanner(new File(path))) {
            // 1. Pular o cabeçalho
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Pula a linha: "year    population"
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) continue; // Ignorar linhas vazias

                // Separa e limpar a linha por espaço
                String[] parts = line.split("\\s+");

                if (parts.length < 2) continue; // Se não tiver Ano e População, pule para a próxima linha

                try {
                    int currentYear = Integer.parseInt(parts[0]);

                    // Remover vírgulas da população antes de converter para long
                    String popString = parts[1].replace(",", "");
                    long currentPopulation = Long.parseLong(popString);

                    if (!isFirstLine) {
                        // 3. Calcular a diferença
                        long diff = Math.abs(currentPopulation - previousPopulation);

                        // 4. Encontrar a maior diferença
                        if (diff > maxDiff) {
                            maxDiff = diff;
                            yearWithMaxDiff = currentYear;
                        }
                    } else {
                        isFirstLine = false;
                    }

                    previousPopulation = currentPopulation;

                } catch (NumberFormatException e) {
                    // Lidar com dados não numéricos (opcional: System.err.println)
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado.");
        }

        System.out.println("O ano com a maior diferença populacional foi: " + yearWithMaxDiff);
    }
}
