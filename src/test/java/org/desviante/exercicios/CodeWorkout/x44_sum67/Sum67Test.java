package org.desviante.exercicios.x44_sum67;

import org.desviante.exercicios.CodeWorkout.x44_sum67.Sum67;
import org.junit.jupiter.api.*;

@DisplayName("Testes para Sum67")
public class Sum67Test {

    private Sum67 sum67;

    @BeforeEach
    void setUp() {
        sum67 = new Sum67();
    }

    @Test
    @DisplayName("Deve somar todos os números caso não exista 6 seguido de 7")
    void sumAllNumbersWithoutSixSeven() {
        int[] nums = {1, 2, 3, 4, 5};
        int resultado = sum67.sum67(nums);
        Assertions.assertEquals(15, resultado);
    }

    @Test
    @DisplayName("Deve ignorar números entre 6 e 7 (inclusive)")
    void ignoreNumbersBetweenSixAndSeven() {
        int[] nums = {1, 6, 2, 2, 7, 1, 6, 99, 99, 7};
        int resultado = sum67.sum67(nums);
        Assertions.assertEquals(2, resultado); // 1 + 1 = 2
    }

    @Test
    @DisplayName("Deve retornar 0 para array vazio")
    void emptyArrayShouldReturnZero() {
        int[] nums = {};
        int resultado = sum67.sum67(nums);
        Assertions.assertEquals(0, resultado);
    }

    @Test
    @DisplayName("Deve funcionar com apenas um elemento")
    void singleElementArray() {
        int[] nums = {5};
        int resultado = sum67.sum67(nums);
        Assertions.assertEquals(5, resultado);
    }

    @Test
    @DisplayName("Deve ignorar quando 6 e 7 estão adjacentes")
    void ignoreWhenSixAndSevenAdjacent() {
        int[] nums = {1, 6, 7, 2};
        int resultado = sum67.sum67(nums);
        Assertions.assertEquals(3, resultado); // 1 + 2 = 3
    }

    @Test
    @DisplayName("Deve funcionar com múltiplos pares 6-7")
    void multipleSixSevenPairs() {
        int[] nums = {1, 6, 2, 6, 2, 7, 1, 7};
        int resultado = sum67.sum67(nums);
        Assertions.assertEquals(9, resultado); // 1 + 1 + 7 = 9
    }

    @Test
    @DisplayName("Deve funcionar quando 6 aparece sem 7 correspondente")
    void sixWithoutSeven() {
        int[] nums = {1, 6, 2, 3, 4};
        int resultado = sum67.sum67(nums);
        Assertions.assertEquals(1, resultado); // apenas 1
    }

    @Test
    @DisplayName("Deve funcionar quando 7 aparece sem 6 correspondente")
    void sevenWithoutSix() {
        int[] nums = {1, 2, 3, 7, 4};
        int resultado = sum67.sum67(nums);
        Assertions.assertEquals(17, resultado); // 1 + 2 + 3 + 7 + 4 = 17
    }

    @Test
    @DisplayName("Deve funcionar com números negativos")
    void negativeNumbers() {
        int[] nums = {-1, 6, -2, 7, -3};
        int resultado = sum67.sum67(nums);
        Assertions.assertEquals(-4, resultado); // -1 + (-3) = -4
    }

    @Test
    @DisplayName("Deve funcionar com zeros")
    void zeroNumbers() {
        int[] nums = {0, 6, 0, 7, 0};
        int resultado = sum67.sum67(nums);
        Assertions.assertEquals(0, resultado); // 0 + 0 = 0
    }
}
