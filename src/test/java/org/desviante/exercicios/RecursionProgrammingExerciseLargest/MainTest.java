package org.desviante.exercicios.RecursionProgrammingExerciseLargest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para o método largest (recursão)
 * Testa a função que encontra o maior elemento em um array
 */
@DisplayName("Testes para o método largest")
class MainTest {
    
    private Main main;
    
    @BeforeEach
    void setUp() {
        main = new Main();
    }
    
    @Test
    @DisplayName("Deve encontrar o maior elemento no exemplo fornecido")
    void testExemploFornecido() {
        int[] numbers = {2, 4, 8};
        assertEquals(8, main.largest(numbers, 2), 
            "O maior elemento de {2, 4, 8} deve ser 8");
    }
    
    @Test
    @DisplayName("Deve funcionar com array de um único elemento")
    void testArrayUmElemento() {
        int[] numbers = {5};
        assertEquals(5, main.largest(numbers, 0), 
            "Array com um elemento deve retornar esse elemento");
    }
    
    @Test
    @DisplayName("Deve encontrar o maior quando está no início")
    void testMaiorNoInicio() {
        int[] numbers = {10, 5, 3, 1};
        assertEquals(10, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar 10 quando está no início do array");
    }
    
    @Test
    @DisplayName("Deve encontrar o maior quando está no meio")
    void testMaiorNoMeio() {
        int[] numbers = {5, 15, 3, 7};
        assertEquals(15, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar 15 quando está no meio do array");
    }
    
    @Test
    @DisplayName("Deve encontrar o maior quando está no final")
    void testMaiorNoFinal() {
        int[] numbers = {1, 3, 5, 20};
        assertEquals(20, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar 20 quando está no final do array");
    }
    
    @Test
    @DisplayName("Deve funcionar com números negativos")
    void testNumerosNegativos() {
        int[] numbers = {-10, -5, -20, -3};
        assertEquals(-3, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar -3 como o maior entre números negativos");
    }
    
    @Test
    @DisplayName("Deve funcionar com números positivos e negativos misturados")
    void testNumerosMisturados() {
        int[] numbers = {-5, 10, -20, 3, 0};
        assertEquals(10, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar 10 em array com positivos e negativos");
    }
    
    @Test
    @DisplayName("Deve funcionar quando todos os elementos são iguais")
    void testElementosIguais() {
        int[] numbers = {7, 7, 7, 7};
        assertEquals(7, main.largest(numbers, numbers.length - 1), 
            "Deve retornar 7 quando todos elementos são iguais");
    }
    
    @Test
    @DisplayName("Deve funcionar com array de dois elementos")
    void testArrayDoisElementos() {
        int[] numbers = {3, 9};
        assertEquals(9, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar 9 em array de dois elementos");
    }
    
    @Test
    @DisplayName("Deve funcionar com números grandes")
    void testNumerosGrandes() {
        int[] numbers = {1000000, 999999, 1000001, 500000};
        assertEquals(1000001, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar o maior entre números grandes");
    }
    
    @Test
    @DisplayName("Deve funcionar quando chamado com índice menor que o último")
    void testComIndiceIntermediario() {
        int[] numbers = {1, 5, 3, 10, 2};
        assertEquals(5, main.largest(numbers, 2), 
            "Deve encontrar 5 ao buscar apenas nos 3 primeiros elementos");
    }
    
    @Test
    @DisplayName("Deve funcionar com array contendo zero")
    void testComZero() {
        int[] numbers = {0, -5, -10};
        assertEquals(0, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar 0 como o maior elemento");
    }
    
    @Test
    @DisplayName("Deve encontrar o maior em array ordenado crescente")
    void testArrayOrdenadoCrescente() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertEquals(5, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar 5 em array ordenado crescente");
    }
    
    @Test
    @DisplayName("Deve encontrar o maior em array ordenado decrescente")
    void testArrayOrdenadoDecrescente() {
        int[] numbers = {10, 8, 6, 4, 2};
        assertEquals(10, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar 10 em array ordenado decrescente");
    }
    
    @Test
    @DisplayName("Deve funcionar com valores duplicados incluindo o maior")
    void testValoresDuplicados() {
        int[] numbers = {3, 8, 5, 8, 2};
        assertEquals(8, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar 8 quando há valores duplicados");
    }
    
    @Test
    @DisplayName("Deve funcionar com Integer.MAX_VALUE")
    void testIntegerMaxValue() {
        int[] numbers = {100, Integer.MAX_VALUE, 50};
        assertEquals(Integer.MAX_VALUE, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar Integer.MAX_VALUE");
    }
    
    @Test
    @DisplayName("Deve funcionar com Integer.MIN_VALUE")
    void testIntegerMinValue() {
        int[] numbers = {Integer.MIN_VALUE, -1000, -500};
        assertEquals(-500, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar -500 quando Integer.MIN_VALUE está presente");
    }
    
    @Test
    @DisplayName("Deve funcionar recursivamente com array grande")
    void testArrayGrande() {
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i;
        }
        numbers[50] = 200; // Coloca o maior no meio
        
        assertEquals(200, main.largest(numbers, numbers.length - 1), 
            "Deve encontrar 200 em array de 100 elementos");
    }
    
    @Test
    @DisplayName("Deve retornar o primeiro elemento quando index é 0")
    void testIndexZero() {
        int[] numbers = {42, 10, 5};
        assertEquals(42, main.largest(numbers, 0), 
            "Deve retornar o primeiro elemento quando index é 0");
    }
}

