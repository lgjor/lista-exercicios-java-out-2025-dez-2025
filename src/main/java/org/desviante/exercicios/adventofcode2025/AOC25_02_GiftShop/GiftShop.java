package org.desviante.exercicios.adventofcode2025.AOC25_02_GiftShop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GiftShop {

    /**
     * Classe interna para representar um intervalo de IDs.
     */
    static class IDRange {
        long startId;
        long endId;

        public IDRange(long startId, long endId) {
            this.startId = startId;
            this.endId = endId;
        }

        public long getSize(){
            return this.endId - this.startId + 1;
        }

        @Override
        public String toString() {
            return "IDRange [startId=" + startId + ", endId=" + endId + "]";
        }
    }

    public static List<IDRange> readIdRangesFromFile(String filePath) throws IOException {
        // Le arquivo como uma única string
        String content = Files.readString(Paths.get(filePath));

        // Limpa a string removendo quebras de linha e espaços em excesso.
        String cleanedContent = content.replaceAll("\\s+", "").trim();

        // Divide a string limpa em intervalos (strings como "11-22").
        String[] rangeStrings = cleanedContent.split(",+");

        List<IDRange> idRanges = new ArrayList<>();

        // Processa cada string de intervalo.
        for (String rangeStr : rangeStrings) {
            if (rangeStr.isEmpty()) continue;

            // Divide cada intervalo em IDs inicial e final.
            String[] ids = rangeStr.split("-");

            if (ids.length == 2) {
                try {
                    // Converte para long
                    long startId = Long.parseLong(ids[0]);
                    long endId = Long.parseLong(ids[1]);
                    idRanges.add(new IDRange(startId, endId));
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao analisar ID: " + rangeStr + ". Pulando.");
                }
            } else {
                System.err.println("Formato de intervalo inválido: " + rangeStr + ". Pulando.");
            }
        }

        return idRanges;
    }

    /**
     * Verifica se um ID é composto por uma sequência de dígitos repetida duas vezes.
     * Ex: 55, 6464, 123123
     * @param id O ID a ser verificado.
     * @return true se o ID for uma sequência repetida, false caso contrário.
     */
    public static boolean isRepeatedSequence(long id) {
        String idStr = String.valueOf(id);
        int length = idStr.length();

        // Um ID de sequência repetida deve ter um número par de dígitos.
        if (length % 2 != 0) {
            return false;
        }

        int halfLength = length / 2;
        String firstHalf = idStr.substring(0, halfLength);
        String secondHalf = idStr.substring(halfLength);

        // Verifica se a primeira metade é igual à segunda.
        return firstHalf.equals(secondHalf);
    }

    public static void main(String[] args) {
        // Altere este caminho para o caminho real do seu arquivo
        String filePath = "src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_02_GiftShop/input.txt";

        System.out.println("Tentando ler o arquivo em: " + filePath);
        List<IDRange> ranges = List.of();
        long somaDosIdsInvalidos = 0;
        try {
            ranges = readIdRangesFromFile(filePath);

            System.out.println("\nIntervalos de IDs lidos:");
            for (IDRange range : ranges) {
                System.out.println(range);
                System.out.println("Tamanho do intervalo: " + range.getSize());

                System.out.println("IDs com sequência repetida encontrados no intervalo: ");
                for (long i = range.startId; i <= range.endId; i++){
                    if (isRepeatedSequence(i)) {
                        System.out.println(i);
                        somaDosIdsInvalidos+=i;
                    }
                }
            }
            System.out.println("----------------- Resultado --------------------");
            System.out.println( "Soma dos Id's inválidos: "+ somaDosIdsInvalidos );
            System.out.println("------------------------------------------------");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}