package org.desviante.exercicios.x11_teenSum;

import org.desviante.exercicios.CodeWorkout.X11_teenSum.TeenSum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes para TeenSum")
public class TeenSumTest {
    
    private TeenSum teenSum;
    
    @BeforeEach
    void setUp() {
        teenSum = new TeenSum();
    }
    
    @Test
    @DisplayName("Deve retornar soma normal quando nenhum valor é teen")
    void testSomaNormalSemTeen() {
        assertEquals(15, teenSum.teenSum(5, 10));
        assertEquals(3, teenSum.teenSum(1, 2));
        assertEquals(24, teenSum.teenSum(12, 12));
        assertEquals(40, teenSum.teenSum(20, 20));
    }
    
    @Test
    @DisplayName("Deve retornar 19 quando o primeiro valor é teen")
    void testPrimeiroValorTeen() {
        assertEquals(19, teenSum.teenSum(13, 1));
        assertEquals(19, teenSum.teenSum(15, 5));
        assertEquals(19, teenSum.teenSum(19, 10));
    }
    
    @Test
    @DisplayName("Deve retornar 19 quando o segundo valor é teen")
    void testSegundoValorTeen() {
        assertEquals(19, teenSum.teenSum(1, 13));
        assertEquals(19, teenSum.teenSum(5, 15));
        assertEquals(19, teenSum.teenSum(10, 19));
    }
    
    @Test
    @DisplayName("Deve retornar 19 quando ambos valores são teen")
    void testAmbosValoresTeen() {
        assertEquals(19, teenSum.teenSum(13, 13));
        assertEquals(19, teenSum.teenSum(15, 17));
        assertEquals(19, teenSum.teenSum(19, 19));
    }
    
    @Test
    @DisplayName("Deve testar os limites do intervalo teen (13 e 19)")
    void testLimitesIntervaloTeen() {
        // 13 é o limite inferior - é teen
        assertEquals(19, teenSum.teenSum(13, 0));
        assertEquals(19, teenSum.teenSum(0, 13));
        
        // 19 é o limite superior - é teen
        assertEquals(19, teenSum.teenSum(19, 0));
        assertEquals(19, teenSum.teenSum(0, 19));
    }
    
    @Test
    @DisplayName("Deve testar valores próximos aos limites (12 e 20)")
    void testValoresForaDoIntervaloTeen() {
        // 12 não é teen, 20 não é teen
        assertEquals(24, teenSum.teenSum(12, 12));
        assertEquals(40, teenSum.teenSum(20, 20));
        assertEquals(32, teenSum.teenSum(12, 20));
    }
    
    @Test
    @DisplayName("Deve testar com valores negativos")
    void testValoresNegativos() {
        assertEquals(-5, teenSum.teenSum(-10, 5));
        assertEquals(19, teenSum.teenSum(-15, 15)); // 15 é teen, retorna 19
        assertEquals(19, teenSum.teenSum(-5, 13));
    }
    
    @Test
    @DisplayName("Deve testar com zero")
    void testComZero() {
        assertEquals(0, teenSum.teenSum(0, 0));
        assertEquals(10, teenSum.teenSum(0, 10));
        assertEquals(19, teenSum.teenSum(0, 15));
    }
}
