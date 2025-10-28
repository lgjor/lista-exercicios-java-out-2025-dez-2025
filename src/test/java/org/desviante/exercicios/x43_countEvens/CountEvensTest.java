package org.desviante.exercicios.x43_countEvens;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para CountEvens")
public class CountEvensTest {

    @Test
    @DisplayName("Deve contar números pares em array com números positivos")
    void countEvensWithPositiveNumbers() {
        int[] nums = {2, 1, 2, 3, 4};
        int resultado = CountEvens.countEvens(nums);
        assertEquals(3, resultado); // 2, 2, 4 são pares
    }

    @Test
    @DisplayName("Deve retornar 0 para array vazio")
    void emptyArrayShouldReturnZero() {
        int[] nums = {};
        int resultado = CountEvens.countEvens(nums);
        assertEquals(0, resultado);
    }

    @Test
    @DisplayName("Deve retornar 0 para array null")
    void nullArrayShouldReturnZero() {
        int[] nums = null;
        int resultado = CountEvens.countEvens(nums);
        assertEquals(0, resultado);
    }

    @Test
    @DisplayName("Deve contar apenas números pares")
    void countOnlyEvenNumbers() {
        int[] nums = {1, 3, 5, 7, 9};
        int resultado = CountEvens.countEvens(nums);
        assertEquals(0, resultado); // nenhum número par
    }

    @Test
    @DisplayName("Deve contar todos os números quando todos são pares")
    void allEvenNumbers() {
        int[] nums = {2, 4, 6, 8, 10};
        int resultado = CountEvens.countEvens(nums);
        assertEquals(5, resultado); // todos são pares
    }

    @Test
    @DisplayName("Deve funcionar com números negativos")
    void negativeNumbers() {
        int[] nums = {-2, -1, -4, -3, -6};
        int resultado = CountEvens.countEvens(nums);
        assertEquals(3, resultado); // -2, -4, -6 são pares
    }

    @Test
    @DisplayName("Deve contar zero como número par")
    void zeroIsEven() {
        int[] nums = {0, 1, 2, 3};
        int resultado = CountEvens.countEvens(nums);
        assertEquals(2, resultado); // 0 e 2 são pares
    }

    @Test
    @DisplayName("Deve funcionar com array de um elemento par")
    void singleEvenElement() {
        int[] nums = {4};
        int resultado = CountEvens.countEvens(nums);
        assertEquals(1, resultado);
    }

    @Test
    @DisplayName("Deve funcionar com array de um elemento ímpar")
    void singleOddElement() {
        int[] nums = {3};
        int resultado = CountEvens.countEvens(nums);
        assertEquals(0, resultado);
    }

    @Test
    @DisplayName("Deve funcionar com números grandes")
    void largeNumbers() {
        int[] nums = {1000, 1001, 1002, 1003, 1004};
        int resultado = CountEvens.countEvens(nums);
        assertEquals(3, resultado); // 1000, 1002, 1004 são pares
    }

    @Test
    @DisplayName("Deve funcionar com números mistos positivos e negativos")
    void mixedPositiveNegativeNumbers() {
        int[] nums = {-3, -2, -1, 0, 1, 2, 3};
        int resultado = CountEvens.countEvens(nums);
        assertEquals(3, resultado); // -2, 0, 2 são pares
    }
}
