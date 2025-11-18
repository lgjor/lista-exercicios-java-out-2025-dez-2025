package org.desviante.exercicios.HyperSkill.File.CountNumbersInAFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountNumbersInAFile {
    public static void main(String[] args) throws FileNotFoundException {
        // Caminho relativo do arquivo
        String path = "src/main/java/org/desviante/exercicios/HyperSkill/File/CountNumbersInAFile/dataset_91022.txt";

        // Tento ler o arquivo e caso falhe lanço uma exceção
        try (Scanner scanner = new Scanner(new File(path))){
            long count = 0;
            while (scanner.hasNext()) { // Verifica se ainda há dados
                if (scanner.hasNextInt()) { // Verifica se o PRÓXIMO dado é um inteiro válido
                    // Verifica se número é maior que 9999 e incrementa a contagem
                    if (scanner.nextInt()>=9999){
                        count++;
                    }
                } else {
                    scanner.next(); // Descarta o dado inválido e move o scanner para o próximo
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            System.err.println("Erro: O arquivo não foi encontrado no caminho especificado: " + path);
            // Opcional: e.printStackTrace();
        }
    }
}
