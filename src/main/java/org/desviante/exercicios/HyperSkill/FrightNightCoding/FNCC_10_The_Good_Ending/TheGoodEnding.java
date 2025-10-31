package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_10_The_Good_Ending;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheGoodEnding {

    public static List<String> readFile(String path) throws IOException {
        if (path==null){
            return null;
        }

        return Files.readAllLines(Path.of(path));
    }

    /**
     * Extrai os caracteres sem pares de cada linha.
     * Cada linha tem 16 caracteres: 8 à esquerda e 8 à direita.
     * Procura caracteres que aparecem apenas uma vez (sem par).
     *
     * @param listaOriginal A lista de strings a ser processada.
     * @return Uma única string contendo os caracteres sem pares de cada linha.
     */
    public static String obterStringTotalComCaracteresUnicos(List<String> listaOriginal) {
        return listaOriginal.stream()
                .map(TheGoodEnding::extrairCaracteresSemPar)
                .collect(Collectors.joining());
    }

    /**
     * Função auxiliar para extrair os caracteres sem pares de uma linha.
     * Conta a frequência de cada caractere e retorna apenas os que aparecem uma vez.
     *
     * @param s A string de entrada (16 caracteres).
     * @return Uma string contendo apenas os caracteres sem par.
     */
    private static String extrairCaracteresSemPar(String s) {
        // Conta a frequência de cada caractere
        Map<Character, Integer> frequencia = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            frequencia.put(c, frequencia.getOrDefault(c, 0) + 1);
        }
        
        // Retorna apenas os caracteres que aparecem uma vez
        return frequencia.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) throws IOException {
        // Caminho do arquivo de strings
        String path = "/mnt/d/projetos/lista-exercicios-java-out-2025-dez-2025/src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_10_The_Good_Ending/hyperskill-dataset-117526442.txt";
        List<String> listaDePalavras = readFile(path);
        System.out.println(obterStringTotalComCaracteresUnicos(listaDePalavras));
    }
}
