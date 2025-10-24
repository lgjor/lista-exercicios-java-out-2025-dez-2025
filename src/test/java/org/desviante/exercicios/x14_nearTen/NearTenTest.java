package org.desviante.exercicios.x14_nearTen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para NearTen")
public class NearTenTest {

    @Test
    @DisplayName("Números que são exatamente múltiplos de 10 devem retornar true")
    void testExactMultiplesOfTen(){
        assertTrue(new NearTen().nearTen(0));
        assertTrue(new NearTen().nearTen(10));
        assertTrue(new NearTen().nearTen(20));
        assertTrue(new NearTen().nearTen(30));
        assertTrue(new NearTen().nearTen(100));
        assertTrue(new NearTen().nearTen(200));
    }

    @Test
    @DisplayName("Números a 1 unidade de um múltiplo de 10 devem retornar true")
    void testOneUnitAway(){
        assertTrue(new NearTen().nearTen(1));  // 1 unidade de 0
        assertTrue(new NearTen().nearTen(9));  // 1 unidade de 10
        assertTrue(new NearTen().nearTen(11)); // 1 unidade de 10
        assertTrue(new NearTen().nearTen(19)); // 1 unidade de 20
        assertTrue(new NearTen().nearTen(21)); // 1 unidade de 20
        assertTrue(new NearTen().nearTen(31)); // 1 unidade de 30
        assertTrue(new NearTen().nearTen(99)); // 1 unidade de 100
    }

    @Test
    @DisplayName("Números a 2 unidades de um múltiplo de 10 devem retornar true")
    void testTwoUnitsAway(){
        assertTrue(new NearTen().nearTen(2));  // 2 unidades de 0
        assertTrue(new NearTen().nearTen(8));  // 2 unidades de 10
        assertTrue(new NearTen().nearTen(12)); // 2 unidades de 10
        assertTrue(new NearTen().nearTen(18)); // 2 unidades de 20
        assertTrue(new NearTen().nearTen(22)); // 2 unidades de 20
        assertTrue(new NearTen().nearTen(32)); // 2 unidades de 30
        assertTrue(new NearTen().nearTen(158)); // 2 unidades de 160
    }

    @Test
    @DisplayName("Números a mais de 2 unidades de um múltiplo de 10 devem retornar false")
    void testMoreThanTwoUnitsAway(){
        assertFalse(new NearTen().nearTen(3));  // 3 unidades de 0
        assertFalse(new NearTen().nearTen(4));  // 4 unidades de 0
        assertFalse(new NearTen().nearTen(5));  // 5 unidades de 0 ou 10
        assertFalse(new NearTen().nearTen(6));  // 4 unidades de 10
        assertFalse(new NearTen().nearTen(7));  // 3 unidades de 10
        assertFalse(new NearTen().nearTen(13)); // 3 unidades de 10
        assertFalse(new NearTen().nearTen(17)); // 3 unidades de 20
        assertFalse(new NearTen().nearTen(23)); // 3 unidades de 20
        assertFalse(new NearTen().nearTen(54)); // 4 unidades de 50
        assertFalse(new NearTen().nearTen(155)); // 5 unidades de 160
    }

    @Test
    @DisplayName("Casos limite - verificar transições entre as zonas")
    void testBoundaryConditions(){
        // Transição em 2->3 (true->false)
        assertTrue(new NearTen().nearTen(2));
        assertFalse(new NearTen().nearTen(3));
        
        // Transição em 7->8 (false->true)
        assertFalse(new NearTen().nearTen(7));
        assertTrue(new NearTen().nearTen(8));
        
        // Transição em 12->13 (true->false)
        assertTrue(new NearTen().nearTen(12));
        assertFalse(new NearTen().nearTen(13));
        
        // Transição em 17->18 (false->true)
        assertFalse(new NearTen().nearTen(17));
        assertTrue(new NearTen().nearTen(18));
    }

    @Test
    @DisplayName("Teste com valores grandes")
    void testLargeNumbers(){
        assertTrue(new NearTen().nearTen(1000));  // Exatamente múltiplo
        assertTrue(new NearTen().nearTen(1001));  // 1 unidade
        assertTrue(new NearTen().nearTen(1002));  // 2 unidades
        assertFalse(new NearTen().nearTen(1003)); // 3 unidades
        assertTrue(new NearTen().nearTen(1008));  // 2 unidades
        assertTrue(new NearTen().nearTen(1009));  // 1 unidade
    }

}