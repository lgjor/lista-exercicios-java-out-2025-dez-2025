package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_08_The_Eldritch_Horror;

import java.io.*;
import java.util.*;

/**
 * Versão otimizada do TheEldritchHorror
 * 
 * Otimizações implementadas:
 * 1. Elimina duplicação: cria assinaturas apenas uma vez
 * 2. Remove ordenação desnecessária: usa Map diretamente para contar frequências
 * 3. Reduz uso de memória: usa apenas 2 Maps em vez de múltiplas estruturas
 * 4. Complexidade: O(n × k log k) em vez de O(n × k log k + n log n)
 * 
 * @author Otimização baseada na análise de eficiência
 */
public class TheEldritchHorror {

    /**
     * Lê palavras de um arquivo, separadas por espaços em branco
     * @param filename Nome do arquivo a ser lido
     * @return Lista de palavras encontradas no arquivo
     */
    private static List<String> readStringListFromFile(String filename) {
        List<String> listaDeStrings = new ArrayList<>();
        String linha;

        // O bloco try-with-resources garante que o BufferedReader e o FileReader sejam fechados
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            while ((linha = br.readLine()) != null) {
                // Usa expressão regular "\\s+" para dividir por um ou mais espaços em branco
                String[] palavras = linha.split("\\s+");

                // Converte o Array de String em uma Lista e adiciona à lista principal
                listaDeStrings.addAll(Arrays.asList(palavras));
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + filename);
            e.printStackTrace();
        }
        return listaDeStrings;
    }

    /**
     * Cria a assinatura de uma palavra ordenando seus caracteres.
     * Palavras que são anagramas terão a mesma assinatura.
     * 
     * @param palavra A palavra original
     * @return A assinatura (palavra com caracteres ordenados)
     */
    private static String criarAssinatura(String palavra) {
        char[] arrayDeCaracteres = palavra.toCharArray();
        Arrays.sort(arrayDeCaracteres);
        return new String(arrayDeCaracteres);
    }

    /**
     * Processa as palavras e encontra aquelas que não têm anagramas.
     * 
     * Otimizações:
     * - Cria assinaturas apenas uma vez
     * - Usa Map diretamente para contar frequências (elimina ordenação O(n log n))
     * - Armazena palavra original junto com contagem
     * 
     * Complexidade: O(n × k log k) onde n = número de palavras, k = tamanho médio da palavra
     * 
     * @param palavras Lista de palavras originais
     * @return Lista de palavras que não têm anagramas
     */
    private static List<String> encontrarPalavrasSemAnagramas(List<String> palavras) {
        if (palavras == null || palavras.isEmpty()) {
            return Collections.emptyList();
        }

        // Map para contar frequências de cada assinatura
        Map<String, Integer> contadorAssinaturas = new HashMap<>();
        
        // Map para armazenar a primeira palavra original correspondente a cada assinatura
        Map<String, String> assinaturaParaPalavraOriginal = new HashMap<>();

        // Processa todas as palavras em uma única passada
        for (String palavra : palavras) {
            // Cria assinatura apenas UMA vez (otimização: elimina duplicação)
            String assinatura = criarAssinatura(palavra);
            
            // Incrementa contador da assinatura
            // Busca a assinatura no Map.
            // Se encontrar: retorna o valor (a contagem atual).
            // Se não encontrar: retorna o valor padrão 0.
            // Depois: Valor encontrado+1. caso não encontre: 0+1=1;
            // Resumo: Pega a contagem atual da assinatura (ou 0 se não existir), aumenta em 1, e salva o valor atualizado."
            contadorAssinaturas.put(assinatura, contadorAssinaturas.getOrDefault(assinatura, 0) + 1);
            
            // Armazena a primeira palavra original para esta assinatura
            // (só precisamos de uma, pois se houver múltiplas, não é palavra sem anagrama)
            assinaturaParaPalavraOriginal.putIfAbsent(assinatura, palavra);
        }

        // Encontra palavras cuja assinatura aparece apenas uma vez (sem anagramas)
        List<String> palavrasSemAnagramas = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : contadorAssinaturas.entrySet()) {
            if (entry.getValue() == 1) {
                String assinatura = entry.getKey();
                String palavraOriginal = assinaturaParaPalavraOriginal.get(assinatura);
                if (palavraOriginal != null) {
                    palavrasSemAnagramas.add(palavraOriginal);
                }
            }
        }

        return palavrasSemAnagramas;
    }

    public static void main(String[] args) {
        String path = "/mnt/d/projetos/lista-exercicios-java-out-2025-dez-2025/src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_08_The_Eldritch_Horror/hyperskill-dataset-117468894.txt";
        
        // Lê palavras do arquivo
        List<String> palavras = readStringListFromFile(path);
        
        // Encontra palavras sem anagramas (otimizado)
        List<String> palavrasSemAnagramas = encontrarPalavrasSemAnagramas(palavras);
        
        // Imprime as palavras encontradas (de acordo com o enunciado, deve haver apenas uma)
        for (String palavra : palavrasSemAnagramas) {
            System.out.println(palavra);
        }
    }
}
