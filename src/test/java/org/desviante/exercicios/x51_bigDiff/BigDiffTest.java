package org.desviante.exercicios.x51_bigDiff;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.security.InvalidParameterException;

@DisplayName("Tests for BigDiff")
public class BigDiffTest {

    @Test
    @DisplayName("Deve lançar exceção quando o array for nulo")
    void nullArrayThrowsException() {
        BigDiff bigDiff = new BigDiff();
        Assertions.assertThrows(InvalidParameterException.class, () -> bigDiff.bigDiff(null));
    }

    @Test
    @DisplayName("Deve lançar exceção quando o array for vazio")
    void emptyArrayThrowsException() {
        BigDiff bigDiff = new BigDiff();
        int[] nums = new int[]{};
        Assertions.assertThrows(InvalidParameterException.class, () -> bigDiff.bigDiff(nums));
    }

    @Test
    @DisplayName("Com um único elemento, a diferença deve ser zero")
    void singleElementReturnsZero() {
        BigDiff bigDiff = new BigDiff();
        int[] nums = new int[]{5};
        int resultado = bigDiff.bigDiff(nums);
        Assertions.assertEquals(0, resultado);
    }

    @Test
    @DisplayName("Deve calcular corretamente para números positivos")
    void computesForPositiveNumbers() {
        BigDiff bigDiff = new BigDiff();
        int[] nums = new int[]{10, 3, 5, 6};
        int resultado = bigDiff.bigDiff(nums);
        Assertions.assertEquals(7, resultado);
    }

    @Test
    @DisplayName("Deve calcular corretamente com números negativos")
    void computesForNegativeNumbers() {
        BigDiff bigDiff = new BigDiff();
        int[] nums = new int[]{-1, -5, -3};
        int resultado = bigDiff.bigDiff(nums);
        Assertions.assertEquals(4, resultado);
    }

    @Test
    @DisplayName("Quando todos os elementos são iguais, diferença deve ser zero")
    void allEqualReturnsZero() {
        BigDiff bigDiff = new BigDiff();
        int[] nums = new int[]{7, 7, 7};
        int resultado = bigDiff.bigDiff(nums);
        Assertions.assertEquals(0, resultado);
    }
}
