package org.desviante.exercicios.adventofcode2025.AOC25_08_Playground;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class Playground {

    List<Coordinate> coordinateList;
    UnionFind unionFind;

    static class Coordinate {
        private int x;
        private int y;
        private int z;
        private int index; // Índice na lista para usar com DSU

        public Coordinate(int x, int y, int z, int index) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.index = index;
        }

        public int getX() { return x; }
        public int getY() { return y; }
        public int getZ() { return z; }
        public int getIndex() { return index; }

        // Calcula a distância euclidiana entre duas coordenadas 3D
        public double distanceTo(Coordinate other) {
            double dx = this.x - other.x;
            double dy = this.y - other.y;
            double dz = this.z - other.z;
            return Math.sqrt(dx * dx + dy * dy + dz * dz);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %d)", x, y, z);
        }
    }

    // Classe para representar um par de coordenadas com sua distância
    static class CoordinatePair implements Comparable<CoordinatePair> {
        int index1;
        int index2;
        double distance;

        public CoordinatePair(int index1, int index2, double distance) {
            this.index1 = index1;
            this.index2 = index2;
            this.distance = distance;
        }

        @Override
        public int compareTo(CoordinatePair other) {
            int distCompare = Double.compare(this.distance, other.distance);
            if (distCompare != 0) {
                return distCompare;
            }
            // Desempate: primeiro por index1, depois por index2
            if (this.index1 != other.index1) {
                return Integer.compare(this.index1, other.index1);
            }
            return Integer.compare(this.index2, other.index2);
        }
    }

    // Estrutura Union-Find (DSU)
    static class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;  // Cada elemento é seu próprio líder
                size[i] = 1;    // Cada circuito tem tamanho 1
            }
        }

        // Find com path compression
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Compressão de caminho
            }
            return parent[x];
        }

        // Union by size
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false; // Já estão no mesmo circuito
            }

            // Anexa a árvore menor na maior
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            return true;
        }

        // Retorna o tamanho do circuito que contém x
        public int getSize(int x) {
            return size[find(x)];
        }

        // Retorna todos os tamanhos de circuitos únicos
        public List<Integer> getAllCircuitSizes() {
            Map<Integer, Integer> circuits = new HashMap<>();
            for (int i = 0; i < parent.length; i++) {
                int root = find(i);
                circuits.put(root, size[root]);
            }
            return new ArrayList<>(circuits.values());
        }
    }

    // Método para ler as coordenadas 3D da entrada
    public void readFile(Path filePath) {
        coordinateList = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(filePath);
            int index = 0;

            for (String line : lines) {
                line = line.trim();

                // Ignora linhas vazias
                if (line.isEmpty()) {
                    continue;
                }

                // Divide a linha por vírgula
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    int x = Integer.parseInt(parts[0].trim());
                    int y = Integer.parseInt(parts[1].trim());
                    int z = Integer.parseInt(parts[2].trim());

                    coordinateList.add(new Coordinate(x, y, z, index));
                    index++;
                } else {
                    System.err.println("Linha com formato inválido ignorada: " + line);
                }
            }

            // Inicializa o UnionFind com o número de coordenadas
            unionFind = new UnionFind(coordinateList.size());

            System.out.println("Total de coordenadas lidas: " + coordinateList.size());

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter coordenada para número: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Conecta as N conexões mais curtas (conta tentativas, não sucessos)
    public void connectShortestPairs(int numAttempts) {
        if (coordinateList == null || coordinateList.isEmpty()) {
            System.out.println("Nenhuma coordenada carregada!");
            return;
        }

        // Cria uma fila de prioridade com todos os pares possíveis
        PriorityQueue<CoordinatePair> pairQueue = new PriorityQueue<>();

        System.out.println("Calculando distâncias entre todos os pares...");
        for (int i = 0; i < coordinateList.size(); i++) {
            for (int j = i + 1; j < coordinateList.size(); j++) {
                Coordinate c1 = coordinateList.get(i);
                Coordinate c2 = coordinateList.get(j);
                double distance = c1.distanceTo(c2);
                pairQueue.add(new CoordinatePair(i, j, distance));
            }
        }

        // Processa as N tentativas mais próximas
        int connectionsCreated = 0;
        int attemptsProcessed = 0;

        while (attemptsProcessed < numAttempts && !pairQueue.isEmpty()) {
            CoordinatePair pair = pairQueue.poll();
            attemptsProcessed++;

            Coordinate c1 = coordinateList.get(pair.index1);
            Coordinate c2 = coordinateList.get(pair.index2);

            // Tenta unir os dois circuitos
            if (unionFind.union(pair.index1, pair.index2)) {
                connectionsCreated++;
                System.out.println(String.format("Tentativa %d [CONECTADO]: %s <-> %s (distância: %.2f)",
                        attemptsProcessed, c1, c2, pair.distance));
            } else {
                // Debug: mostra tentativas ignoradas
                System.out.println(String.format("Tentativa %d [IGNORADO]: %s <-> %s (distância: %.2f) - já no mesmo circuito",
                        attemptsProcessed, c1, c2, pair.distance));
            }
        }

        System.out.println(String.format("\n%d tentativas processadas (%d conexões criadas)",
                attemptsProcessed, connectionsCreated));
    }

    // Conecta até formar um único circuito (Parte 2)
    public long connectUntilSingleCircuit() {
        if (coordinateList == null || coordinateList.isEmpty()) {
            System.out.println("Nenhuma coordenada carregada!");
            return 0;
        }

        // Cria uma fila de prioridade com todos os pares possíveis
        PriorityQueue<CoordinatePair> pairQueue = new PriorityQueue<>();

        System.out.println("Calculando distâncias entre todos os pares...");
        for (int i = 0; i < coordinateList.size(); i++) {
            for (int j = i + 1; j < coordinateList.size(); j++) {
                Coordinate c1 = coordinateList.get(i);
                Coordinate c2 = coordinateList.get(j);
                double distance = c1.distanceTo(c2);
                pairQueue.add(new CoordinatePair(i, j, distance));
            }
        }

        int connectionsCreated = 0;
        int totalCircuits = coordinateList.size(); // Inicialmente, cada caixa é seu próprio circuito
        CoordinatePair lastConnection = null;

        System.out.println("Conectando até formar um único circuito...\n");

        while (totalCircuits > 1 && !pairQueue.isEmpty()) {
            CoordinatePair pair = pairQueue.poll();

            Coordinate c1 = coordinateList.get(pair.index1);
            Coordinate c2 = coordinateList.get(pair.index2);

            // Tenta unir os dois circuitos
            if (unionFind.union(pair.index1, pair.index2)) {
                connectionsCreated++;
                totalCircuits--; // Dois circuitos se tornaram um
                lastConnection = pair; // Salva a última conexão

                System.out.println(String.format("Conexão %d: %s <-> %s (distância: %.2f) | Circuitos restantes: %d",
                        connectionsCreated, c1, c2, pair.distance, totalCircuits));
            }
        }

        if (totalCircuits == 1 && lastConnection != null) {
            Coordinate c1 = coordinateList.get(lastConnection.index1);
            Coordinate c2 = coordinateList.get(lastConnection.index2);
            long productX = (long) c1.getX() * c2.getX();

            System.out.println("\n=== Circuito Único Formado! ===");
            System.out.println(String.format("Última conexão: %s <-> %s", c1, c2));
            System.out.println(String.format("Coordenadas X: %d e %d", c1.getX(), c2.getX()));
            System.out.println(String.format("Produto das coordenadas X: %d × %d = %d",
                    c1.getX(), c2.getX(), productX));

            return productX;
        } else {
            System.out.println("\nErro: Não foi possível formar um único circuito!");
            return 0;
        }
    }
    public int analyzeCircuits() {
        if (unionFind == null) {
            System.out.println("UnionFind não inicializado!");
            return 0;
        }

        List<Integer> circuitSizes = unionFind.getAllCircuitSizes();
        circuitSizes.sort((a, b) -> b - a); // Ordena em ordem decrescente

        System.out.println("\n=== Análise dos Circuitos ===");
        System.out.println("Total de circuitos: " + circuitSizes.size());
        System.out.println("Tamanhos dos circuitos: " + circuitSizes);

        if (circuitSizes.size() >= 3) {
            int product = circuitSizes.get(0) * circuitSizes.get(1) * circuitSizes.get(2);
            System.out.println(String.format("\nTrês maiores circuitos: %d, %d, %d",
                    circuitSizes.get(0), circuitSizes.get(1), circuitSizes.get(2)));
            System.out.println("Produto: " + product);
            return product;
        }

        return 0;
    }

    public static void main(String[] args) {
        Path filePath = Path.of(
                "src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_08_Playground/input.txt"
        );

        Playground playground = new Playground();

        // ========== PARTE 1 ==========
        System.out.println("========== PARTE 1 ==========\n");
        playground.readFile(filePath);
        playground.connectShortestPairs(10);
        playground.analyzeCircuits();

        // ========== PARTE 2 ==========
        System.out.println("\n\n========== PARTE 2 ==========\n");

        // Reinicia o UnionFind para começar do zero
        playground = new Playground();
        playground.readFile(filePath);
        long resultado = playground.connectUntilSingleCircuit();

        System.out.println("\n=== Resposta da Parte 2 ===");
        System.out.println("Produto das coordenadas X: " + resultado);
    }
}