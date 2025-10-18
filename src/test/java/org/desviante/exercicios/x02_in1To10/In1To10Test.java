package org.desviante.exercicios.x02_in1To10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para o método in1To10
 * Testa a função que verifica se um número está no intervalo 1-10
 * com suporte a modo normal e modo outside
 */
@DisplayName("Testes para o método in1To10")
class In1To10Test {
    
    private In1To10 in1To10;
    
    @BeforeEach
    void setUp() {
        in1To10 = new In1To10();
    }
    
    // ==================== TESTES MODO NORMAL (outsideMode = false) ====================
    
    @Test
    @DisplayName("Modo Normal: Deve retornar false para 11")
    void testModoNormal_11_RetornaFalse() {
        assertFalse(in1To10.in1To10(11, false), 
            "11 não está no intervalo 1-10, deve retornar false");
    }
    
    @Test
    @DisplayName("Modo Normal: Deve retornar true para 5 (meio do intervalo)")
    void testModoNormal_5_RetornaTrue() {
        assertTrue(in1To10.in1To10(5, false), 
            "5 está no intervalo 1-10, deve retornar true");
    }
    
    @Test
    @DisplayName("Modo Normal: Deve retornar true para 1 (limite inferior)")
    void testModoNormal_1_RetornaTrue() {
        assertTrue(in1To10.in1To10(1, false), 
            "1 está no intervalo 1-10 (inclusive), deve retornar true");
    }
    
    @Test
    @DisplayName("Modo Normal: Deve retornar true para 10 (limite superior)")
    void testModoNormal_10_RetornaTrue() {
        assertTrue(in1To10.in1To10(10, false), 
            "10 está no intervalo 1-10 (inclusive), deve retornar true");
    }
    
    @Test
    @DisplayName("Modo Normal: Deve retornar false para 0")
    void testModoNormal_0_RetornaFalse() {
        assertFalse(in1To10.in1To10(0, false), 
            "0 não está no intervalo 1-10, deve retornar false");
    }
    
    @Test
    @DisplayName("Modo Normal: Deve retornar false para números negativos")
    void testModoNormal_Negativo_RetornaFalse() {
        assertFalse(in1To10.in1To10(-5, false), 
            "-5 não está no intervalo 1-10, deve retornar false");
        assertFalse(in1To10.in1To10(-1, false), 
            "-1 não está no intervalo 1-10, deve retornar false");
    }
    
    @Test
    @DisplayName("Modo Normal: Deve retornar false para 12")
    void testModoNormal_12_RetornaFalse() {
        assertFalse(in1To10.in1To10(12, false), 
            "12 não está no intervalo 1-10, deve retornar false");
    }
    
    @Test
    @DisplayName("Modo Normal: Deve retornar true para todos os números de 2 a 9")
    void testModoNormal_IntervaloCompleto_RetornaTrue() {
        for (int i = 2; i <= 9; i++) {
            assertTrue(in1To10.in1To10(i, false), 
                i + " está no intervalo 1-10, deve retornar true");
        }
    }
    
    @Test
    @DisplayName("Modo Normal: Deve retornar false para números muito grandes")
    void testModoNormal_NumeroGrande_RetornaFalse() {
        assertFalse(in1To10.in1To10(100, false), 
            "100 não está no intervalo 1-10, deve retornar false");
        assertFalse(in1To10.in1To10(1000, false), 
            "1000 não está no intervalo 1-10, deve retornar false");
    }
    
    @Test
    @DisplayName("Modo Normal: Deve retornar false para números muito pequenos")
    void testModoNormal_NumeroPequeno_RetornaFalse() {
        assertFalse(in1To10.in1To10(-100, false), 
            "-100 não está no intervalo 1-10, deve retornar false");
        assertFalse(in1To10.in1To10(-1000, false), 
            "-1000 não está no intervalo 1-10, deve retornar false");
    }
    
    // ==================== TESTES MODO OUTSIDE (outsideMode = true) ====================
    
    @Test
    @DisplayName("Modo Outside: Deve retornar true para 11 (exemplo fornecido)")
    void testModoOutside_11_RetornaTrue() {
        assertTrue(in1To10.in1To10(11, true), 
            "11 >= 10, no modo outside deve retornar true");
    }
    
    @Test
    @DisplayName("Modo Outside: Deve retornar false para 5 (meio do intervalo)")
    void testModoOutside_5_RetornaFalse() {
        assertFalse(in1To10.in1To10(5, true), 
            "5 está entre 2 e 9, no modo outside deve retornar false");
    }
    
    @Test
    @DisplayName("Modo Outside: Deve retornar true para 1 (limite)")
    void testModoOutside_1_RetornaTrue() {
        assertTrue(in1To10.in1To10(1, true), 
            "1 <= 1, no modo outside deve retornar true");
    }
    
    @Test
    @DisplayName("Modo Outside: Deve retornar true para 10 (limite)")
    void testModoOutside_10_RetornaTrue() {
        assertTrue(in1To10.in1To10(10, true), 
            "10 >= 10, no modo outside deve retornar true");
    }
    
    @Test
    @DisplayName("Modo Outside: Deve retornar true para 0")
    void testModoOutside_0_RetornaTrue() {
        assertTrue(in1To10.in1To10(0, true), 
            "0 <= 1, no modo outside deve retornar true");
    }
    
    @Test
    @DisplayName("Modo Outside: Deve retornar true para números negativos")
    void testModoOutside_Negativo_RetornaTrue() {
        assertTrue(in1To10.in1To10(-5, true), 
            "-5 <= 1, no modo outside deve retornar true");
        assertTrue(in1To10.in1To10(-1, true), 
            "-1 <= 1, no modo outside deve retornar true");
    }
    
    @Test
    @DisplayName("Modo Outside: Deve retornar true para 12")
    void testModoOutside_12_RetornaTrue() {
        assertTrue(in1To10.in1To10(12, true), 
            "12 >= 10, no modo outside deve retornar true");
    }
    
    @Test
    @DisplayName("Modo Outside: Deve retornar false para números de 2 a 9")
    void testModoOutside_IntervaloInterno_RetornaFalse() {
        for (int i = 2; i <= 9; i++) {
            assertFalse(in1To10.in1To10(i, true), 
                i + " está entre 2 e 9, no modo outside deve retornar false");
        }
    }
    
    @Test
    @DisplayName("Modo Outside: Deve retornar true para números muito grandes")
    void testModoOutside_NumeroGrande_RetornaTrue() {
        assertTrue(in1To10.in1To10(100, true), 
            "100 >= 10, no modo outside deve retornar true");
        assertTrue(in1To10.in1To10(1000, true), 
            "1000 >= 10, no modo outside deve retornar true");
    }
    
    @Test
    @DisplayName("Modo Outside: Deve retornar true para números muito pequenos")
    void testModoOutside_NumeroPequeno_RetornaTrue() {
        assertTrue(in1To10.in1To10(-100, true), 
            "-100 <= 1, no modo outside deve retornar true");
        assertTrue(in1To10.in1To10(-1000, true), 
            "-1000 <= 1, no modo outside deve retornar true");
    }
    
    // ==================== TESTES DE LIMITES E CASOS ESPECIAIS ====================
    
    @Test
    @DisplayName("Limites: Deve testar corretamente o valor 2 em ambos os modos")
    void testLimites_Valor2() {
        assertTrue(in1To10.in1To10(2, false), 
            "2 está no intervalo 1-10 no modo normal");
        assertFalse(in1To10.in1To10(2, true), 
            "2 não satisfaz <= 1 nem >= 10 no modo outside");
    }
    
    @Test
    @DisplayName("Limites: Deve testar corretamente o valor 9 em ambos os modos")
    void testLimites_Valor9() {
        assertTrue(in1To10.in1To10(9, false), 
            "9 está no intervalo 1-10 no modo normal");
        assertFalse(in1To10.in1To10(9, true), 
            "9 não satisfaz <= 1 nem >= 10 no modo outside");
    }
    
    @Test
    @DisplayName("Casos Especiais: Integer.MAX_VALUE em ambos os modos")
    void testCasosEspeciais_IntegerMaxValue() {
        assertFalse(in1To10.in1To10(Integer.MAX_VALUE, false), 
            "Integer.MAX_VALUE não está no intervalo 1-10 no modo normal");
        assertTrue(in1To10.in1To10(Integer.MAX_VALUE, true), 
            "Integer.MAX_VALUE >= 10 no modo outside");
    }
    
    @Test
    @DisplayName("Casos Especiais: Integer.MIN_VALUE em ambos os modos")
    void testCasosEspeciais_IntegerMinValue() {
        assertFalse(in1To10.in1To10(Integer.MIN_VALUE, false), 
            "Integer.MIN_VALUE não está no intervalo 1-10 no modo normal");
        assertTrue(in1To10.in1To10(Integer.MIN_VALUE, true), 
            "Integer.MIN_VALUE <= 1 no modo outside");
    }
    
    @Test
    @DisplayName("Comportamento: Mesmo número deve ter resultados opostos dependendo do modo")
    void testComportamento_ModosDiferentes() {
        // Número dentro do intervalo 1-10
        int dentroIntervalo = 5;
        assertTrue(in1To10.in1To10(dentroIntervalo, false), 
            "5 deve ser true no modo normal");
        assertFalse(in1To10.in1To10(dentroIntervalo, true), 
            "5 deve ser false no modo outside");
        
        // Número fora do intervalo
        int foraIntervalo = 15;
        assertFalse(in1To10.in1To10(foraIntervalo, false), 
            "15 deve ser false no modo normal");
        assertTrue(in1To10.in1To10(foraIntervalo, true), 
            "15 deve ser true no modo outside");
    }
    
    @Test
    @DisplayName("Tabela de Verdade: Testa valores-chave com ambos os modos")
    void testTabelaVerdade() {
        // Estrutura: [valor, modoNormal esperado, modoOutside esperado]
        Object[][] casos = {
            {-10, false, true},
            {0, false, true},
            {1, true, true},
            {2, true, false},
            {5, true, false},
            {9, true, false},
            {10, true, true},
            {11, false, true},
            {50, false, true}
        };
        
        for (Object[] caso : casos) {
            int valor = (int) caso[0];
            boolean esperadoNormal = (boolean) caso[1];
            boolean esperadoOutside = (boolean) caso[2];
            
            assertEquals(esperadoNormal, in1To10.in1To10(valor, false),
                String.format("Valor %d no modo normal deve retornar %b", valor, esperadoNormal));
            assertEquals(esperadoOutside, in1To10.in1To10(valor, true),
                String.format("Valor %d no modo outside deve retornar %b", valor, esperadoOutside));
        }
    }
}

