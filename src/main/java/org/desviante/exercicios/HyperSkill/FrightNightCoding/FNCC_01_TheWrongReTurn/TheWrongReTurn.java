package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_01_TheWrongReTurn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

public class TheWrongReTurn {

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
    * Conta a frequência dos dígitos '0' a '9' em uma string, e retorna uma
    * lista de pares (Caractere, Contagem) ordenada de forma decrescente pela Contagem.
    * * @param conteudo A string contendo os caracteres (esperam-se dígitos de '0' a '9').
    * @return Uma lista ordenada de pares (Caractere, Frequência).
    */
    public static List<Entry<Character, Integer>> contarEOrdenar(String conteudo) {

        // 1. Array de Frequência para Contagem O(1)
        // Tamanho 10, para índices 0 a 9 (dígitos '0' a '9').
        int[] frequenciaDigitos = new int[10];

        // 2. Contagem da Frequência (O(N))
        if (conteudo == null || conteudo.isEmpty()) {
            return Collections.emptyList();
        }

        for (char c : conteudo.toCharArray()) {
            // Verifica se o caractere é um dígito no intervalo de interesse.
            if (c >= '0' && c <= '9') {
                // Mapeia o caractere ('0' a '9') diretamente para o índice (0 a 9).
                int indice = c - '0';
                frequenciaDigitos[indice]++;
            }
            // Ignora quaisquer outros caracteres (letras, pontuação, espaços, etc.)
        }

        // 3. Preparar a Lista de Pares (Caractere, Contagem)
        // Usamos List<Entry> para manter o par Chave-Valor antes de ordenar.
        List<Entry<Character, Integer>> listaOrdenada = new ArrayList<>();

        for (int i = 0; i < frequenciaDigitos.length; i++) {
            int contagem = frequenciaDigitos[i];

            if (contagem > 0) {
                // Converte o índice de volta para o caractere ('0' + 5 = '5')
                char digito = (char) ('0' + i);
                listaOrdenada.add(new SimpleEntry<>(digito, contagem));
            }
        }

        // 4. Ordenação Decrescente pela Frequência, e em caso de empate, pelo dígito maior (O(K log K), com K<=10)
        // Utilizamos o Comparator.comparingByValue() e .reversed() para ordenar a lista.
        // Em caso de empate na frequência, o dígito maior vem primeiro.
        listaOrdenada.sort(
            Entry.<Character, Integer>comparingByValue(Comparator.reverseOrder())
            .thenComparing(Entry.comparingByKey(Comparator.reverseOrder()))
        );

        return listaOrdenada;
    }

    // Imprime todas as chaves e valores da lista ordenada
    // private static void printKeysAndValues(List<Entry<Character, Integer>> output) {

    //     for (Entry<Character, Integer> entry : output) {
    //         System.out.println(entry.getKey() + " " + entry.getValue());
    //     }

    // }

    // Imprime as 4 primeiras chaves da lista ordenada
    private static void printFirstFourKeys(List<Entry<Character, Integer>> output) {
        if (output == null || output.size() < 4) {
            throw new IllegalArgumentException("Lista deve ter pelo menos 4 elementos");
        }

        for (int i = 0; i < 4; i++) {
            System.out.print(output.get(i).getKey());
        }

    }

    public static void main(String[] args) throws IOException {
        // Considerando que o arquivo está no mesmo pacote do main
        final String filePath01 = "src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_01_TheWrongReTurn/hyperskill-dataset-117262104.txt";
        //final String filePath02 = "src/main/java/org/desviante/exercicios/FrightNightCodingChallengeHyperskill/FNCC_01_TheWrongReTurn/hyperskill-dataset-117266224.txt";
        final String filePath = filePath01;
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

        // Ordena a entrada
        List<Entry<Character, Integer>> orderedList = contarEOrdenar(input);

        //printKeysAndValues(output);
        printFirstFourKeys(orderedList);

    }
}
