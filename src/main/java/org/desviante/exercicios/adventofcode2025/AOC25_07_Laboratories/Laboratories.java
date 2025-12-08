package org.desviante.exercicios.adventofcode2025.AOC25_07_Laboratories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Laboratories {

    private char[][] grid;
    private int rows;
    private int cols;
    private int startRow;
    private int startCol;

    static class Beam {
        int row;
        int col;

        public Beam(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Beam[" + row + "," + col + "]";
        }
    }

    public void readFile(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);

            rows = lines.size();
            cols = lines.get(0).length();
            grid = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                String line = lines.get(i);
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = line.charAt(j);
                    if (grid[i][j] == 'S') {
                        startRow = i;
                        startCol = j;
                    }
                }
            }

            System.out.println("Grid carregado: " + rows + "x" + cols);
            System.out.println("Posição inicial S: (" + startRow + ", " + startCol + ")");

        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= rows || col < 0 || col >= cols;
    }

    public void printGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    // ========== PARTE 1 ==========
    public int countSplits() {
        Queue<Beam> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> splittersHit = new HashSet<>();

        queue.add(new Beam(startRow, startCol));

        while (!queue.isEmpty()) {
            Beam beam = queue.poll();

            String state = beam.row + "," + beam.col;
            if (visited.contains(state)) continue;
            visited.add(state);

            int nextRow = beam.row + 1;
            int nextCol = beam.col;

            if (isOutOfBounds(nextRow, nextCol)) continue;

            char cell = grid[nextRow][nextCol];

            if (cell == '.' || cell == 'S') {
                queue.add(new Beam(nextRow, nextCol));
            }
            else if (cell == '^') {
                String splitterKey = nextRow + "," + nextCol;
                splittersHit.add(splitterKey);

                int leftCol = nextCol - 1;
                int rightCol = nextCol + 1;

                if (!isOutOfBounds(nextRow, leftCol)) {
                    queue.add(new Beam(nextRow, leftCol));
                }

                if (!isOutOfBounds(nextRow, rightCol)) {
                    queue.add(new Beam(nextRow, rightCol));
                }
            }
        }

        return splittersHit.size();
    }

    // ========== PARTE 2 - ABORDAGEM DE CONTAGEM ==========
    public long countTimelines() {
        // Mapa: posição -> número de caminhos únicos que chegam aqui
        Map<String, Long> pathCount = new HashMap<>();

        // Fila de processamento por linha (processa linha por linha)
        Queue<String> queue = new LinkedList<>();

        // Começar em S com 1 caminho
        String startKey = startRow + "," + startCol;
        pathCount.put(startKey, 1L);
        queue.add(startKey);

        // Rastrear posições já processadas
        Set<String> processed = new HashSet<>();

        long totalExitPaths = 0;

        while (!queue.isEmpty()) {
            String posKey = queue.poll();

            if (processed.contains(posKey)) continue;
            processed.add(posKey);

            String[] parts = posKey.split(",");
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);

            long pathsHere = pathCount.getOrDefault(posKey, 0L);
            if (pathsHere == 0) continue;

            // Próxima posição (desce)
            int nextRow = row + 1;
            int nextCol = col;

            // Se saiu do grid, conta os caminhos que chegaram aqui
            if (isOutOfBounds(nextRow, nextCol)) {
                totalExitPaths += pathsHere;
                continue;
            }

            char cell = grid[nextRow][nextCol];
            String nextKey = nextRow + "," + nextCol;

            if (cell == '.' || cell == 'S') {
                // Todos os caminhos continuam para a próxima posição
                pathCount.put(nextKey, pathCount.getOrDefault(nextKey, 0L) + pathsHere);
                queue.add(nextKey);
            }
            else if (cell == '^') {
                // Divisão: os caminhos se dividem em LEFT e RIGHT
                int leftCol = nextCol - 1;
                int rightCol = nextCol + 1;

                if (!isOutOfBounds(nextRow, leftCol)) {
                    String leftKey = nextRow + "," + leftCol;
                    pathCount.put(leftKey, pathCount.getOrDefault(leftKey, 0L) + pathsHere);
                    queue.add(leftKey);
                }

                if (!isOutOfBounds(nextRow, rightCol)) {
                    String rightKey = nextRow + "," + rightCol;
                    pathCount.put(rightKey, pathCount.getOrDefault(rightKey, 0L) + pathsHere);
                    queue.add(rightKey);
                }
            }
        }

        return totalExitPaths;
    }

    public static void main(String[] args) {
        Path filePath = Path.of(
                "src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_07_Laboratories/input.txt"
        );

        Laboratories lab = new Laboratories();
        lab.readFile(filePath);

        System.out.println("\n========== PARTE 1 ==========");
        int splits = lab.countSplits();
        System.out.println("Total de divisões: " + splits);

        System.out.println("\n========== PARTE 2 ==========");
        long timelines = lab.countTimelines();
        System.out.println("Total de timelines: " + timelines);
    }
}