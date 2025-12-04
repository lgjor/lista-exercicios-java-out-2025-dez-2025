package org.desviante.exercicios.adventofcode2025.AOC25_04_PrintingDepartment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PrintingDepartment {
    char[][] rollsOfPapers;

    public void loadFileIntoMatrix(String filePath) throws IOException {
        // Ler todas as linhas do arquivo
        List<String> lines = Files.readAllLines(Path.of(filePath));

        // Criar matriz com base nas dimensões do arquivo
        int rows = lines.size();
        int cols = lines.get(0).length();
        rollsOfPapers = new char[rows][cols];

        // Preencher a matriz char por char
        for (int r = 0; r < rows; r++) {
            rollsOfPapers[r] = lines.get(r).toCharArray();
        }
    }

    public void printMatrix() {
        for (char[] row : rollsOfPapers) {
            System.out.println(new String(row));
        }
    }

    // PART ONE
    public long contarRolosValidos(){
        long count = 0;

        // Percorrer todos os itens da matriz bidimensional
        for (int row = 0; row < rollsOfPapers.length; row++) {
            for (int col = 0; col < rollsOfPapers[row].length; col++) {

                // Se não for um rolo válido '@', pula para a próxima coluna
                if (rollsOfPapers[row][col] != '@') {
                    continue;
                }

                int vizinhos = 0;

                // Percorrer os 8 vizinhos de cada elemento da matriz

                // Deslocamento da linha de -1 para +1
                for (int dr = -1; dr <= 1; dr++) {

                    // Deslocamento da coluna de -1 para +1
                    for (int dc = -1; dc <= 1; dc++) {

                        if (dr == 0 && dc == 0) continue; // ignora o próprio

                        int vr = row + dr;
                        int vc = col + dc;

                        // dentro dos limites?
                        if (vr >= 0 && vr < rollsOfPapers.length &&
                                vc >= 0 && vc < rollsOfPapers[vr].length) {

                            if (rollsOfPapers[vr][vc] == '@') {
                                vizinhos++;
                            }
                        }
                    }
                }

                // Regra: menos de 4
                if (vizinhos < 4) {
                    count++;
                }
            }
        }
        return count;
    }

    // PART TWO
    // Remover rolos válidos da matriz, transformando-os em .
    public long removerRolosValidos() {
        long count = 0;

        // Criar uma lista de posições que devem ser removidas
        List<int[]> paraRemover = new ArrayList<>();

        // PRIMEIRO: identificar
        for (int row = 0; row < rollsOfPapers.length; row++) {
            for (int col = 0; col < rollsOfPapers[row].length; col++) {

                if (rollsOfPapers[row][col] != '@') continue;

                int vizinhos = 0;

                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {

                        if (dr == 0 && dc == 0) continue;

                        int vr = row + dr;
                        int vc = col + dc;

                        if (vr >= 0 && vr < rollsOfPapers.length &&
                                vc >= 0 && vc < rollsOfPapers[vr].length &&
                                rollsOfPapers[vr][vc] == '@') {

                            vizinhos++;
                        }
                    }
                }

                if (vizinhos < 4) {
                    paraRemover.add(new int[]{row, col});
                    count++;
                }
            }
        }

        // SEGUNDO: remover todos de uma vez
        for (int[] pos : paraRemover) {
            rollsOfPapers[pos[0]][pos[1]] = '.';
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        final String filePath = "src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_04_PrintingDepartment/input.txt";

        PrintingDepartment pd = new PrintingDepartment();
        pd.loadFileIntoMatrix(filePath);
        System.out.println("===============");
        System.out.println("Rolos de papel: ");
        System.out.println("---------------");
        pd.printMatrix();
        System.out.println("===============");
        long rolosValidos = 0;
        long rolosRemovidos = 0;
        do{
            rolosValidos = pd.removerRolosValidos();
            rolosRemovidos += rolosValidos;
            System.out.println("Existem "+ rolosValidos +" rolos válidos de papel.");
        } while (rolosValidos >0);
        System.out.println("===============");
        System.out.println("Rolos restantes: ");
        System.out.println("---------------");
        pd.printMatrix();
        System.out.println("===============");
        System.out.println("Total de rolos removidos: "+rolosRemovidos);

    }
}
