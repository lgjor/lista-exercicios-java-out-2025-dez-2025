package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_07_The_Phone_Call;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThePhoneCall {

    /**
     * Lê um número decimal do arquivo dataset
     * @param filename Nome do arquivo a ser lido
     * @return O número decimal encontrado no arquivo
     * @throws RuntimeException se o arquivo não for encontrado ou houver erro na leitura
     */
    private static long readNumberFromFile(String filename) {
        File file = new File(filename);
        
        // Verifica se o arquivo existe
        if (!file.exists()) {
            throw new RuntimeException("Arquivo não encontrado: " + filename);
        }
        
        // Verifica se o arquivo pode ser lido
        if (!file.canRead()) {
            throw new RuntimeException("Não é possível ler o arquivo: " + filename);
        }
        
        try (Scanner scanner = new Scanner(file)) {
            // Verifica se há conteúdo no arquivo
            if (!scanner.hasNext()) {
                throw new RuntimeException("Arquivo está vazio: " + filename);
            }
            
            // Lê o número
            if (scanner.hasNextLong()) {
                return scanner.nextLong();
            } else {
                throw new RuntimeException("Conteúdo inválido no arquivo: " + filename + 
                                         ". Esperado um número decimal.");
            }
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Erro ao abrir o arquivo: " + filename, e);
        }
    }
    public static void main(String[] args) {
        // Lê o número decimal do arquivo dataset
        long numeroDecimal = readNumberFromFile("src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_07_The_Phone_Call/hyperskill-dataset-117438167.txt");

        System.out.println("Número decimal: " + numeroDecimal);
        
        // Valor de overflow: 2^32 = 4294967296
        long max32Bit = 1L << 32; // 4294967296
        
        int overflows = 0;
        long numeroAtual = numeroDecimal;
        
        // Calcula quantos overflows são necessários
        while (numeroAtual > max32Bit) {
            overflows++;
            numeroAtual -= max32Bit;
        }
        
        // Converte para binário
        String binario = Long.toBinaryString(numeroAtual);
        
        // Remove zeros à esquerda
        binario = binario.replaceFirst("^0+", "");
        
        // Se todos os dígitos eram zeros, mantém pelo menos um zero
        if (binario.isEmpty()) {
            binario = "0";
        }
        
        // Saída no formato: número_de_overflows,binário
        System.out.println(overflows + "," + binario);
    }
}