package org.desviante.exercicios.x41_plusTwo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Testes para PlusTwo")
public class PlusTwoTest {

    private PlusTwo plusTwo;

    @BeforeEach
    void setUp() {
        plusTwo = new PlusTwo();
    }

    @DisplayName("Deve concatenar dois arrays de 2 elementos")
    @Test
    void testPlusTwoBasic() {
        int[] a = {1, 2};
        int[] b = {3, 4};
        int[] expected = {1, 2, 3, 4};
        int[] result = plusTwo.plusTwo(a, b);
        assertArrayEquals(expected, result);
    }

    @DisplayName("Deve concatenar arrays com elementos negativos")
    @Test
    void testPlusTwoWithNegatives() {
        int[] a = {-1, -2};
        int[] b = {-3, -4};
        int[] expected = {-1, -2, -3, -4};
        int[] result = plusTwo.plusTwo(a, b);
        assertArrayEquals(expected, result);
    }

    @DisplayName("Deve concatenar arrays com zero")
    @Test
    void testPlusTwoWithZero() {
        int[] a = {0, 5};
        int[] b = {10, 0};
        int[] expected = {0, 5, 10, 0};
        int[] result = plusTwo.plusTwo(a, b);
        assertArrayEquals(expected, result);
    }

    @DisplayName("Deve concatenar arrays com números grandes")
    @Test
    void testPlusTwoWithLargeNumbers() {
        int[] a = {100, 200};
        int[] b = {300, 400};
        int[] expected = {100, 200, 300, 400};
        int[] result = plusTwo.plusTwo(a, b);
        assertArrayEquals(expected, result);
    }

    @DisplayName("Deve concatenar arrays vazios")
    @Test
    void testPlusTwoWithEmptyArrays() {
        int[] a = {};
        int[] b = {};
        int[] expected = {};
        int[] result = plusTwo.plusTwo(a, b);
        assertArrayEquals(expected, result);
    }


}
