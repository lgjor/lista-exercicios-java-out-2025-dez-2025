package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_09_YouCannotEscape;

public class YouCannotEscape {
    public static void main(String[] args) {
        // Caminho do arquivo de mapa
        String path = "/mnt/d/projetos/lista-exercicios-java-out-2025-dez-2025/src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_09_YouCannotEscape/hyperskill-dataset-117494331.txt";

        // 1. Leitura do mapa e dos pontos
        ReadMap leitor = new ReadMap(path);
        char[][] mapa = leitor.getMap();
        EndPoints pontos = leitor.getEndPoints();

        // 2. Encontra o menor caminho
        PathFinder finder = new PathFinder();
        String caminho = finder.shortestPath(mapa, pontos);

        // 3. Imprime a matriz e o menor caminho encontrado
        imprimirMatriz(mapa);
        System.out.println("Menor caminho: " + caminho);
    }

    // imprime a matriz
    public static void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
}

