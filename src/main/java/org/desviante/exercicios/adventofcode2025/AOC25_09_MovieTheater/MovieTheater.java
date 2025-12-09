package org.desviante.exercicios.adventofcode2025.AOC25_09_MovieTheater;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MovieTheater {

    List<Coordinate> coordinateList;
    Set<Coordinate> redTiles;
    Set<Coordinate> greenTiles;

    // Otimizações
    private int minX, maxX, minY, maxY;  // Bounding box
    private int polygonMinX, polygonMaxX, polygonMinY, polygonMaxY;  // Bounding box estrito do polígono

    static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }

    // Método para ler as coordenadas da entrada
    public void readFile(Path filePath) {
        coordinateList = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length == 2) {
                    int x = Integer.parseInt(parts[0].trim());
                    int y = Integer.parseInt(parts[1].trim());

                    coordinateList.add(new Coordinate(x, y));
                } else {
                    System.err.println("Linha com formato inválido ignorada: " + line);
                }
            }

            // Inicializa os conjuntos e otimizações
            initializeTiles();
            calculateBoundingBox();

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter coordenada para número: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Calcula o bounding box do polígono para limitar a busca.
     */
    private void calculateBoundingBox() {
        if (coordinateList.isEmpty()) {
            return;
        }

        minX = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        minY = Integer.MAX_VALUE;
        maxY = Integer.MIN_VALUE;

        for (Coordinate c : coordinateList) {
            minX = Math.min(minX, c.getX());
            maxX = Math.max(maxX, c.getX());
            minY = Math.min(minY, c.getY());
            maxY = Math.max(maxY, c.getY());
        }

        // Bounding box estrito considerando tiles verdes também
        polygonMinX = minX;
        polygonMaxX = maxX;
        polygonMinY = minY;
        polygonMaxY = maxY;

        for (Coordinate c : greenTiles) {
            polygonMinX = Math.min(polygonMinX, c.getX());
            polygonMaxX = Math.max(polygonMaxX, c.getX());
            polygonMinY = Math.min(polygonMinY, c.getY());
            polygonMaxY = Math.max(polygonMaxY, c.getY());
        }
    }

    /**
     * Inicializa os conjuntos de tiles vermelhos e verdes.
     */
    private void initializeTiles() {
        redTiles = new HashSet<>(coordinateList);
        greenTiles = new HashSet<>();

        // Adiciona tiles verdes que conectam tiles vermelhos consecutivos
        for (int i = 0; i < coordinateList.size(); i++) {
            Coordinate current = coordinateList.get(i);
            Coordinate next = coordinateList.get((i + 1) % coordinateList.size());
            addTilesBetween(current, next);
        }
    }

    /**
     * Adiciona tiles verdes entre duas coordenadas.
     */
    private void addTilesBetween(Coordinate c1, Coordinate c2) {
        int x1 = c1.getX();
        int y1 = c1.getY();
        int x2 = c2.getX();
        int y2 = c2.getY();

        if (x1 == x2) {
            int minY = Math.min(y1, y2);
            int maxY = Math.max(y1, y2);
            for (int y = minY; y <= maxY; y++) {
                Coordinate tile = new Coordinate(x1, y);
                if (!redTiles.contains(tile)) {
                    greenTiles.add(tile);
                }
            }
        } else if (y1 == y2) {
            int minX = Math.min(x1, x2);
            int maxX = Math.max(x1, x2);
            for (int x = minX; x <= maxX; x++) {
                Coordinate tile = new Coordinate(x, y1);
                if (!redTiles.contains(tile)) {
                    greenTiles.add(tile);
                }
            }
        }
    }

    /**
     * Verifica se um ponto está dentro do polígono usando ray casting.
     */
    private boolean isInsidePolygon(int x, int y) {
        int intersections = 0;
        int n = coordinateList.size();

        for (int i = 0; i < n; i++) {
            Coordinate p1 = coordinateList.get(i);
            Coordinate p2 = coordinateList.get((i + 1) % n);

            if ((p1.getY() > y) != (p2.getY() > y)) {
                double xIntersection = (double)(p2.getX() - p1.getX()) * (y - p1.getY()) /
                        (p2.getY() - p1.getY()) + p1.getX();

                if (x < xIntersection) {
                    intersections++;
                }
            }
        }

        return (intersections % 2) == 1;
    }

    /**
     * Verifica se uma coordenada é válida (vermelha ou verde) SEM cache.
     * Otimizado para evitar criar objetos desnecessários.
     */
    private boolean isRedOrGreenFast(int x, int y) {
        // Verificação rápida: está fora do bounding box?
        if (x < polygonMinX || x > polygonMaxX || y < polygonMinY || y > polygonMaxY) {
            return false;
        }

        // Verifica se está nos sets (usa hash direto)
        Coordinate coord = new Coordinate(x, y);
        if (redTiles.contains(coord) || greenTiles.contains(coord)) {
            return true;
        }

        // Última opção: ray casting (mais caro)
        return isInsidePolygon(x, y);
    }

    /**
     * Verifica se os 4 cantos de um retângulo estão dentro do bounding box e são válidos.
     */
    private boolean quickValidityCheck(int x1, int y1, int x2, int y2) {
        // Verifica se está dentro do bounding box
        if (x1 < polygonMinX || x1 > polygonMaxX || x2 < polygonMinX || x2 > polygonMaxX ||
                y1 < polygonMinY || y1 > polygonMaxY || y2 < polygonMinY || y2 > polygonMaxY) {
            return false;
        }

        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);

        // Verifica os 4 cantos
        return isRedOrGreenFast(minX, minY) && isRedOrGreenFast(maxX, minY) &&
                isRedOrGreenFast(minX, maxY) && isRedOrGreenFast(maxX, maxY);
    }

    /**
     * Verifica se todos os tiles de um retângulo são válidos.
     * IMPORTANTE: Para garantir precisão, usa amostragem densa.
     */
    private boolean isRectangleValid(Coordinate c1, Coordinate c2) {
        int x1 = c1.getX();
        int y1 = c1.getY();
        int x2 = c2.getX();
        int y2 = c2.getY();

        // Verificação rápida dos cantos
        if (!quickValidityCheck(x1, y1, x2, y2)) {
            return false;
        }

        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);

        long width = maxX - minX + 1;
        long height = maxY - minY + 1;
        long area = width * height;

        // Para retângulos grandes, usa verificação de perímetro primeiro
        // Se o perímetro inteiro for válido, há boa chance do interior também ser

        // Verifica perímetro completo (bordas)
        for (int x = minX; x <= maxX; x++) {
            if (!isRedOrGreenFast(x, minY)) return false;
            if (!isRedOrGreenFast(x, maxY)) return false;
        }
        for (int y = minY + 1; y < maxY; y++) {
            if (!isRedOrGreenFast(minX, y)) return false;
            if (!isRedOrGreenFast(maxX, y)) return false;
        }

        // Para retângulos pequenos, verifica o interior completo
        if (area <= 50000) {
            for (int x = minX + 1; x < maxX; x++) {
                for (int y = minY + 1; y < maxY; y++) {
                    if (!isRedOrGreenFast(x, y)) {
                        return false;
                    }
                }
            }
            return true;
        }

        // Para retângulos médios, usa amostragem moderada
        if (area <= 500000) {
            int step = Math.max(2, (int)Math.sqrt(area / 5000));
            for (int x = minX + step; x < maxX; x += step) {
                for (int y = minY + step; y < maxY; y += step) {
                    if (!isRedOrGreenFast(x, y)) {
                        return false;
                    }
                }
            }
            // Verifica linhas adicionais
            int midY = (minY + maxY) / 2;
            for (int x = minX; x <= maxX; x += step) {
                if (!isRedOrGreenFast(x, midY)) return false;
            }
            return true;
        }

        // Para retângulos grandes, usa amostragem densa em grid
        int step = Math.max(10, (int)Math.sqrt(area / 2000));
        for (int x = minX + step; x < maxX; x += step) {
            for (int y = minY + step; y < maxY; y += step) {
                if (!isRedOrGreenFast(x, y)) {
                    return false;
                }
            }
        }

        // Verifica linhas e colunas adicionais para maior confiabilidade
        int quarterY1 = minY + (maxY - minY) / 4;
        int quarterY2 = minY + 3 * (maxY - minY) / 4;
        int quarterX1 = minX + (maxX - minX) / 4;
        int quarterX2 = minX + 3 * (maxX - minX) / 4;

        for (int x = minX; x <= maxX; x += step) {
            if (!isRedOrGreenFast(x, quarterY1)) return false;
            if (!isRedOrGreenFast(x, quarterY2)) return false;
        }
        for (int y = minY; y <= maxY; y += step) {
            if (!isRedOrGreenFast(quarterX1, y)) return false;
            if (!isRedOrGreenFast(quarterX2, y)) return false;
        }

        return true;
    }

    /**
     * Calcula a área de um retângulo (Parte 1 e 2).
     */
    private long calculateRectangleArea(Coordinate c1, Coordinate c2) {
        long width = Math.abs((long)c2.getX() - c1.getX()) + 1;
        long height = Math.abs((long)c2.getY() - c1.getY()) + 1;
        return width * height;
    }

    /**
     * Parte 1: Encontra o maior retângulo sem restrições.
     */
    public long findLargestRectangle() {
        if (coordinateList == null || coordinateList.size() < 2) {
            return 0;
        }

        long maxArea = 0;

        for (int i = 0; i < coordinateList.size(); i++) {
            for (int j = i + 1; j < coordinateList.size(); j++) {
                Coordinate c1 = coordinateList.get(i);
                Coordinate c2 = coordinateList.get(j);

                long area = calculateRectangleArea(c1, c2);

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    /**
     * Resultado do cálculo da Parte 2
     */
    static class RectangleResult {
        long area;
        Coordinate corner1;
        Coordinate corner2;

        RectangleResult(long area, Coordinate corner1, Coordinate corner2) {
            this.area = area;
            this.corner1 = corner1;
            this.corner2 = corner2;
        }
    }

    /**
     * Parte 2: Encontra o maior retângulo com tiles vermelhos/verdes.
     * Retorna o resultado completo (área + cantos) em uma única passagem.
     */
    public RectangleResult findLargestRectanglePart2WithDetails() {
        if (coordinateList == null || coordinateList.size() < 2) {
            return new RectangleResult(0, null, null);
        }

        long maxArea = 0;
        Coordinate bestCorner1 = null;
        Coordinate bestCorner2 = null;
        int candidatesChecked = 0;
        int candidatesSkipped = 0;

        System.out.println("Processando " + coordinateList.size() + " coordenadas...");
        int totalPairs = (coordinateList.size() * (coordinateList.size() - 1)) / 2;
        int processed = 0;
        int lastPercent = -1;

        for (int i = 0; i < coordinateList.size(); i++) {
            for (int j = i + 1; j < coordinateList.size(); j++) {
                processed++;

                // Mostra progresso a cada 5%
                int percent = (processed * 100) / totalPairs;
                if (percent % 5 == 0 && percent != lastPercent) {
                    System.out.println("Progresso: " + percent + "% (" + processed + "/" + totalPairs +
                            ") - Melhor área: " + maxArea);
                    lastPercent = percent;
                }

                Coordinate c1 = coordinateList.get(i);
                Coordinate c2 = coordinateList.get(j);

                // Pula se a área potencial não supera o máximo atual
                long potentialArea = calculateRectangleArea(c1, c2);
                if (potentialArea <= maxArea) {
                    candidatesSkipped++;
                    continue;
                }

                // Verifica validade com otimizações
                if (isRectangleValid(c1, c2)) {
                    candidatesChecked++;
                    if (potentialArea > maxArea) {
                        maxArea = potentialArea;
                        bestCorner1 = c1;
                        bestCorner2 = c2;
                        System.out.println("  -> Novo melhor: " + maxArea + " entre " + c1 + " e " + c2);
                    }
                } else {
                    candidatesSkipped++;
                }
            }
        }

        System.out.println("\nEstatísticas de otimização:");
        System.out.println("  - Candidatos verificados completamente: " + candidatesChecked);
        System.out.println("  - Candidatos descartados rapidamente: " + candidatesSkipped);
        System.out.println("  - Tiles verdes no polígono: " + greenTiles.size());

        return new RectangleResult(maxArea, bestCorner1, bestCorner2);
    }

    /**
     * Exibe os detalhes de um resultado.
     */
    public void displayRectangleResult(RectangleResult result) {
        if (result.corner1 == null || result.corner2 == null) {
            System.out.println("Nenhum retângulo válido encontrado.");
            return;
        }

        System.out.println("\nDetalhes do maior retângulo:");
        System.out.println("Canto 1: " + result.corner1);
        System.out.println("Canto 2: " + result.corner2);
        System.out.println("Largura: " + (Math.abs(result.corner2.getX() - result.corner1.getX()) + 1));
        System.out.println("Altura: " + (Math.abs(result.corner2.getY() - result.corner1.getY()) + 1));
        System.out.println("Área: " + result.area);
    }

    public static void main(String[] args) {
        Path filePath = Path.of(
                "src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_09_MovieTheater/input.txt"
        );

        MovieTheater movieTheater = new MovieTheater();
        movieTheater.readFile(filePath);

        System.out.println("Coordenadas lidas: " + movieTheater.coordinateList.size());
        System.out.println("Tiles vermelhos: " + movieTheater.redTiles.size());
        System.out.println("Tiles verdes (bordas): " + movieTheater.greenTiles.size());
        System.out.println("Bounding Box: (" + movieTheater.polygonMinX + "," + movieTheater.polygonMinY +
                ") até (" + movieTheater.polygonMaxX + "," + movieTheater.polygonMaxY + ")");
        System.out.println();

        // === PARTE 1 ===
        System.out.println("=== PARTE 1 ===");
        long start1 = System.currentTimeMillis();
        long largestArea = movieTheater.findLargestRectangle();
        long end1 = System.currentTimeMillis();
        System.out.println("Maior área possível (sem restrições): " + largestArea);
        System.out.println("Tempo: " + (end1 - start1) + "ms");
        System.out.println();

        // === PARTE 2 ===
        System.out.println("=== PARTE 2 ===");
        long start2 = System.currentTimeMillis();
        RectangleResult result = movieTheater.findLargestRectanglePart2WithDetails();
        long end2 = System.currentTimeMillis();
        System.out.println("Maior área possível (apenas tiles vermelhos/verdes): " + result.area);
        System.out.println("Tempo: " + (end2 - start2) + "ms");

        movieTheater.displayRectangleResult(result);
    }
}