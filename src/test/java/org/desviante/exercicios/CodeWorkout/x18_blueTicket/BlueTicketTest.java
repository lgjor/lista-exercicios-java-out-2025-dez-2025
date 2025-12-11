package org.desviante.exercicios.x18_blueTicket;

import org.desviante.exercicios.CodeWorkout.x18_blueTicket.BlueTicket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

/**
 * Testes para a classe BlueTicket
 */
@DisplayName("Testes para a classe BlueTicket")
public class BlueTicketTest {

    @Test
    @DisplayName("Se a soma de qualquer par for 10, o resultado é 10")
    void testBlueTicket10() {
        assertEquals(10, new BlueTicket().blueTicket(9, 1, 0));
        assertEquals(10, new BlueTicket().blueTicket(9, 0, 1));
        assertEquals(10, new BlueTicket().blueTicket(0, 9, 1));
    }

    @Test
    @DisplayName("Se ab for 10 a mais que bc ou ac, o resultado é 5")
    void testBlueTicket5() {
        // Casos onde a = c + 10, então ab = bc + 10
        assertEquals(5, new BlueTicket().blueTicket(11, 2, 1)); // ab=13, bc=3, ac=12: ab==bc+10? 13==13 ✓
        assertEquals(5, new BlueTicket().blueTicket(12, 3, 2)); // ab=15, bc=5, ac=14: ab==bc+10? 15==15 ✓
        assertEquals(5, new BlueTicket().blueTicket(15, 0, 5)); // ab=15, bc=5, ac=20: ab==bc+10? 15==15 ✓
        
        // Casos onde b = c + 10, então ab = ac + 10
        assertEquals(5, new BlueTicket().blueTicket(2, 11, 1)); // ab=13, bc=12, ac=3: ab==ac+10? 13==13 ✓
        assertEquals(5, new BlueTicket().blueTicket(3, 12, 2)); // ab=15, bc=14, ac=5: ab==ac+10? 15==15 ✓
        assertEquals(5, new BlueTicket().blueTicket(0, 15, 5)); // ab=15, bc=20, ac=5: ab==ac+10? 15==15 ✓
    }

    @Test
    @DisplayName("Se nenhum par soma 10 e ab não é 10 a mais que bc ou ac, o resultado é 0")
    void testBlueTicket0() {
        assertEquals(0, new BlueTicket().blueTicket(1, 2, 3)); // ab=3, bc=5, ac=4: nenhuma condição atendida
        assertEquals(0, new BlueTicket().blueTicket(1, 2, 4)); // ab=3, bc=6, ac=5: nenhuma condição atendida
        assertEquals(0, new BlueTicket().blueTicket(1, 2, 5)); // ab=3, bc=7, ac=6: nenhuma condição atendida
        assertEquals(0, new BlueTicket().blueTicket(1, 2, 6)); // ab=3, bc=8, ac=7: nenhuma condição atendida
        assertEquals(0, new BlueTicket().blueTicket(1, 2, 7)); // ab=3, bc=9, ac=8: nenhuma condição atendida
        assertEquals(0, new BlueTicket().blueTicket(3, 4, 5)); // ab=7, bc=9, ac=8: nenhuma condição atendida
    }    
}
