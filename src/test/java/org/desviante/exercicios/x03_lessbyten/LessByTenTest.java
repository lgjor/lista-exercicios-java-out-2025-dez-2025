package org.desviante.exercicios.x03_lessbyten;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe LessByTen
 */
@DisplayName("Testes para o método lessBy10")
class LessByTenTest {
    
    private LessByTen lessByTen;
    
    @BeforeEach
    void setUp() {
        lessByTen = new LessByTen();
    }
    
    @Test
    @DisplayName("Deve retornar false quando todas as diferenças são menores que 10")
    void testAllDifferencesLessThan10() {
        assertFalse(lessByTen.lessBy10(1, 2, 3), 
            "Diferenças (1,2,3) são todas menores que 10");
        assertFalse(lessByTen.lessBy10(5, 5, 5), 
            "Todos os valores iguais (5,5,5)");
        assertFalse(lessByTen.lessBy10(10, 15, 19), 
            "Diferenças (10,15,19) são todas menores que 10");
    }
    
    @Test
    @DisplayName("Deve retornar true quando a diferença entre A e B é >= 10")
    void testDifferenceAB_GreaterOrEqual10() {
        assertTrue(lessByTen.lessBy10(1, 11, 5), 
            "Diferença entre 1 e 11 é 10");
        assertTrue(lessByTen.lessBy10(20, 5, 8), 
            "Diferença entre 20 e 5 é 15");
        assertTrue(lessByTen.lessBy10(0, 15, 7), 
            "Diferença entre 0 e 15 é 15");
    }
    
    @Test
    @DisplayName("Deve retornar true quando a diferença entre A e C é >= 10")
    void testDifferenceAC_GreaterOrEqual10() {
        assertTrue(lessByTen.lessBy10(1, 5, 11), 
            "Diferença entre 1 e 11 é 10");
        assertTrue(lessByTen.lessBy10(25, 5, 10), 
            "Diferença entre 25 e 10 é 15");
        assertTrue(lessByTen.lessBy10(0, 5, 20), 
            "Diferença entre 0 e 20 é 20");
    }
    
    @Test
    @DisplayName("Deve retornar true quando a diferença entre B e C é >= 10")
    void testDifferenceBC_GreaterOrEqual10() {
        assertTrue(lessByTen.lessBy10(5, 1, 11), 
            "Diferença entre 1 e 11 é 10");
        assertTrue(lessByTen.lessBy10(5, 20, 5), 
            "Diferença entre 20 e 5 é 15");
        assertTrue(lessByTen.lessBy10(7, 0, 15), 
            "Diferença entre 0 e 15 é 15");
    }
    
    @Test
    @DisplayName("Deve retornar true quando exatamente a diferença é 10")
    void testExactlyDifference10() {
        assertTrue(lessByTen.lessBy10(0, 10, 5), 
            "Diferença exata de 10 entre 0 e 10");
        assertTrue(lessByTen.lessBy10(10, 0, 5), 
            "Diferença exata de 10 entre 10 e 0");
        assertTrue(lessByTen.lessBy10(5, 0, 10), 
            "Diferença exata de 10 entre 0 e 10");
    }
    
    @Test
    @DisplayName("Deve retornar false quando a diferença é 9 (limite inferior)")
    void testDifference9() {
        assertFalse(lessByTen.lessBy10(0, 9, 5), 
            "Diferença de 9 não deve retornar true");
        assertFalse(lessByTen.lessBy10(9, 0, 5), 
            "Diferença de 9 não deve retornar true");
    }
    
    @Test
    @DisplayName("Deve funcionar com números negativos")
    void testNegativeNumbers() {
        assertTrue(lessByTen.lessBy10(-5, 5, 0), 
            "Diferença entre -5 e 5 é 10");
        assertTrue(lessByTen.lessBy10(-10, 5, 0), 
            "Diferença entre -10 e 5 é 15");
        assertFalse(lessByTen.lessBy10(-5, -3, -1), 
            "Diferenças pequenas com números negativos");
        assertTrue(lessByTen.lessBy10(-20, -5, -10), 
            "Diferença entre -20 e -5 é 15");
    }
    
    @Test
    @DisplayName("Deve funcionar com valores zero")
    void testZeroValues() {
        assertTrue(lessByTen.lessBy10(0, 0, 10), 
            "Diferença entre 0 e 10 é 10");
        assertTrue(lessByTen.lessBy10(0, 10, 0), 
            "Diferença entre 0 e 10 é 10");
        assertTrue(lessByTen.lessBy10(10, 0, 0), 
            "Diferença entre 10 e 0 é 10");
        assertFalse(lessByTen.lessBy10(0, 0, 0), 
            "Todos zero, sem diferença >= 10");
    }
    
    @Test
    @DisplayName("Deve funcionar com números grandes")
    void testLargeNumbers() {
        assertTrue(lessByTen.lessBy10(1000, 990, 995), 
            "Diferença entre 1000 e 990 é 10");
        assertTrue(lessByTen.lessBy10(1000000, 999990, 999995), 
            "Diferença entre 1000000 e 999990 é 10");
        assertFalse(lessByTen.lessBy10(1000, 995, 999), 
            "Diferenças menores que 10 com números grandes");
    }
    
    @Test
    @DisplayName("Casos dos exemplos fornecidos no Main")
    void testProvidedExamples() {
        assertFalse(lessByTen.lessBy10(1, 2, 3), 
            "Exemplo 1: (1,2,3) deve retornar false");
        assertTrue(lessByTen.lessBy10(0, 2, 10), 
            "Exemplo 2: (0,2,10) deve retornar true");
    }
    
    @Test
    @DisplayName("Deve funcionar quando múltiplas diferenças são >= 10")
    void testMultipleDifferences() {
        assertTrue(lessByTen.lessBy10(0, 20, 40), 
            "Todas as diferenças são >= 10");
        assertTrue(lessByTen.lessBy10(100, 0, 200), 
            "Múltiplas diferenças >= 10");
    }
}

