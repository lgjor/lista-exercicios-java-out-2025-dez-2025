package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_03_The_Game_Begins;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TheGameBegins {

    // Função para ler arquivo
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

    /**
     * Lê uma string e retorna uma nova string contendo apenas os caracteres
     * que não se repetem na string original, mantendo a ordem.
     * * @param str A string de entrada.
     * @return Uma string com os caracteres únicos (não repetidos).
     */
    public static String getCaracteresUnicos(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        // 1. Contar a frequência de cada caractere, mantendo a ordem de inserção
        // LinkedHashMap é usado para preservar a ordem em que os caracteres aparecem
        Map<Character, Integer> frequencia = new LinkedHashMap<>();

        for (char caractere : str.toCharArray()) {
            frequencia.put(caractere, frequencia.getOrDefault(caractere, 0) + 1);
        }

        // 2. Construir a string de resultado apenas com caracteres com frequência 1
        StringBuilder caracteresUnicos = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() == 1) {
                caracteresUnicos.append(entry.getKey());
            }
        }

        return caracteresUnicos.toString();
    }

    public static void main(String[] args) throws IOException {
        // Considerando que o arquivo está no mesmo pacote do main
        final String filePath = "src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_03_The_Game_Begins/hyperskill-dataset-117323308.txt";
        String input = null;
        // Lê o conteúdo do arquivo
        try {
            input = readFile(filePath);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            return;
        }

        // Exibe os caracteres únicos
        System.out.println(getCaracteresUnicos(input));

    }

}
