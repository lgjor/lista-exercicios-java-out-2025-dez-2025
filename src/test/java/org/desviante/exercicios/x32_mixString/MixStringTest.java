package org.desviante.exercicios.x32_mixString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para a classe MixString")
public class MixStringTest {

    private MixString mixString;

    @BeforeEach
    void setUp() {
        mixString = new MixString();
    }

    @Test
    @DisplayName("Deve misturar duas strings de mesmo tamanho")
    void testMixStringMesmoTamanho() {
        assertEquals("axbycz", mixString.mixString("abc", "xyz"));
    }

    @Test
    @DisplayName("Deve misturar strings com a primeira menor que a segunda")
    void testMixStringPrimeiraMenor() {
        assertEquals("HTihere", mixString.mixString("Hi", "There"));
    }

    @Test
    @DisplayName("Deve misturar strings com a primeira maior que a segunda")
    void testMixStringPrimeiraMaior() {
        assertEquals("xyxyxx", mixString.mixString("xxxx", "yy"));
    }

    @Test
    @DisplayName("Deve misturar strings com tamanhos muito diferentes")
    void testMixStringTamanhosDiferentes() {
        assertEquals("xTxhxexre", mixString.mixString("xxxx", "There"));
    }

    @Test
    @DisplayName("Deve retornar string vazia quando ambas são vazias")
    void testMixStringAmbosVazios() {
        assertEquals("", mixString.mixString("", ""));
    }

    @Test
    @DisplayName("Deve retornar a segunda string quando a primeira é vazia")
    void testMixStringPrimeiraVazia() {
        assertEquals("Hello", mixString.mixString("", "Hello"));
    }

    @Test
    @DisplayName("Deve retornar a primeira string quando a segunda é vazia")
    void testMixStringSegundaVazia() {
        assertEquals("World", mixString.mixString("World", ""));
    }

    @Test
    @DisplayName("Deve misturar strings com um caractere cada")
    void testMixStringUmCaractere() {
        assertEquals("ab", mixString.mixString("a", "b"));
    }

    @Test
    @DisplayName("Deve misturar strings com caracteres especiais")
    void testMixStringCaracteresEspeciais() {
        assertEquals("1a2b3c", mixString.mixString("123", "abc"));
    }

    @Test
    @DisplayName("Deve misturar strings com espaços")
    void testMixStringComEspacos() {
        assertEquals("a b c ", mixString.mixString("abc", "   "));
    }
}
