package org.desviante.exercicios.x52_centeredAverage;

import org.desviante.exercicios.CodeWorkout.x52_centeredAverage.CenteredAverage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for CenteredAverage")
public class CenteredAverageTest {

    @Test
    @DisplayName("Calcula média centralizada para [1,2,3,4,100] -> 3")
    void computesExampleOne() {
        CenteredAverage ca = new CenteredAverage();
        int[] nums = new int[]{1, 2, 3, 4, 100};
        int resultado = ca.centeredAverage(nums);
        Assertions.assertEquals(3, resultado);
    }

    @Test
    @DisplayName("Calcula média centralizada para [1,1,5,5,10,8,7] -> 5")
    void computesExampleTwo() {
        CenteredAverage ca = new CenteredAverage();
        int[] nums = new int[]{1, 1, 5, 5, 10, 8, 7};
        int resultado = ca.centeredAverage(nums);
        Assertions.assertEquals(5, resultado);
    }

    @Test
    @DisplayName("Calcula média centralizada para [10, 0, 0, 0, 10] -> 0")
    void handlesZerosAndEnds() {
        CenteredAverage ca = new CenteredAverage();
        int[] nums = new int[]{10, 0, 0, 0, 10};
        int resultado = ca.centeredAverage(nums);
        Assertions.assertEquals(3, resultado);
    }

    @Test
    @DisplayName("Funciona com números negativos e positivos misturados")
    void handlesNegativeAndPositive() {
        CenteredAverage ca = new CenteredAverage();
        int[] nums = new int[]{-5, -1, 0, 2, 100};
        int resultado = ca.centeredAverage(nums);
        // remove min=-5 e max=100, média de [-1,0,2] = (1)/3 = 0
        Assertions.assertEquals(0, resultado);
    }

    @Test
    @DisplayName("Quando todos iguais, média centralizada é o próprio valor")
    void allEqual() {
        CenteredAverage ca = new CenteredAverage();
        int[] nums = new int[]{4, 4, 4, 4, 4};
        int resultado = ca.centeredAverage(nums);
        Assertions.assertEquals(4, resultado);
    }
}
