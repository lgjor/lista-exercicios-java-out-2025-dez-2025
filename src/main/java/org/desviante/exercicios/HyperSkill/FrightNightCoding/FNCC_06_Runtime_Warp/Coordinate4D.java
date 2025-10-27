package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_06_Runtime_Warp;

/**
 * Classe para representar uma coordenada em espaço 4D.
 * 
 * Uma coordenada 4D contém quatro valores: x1, x2, x3, x4
 */
public class Coordinate4D {
    private final int x1;
    private final int x2;
    private final int x3;
    private final int x4;
    
    /**
     * Construtor para criar uma coordenada 4D.
     * 
     * @param x1 Primeira dimensão
     * @param x2 Segunda dimensão
     * @param x3 Terceira dimensão
     * @param x4 Quarta dimensão
     */
    public Coordinate4D(int x1, int x2, int x3, int x4) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
    }
    
    /**
     * Calcula a distância euclidiana entre duas coordenadas 4D.
     * 
     * Fórmula: √[(x1-x2)² + (y1-y2)² + (z1-z2)² + (w1-w2)²]
     * 
     * @param coordinate1 Primeira coordenada
     * @param coordinate2 Segunda coordenada
     * @return Distância euclidiana entre as duas coordenadas
     */
    public static double calculateDistance(Coordinate4D coordinate1, Coordinate4D coordinate2) {
        return Math.sqrt(
            Math.pow(coordinate1.x1 - coordinate2.x1, 2) + 
            Math.pow(coordinate1.x2 - coordinate2.x2, 2) + 
            Math.pow(coordinate1.x3 - coordinate2.x3, 2) + 
            Math.pow(coordinate1.x4 - coordinate2.x4, 2)
        );
    }
    
    // Getters
    public int getX1() {
        return x1;
    }
    
    public int getX2() {
        return x2;
    }
    
    public int getX3() {
        return x3;
    }
    
    public int getX4() {
        return x4;
    }
    
    @Override
    public String toString() {
        return String.format("(%d, %d, %d, %d)", x1, x2, x3, x4);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Coordinate4D that = (Coordinate4D) obj;
        return x1 == that.x1 && x2 == that.x2 && 
               x3 == that.x3 && x4 == that.x4;
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(x1, x2, x3, x4);
    }
} 