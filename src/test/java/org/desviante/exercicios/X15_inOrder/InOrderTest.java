package org.desviante.exercicios.X15_inOrder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe InOrder
 */
@DisplayName("Testes para InOrder")
public class InOrderTest {

    @Test
    @DisplayName("Quando bOk=false e valores estão em ordem crescente (a < b < c), deve retornar true")
    void testInOrderWhenBOkFalseAndValuesInOrder() {
        assertTrue(new InOrder().inOrder(1, 2, 4, false));
        assertTrue(new InOrder().inOrder(1, 2, 3, false));
        assertTrue(new InOrder().inOrder(0, 5, 10, false));
        assertTrue(new InOrder().inOrder(-5, 0, 5, false));
        assertTrue(new InOrder().inOrder(10, 20, 30, false));
    }

    @Test
    @DisplayName("Quando bOk=false e b não é maior que a, deve retornar false")
    void testInOrderWhenBOkFalseAndBNotGreaterThanA() {
        assertFalse(new InOrder().inOrder(1, 1, 2, false));  // b igual a a
        assertFalse(new InOrder().inOrder(2, 1, 3, false));  // b menor que a
        assertFalse(new InOrder().inOrder(5, 3, 7, false));  // b menor que a
        assertFalse(new InOrder().inOrder(0, 0, 5, false));  // b igual a a
    }

    @Test
    @DisplayName("Quando bOk=false e c não é maior que b, deve retornar false")
    void testInOrderWhenBOkFalseAndCNotGreaterThanB() {
        assertFalse(new InOrder().inOrder(1, 2, 2, false));  // c igual a b
        assertFalse(new InOrder().inOrder(1, 2, 1, false));  // c menor que b
        assertFalse(new InOrder().inOrder(1, 5, 3, false));  // c menor que b
        assertFalse(new InOrder().inOrder(0, 10, 0, false)); // c menor que b
    }

    @Test
    @DisplayName("Quando bOk=true e c é maior que b, deve retornar true (independente de a)")
    void testInOrderWhenBOkTrueAndCGreaterThanB() {
        assertTrue(new InOrder().inOrder(1, 1, 2, true));    // a = b, c > b
        assertTrue(new InOrder().inOrder(3, 2, 4, true));    // a > b, c > b
        assertTrue(new InOrder().inOrder(1, 2, 4, true));    // a < b, c > b
        assertTrue(new InOrder().inOrder(5, 5, 10, true));   // a = b, c > b
        assertTrue(new InOrder().inOrder(10, 5, 20, true));  // a > b, c > b
    }

    @Test
    @DisplayName("Quando bOk=true e c não é maior que b, deve retornar false")
    void testInOrderWhenBOkTrueAndCNotGreaterThanB() {
        assertFalse(new InOrder().inOrder(1, 2, 2, true));   // c igual a b
        assertFalse(new InOrder().inOrder(1, 2, 1, true));   // c menor que b
        assertFalse(new InOrder().inOrder(5, 10, 8, true));  // c menor que b
        assertFalse(new InOrder().inOrder(0, 5, 5, true));   // c igual a b
    }

    @Test
    @DisplayName("Casos limite - verificar transições e valores iguais")
    void testBoundaryConditions() {
        // Valores consecutivos
        assertTrue(new InOrder().inOrder(1, 2, 3, false));
        assertFalse(new InOrder().inOrder(1, 2, 2, false));
        
        // Valores negativos
        assertTrue(new InOrder().inOrder(-3, -2, -1, false));
        assertTrue(new InOrder().inOrder(-10, -5, 0, false));
        
        // Zero no meio
        assertTrue(new InOrder().inOrder(-5, 0, 5, false));
        
        // Todos iguais
        assertFalse(new InOrder().inOrder(5, 5, 5, false));
        assertFalse(new InOrder().inOrder(5, 5, 5, true));
    }

    @Test
    @DisplayName("Exemplos do problema - casos fornecidos na especificação")
    void testExamplesFromProblemDescription() {
        // Casos típicos onde bOk=false
        assertTrue(new InOrder().inOrder(1, 2, 4, false));
        assertFalse(new InOrder().inOrder(1, 2, 1, false));
        
        // Casos típicos onde bOk=true (exceção aplicada)
        assertTrue(new InOrder().inOrder(1, 1, 2, true));
        assertFalse(new InOrder().inOrder(3, 1, 4, false));
        assertTrue(new InOrder().inOrder(3, 1, 4, true));
    }
}