package org.desviante.exercicios.x010_comboString;

import org.desviante.exercicios.x10_comboString.ComboString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
* Testes para a classe MakeTags
*/
public class ComboStringTest {

    private ComboString comboString;

    @BeforeEach
    void setUp() {
        comboString = new ComboString();
    }

    @Test
    @DisplayName("Se uma palavra for menor, deverá retorná-la em volta da maior")
    void testOneWordSmaller(){
        assertEquals("hiHellohi", comboString.comboString("Hello", "hi"));
        assertEquals("hiHellohi", comboString.comboString("hi", "Hello"));
    }

    @Test
    @DisplayName("Se as palavras forem iguais, será indiferente a ordem do retorno")
    void testTwoEqualsWords(){
        assertEquals("eitaeitaeita", comboString.comboString("eita", "eita"));
    }

    @Test
    @DisplayName("Se alguma das strings for null, deverá retornar uma string vazia")
    void testNullString(){
        assertEquals("", comboString.comboString(null, null));
    }

    @Test
    @DisplayName("Se uma das strings for vazia, deverá retornar apenas a outra string uma vez")
    void testEmptyString() {
        assertEquals("middle", comboString.comboString("", "middle"));
        assertEquals("middle test 2", comboString.comboString("middle test 2", ""));
    }
}
