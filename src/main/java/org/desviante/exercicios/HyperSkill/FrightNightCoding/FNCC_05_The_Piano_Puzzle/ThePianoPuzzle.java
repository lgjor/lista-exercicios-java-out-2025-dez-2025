package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_05_The_Piano_Puzzle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThePianoPuzzle {

    final char[] SEVENNOTES = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

    public static String readFile(String nomeArquivo) throws IOException {
        if (nomeArquivo == null || nomeArquivo.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do arquivo não pode ser nulo ou vazio");
        }

        StringBuilder conteudo = new StringBuilder();

        // Uso de try-with-resources garante que o BufferedReader seja fechado automaticamente
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            int charLido;
            // Lê o arquivo caractere por caractere e anexa ao StringBuilder
            while ((charLido = br.read()) != -1) {
                conteudo.append((char) charLido);
            }
        }
        return conteudo.toString();
    }

    boolean containsAllSevenNotes(String sequence) {
        boolean[] found = new boolean[7];
        for (char c : sequence.toCharArray()) {
            for (int i = 0; i < SEVENNOTES.length; i++) {
                if (c == SEVENNOTES[i]) {
                    found[i] = true;
                    break;
                }
            }
        }
        // Verifica se todas as 7 notas foram encontradas
        for (boolean b : found) {
            if (!b) return false;
        }
        return true;
    }

    String getSmallerSequence(String fullsequence){
        try {
            if (fullsequence.isEmpty()){
                return "";
            }
            
            // Inicia com a menor sequência possível sendo toda a string
            String shortestSequence = null;
            
            // Percorre todas as posições possíveis de início
            for (int i = 0; i < fullsequence.length(); i++) {
                // Para cada posição de início, tenta encontrar a menor sequência
                // que contém todas as 7 notas
                for (int j = i + 7; j <= fullsequence.length(); j++) {
                    String substring = fullsequence.substring(i, j);
                    
                    // Verifica se contém todas as 7 notas
                    if (containsAllSevenNotes(substring)) {
                        // Encontrou uma sequência válida
                        if (shortestSequence == null || substring.length() < shortestSequence.length()) {
                            shortestSequence = substring;
                        }
                        // Não precisa continuar com este i, já encontrou a menor começando aqui
                        break;
                    }
                }
            }
            
            return shortestSequence != null ? shortestSequence : "not found";

        } catch (NullPointerException e) {
            System.out.println("A sequência é nula, tente nvamente.");
            return "not found";
        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = "/mnt/d/projetos/lista-exercicios-java-out-2025-dez-2025/src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_05_The_Piano_Puzzle/hyperskill-dataset-117371123.txt";
        String fullSequence = "";
        try{
            fullSequence = readFile(filePath);
        } catch (IOException e){
            System.out.println("O arquivo não pode ser lido"+e);
        }
        ThePianoPuzzle thePianoPuzzle = new ThePianoPuzzle();
        System.out.println(thePianoPuzzle.getSmallerSequence(fullSequence));
    }
}
