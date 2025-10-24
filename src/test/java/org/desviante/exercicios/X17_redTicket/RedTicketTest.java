package org.desviante.exercicios.X17_redTicket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe RedTicket
 */
@DisplayName("Testes para RedTicket")
public class RedTicketTest {

    @Test
    @DisplayName("Todos os valores são 2, deve retornar 10")
    void testAllTwos() {
        assertEquals(10, new RedTicket().redTicket(2, 2, 2));
    }

    @Test
    @DisplayName("Todos os valores são iguais (mas não 2), deve retornar 5")
    void testAllSameNotTwo() {
        assertEquals(5, new RedTicket().redTicket(0, 0, 0));
        assertEquals(5, new RedTicket().redTicket(1, 1, 1));
    }

    @Test
    @DisplayName("b e c são diferentes de a, deve retornar 1")
    void testBandCDiffFromA() {
        assertEquals(1, new RedTicket().redTicket(0, 1, 1)); // b e c iguais, mas diferentes de a
        assertEquals(1, new RedTicket().redTicket(0, 1, 2)); // b e c diferentes entre si e de a
        assertEquals(1, new RedTicket().redTicket(1, 0, 2)); // b e c diferentes entre si e de a
        assertEquals(1, new RedTicket().redTicket(2, 0, 1)); // b e c diferentes entre si e de a
        assertEquals(1, new RedTicket().redTicket(1, 2, 2)); // b e c iguais, mas diferentes de a
        assertEquals(1, new RedTicket().redTicket(1, 0, 0)); // b e c iguais, mas diferentes de a
    }

    @Test
    @DisplayName("Nenhuma das condições anteriores, deve retornar 0")
    void testDefaultCase() {
        assertEquals(0, new RedTicket().redTicket(2, 1, 2)); // a igual a c, mas não todos iguais
        assertEquals(0, new RedTicket().redTicket(0, 0, 1)); // a igual a b, mas não todos iguais
        assertEquals(0, new RedTicket().redTicket(1, 1, 0)); // a igual a b, mas não todos iguais
        assertEquals(0, new RedTicket().redTicket(2, 2, 1)); // a igual a b, mas não todos iguais
    }

    @Test
    @DisplayName("Casos mistos e limites")
    void testMixedCases() {
        assertEquals(1, new RedTicket().redTicket(1, 2, 0)); // b != a e c != a
        assertEquals(0, new RedTicket().redTicket(0, 2, 0)); // a igual a c, mas não todos iguais
        assertEquals(1, new RedTicket().redTicket(2, 1, 0)); // b != a e c != a
    }
}
