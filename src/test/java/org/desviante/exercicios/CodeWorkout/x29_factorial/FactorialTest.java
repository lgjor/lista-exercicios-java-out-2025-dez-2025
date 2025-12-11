package org.desviante.exercicios.x29_factorial;

import org.desviante.exercicios.CodeWorkout.x29_factorial.Factorial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes para Factorial")
public class FactorialTest {

    private Factorial factorial = new Factorial();

    @Test
    @DisplayName("Teste factorial(0) = 1")
    public void testFactorialZero() {
        assertEquals(1, factorial.factorial(0), "0! deve ser 1");
    }

    @Test
    @DisplayName("Teste factorial(1) = 1")
    public void testFactorialOne() {
        assertEquals(1, factorial.factorial(1), "1! deve ser 1");
    }

    @Test
    @DisplayName("Teste factorial(2) = 2")
    public void testFactorialTwo() {
        assertEquals(2, factorial.factorial(2), "2! deve ser 2");
    }

    @Test
    @DisplayName("Teste factorial(3) = 6")
    public void testFactorialThree() {
        assertEquals(6, factorial.factorial(3), "3! deve ser 6");
    }

    @Test
    @DisplayName("Teste factorial(4) = 24")
    public void testFactorialFour() {
        assertEquals(24, factorial.factorial(4), "4! deve ser 24");
    }

    @Test
    @DisplayName("Teste factorial(5) = 120")
    public void testFactorialFive() {
        assertEquals(120, factorial.factorial(5), "5! deve ser 120");
    }

    @Test
    @DisplayName("Teste factorial(6) = 720")
    public void testFactorialSix() {
        assertEquals(720, factorial.factorial(6), "6! deve ser 720");
    }

    @Test
    @DisplayName("Teste factorial(7) = 5040")
    public void testFactorialSeven() {
        assertEquals(5040, factorial.factorial(7), "7! deve ser 5040");
    }

    @Test
    @DisplayName("Teste factorial(10) = 3628800")
    public void testFactorialTen() {
        assertEquals(3628800, factorial.factorial(10), "10! deve ser 3628800");
    }

}
