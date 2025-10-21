package org.desviante.exercicios.x31_plusOut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class PlusOutTest {

    private PlusOut plusOut;

    @BeforeEach
    void setUp() {
        plusOut = new PlusOut();
    }

    @Test
    @DisplayName("Caso básico 1: plusOut('12xy34', 'xy') deve retornar '++xy++'")
    void testCasoBasico1() {
        assertEquals("++xy++", plusOut.plusOut("12xy34", "xy"));
    }

    @Test
    @DisplayName("Caso básico 2: plusOut('12xy34', '1') deve retornar '1+++++'")
    void testCasoBasico2() {
        assertEquals("1+++++", plusOut.plusOut("12xy34", "1"));
    }

    @Test
    @DisplayName("Palavra não encontrada: todos os caracteres devem virar '+'")
    void testPalavraInexistente() {
        assertEquals("++++++", plusOut.plusOut("12xy34", "z"));
        assertEquals("+++++", plusOut.plusOut("abcde", "xyz"));
    }

    @Test
    @DisplayName("Múltiplas ocorrências da palavra")
    void testMultiplasOcorrencias() {
        assertEquals("++xy++xy++++", plusOut.plusOut("12xy34xy3435", "xy"));
        assertEquals("++aa++aa++", plusOut.plusOut("12aa34aa56", "aa"));
    }

    @Test
    @DisplayName("Palavra no início da string")
    void testPalavraNoInicio() {
        assertEquals("abc+++", plusOut.plusOut("abc123", "abc"));
        assertEquals("xy++++", plusOut.plusOut("xy1234", "xy"));
    }

    @Test
    @DisplayName("Palavra no final da string")
    void testPalavraNoFinal() {
        assertEquals("+++abc", plusOut.plusOut("123abc", "abc"));
        assertEquals("+++++xy", plusOut.plusOut("12345xy", "xy"));
    }

    @Test
    @DisplayName("Palavra ocupa toda a string")
    void testPalavraTodaString() {
        assertEquals("hello", plusOut.plusOut("hello", "hello"));
        assertEquals("abc", plusOut.plusOut("abc", "abc"));
    }

    @Test
    @DisplayName("Palavra de 1 caractere - múltiplas ocorrências")
    void testPalavraUmCaractere() {
        assertEquals("a+a+a", plusOut.plusOut("a1a2a", "a"));
        assertEquals("+++x+++x", plusOut.plusOut("123x456x", "x"));
    }

    @Test
    @DisplayName("String contém apenas a palavra repetida")
    void testApenasPalavraRepetida() {
        assertEquals("ababab", plusOut.plusOut("ababab", "ab"));
        assertEquals("xyxyxy", plusOut.plusOut("xyxyxy", "xy"));
    }

    @Test
    @DisplayName("Palavra maior que a string: tudo vira '+'")
    void testPalavraMaiorQueString() {
        assertEquals("+++", plusOut.plusOut("abc", "abcde"));
        assertEquals("++", plusOut.plusOut("xy", "xyz"));
    }

    @Test
    @DisplayName("String vazia")
    void testStringVazia() {
        assertEquals("", plusOut.plusOut("", "abc"));
    }

    @Test
    @DisplayName("Palavra aparece consecutivamente")
    void testPalavrasConsecutivas() {
        assertEquals("aaaa++++", plusOut.plusOut("aaaa1234", "aa"));
        assertEquals("xxxxxx", plusOut.plusOut("xxxxxx", "xx"));
    }

    @Test
    @DisplayName("Palavra com caracteres especiais")
    void testCaracteresEspeciais() {
        assertEquals("++--++", plusOut.plusOut("12--34", "--"));
        assertEquals("..++++", plusOut.plusOut("..1234", ".."));
    }

    @Test
    @DisplayName("Palavra entre outros caracteres")
    void testPalavraEntreCaracteres() {
        assertEquals("++++hello+++++", plusOut.plusOut("1234hello56789", "hello"));
        assertEquals("+++world+++", plusOut.plusOut("123world456", "world"));
    }

    @Test
    @DisplayName("Casos com espaços")
    void testComEspacos() {
        assertEquals("++ ++", plusOut.plusOut("12 34", " "));
        assertEquals("hi+++++", plusOut.plusOut("hi 1234", "hi"));
    }

    @Test
    @DisplayName("Palavra longa na string")
    void testPalavraLonga() {
        assertEquals("++programming++", plusOut.plusOut("12programming34", "programming"));
        assertEquals("java++++", plusOut.plusOut("java1234", "java"));
    }
}
