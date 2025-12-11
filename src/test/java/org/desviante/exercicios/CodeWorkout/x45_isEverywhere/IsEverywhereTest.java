package org.desviante.exercicios.x45_isEverywhere;

import org.desviante.exercicios.CodeWorkout.x45_isEverywhere.IsEverywhere;
import org.junit.jupiter.api.*;

@DisplayName("Testes para IsEverywhere")
public class IsEverywhereTest {

    private IsEverywhere isEverywhere;

    @BeforeEach
    void setUp() {
        isEverywhere = new IsEverywhere();
    }

    @Test
    @DisplayName("Deve retornar true quando valor está em todos os pares adjacentes")
    void valuePresentInAllAdjacentPairs() {
        int[] nums = {1, 2, 1, 3};
        boolean resultado = isEverywhere.isEverywhere(nums, 1);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar true quando valor aparece em posições alternadas")
    void valueInAlternatingPositions() {
        int[] nums = {1, 2, 1, 2, 1};
        boolean resultado = isEverywhere.isEverywhere(nums, 1);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar false quando valor não está em algum par adjacente")
    void valueNotInAllAdjacentPairs() {
        int[] nums = {1, 2, 1, 3, 4};
        boolean resultado = isEverywhere.isEverywhere(nums, 1);
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve retornar true para array vazio")
    void emptyArrayShouldReturnTrue() {
        int[] nums = {};
        boolean resultado = isEverywhere.isEverywhere(nums, 1);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar true para array com um elemento")
    void singleElementArrayShouldReturnTrue() {
        int[] nums = {5};
        boolean resultado = isEverywhere.isEverywhere(nums, 5);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar true para array com um elemento mesmo com valor diferente")
    void singleElementArrayWithDifferentValue() {
        int[] nums = {5};
        boolean resultado = isEverywhere.isEverywhere(nums, 3);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar false para array null")
    void nullArrayShouldReturnFalse() {
        int[] nums = null;
        boolean resultado = isEverywhere.isEverywhere(nums, 1);
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve retornar true quando valor está em todas as posições")
    void valueInAllPositions() {
        int[] nums = {2, 2, 2, 2};
        boolean resultado = isEverywhere.isEverywhere(nums, 2);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar true quando valor está em posições pares")
    void valueInEvenPositions() {
        int[] nums = {1, 3, 1, 3, 1};
        boolean resultado = isEverywhere.isEverywhere(nums, 1);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar true quando valor está em posições ímpares")
    void valueInOddPositions() {
        int[] nums = {3, 1, 3, 1, 3};
        boolean resultado = isEverywhere.isEverywhere(nums, 1);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar false quando valor não aparece em nenhum par")
    void valueNotInAnyPair() {
        int[] nums = {2, 3, 4, 5};
        boolean resultado = isEverywhere.isEverywhere(nums, 1);
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve funcionar com valores negativos")
    void negativeValues() {
        int[] nums = {-1, 2, -1, 3};
        boolean resultado = isEverywhere.isEverywhere(nums, -1);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve funcionar com zero")
    void zeroValue() {
        int[] nums = {0, 1, 0, 2};
        boolean resultado = isEverywhere.isEverywhere(nums, 0);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar false quando há par sem o valor")
    void pairWithoutValue() {
        int[] nums = {1, 2, 3, 4, 1};
        boolean resultado = isEverywhere.isEverywhere(nums, 1);
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve funcionar com array de dois elementos onde valor está presente")
    void twoElementArrayWithValue() {
        int[] nums = {3, 1};
        boolean resultado = isEverywhere.isEverywhere(nums, 3);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve funcionar com array de dois elementos onde valor não está presente")
    void twoElementArrayWithoutValue() {
        int[] nums = {2, 3};
        boolean resultado = isEverywhere.isEverywhere(nums, 1);
        Assertions.assertFalse(resultado);
    }
}
