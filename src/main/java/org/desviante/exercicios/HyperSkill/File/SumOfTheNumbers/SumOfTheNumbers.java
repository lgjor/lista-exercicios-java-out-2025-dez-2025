package org.desviante.exercicios.HyperSkill.File.SumOfTheNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumOfTheNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        // Caminho relativo do arquivo
        String path = "src/main/java/org/desviante/exercicios/HyperSkill/File/SumOfTheNumbers/dataset_91033.txt";

        // Tento ler o arquivo e caso falhe lanço uma exceção
        try (Scanner scanner = new Scanner(new File(path))){
            long sum = 0;
            while (scanner.hasNext()) { // Verifica se ainda há dados
                if (scanner.hasNextInt()) { // Verifica se o PRÓXIMO dado é um inteiro válido
                    sum += scanner.nextInt(); // Se for, soma.
                } else {
                    scanner.next(); // Descarta o dado inválido e move o scanner para o próximo
                }
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.err.println("Erro: O arquivo não foi encontrado no caminho especificado: " + path);
            // Opcional: e.printStackTrace();
        }
    }
}
