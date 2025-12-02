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

    /**
     * Verifica se o ID é composto INTEIRAMENTE pela repetição de sua menor subsequência.
     * @param id O ID a ser verificado.
     * @return true se o ID for uma sequência repetida, false caso contrário.
     */
    public static boolean hasRepeatedSequence(long id) {
        String idStr = String.valueOf(id);
        int length = idStr.length();

        if (length < 2) {
            return false;
        }

        // Tenta todos os possíveis tamanhos de subsequência (períodos) de 1 até a metade
        for (int periodo = 1; periodo <= length / 2; periodo++) {

            // Critério 1: O comprimento total deve ser um múltiplo do período (repetição exata)
            if (length % periodo == 0) {

                String sequencia = idStr.substring(0, periodo);
                boolean isRepeated = true;

                // Critério 2: Verifica se TODAS as subsequências são IGUAIS à primeira
                for (int i = periodo; i < length; i += periodo) {
                    String proximaSequencia = idStr.substring(i, Math.min(i + periodo, length)); // Math.min() para segurança

                    if (!sequencia.equals(proximaSequencia)) {
                        isRepeated = false;
                        break;
                    }
                }

                if (isRepeated) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Altere este caminho para o caminho real do seu arquivo
        String filePath = "src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_02_GiftShop/input.txt";

        System.out.println("Tentando ler o arquivo em: " + filePath);
        List<IDRange> ranges = List.of();
        long somaDosIdsInvalidos = 0;
        try {
            ranges = readIdRangesFromFile(filePath);

            //System.out.println("\nIntervalos de IDs lidos:");
            for (IDRange range : ranges) {
                System.out.println(range);
                //System.out.println("Tamanho do intervalo: " + range.getSize());

                System.out.print("IDs com sequência repetida encontrados no intervalo: ");
                for (long i = range.startId; i <= range.endId; i++){
                    if (isRepeatedSequence(i)) {
                        System.out.print(i+" ");
                        somaDosIdsInvalidos+=i;
                    }
                }
                System.out.println();
            }
            System.out.println("----------------- Resultado da parte 1 --------------------");
            System.out.println( "Soma dos Id's inválidos: "+ somaDosIdsInvalidos );
            System.out.println("-----------------------------------------------------------");

            // Reinicia a soma para realizar a parte 2
            somaDosIdsInvalidos=0;

            for (IDRange range : ranges) {
                System.out.println("\nIntervalo: " + range);

                System.out.println("IDs Inválidos (Sequência Repetida ≥ 2x) no Intervalo:");

                for (long i = range.startId; i <= range.endId; i++){

                    // Verifica se o ID é INVÁLIDO usando o critério mais abrangente
                    if (hasRepeatedSequence(i)) {
                        System.out.println("  -> ID Inválido encontrado: " + i);
                        // Soma o ID à variável de resultado
                        somaDosIdsInvalidos += i;
                    }
                }
            }

            // Resultado Final
            System.out.println("\n===========================================================");
            System.out.println("🚀 Soma Total dos Id's inválidos (Critério Final): " + somaDosIdsInvalidos);
            System.out.println("===========================================================");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}