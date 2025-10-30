package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_09_YouCannotEscape;

import java.util.LinkedList;
import java.util.Queue;

public class PathFinder {
    public String shortestPath(char[][] map, EndPoints endpoints) {
        int nRows = map.length;
        int nCols = map[0].length;

        Position start = endpoints.getStart();
        Position goal = endpoints.getGoal();

        // Armazena posições visitadas para permitir que as posições sejam visitadas apenas uma vez
        boolean[][] visitado = new boolean[nRows][nCols];

        // Armazena o movimento que leva a cada posição
        Movimento[][] comoChegou = new Movimento[nRows][nCols];
        // Armazena a posição anterior que leva a cada posição
        Position[][] deOndeVeio = new Position[nRows][nCols];

        // Fila de nós a serem visitados
        Queue<Position> fila = new LinkedList<>();

        // Adiciona posição inicial na fila de nós a serem visitados
        fila.add(start);

        // Marca posição inicial como visitada
        visitado[start.getRow()][start.getColumn()] = true;

        // Abordagem: BFS (Breadth-First Search) em grade não ponderada garante o menor número de passos.
        // Diferenciação de células: apenas '.', 'P' e 'G' são consideradas caminháveis.
        // Observação: o leitor preenche colunas com ' ' (espaço) para igualar comprimentos; esses espaços NÃO são caminháveis.
        while (!fila.isEmpty()) {

            // Remove o primeiro nó da fila e o processa
            Position atual = fila.poll();

            // Se o nó atual é o objetivo, constrói o caminho e retorna
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
            
            // Para cada movimento possível, calcula a nova posição e verifica se é caminhável
            for (Movimento mov : Movimento.values()) {
                // Calcula a nova posição
                int novoRow = atual.getRow() + mov.getDeltaRow();
                int novoCol = atual.getColumn() + mov.getDeltaCol();
                // Verifica se a nova posição está dentro do mapa
                if (novoRow >= 0 && novoRow < nRows && novoCol >= 0 && novoCol < nCols) {
                    char cell = map[novoRow][novoCol];
                    // Verifica se a célula é caminhável
                    boolean walkable = (cell == '.' || cell == 'P' || cell == 'G');
                    // Se a célula é caminhável e não foi visitada, adiciona a nova posição na fila e marca como visitada
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