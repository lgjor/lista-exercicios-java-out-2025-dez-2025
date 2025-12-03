package org.desviante.exercicios.adventofcode2025.AOC25_03_Lobby;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Lobby {

    public static void ajustarParaDoze(List<Integer> lista) {

        int tamanhoDesejado = 12;
        int tamanhoAtual = lista.size();

        // 1. Verificar se a lista já é igual ou menor que o tamanho desejado
        if (tamanhoAtual <= tamanhoDesejado) {
            System.out.println("A lista já tem " + tamanhoAtual + " elementos. Nenhuma remoção necessária.");
            return;
        }

        // 2. Calcular o número de elementos a remover
        int elementosParaRemover = tamanhoAtual - tamanhoDesejado;

        System.out.println("Removendo " + elementosParaRemover + " elementos do final da lista.");

        // 3. Remover a quantidade necessária
        for (int i = 0; i < elementosParaRemover; i++) {
            // Remove o último elemento da lista a cada iteração
            // list.size() - 1 sempre aponta para o último índice
            lista.remove(lista.size() - 1);
        }
    }
    static String getMaiorImpacto(String bancoDeBaterias){
        int maiorImpacto = 0;
        int segundoMaiorImpacto = 0;
        int indexOfMaiorImpacto = 0;
        // Busca o maior digito
        for (int i=0; i<bancoDeBaterias.length()-1; i++){
            int impactoAtual = Character.getNumericValue(bancoDeBaterias.charAt(i));
            if ( impactoAtual > maiorImpacto ) {
                maiorImpacto = impactoAtual;
                indexOfMaiorImpacto = i;
            }
        }
        // Busca o segundo maior digito
        for (int i=indexOfMaiorImpacto+1; i<bancoDeBaterias.length(); i++){
            int impactoAtual = Character.getNumericValue(bancoDeBaterias.charAt(i));
            if (i!= indexOfMaiorImpacto){
                if ( impactoAtual > segundoMaiorImpacto ) {
                    segundoMaiorImpacto = impactoAtual;
                }
            }
        }
        return String.valueOf(maiorImpacto)+String.valueOf(segundoMaiorImpacto);
    }

    /**
     * Dada uma String
     * Ler cada dígito da esquerda para a direita.
     * Enquanto o último dígito adicionado à pilha for menor que o atual, removemos o último — se ainda temos remoções disponíveis.
     * Sempre adicionamos o dígito atual ao final.
     * Se ainda faltar remover dígitos no final, removemos do final.
     * O resultado tem 12 dígitos.
     * @return long
     */
    static long getMaiorImpactoParteDois(String bancoDeBaterias){

        if (bancoDeBaterias == null || bancoDeBaterias.length() <= 12) {
            return Long.parseLong(bancoDeBaterias);
        }

        int elementosParaRemover = bancoDeBaterias.length() - 12;

        Deque<Character> resultadoStack = new ArrayDeque<>();

        for (int i = 0; i < bancoDeBaterias.length(); i++) {
            char digitoAtual = bancoDeBaterias.charAt(i);

            while (!resultadoStack.isEmpty() &&
                    resultadoStack.peekLast() < digitoAtual &&
                    elementosParaRemover > 0)
            {
                resultadoStack.removeLast();
                elementosParaRemover--;
            }

            resultadoStack.addLast(digitoAtual);
        }

        // Se ainda temos remoções pendentes, remover do final
        while (elementosParaRemover > 0) {
            resultadoStack.removeLast();
            elementosParaRemover--;
        }

        // Assegure exatamente 12 dígitos
        while (resultadoStack.size() > 12) {
            resultadoStack.removeLast();
        }

        StringBuilder resultado = new StringBuilder(12);
        for (char c : resultadoStack) {
            resultado.append(c);
        }

        return Long.parseLong(resultado.toString());
    }

    public static void main(String[] args) {
        final String filePath = "src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_03_Lobby/input.txt";
        System.out.println("--- Bancos de bateria lidos ---");
        long resultadoParte1 = 0;
        long resultadoParte2 = 0;
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String bancoDeBaterias = scanner.nextLine();
                System.out.println(bancoDeBaterias);
                System.out.println("------------------------------------------");
                System.out.println("Gerando o maior impacto parte 1..");
                resultadoParte1 +=Integer.parseInt(getMaiorImpacto(bancoDeBaterias));
                System.out.println("------------------------------------------");
                System.out.println("Gerando o maior impacto parte 2..");
                resultadoParte2 +=getMaiorImpactoParteDois(bancoDeBaterias);
            }
            System.out.println("Maior impacto parte 1: "+ resultadoParte1);
            System.out.println("Maior impacto parte 2: "+ resultadoParte2);
        }
        catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado no caminho especificado: " + filePath);
        }
        catch (NumberFormatException e) {
            System.err.println("Erro de formato. Linha com rotação não numérica.");
        }
    }
}
