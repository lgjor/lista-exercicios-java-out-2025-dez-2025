package org.desviante.exercicios.x48_sum13;

import org.desviante.exercicios.CodeWorkout.x48_sum13.Sum13;
import org.junit.jupiter.api.*;

@DisplayName("Testes para Sum13")
public class Sum13Test {

    private Sum13 sum13;

    @BeforeEach
    void setUp() {
        sum13 = new Sum13();
    }

    @Test
    @DisplayName("Deve somar todos os números quando não há 13")
    void sumAllNumbersWhenNoThirteen() {
        int[] nums = {1, 2, 3, 4};
        int resultado = sum13.sum13(nums);
        Assertions.assertEquals(10, resultado);
    }

    @Test
    @DisplayName("Deve ignorar 13 e o número imediatamente seguinte")
    void ignoreThirteenAndNextNumber() {
        int[] nums = {1, 13, 2, 2};
        int resultado = sum13.sum13(nums);
        Assertions.assertEquals(3, resultado); // 1 + 2 = 3
    }

    @Test
    @DisplayName("Deve funcionar com múltiplas ocorrências de 13")
    void multipleThirteens() {
        int[] nums = {13, 1, 2, 13, 2, 1, 13};
        int resultado = sum13.sum13(nums);
        Assertions.assertEquals(3, resultado); // 2 + 1 = 3
    }

    @Test
    @DisplayName("Deve retornar 0 para array vazio")
    void emptyArrayShouldReturnZero() {
        int[] nums = {};
        int resultado = sum13.sum13(nums);
        Assertions.assertEquals(0, resultado);
    }

    @Test
    @DisplayName("Deve retornar 0 para entrada null")
    void nullInputShouldReturnZero() {
        int resultado = sum13.sum13(null);
        Assertions.assertEquals(0, resultado);
    }

    @Test
    @DisplayName("Deve ignorar 13 no final do array")
    void ignoreThirteenAtEnd() {
        int[] nums = {1, 2, 13};
        int resultado = sum13.sum13(nums);
        Assertions.assertEquals(3, resultado);
    }

    @Test
    @DisplayName("Deve ignorar corretamente quando há 13 consecutivos")
    void consecutiveThirteens() {
        int[] nums = {1, 13, 13, 2, 1};
        int resultado = sum13.sum13(nums);
        Assertions.assertEquals(2, resultado); // 1 + 2 + 1 = 4
    }
}
