package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_09_YouCannotEscape;

import java.util.LinkedList;
import java.util.Queue;

public class PathFinder {
    public String shortestPath(char[][] map, EndPoints endpoints) {
        int nRows = map.length;
        int nCols = map[0].length;

        Position start = endpoints.getStart();
        Position goal = endpoints.getGoal();

        boolean[][] visitado = new boolean[nRows][nCols];
        Movimento[][] comoChegou = new Movimento[nRows][nCols];
        Position[][] deOndeVeio = new Position[nRows][nCols];

        Queue<Position> fila = new LinkedList<>();
        fila.add(start);
        visitado[start.getRow()][start.getColumn()] = true;

        // Abordagem: BFS (Breadth-First Search) em grade não ponderada garante o menor número de passos.
        // Diferenciação de células: apenas '.', 'P' e 'G' são consideradas caminháveis.
        // Observação: o leitor preenche colunas com ' ' (espaço) para igualar comprimentos; esses espaços NÃO são caminháveis.
        while (!fila.isEmpty()) {
            Position atual = fila.poll();
            if (atual.equals(goal)) {
                // Reconstrói caminho a partir do objetivo até a origem usando os predecessores
                StringBuilder caminho = new StringBuilder();
                Position p = goal;
                while (!p.equals(start)) {
                    Movimento mov = comoChegou[p.getRow()][p.getColumn()];
                    caminho.append(mov.getSimbolo());
                    p = deOndeVeio[p.getRow()][p.getColumn()];
                }
                return caminho.reverse().toString(); // Caminho invertido para ficar da origem ao destino
            }
            for (Movimento mov : Movimento.values()) {
                int novoRow = atual.getRow() + mov.getDeltaRow();
                int novoCol = atual.getColumn() + mov.getDeltaCol();
                if (novoRow >= 0 && novoRow < nRows && novoCol >= 0 && novoCol < nCols) {
                    char cell = map[novoRow][novoCol];
                    boolean walkable = (cell == '.' || cell == 'P' || cell == 'G');
                    if (!visitado[novoRow][novoCol] && walkable) {
                        visitado[novoRow][novoCol] = true;
                        fila.add(new Position(novoRow, novoCol));
                        comoChegou[novoRow][novoCol] = mov;
                        deOndeVeio[novoRow][novoCol] = atual;
                    }
                }
            }
        }
        return ""; // Sem caminho encontrado
    }
}