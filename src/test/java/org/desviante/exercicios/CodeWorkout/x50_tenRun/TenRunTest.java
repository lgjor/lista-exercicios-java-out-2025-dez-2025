package org.desviante.exercicios.x50_tenRun;


import org.desviante.exercicios.CodeWorkout.x50_tenRun.TenRun;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for TenRun")
public class TenRunTest {


    @Test
    @DisplayName("Quando for nulo, deve retornar nulo")
    void nullArrayNullReturn(){
        int[] resultado = TenRun.tenRun(null);
        Assertions.assertNull(resultado);
    }

    @Test
    @DisplayName("Se houver apenas 1 elemento, não faz nada")
    void oneElementReturnOneElement(){
        int[] nums = new int[]{10};
        int [] resultado = TenRun.tenRun(nums);
        Assertions.assertArrayEquals(nums, resultado);
    }

    @Test
    @DisplayName("Se o múltiplo de 10 for o último elemento, não faz nada")
    void lastElementTenRun(){
        int[] nums = new int[]{1, 3, 4, 5, 10};
        int [] resultado = TenRun.tenRun(nums);
        Assertions.assertArrayEquals(nums, resultado);
    }

    @Test
    @DisplayName("Deve substituir o elemento seguinte pelo múltiplo de 10 correspondente")
    void replaceTenRunCorrectly(){
        int[] nums = new int[]{2, 10, 3, 4, 20, 5};
        int [] resultado = TenRun.tenRun(nums);
        int [] expected = new int[]{2, 10, 10, 10, 20, 20};
        Assertions.assertArrayEquals(expected, resultado);

        nums = new int[]{10, 1, 20, 2};
        resultado = TenRun.tenRun(nums);
        expected = new int[] {10, 10, 20, 20};
        Assertions.assertArrayEquals(expected, resultado);

        nums = new int[]{10, 1, 9, 20};
        resultado = TenRun.tenRun(nums);
        expected = new int[] {10, 10, 10, 20};
        Assertions.assertArrayEquals(expected, resultado);
    }

}
