package org.desviante.exercicios.x13_caughtSpeeding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para CaughtSpeeding")
public class CaughtSpeedingTest {

    @Test
    @DisplayName("Velocidade maior que 85 sempre deve retornar 2")
    void testBigTicket(){
        assertEquals(2, new CaughtSpeeding().caughtSpeeding(86, false));
        assertEquals(2, new CaughtSpeeding().caughtSpeeding(86, true));
        assertEquals(2, new CaughtSpeeding().caughtSpeeding(190, false));
        assertEquals(2, new CaughtSpeeding().caughtSpeeding(100, true));
    }

    @Test
    @DisplayName("Velocidade 60 ou menos (sem aniversário) deve retornar 0")
    void testNoTicketNoBirthday(){
        assertEquals(0, new CaughtSpeeding().caughtSpeeding(60, false));
        assertEquals(0, new CaughtSpeeding().caughtSpeeding(50, false));
        assertEquals(0, new CaughtSpeeding().caughtSpeeding(0, false));
        assertEquals(0, new CaughtSpeeding().caughtSpeeding(45, false));
    }

    @Test
    @DisplayName("Velocidade 65 ou menos (com aniversário) deve retornar 0")
    void testNoTicketWithBirthday(){
        assertEquals(0, new CaughtSpeeding().caughtSpeeding(65, true));
        assertEquals(0, new CaughtSpeeding().caughtSpeeding(60, true));
        assertEquals(0, new CaughtSpeeding().caughtSpeeding(0, true));
        assertEquals(0, new CaughtSpeeding().caughtSpeeding(50, true));
    }

    @Test
    @DisplayName("Velocidade entre 61 e 80 (sem aniversário) deve retornar 1")
    void testSmallTicketNoBirthday(){
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(61, false));
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(70, false));
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(80, false));
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(75, false));
    }

    @Test
    @DisplayName("Velocidade entre 66 e 85 (com aniversário) deve retornar 1")
    void testSmallTicketWithBirthday(){
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(66, true));
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(75, true));
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(80, true));
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(85, true));
    }

    @Test
    @DisplayName("Velocidade entre 81 e 85 (sem aniversário) deve retornar 2")
    void testBigTicketNoBirthday(){
        assertEquals(2, new CaughtSpeeding().caughtSpeeding(81, false));
        assertEquals(2, new CaughtSpeeding().caughtSpeeding(82, false));
        assertEquals(2, new CaughtSpeeding().caughtSpeeding(85, false));
    }

    @Test
    @DisplayName("Casos limite - verificar transições entre categorias")
    void testBoundaryConditions(){
        // Transição 60->61 sem aniversário (0->1)
        assertEquals(0, new CaughtSpeeding().caughtSpeeding(60, false));
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(61, false));
        
        // Transição 80->81 sem aniversário (1->2)
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(80, false));
        assertEquals(2, new CaughtSpeeding().caughtSpeeding(81, false));
        
        // Transição 65->66 com aniversário (0->1)
        assertEquals(0, new CaughtSpeeding().caughtSpeeding(65, true));
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(66, true));
        
        // Transição 85->86 com aniversário (1->2)
        assertEquals(1, new CaughtSpeeding().caughtSpeeding(85, true));
        assertEquals(2, new CaughtSpeeding().caughtSpeeding(86, true));
    }

}
