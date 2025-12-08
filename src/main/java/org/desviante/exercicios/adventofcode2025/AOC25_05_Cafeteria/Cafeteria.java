package org.desviante.exercicios.adventofcode2025.AOC25_05_Cafeteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafeteria {
    record Interval(long start, long end, long size) {
        // Construtor compacto para calcular automaticamente o tamanho
        public Interval(long start, long end) {
            this(start, end, (end - start + 1));
        }
    }
    List<Interval> ranges = new ArrayList<>();
    List<Long> ingredients = new ArrayList<>();
    List<Long> freshIngredients = new ArrayList<>();

    // Read all intervals in the input file, until the empty line
    public void readIntervals(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Ler até encontrar uma linha vazia
            while ((line = br.readLine()) != null && !line.isBlank()) {

                // Cada linha tem o formato "X-Y"
                String[] parts = line.split("-");
                long start = Long.parseLong(parts[0].trim());
                long end = Long.parseLong(parts[1].trim());

                ranges.add(new Interval(start, end));
            }
        }
    }

    // Read all ingredients
    public void readIngredientIds(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // avançar até a linha vazia
            while ((line = br.readLine()) != null && !line.isBlank()) {
                // pula linhas de intervalos
            }

            // Ler IDs até o fim do arquivo
            while ((line = br.readLine()) != null && !line.isBlank()) {
                long ingredient = Long.parseLong(line.trim());
                ingredients.add(ingredient);
                if (isFresh(ingredient)){
                    freshIngredients.add(ingredient);
                }
            }
        }
    }

    public boolean isFresh(long ingredient){
        for (Interval interval: ranges){
            if (ingredient>=interval.start && ingredient<=interval.end){
                return true;
            }
        }
        return false;
    }

    public long countUniqueElements() {
        if (ranges.isEmpty()) return 0;

        // 1. Ordena por início
        List<Interval> sorted = new ArrayList<>(ranges);
        sorted.sort(Comparator.comparingLong(Interval::start));

        long total = 0;

        // 2. Começa com o primeiro intervalo
        long currentStart = sorted.get(0).start();
        long currentEnd = sorted.get(0).end();

        // 3. Percorre a lista ordenada
        for (int i = 1; i < sorted.size(); i++) {

            Interval in = sorted.get(i);

            if (in.start() <= currentEnd + 1) {
                // Há overlap → mescla
                currentEnd = Math.max(currentEnd, in.end());
            } else {
                // Não há overlap → soma tamanho do intervalo anterior
                total += (currentEnd - currentStart + 1);

                // Move para o próximo
                currentStart = in.start();
                currentEnd = in.end();
            }
        }

        // Soma último intervalo
        total += (currentEnd - currentStart + 1);

        return total;
    }

    public static void main(String[] args) throws IOException {
        final String filePath = "src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_05_Cafeteria/input.txt";
        Cafeteria coffeshop = new Cafeteria();
        coffeshop.readIntervals(filePath);
        coffeshop.readIngredientIds(filePath);
        System.out.println(coffeshop.ranges);
        System.out.println(coffeshop.ingredients);
        System.out.println("Part 1: There are "+coffeshop.freshIngredients.size()+" fresh ingredients");
        System.out.println("Part 2: There are "+coffeshop.countUniqueElements()+" fresh ingredients");

    }

}
