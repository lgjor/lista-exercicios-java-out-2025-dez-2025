package org.desviante.exercicios.adventofcode2025.AOC25_06_TrashCompactor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrashCompactor {
    private long total;

    public TrashCompactor() {
        this.total = 0;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    // Classe auxiliar
    public static class Problema {
        public final List<Long> numeros;
        public final char operador;

        public Problema(List<Long> numeros, char operador) {
            this.numeros = numeros;
            this.operador = operador;
        }
    }

    // ============================================================
    // PARTE 1
    // ============================================================

    public static List<Problema> lerProblemas(Path filePath) throws IOException {
        List<String> linhas = Files.readAllLines(filePath);
        String linhaOperadores = linhas.get(linhas.size() - 1);
        List<String> linhasOperandos = linhas.subList(0, linhas.size() - 1);

        // CORREÇÃO: usar o máximo comprimento entre todas as linhas
        int largura = linhaOperadores.length();
        for (String linha : linhasOperandos) {
            largura = Math.max(largura, linha.length());
        }

        List<Problema> problemas = new ArrayList<>();

        int col = 0;
        while (col < largura) {
            while (col < largura && colunaVazia(linhasOperandos, col)) {
                col++;
            }
            if (col >= largura) break;

            int inicio = col;

            while (col < largura && !colunaVazia(linhasOperandos, col)) {
                col++;
            }

            int fim = col - 1;

            List<Long> nums = new ArrayList<>();
            for (String linha : linhasOperandos) {
                StringBuilder sb = new StringBuilder();

                for (int c = inicio; c <= fim && c < linha.length(); c++) {
                    char ch = linha.charAt(c);
                    if (Character.isDigit(ch)) {
                        sb.append(ch);
                    }
                }

                if (sb.length() > 0) {
                    nums.add(Long.parseLong(sb.toString()));
                }
            }

            // Extrair operador (pode não existir para os últimos blocos)
            char operador = ' ';
            for (int c = inicio; c <= fim && c < linhaOperadores.length(); c++) {
                char ch = linhaOperadores.charAt(c);
                if (ch == '+' || ch == '*') {
                    operador = ch;
                    break;
                }
            }

            // Se não encontrou operador na linha de operadores, procurar na última coluna válida
            if (operador == ' ') {
                for (int c = fim; c >= inicio && c < linhaOperadores.length(); c--) {
                    char ch = linhaOperadores.charAt(c);
                    if (ch == '+' || ch == '*') {
                        operador = ch;
                        break;
                    }
                }
            }

            problemas.add(new Problema(nums, operador));
        }

        return problemas;
    }

    public void calcularResultados(List<Problema> problemas) {
        long total = 0;

        for (Problema p : problemas) {
            long acc = (p.operador == '+') ? 0 : 1;

            for (long n : p.numeros) {
                if (p.operador == '+') acc += n;
                else acc *= n;
            }

            total += acc;
        }

        setTotal(total);
    }

    private static boolean colunaVazia(List<String> linhas, int col) {
        for (String linha : linhas) {
            if (col < linha.length() && linha.charAt(col) != ' ') {
                return false;
            }
        }
        return true;
    }

    // ============================================================
    // PARTE 2 - leitura vertical
    // ============================================================

    public static List<Problema> lerProblemasParte2(Path filePath) throws IOException {
        List<String> linhas = Files.readAllLines(filePath);
        List<String> operandos = linhas.subList(0, linhas.size() - 1);
        String linhaOperadores = linhas.get(linhas.size() - 1);

        int altura = operandos.size();

        // CORREÇÃO: usar o máximo comprimento
        int largura = linhaOperadores.length();
        for (String linha : operandos) {
            largura = Math.max(largura, linha.length());
        }

        List<Problema> problemas = new ArrayList<>();

        int col = largura - 1;

        while (col >= 0) {
            while (col >= 0 && colunaVazia(operandos, col)) {
                col--;
            }
            if (col < 0) break;

            int fim = col;
            while (col >= 0 && !colunaVazia(operandos, col)) {
                col--;
            }
            int inicio = col + 1;

            List<Long> numeros = new ArrayList<>();

            for (int c = fim; c >= inicio; c--) {
                StringBuilder sb = new StringBuilder();

                for (int r = 0; r < altura; r++) {
                    char ch = (c < operandos.get(r).length()) ? operandos.get(r).charAt(c) : ' ';
                    if (Character.isDigit(ch)) sb.append(ch);
                }

                if (sb.length() > 0) {
                    numeros.add(Long.parseLong(sb.toString()));
                }
            }

            Collections.reverse(numeros);

            // Procurar operador (pode estar fora do range da linha de operadores)
            char operador = ' ';
            for (int c = inicio; c <= fim && c < linhaOperadores.length(); c++) {
                char ch = linhaOperadores.charAt(c);
                if (ch == '+' || ch == '*') {
                    operador = ch;
                    break;
                }
            }

            problemas.add(new Problema(numeros, operador));
        }

        Collections.reverse(problemas);
        return problemas;
    }

    public void calcularResultadosParte2(List<Problema> problemasP2) {
        calcularResultados(problemasP2);
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of(
                "src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_06_TrashCompactor/input.txt"
        );

        // --- Parte 1 ---
        List<Problema> problemas = lerProblemas(filePath);
        TrashCompactor trash1 = new TrashCompactor();
        trash1.calcularResultados(problemas);
        System.out.println("Total final PARTE 1 = " + trash1.getTotal());

        // --- Parte 2 ---
        List<Problema> problemasP2 = lerProblemasParte2(filePath);
        TrashCompactor trash2 = new TrashCompactor();
        trash2.calcularResultadosParte2(problemasP2);
        System.out.println("Total final PARTE 2 = " + trash2.getTotal());
    }

}