package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_02_TheWhiteNoise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TheWhiteNoise {

    // Função para ler arquivo e retornar lista angulos positivos válidos entre 0 and 359.
    public static List<Integer> readFile(String nomeArquivo) throws IOException {
        if (nomeArquivo == null || nomeArquivo.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do arquivo não pode ser nulo ou vazio");
        }

        List<Integer> numeros = new ArrayList<>();

        // Uso de try-with-resources garante que o BufferedReader seja fechado automaticamente
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            // Lê o arquivo linha por linha
            while ((linha = br.readLine()) != null) {
                // Remove espaços em branco e quebras de linha
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    // Divide a linha por vírgulas e converte cada parte para inteiro
                    String[] partes = linha.split(",");
                    for (String parte : partes) {
                        try {
                            int numero = Integer.parseInt(parte.trim());
                            numeros.add(numero%360);
                        } catch (NumberFormatException e) {
                            // Ignora partes que não são números válidos
                            System.err.println("Aviso: Ignorando valor inválido: " + parte);
                        }
                    }
                }
            }
        }
        return numeros;
    }

    // Função para calcular a soma dos ângulos
    public static int calculateAngleSum(List<Integer> angles) {
        int soma = 0;
        for (int numero : angles) {
            soma += numero;
        }
        return soma;
    }

    public static void main(String[] args) throws IOException {
        final String filePath = "src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_02_TheWhiteNoise/hyperskill-dataset-117290312.txt";
        List<Integer> angles = null;
        
        // Lê o conteúdo do arquivo
        try {
            angles = readFile(filePath);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            return;
        }
        System.out.println("Soma dos ângulos: " + calculateAngleSum(angles));
    }
}
