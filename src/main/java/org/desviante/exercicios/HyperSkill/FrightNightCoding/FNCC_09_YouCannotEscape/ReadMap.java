package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_09_YouCannotEscape;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadMap {

    private final String path;
    private final char[][] mapa;
    private final EndPoints endPoints;

    public ReadMap(String path) {
        this.path = path;
        this.mapa = readFile(path);
        this.endPoints = findEndpoints(this.mapa);
    }

    private char[][] readFile(String path) {
        List<String> linhas = new ArrayList<>();
        int maxColunas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
                if (linha.length() > maxColunas) {
                    maxColunas = linha.length();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + path, e);
        }

        int numLinhas = linhas.size();
        if (numLinhas == 0) return new char[0][0];

        char[][] matriz = new char[numLinhas][maxColunas];

        for (int i = 0; i < numLinhas; i++) {
            String linha = linhas.get(i);
            for (int j = 0; j < linha.length(); j++) {
                matriz[i][j] = linha.charAt(j);
            }
            for (int j = linha.length(); j < maxColunas; j++) {
                matriz[i][j] = ' ';
            }
        }
        return matriz;
    }

    private EndPoints findEndpoints(char[][] matrix) {
        Position start = null;
        Position goal = null;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'P') start = new Position(i, j);
                if (matrix[i][j] == 'G') goal = new Position(i, j);
            }
        }
        if (start == null || goal == null) throw new RuntimeException("Mapa sem ponto de partida ou chegada!");
        return new EndPoints(start, goal);
    }

    public char[][] getMap() {
        return mapa;
    }

    public EndPoints getEndPoints() {
        return endPoints;
    }
}