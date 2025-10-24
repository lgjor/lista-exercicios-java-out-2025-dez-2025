package org.desviante.exercicios.x01_sortasum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe SortaSum
 */
@DisplayName("Testes para a classe SortaSum")
public class SortaSumTest {

    @Test
    @DisplayName("Deve retornar 20 quando a soma está entre 10 e 19")
    public void testSortaSumRetorna20QuandoSomaEntre10E19() {
        SortaSum sortaSum = new SortaSum();
        
        // Testa com soma = 10
        assertEquals(20, sortaSum.sortaSum(5, 5));
        
        // Testa com soma = 15
        assertEquals(20, sortaSum.sortaSum(7, 8));
        
        // Testa com soma = 19
        assertEquals(20, sortaSum.sortaSum(10, 9));
    }

    @Test
    @DisplayName("Deve retornar a soma quando é menor que 10")
    public void testSortaSumRetornaSomaQuandoMenorQue10() {
        SortaSum sortaSum = new SortaSum();
        
        // Testa com soma = 5
        assertEquals(5, sortaSum.sortaSum(2, 3));
        
        // Testa com soma = 9
        assertEquals(9, sortaSum.sortaSum(4, 5));
        
        // Testa com soma = 0
        assertEquals(0, sortaSum.sortaSum(0, 0));
    }

    @Test
    @DisplayName("Deve retornar a soma quando é maior ou igual a 20")
    public void testSortaSumRetornaSomaQuandoMaiorOuIgual20() {
        SortaSum sortaSum = new SortaSum();
        
        // Testa com soma = 20
        assertEquals(20, sortaSum.sortaSum(10, 10));
        
        // Testa com soma = 25
        assertEquals(25, sortaSum.sortaSum(12, 13));
        
        // Testa com soma = 100
        assertEquals(100, sortaSum.sortaSum(50, 50));
    }

    @Test
    @DisplayName("Deve funcionar com números negativos")
    public void testSortaSumComNumerosNegativos() {
        SortaSum sortaSum = new SortaSum();
        
        // Testa com números negativos
        assertEquals(-5, sortaSum.sortaSum(-2, -3));
        
        // Testa com soma resultando em intervalo 10-19
        assertEquals(20, sortaSum.sortaSum(15, -5));
        
        // Testa números positivos e negativos
        assertEquals(3, sortaSum.sortaSum(10, -7));
    }
}

