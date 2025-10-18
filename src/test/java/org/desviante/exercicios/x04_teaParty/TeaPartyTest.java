package org.desviante.exercicios.x04_teaParty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe TeaParty
 */

public class TeaPartyTest {

    private TeaParty teaParty;

    @BeforeEach
    void setUp() {
        teaParty = new TeaParty();
    }

    @Test
    @DisplayName("Deve retornar 0 se tea ou candy menor que 5")
    void testTeaParty_LessThan5() {
        assertEquals(0, teaParty.teaParty(3, 3));   // Ambos < 5
        assertEquals(0, teaParty.teaParty(2, 2));   // Ambos < 5
        assertEquals(0, teaParty.teaParty(1, 1));   // Ambos < 5
        assertEquals(0, teaParty.teaParty(4, 10));  // tea < 5
        assertEquals(0, teaParty.teaParty(10, 4));  // candy < 5
        assertEquals(0, teaParty.teaParty(6, 3));   // candy < 5
        assertEquals(0, teaParty.teaParty(3, 6));   // tea < 5
    }
    
    @Test
    @DisplayName("Deve retornar 2 se ambos >= 5 e tea ou candy maior ou igual a 2x o outro")
    void testTeaParty_GreaterOrEqual2xOther() {
        assertEquals(2, teaParty.teaParty(10, 5));  // tea = 2*candy
        assertEquals(2, teaParty.teaParty(5, 10));  // candy = 2*tea
        assertEquals(2, teaParty.teaParty(20, 10)); // tea = 2*candy
        assertEquals(2, teaParty.teaParty(12, 6));  // tea = 2*candy
        assertEquals(2, teaParty.teaParty(6, 12));  // candy = 2*tea
    }
    
    @Test
    @DisplayName("Deve retornar 1 se ambos >= 5 e nenhum >= 2x o outro")
    void testTeaParty_GreaterThan5AndLessThan2xOther() {
        assertEquals(1, teaParty.teaParty(5, 5));   // Ambos iguais
        assertEquals(1, teaParty.teaParty(6, 5));   // tea um pouco maior, mas < 2x
        assertEquals(1, teaParty.teaParty(5, 6));   // candy um pouco maior, mas < 2x
        assertEquals(1, teaParty.teaParty(7, 6));   // Ambos próximos
        assertEquals(1, teaParty.teaParty(9, 5));   // tea < 2*candy (9 < 10)
    }
}
