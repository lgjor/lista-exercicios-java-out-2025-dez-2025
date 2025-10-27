package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_05_The_Piano_Puzzle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ThePianoPuzzleOptimized {

    // As 7 notas que PRECISAM estar na subsequência.
    final char[] SEVEN_NOTES_ARRAY = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    final int NUMBER_OF_UNIQUE_NOTES = SEVEN_NOTES_ARRAY.length;

    /**
     * Lê o conteúdo de um arquivo de texto.
     */
    public static String readFile(String nomeArquivo) throws IOException {
        if (nomeArquivo == null || nomeArquivo.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do arquivo não pode ser nulo ou vazio");
        }

        StringBuilder conteudo = new StringBuilder();

        // Garante que o BufferedReader seja fechado automaticamente (try-with-resources)
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            // Lê o arquivo linha por linha para um desempenho potencialmente melhor (dependendo do SO/arquivos grandes)
            // Mantendo a leitura de caracteres para ser mais fiel ao original, mas simplificando para string total.
            int charLido;
            while ((charLido = br.read()) != -1) {
                conteudo.append((char) charLido);
            }
        }
        return conteudo.toString();
    }

    /**
     * Encontra a menor subsequência que contém todas as 7 notas usando o algoritmo de Janela Deslizante.
     * Complexidade de tempo: O(N), onde N é o comprimento da sequência completa.
     */
    String getSmallerSequenceOptimized(String fullSequence) {
        if (fullSequence == null || fullSequence.length() < NUMBER_OF_UNIQUE_NOTES) {
            return "not found";
        }

        // 1. Estruturas para rastrear notas na Janela Deslizante.
        // Usamos um Map para rastrear a contagem de cada nota (A-G) dentro da nossa janela.
        Map<Character, Integer> windowCounts = new HashMap<>();

        // Define quais caracteres são as notas
        for (char note : SEVEN_NOTES_ARRAY) {
            windowCounts.put(note, 0); // Inicializa a contagem para 0
        }

        // Variável de controle: quantos dos 7 tipos de notas únicos foram encontrados na janela.
        int uniqueNotesFound = 0;

        // Variáveis para rastrear a menor janela encontrada.
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        // 2. Expansão da Janela (com o ponteiro 'right').
        for (int right = 0; right < fullSequence.length(); right++) {
            char charRight = fullSequence.charAt(right);

            if (windowCounts.containsKey(charRight)) {
                // Adiciona o caractere atual à janela e atualiza sua contagem.
                windowCounts.put(charRight, windowCounts.get(charRight) + 1);

                // Se a contagem para esta nota atingiu 1, encontramos uma nova nota única.
                if (windowCounts.get(charRight) == 1) {
                    uniqueNotesFound++;
                }
            }

            // 3. Contração da Janela (com o ponteiro 'left') - Condição: Encontramos todas as 7 notas.
            while (uniqueNotesFound == NUMBER_OF_UNIQUE_NOTES) {
                // Sequência Válida Encontrada! Verifica se é a menor até agora.
                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    minStart = left;
                }

                // Tenta contrair a janela (mover 'left' para a direita) para encontrar uma sequência menor.
                char charLeft = fullSequence.charAt(left);

                if (windowCounts.containsKey(charLeft)) {
                    // Remove o caractere 'left' da janela e atualiza sua contagem.
                    windowCounts.put(charLeft, windowCounts.get(charLeft) - 1);

                    // Se a contagem desta nota caiu para 0, perdemos uma nota única.
                    if (windowCounts.get(charLeft) == 0) {
                        uniqueNotesFound--;
                    }
                }
                left++; // Move o ponteiro esquerdo para contrair a janela.
            }
        }

        // 4. Resultado.
        // Se minLength for MAX_VALUE, nenhuma subsequência válida foi encontrada.
        return minLength == Integer.MAX_VALUE ? "not found" : fullSequence.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) throws IOException {
        String filePath = "/mnt/d/projetos/lista-exercicios-java-out-2025-dez-2025/src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_05_The_Piano_Puzzle/hyperskill-dataset-117371123.txt";
        String fullSequence = "";
        try{
            fullSequence = readFile(filePath);
        } catch (IOException e){
            System.out.println("O arquivo não pode ser lido: "+e.getMessage());
        }

        ThePianoPuzzleOptimized thePianoPuzzle = new ThePianoPuzzleOptimized();
        System.out.println(thePianoPuzzle.getSmallerSequenceOptimized(fullSequence));
    }
}
