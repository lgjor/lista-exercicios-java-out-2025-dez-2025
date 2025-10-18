package org.desviante.exercicios.x03_lessbyten;

/**
 * Exercício: Less By Ten
 * Verifica se a diferença entre quaisquer dois números é >= 10
 */
public class LessByTen {
    
    /**
     * Verifica se a diferença absoluta entre quaisquer dois dos três números é >= 10
     * @param a primeiro número
     * @param b segundo número
     * @param c terceiro número
     * @return true se pelo menos uma diferença for >= 10
     */
    public boolean lessBy10(int a, int b, int c) {
        // 1. A é >= 10 diferente de B (A - B >= 10 OU B - A >= 10)
        boolean diffAB = (a - b >= 10) || (b - a >= 10);

        // 2. A é >= 10 diferente de C (A - C >= 10 OU C - A >= 10)
        boolean diffAC = (a - c >= 10) || (c - a >= 10);

        // 3. B é >= 10 diferente de C (B - C >= 10 OU C - B >= 10)
        boolean diffBC = (b - c >= 10) || (c - b >= 10);

        // Retorna verdadeiro se pelo menos uma das diferenças for >= 10
        return diffAB || diffAC || diffBC;
    }
    
    public static void main(String[] args) {
        LessByTen lessByTen = new LessByTen();
        
        boolean result1 = lessByTen.lessBy10(1, 2, 3);
        System.out.println(result1);
        
        boolean result2 = lessByTen.lessBy10(0, 2, 10);
        System.out.println(result2);
    }
}

