package org.desviante.exercicios.x40_Sum_3_integers_in_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for Sum3IntegersArray")
public class Sum3IntegersArrayTest {

    private Sum3IntegersArray sum3IntegersArray;

    @BeforeEach
    void setUp() {
        sum3IntegersArray = new Sum3IntegersArray();
    }

    @DisplayName("Caso o array não tenha 3 elementos, retorne zero")
    @Test
    void testArrayLengthLessThan3() {
        assertEquals(0, sum3IntegersArray.sum3(new int[]{1, 2}));
        assertEquals(0, sum3IntegersArray.sum3(new int[]{1}));
        assertEquals(0, sum3IntegersArray.sum3(new int[]{}));
    }

    @DisplayName("Caso o array seja nulo, retorne zero")
    @Test
    void testNullArray() {
        assertEquals(0, sum3IntegersArray.sum3(null));
    }

    @DisplayName("Caso o array esteja vazio, retorne zero")
    @Test
    void testEmptyArray() {
        assertEquals(0, sum3IntegersArray.sum3(new int[]{}));
    }

    @DisplayName("Caso o array tenha 3 elementos, some e mostre o resultado da soma")
    @Test
    void testArrayLength3() {
        assertEquals(6, sum3IntegersArray.sum3(new int[]{1, 2, 3}));
        assertEquals(18, sum3IntegersArray.sum3(new int[]{5, 11, 2}));
        assertEquals(-5, sum3IntegersArray.sum3(new int[]{-10, 4, 1}));
    }

    @DisplayName("Deve funcionar para valores negativos")
    @Test
    void testNegativeValues() {
        assertEquals(-6, sum3IntegersArray.sum3(new int[]{-1, -2, -3}));
        assertEquals(-18, sum3IntegersArray.sum3(new int[]{-5, -11, -2}));
        assertEquals(0, sum3IntegersArray.sum3(new int[]{-10, 10, 0}));
    }


}
