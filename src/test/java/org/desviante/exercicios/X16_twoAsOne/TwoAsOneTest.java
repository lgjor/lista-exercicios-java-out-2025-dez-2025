package org.desviante.exercicios.X16_twoAsOne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe TwoAsOne
 */
@DisplayName("Testes para TwoAsOne")
public class TwoAsOneTest {

    @Test
    @DisplayName("Quando a+b=c, deve retornar true")
    void testTwoAsOneWhenAPlusBEqualsC() {
        assertTrue(new TwoAsOne().twoAsOne(1, 2, 3));
        assertTrue(new TwoAsOne().twoAsOne(5, 10, 15));
        assertTrue(new TwoAsOne().twoAsOne(0, 5, 5));
        assertTrue(new TwoAsOne().twoAsOne(-1, 3, 2));
    }

    @Test
    @DisplayName("Quando a+c=b, deve retornar true")
    void testTwoAsOneWhenAPlusCEqualsB() {
        assertTrue(new TwoAsOne().twoAsOne(1, 3, 2));
        assertTrue(new TwoAsOne().twoAsOne(5, 15, 10));
        assertTrue(new TwoAsOne().twoAsOne(0, 5, 5));
        assertTrue(new TwoAsOne().twoAsOne(-2, 1, 3));
    }

    @Test
    @DisplayName("Quando b+c=a, deve retornar true")
    void testTwoAsOneWhenBPlusCEqualsA() {
        assertTrue(new TwoAsOne().twoAsOne(3, 1, 2));
        assertTrue(new TwoAsOne().twoAsOne(15, 5, 10));
        assertTrue(new TwoAsOne().twoAsOne(5, 0, 5));
        assertTrue(new TwoAsOne().twoAsOne(1, -2, 3));
    }
    
    @Test
    @DisplayName("Quando não é possível adicionar dois dos ints para obter o terceiro, deve retornar false")
    void testTwoAsOneWhenNotPossible() {
        assertFalse(new TwoAsOne().twoAsOne(1, 2, 4));
        assertFalse(new TwoAsOne().twoAsOne(3, 5, 9));
        assertFalse(new TwoAsOne().twoAsOne(10, 20, 40));
        assertFalse(new TwoAsOne().twoAsOne(7, 8, 16));
    }

    @Test
    @DisplayName("Casos com zero - zero como resultado ou operando")
    void testTwoAsOneWithZero() {
        assertTrue(new TwoAsOne().twoAsOne(0, 0, 0));    // 0+0=0
        assertTrue(new TwoAsOne().twoAsOne(5, -5, 0));   // 5+(-5)=0
        assertTrue(new TwoAsOne().twoAsOne(0, 7, 7));    // 0+7=7
        assertTrue(new TwoAsOne().twoAsOne(3, 0, 3));    // 3+0=3
        assertFalse(new TwoAsOne().twoAsOne(0, 1, 3));   // nenhuma combinação funciona
    }

    @Test
    @DisplayName("Casos com números negativos")
    void testTwoAsOneWithNegativeNumbers() {
        assertTrue(new TwoAsOne().twoAsOne(-1, -2, -3));  // (-1)+(-2)=-3
        assertTrue(new TwoAsOne().twoAsOne(-5, 10, 5));   // (-5)+10=5
        assertTrue(new TwoAsOne().twoAsOne(10, -5, 5));   // (-5)+10=5
        assertTrue(new TwoAsOne().twoAsOne(-10, -5, 5));  // (-10)+(-5)=-15? Não. 5+(-5)=0? Não. (-10)+5=-5? Sim!
        assertFalse(new TwoAsOne().twoAsOne(-1, -2, 5));  // nenhuma combinação funciona
    }

    @Test
    @DisplayName("Casos limite - valores iguais e consecutivos")
    void testBoundaryConditions() {
        assertTrue(new TwoAsOne().twoAsOne(1, 1, 2));    // 1+1=2
        assertTrue(new TwoAsOne().twoAsOne(2, 2, 4));    // 2+2=4
        assertTrue(new TwoAsOne().twoAsOne(1, 2, 3));    // números consecutivos
        assertFalse(new TwoAsOne().twoAsOne(1, 1, 3));   // 1+1≠3
        assertFalse(new TwoAsOne().twoAsOne(2, 2, 5));   // 2+2≠5
    }

    @Test
    @DisplayName("Exemplos do problema - casos gerais")
    void testGeneralExamples() {
        assertTrue(new TwoAsOne().twoAsOne(1, 2, 3));    // exemplo básico: 1+2=3
        assertTrue(new TwoAsOne().twoAsOne(3, 1, 2));    // ordem diferente: 1+2=3
        assertFalse(new TwoAsOne().twoAsOne(3, 2, 2));   // nenhuma combinação funciona
        assertFalse(new TwoAsOne().twoAsOne(2, 2, 2));   // nenhuma combinação: 2+2=4≠2
    }
}
