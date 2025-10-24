package org.desviante.exercicios.x07_endsLy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.desviante.exercicios.X07_endsLy.EndsLy;

/**
 * Testes para a classe EndsLy
 */
public class EndsLyTest {
    private EndsLy endsLy;

    @BeforeEach
    void setUp() {
        endsLy = new EndsLy();
    }

    @Test
    @DisplayName("Deve retornar true se a string terminar em 'ly'")
    void testEndsLyTrue() {
        assertTrue(endsLy.endsLy("happyly"));
    }

    @Test
    @DisplayName("Deve retornar false se a string não terminar em 'ly'")
    void testEndsLyFalse() {
        assertFalse(endsLy.endsLy("happy"));
    }

    @Test
    @DisplayName("Deve retornar false se a string for null")
    void testEndsLyNull() {
        assertFalse(endsLy.endsLy(null));
    }

}
