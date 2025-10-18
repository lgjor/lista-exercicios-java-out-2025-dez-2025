package org.desviante.exercicios.x08_seeColor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe SeeColor
 */
public class SeeColorTest {

    private SeeColor seeColor;

    @BeforeEach
    void setUp() {
        seeColor = new SeeColor();
    }

    @Test
    @DisplayName("Deve retornar 'red' se a string começar com 'red'")
    void testSeeColorRed() {
        assertEquals("red", seeColor.seeColor("redxx"));
        assertEquals("red", seeColor.seeColor("red"));
    }

    @Test
    @DisplayName("Deve retornar 'blue' se a string começar com 'blue'")
    void testSeeColorBlue() {
        assertEquals("blue", seeColor.seeColor("blueTimes"));
        assertEquals("blue", seeColor.seeColor("blue"));
    }

    @Test
    @DisplayName("Deve retornar uma string vazia se não começar com 'red' ou 'blue'")
    void testSeeColorNone() {
        assertEquals("", seeColor.seeColor("aBlue"));
        assertEquals("", seeColor.seeColor("xyz"));
        assertEquals("", seeColor.seeColor(""));
        assertEquals("", seeColor.seeColor("re"));
        assertEquals("", seeColor.seeColor("blu"));
    }

    @Test
    @DisplayName("Deve retornar uma string vazia se a string for null")
    void testSeeColorNull() {
        assertEquals("", seeColor.seeColor(null));
    }

}
