package org.desviante.exercicios.x49_modThree;

import org.junit.jupiter.api.*;

@DisplayName("Testes para ModThree")
public class ModThreeTest {

    private ModThree modThree;

    @BeforeEach
    void setUp() {
        modThree = new ModThree();
    }

    @Test
    @DisplayName("Deve retornar true para 3 pares consecutivos no início")
    void threeConsecutiveEvensAtStart() {
        int[] nums = {2, 4, 6, 1};
        boolean resultado = modThree.modThree(nums);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar true para 3 ímpares consecutivos no fim")
    void threeConsecutiveOddsAtEnd() {
        int[] nums = {2, 4, 1, 3, 5};
        boolean resultado = modThree.modThree(nums);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar true para 3 pares consecutivos no meio")
    void threeConsecutiveEvensInMiddle() {
        int[] nums = {1, 2, 2, 2, 3};
        boolean resultado = modThree.modThree(nums);
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar false quando não houver 3 de mesma paridade consecutivos")
    void noThreeInARowSameParity() {
        int[] nums = {1, 2, 1, 2, 1, 2};
        boolean resultado = modThree.modThree(nums);
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve lidar com arrays menores que 3 elementos retornando false")
    void arraysTooSmallReturnFalse() {
        Assertions.assertFalse(modThree.modThree(new int[]{}));
        Assertions.assertFalse(modThree.modThree(new int[]{1}));
        Assertions.assertFalse(modThree.modThree(new int[]{1, 2}));
    }

    @Test
    @DisplayName("Deve retornar false para entrada null")
    void nullInputReturnsFalse() {
        Assertions.assertFalse(modThree.modThree(null));
    }

    @Test
    @DisplayName("Deve funcionar com números negativos pares e ímpares")
    void worksWithNegativeNumbers() {
        Assertions.assertTrue(modThree.modThree(new int[]{-2, -4, -6}));
        Assertions.assertTrue(modThree.modThree(new int[]{-1, -3, -5}));
    }

    @Test
    @DisplayName("Deve funcionar com zeros (pares)")
    void worksWithZeros() {
        Assertions.assertTrue(modThree.modThree(new int[]{0, 0, 0}));
        Assertions.assertTrue(modThree.modThree(new int[]{1, 0, 2, 4, 6}));
    }
}
