package org.desviante.exercicios.x30_repeatEnd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes para RepeatEnd")
public class RepeatEndTest {

    private RepeatEnd repeatEnd = new RepeatEnd();

    @Test
    @DisplayName("Teste repeatEnd('Hello', 3) = 'llollollo'")
    public void testRepeatEndHello3() {
        assertEquals("llollollo", repeatEnd.repeatEnd("Hello", 3), 
            "Deve repetir os últimos 3 caracteres ('llo') 3 vezes");
    }

    @Test
    @DisplayName("Teste repeatEnd('Hello', 2) = 'lolo'")
    public void testRepeatEndHello2() {
        assertEquals("lolo", repeatEnd.repeatEnd("Hello", 2), 
            "Deve repetir os últimos 2 caracteres ('lo') 2 vezes");
    }

    @Test
    @DisplayName("Teste repeatEnd('Hello', 1) = 'o'")
    public void testRepeatEndHello1() {
        assertEquals("o", repeatEnd.repeatEnd("Hello", 1), 
            "Deve repetir o último caractere ('o') 1 vez");
    }

    @Test
    @DisplayName("Teste repeatEnd('Hello', 0) = ''")
    public void testRepeatEndHello0() {
        assertEquals("", repeatEnd.repeatEnd("Hello", 0), 
            "Deve retornar string vazia quando n = 0");
    }

    @Test
    @DisplayName("Teste repeatEnd('abc', 3) = 'abcabcabc'")
    public void testRepeatEndAbc3() {
        assertEquals("abcabcabc", repeatEnd.repeatEnd("abc", 3), 
            "Deve repetir a string inteira ('abc') 3 vezes quando n = comprimento");
    }

    @Test
    @DisplayName("Teste repeatEnd('1234', 2) = '3434'")
    public void testRepeatEnd1234() {
        assertEquals("3434", repeatEnd.repeatEnd("1234", 2), 
            "Deve repetir os últimos 2 caracteres ('34') 2 vezes");
    }

    @Test
    @DisplayName("Teste repeatEnd('1234', 3) = '234234234'")
    public void testRepeatEnd1234_3() {
        assertEquals("234234234", repeatEnd.repeatEnd("1234", 3), 
            "Deve repetir os últimos 3 caracteres ('234') 3 vezes");
    }

    @Test
    @DisplayName("Teste repeatEnd('', 0) = ''")
    public void testRepeatEndEmptyString() {
        assertEquals("", repeatEnd.repeatEnd("", 0), 
            "Deve retornar string vazia para entrada vazia");
    }

    @Test
    @DisplayName("Teste repeatEnd('Code', 4) = 'CodeCodeCodeCode'")
    public void testRepeatEndCode4() {
        assertEquals("CodeCodeCodeCode", repeatEnd.repeatEnd("Code", 4), 
            "Deve repetir a string inteira ('Code') 4 vezes quando n = comprimento");
    }

    @Test
    @DisplayName("Teste repeatEnd('Code', 2) = 'dede'")
    public void testRepeatEndCode2() {
        assertEquals("dede", repeatEnd.repeatEnd("Code", 2), 
            "Deve repetir os últimos 2 caracteres ('de') 2 vezes");
    }

    @Test
    @DisplayName("Teste repeatEnd('Java', 3) = 'avaavaava'")
    public void testRepeatEndJava3() {
        assertEquals("avaavaava", repeatEnd.repeatEnd("Java", 3), 
            "Deve repetir os últimos 3 caracteres ('ava') 3 vezes");
    }

}
