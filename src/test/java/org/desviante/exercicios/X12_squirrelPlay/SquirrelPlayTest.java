package org.desviante.exercicios.X12_squirrelPlay;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testes para SquirrelPlay")
public class SquirrelPlayTest {
    
    private SquirrelPlay squirrelPlay;
    
    @BeforeEach
    void setUp() {
        squirrelPlay = new SquirrelPlay();
    }
    
    @Test
    @DisplayName("Deve retornar true quando temperatura está no intervalo válido fora do verão")
    void testTemperaturaValidaForaDoVerao() {
        // Temperatura entre 60 e 90 (não verão)
        assertTrue(squirrelPlay.squirrelPlay(70, false));
        assertTrue(squirrelPlay.squirrelPlay(80, false));
        assertTrue(squirrelPlay.squirrelPlay(75, false));
    }
    
    @Test
    @DisplayName("Deve retornar true quando temperatura está no intervalo válido no verão")
    void testTemperaturaValidaNoVerao() {
        // Temperatura entre 60 e 100 (verão)
        assertTrue(squirrelPlay.squirrelPlay(70, true));
        assertTrue(squirrelPlay.squirrelPlay(95, true));
        assertTrue(squirrelPlay.squirrelPlay(85, true));
    }
    
    @Test
    @DisplayName("Deve retornar true no limite inferior (60) em qualquer estação")
    void testLimiteInferior() {
        assertTrue(squirrelPlay.squirrelPlay(60, false));
        assertTrue(squirrelPlay.squirrelPlay(60, true));
    }
    
    @Test
    @DisplayName("Deve retornar true no limite superior fora do verão (90)")
    void testLimiteSuperiorForaDoVerao() {
        assertTrue(squirrelPlay.squirrelPlay(90, false));
    }
    
    @Test
    @DisplayName("Deve retornar true no limite superior no verão (100)")
    void testLimiteSuperiorNoVerao() {
        assertTrue(squirrelPlay.squirrelPlay(100, true));
    }
    
    @Test
    @DisplayName("Deve retornar false quando temperatura está abaixo do limite inferior")
    void testTemperaturaAbaixoDoMinimo() {
        assertFalse(squirrelPlay.squirrelPlay(59, false));
        assertFalse(squirrelPlay.squirrelPlay(59, true));
        assertFalse(squirrelPlay.squirrelPlay(50, false));
        assertFalse(squirrelPlay.squirrelPlay(50, true));
        assertFalse(squirrelPlay.squirrelPlay(0, false));
    }
    
    @Test
    @DisplayName("Deve retornar false quando temperatura está acima do limite superior fora do verão")
    void testTemperaturaAcimaDoMaximoForaDoVerao() {
        assertFalse(squirrelPlay.squirrelPlay(91, false));
        assertFalse(squirrelPlay.squirrelPlay(95, false));
        assertFalse(squirrelPlay.squirrelPlay(100, false));
    }
    
    @Test
    @DisplayName("Deve retornar false quando temperatura está acima do limite superior no verão")
    void testTemperaturaAcimaDoMaximoNoVerao() {
        assertFalse(squirrelPlay.squirrelPlay(101, true));
        assertFalse(squirrelPlay.squirrelPlay(105, true));
        assertFalse(squirrelPlay.squirrelPlay(120, true));
    }
    
    @Test
    @DisplayName("Deve testar valores nas bordas entre 90 e 100")
    void testValoresNasBordasEntre90e100() {
        // 91 a 100 são válidos apenas no verão
        assertFalse(squirrelPlay.squirrelPlay(91, false));
        assertTrue(squirrelPlay.squirrelPlay(91, true));
        
        assertFalse(squirrelPlay.squirrelPlay(95, false));
        assertTrue(squirrelPlay.squirrelPlay(95, true));
        
        assertFalse(squirrelPlay.squirrelPlay(100, false));
        assertTrue(squirrelPlay.squirrelPlay(100, true));
    }
    
    @Test
    @DisplayName("Deve testar com temperaturas extremas")
    void testTemperaturasExtremas() {
        assertFalse(squirrelPlay.squirrelPlay(-50, false));
        assertFalse(squirrelPlay.squirrelPlay(-50, true));
        assertFalse(squirrelPlay.squirrelPlay(200, false));
        assertFalse(squirrelPlay.squirrelPlay(200, true));
    }
    
    @Test
    @DisplayName("Deve testar casos típicos de uso")
    void testCasosTipicosDeUso() {
        // Casos típicos mencionados em exercícios similares
        assertTrue(squirrelPlay.squirrelPlay(70, false));
        assertFalse(squirrelPlay.squirrelPlay(95, false));
        assertTrue(squirrelPlay.squirrelPlay(95, true));
    }
}
