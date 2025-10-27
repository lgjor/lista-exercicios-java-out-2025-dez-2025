package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_06_Runtime_Warp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por calcular a distância entre coordenadas 4D.
 * Recebe uma lista de coordenadas 4D e retorna a distância entre 
 * a primeira e última coordenada.
 */
public class Runtime_Warp {

    /**
     * Calcula a distância total percorrida somando as distâncias entre coordenadas consecutivas.
     * 
     * Para cada distância calculada entre coordenadas consecutivas:
     * 1. Se a distância não for um número inteiro, arredonda para cima
     * 2. Soma todas as distâncias arredondadas
     * 
     * @param coordenadas Lista de coordenadas 4D
     * @return Distância total (soma das distâncias individuais arredondadas)
     * @throws IllegalArgumentException Se a lista for nula ou vazia
     */
    public static int calculateDistance(List<Coordinate4D> coordenadas) {
        if (coordenadas == null || coordenadas.isEmpty()) {
            throw new IllegalArgumentException("A lista de coordenadas não pode ser nula ou vazia");
        }
        
        if (coordenadas.size() == 1) {
            return 0;
        }
        
        int distanciaTotal = 0;
        
        // Calcula e arredonda cada distância individual entre coordenadas consecutivas
        for (int i = 0; i < coordenadas.size() - 1; i++) {
            Coordinate4D atual = coordenadas.get(i);
            Coordinate4D proxima = coordenadas.get(i + 1);
            
            // Calcula a distância euclidiana
            double distancia = Coordinate4D.calculateDistance(atual, proxima);
            
            // Arredonda para cima (ceil) cada distância individual
            int distanciaArredondada = (int) Math.ceil(distancia);
            
            // Soma à distância total
            distanciaTotal += distanciaArredondada;
        }
        
        return distanciaTotal;
    }
    
    /**
     * Lê um arquivo contendo coordenadas em espaço 4D.
     * Cada linha contém 4 valores inteiros separados por vírgula.
     * 
     * Formato esperado:
     * x1,x2,x3,x4
     * 
     * Exemplo:
     * 57,-1,64,67
     * -10,-12,28,62
     * 90,-16,-58,-13
     * 
     * @param nomeArquivo O caminho do arquivo a ser lido
     * @return Lista de coordenadas 4D
     * @throws IOException Se houver erro ao ler o arquivo
     */
    public static List<Coordinate4D> readFile(String nomeArquivo) throws IOException {
        List<Coordinate4D> coordenadas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                
                // Ignora linhas vazias
                if (linha.isEmpty()) {
                    continue;
                }

                // Divide a linha pela vírgula
                String[] valores = linha.split(",");

                // Valida que tem exatamente 4 valores
                if (valores.length != 4) {
                    throw new IllegalArgumentException(
                        String.format("Linha inválida: esperado 4 valores, encontrado %d. Linha: %s", 
                                     valores.length, linha));
                }

                // Converte os valores para inteiros e cria a coordenada
                try {
                    int x1 = Integer.parseInt(valores[0].trim());
                    int x2 = Integer.parseInt(valores[1].trim());
                    int x3 = Integer.parseInt(valores[2].trim());
                    int x4 = Integer.parseInt(valores[3].trim());
                    
                    coordenadas.add(new Coordinate4D(x1, x2, x3, x4));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(
                        String.format("Erro ao converter valores para inteiro na linha: %s", linha), e);
                }
            }
        }

        return coordenadas;
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_06_Runtime_Warp/hyperskill-dataset-117404456.txt";
        
        try {
            // Lê o arquivo e retorna uma lista de coordenadas
            List<Coordinate4D> coordenadas = readFile(filePath);
            
            // Imprime as coordenadas
            System.out.println("Coordenadas lidas: " + coordenadas.size());
            if (!coordenadas.isEmpty()) {
                System.out.println("Primeira coordenada: " + coordenadas.get(0));
                System.out.println("Última coordenada: " + coordenadas.get(coordenadas.size() - 1));
            }
            
            // Calcula a distância total somando as distâncias entre coordenadas consecutivas
            int distancia = calculateDistance(coordenadas);
            
            // Imprime a distância
            System.out.println("Distância total (arredondada para cima): " + distancia);
            
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao processar coordenadas: " + e.getMessage());
        }
    }
}
