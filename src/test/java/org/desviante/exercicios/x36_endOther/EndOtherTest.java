package org.desviante.exercicios.x36_endOther;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para EndOther")
public class EndOtherTest {

    private EndOther endOther;

    @BeforeEach
    void setUp() {
        endOther = new EndOther();
    }

    @Test
    @DisplayName("Deve retornar true caso a segunda palavra esteja ao final da primeira")
    void testEndOtherTrue() {
        assertTrue(endOther.endOther("Hiabc", "abc"));
    }

    @Test
    @DisplayName("Deve retornar true caso a primeira palavra esteja ao final da segunda")
    void testEndOtherTrue2() {
        assertTrue(endOther.endOther("AbC", "HiaBc"));
    }

    @Test
    @DisplayName("Deve retornar false caso nenhuma das palavras esteja ao final da outra")
    void testEndOtherFalse() {
        assertFalse(endOther.endOther("abc", "abXabcf"));
        assertFalse(endOther.endOther("abc", "ab"));
    }

    @Test
    @DisplayName("Deve ignorar uppercase e lowercase")
    void testLowerCaseUpperCase(){
        assertTrue(endOther.endOther("AbCDi", "cdI"));
        assertTrue(endOther.endOther("aCxFIO", "io"));
        assertTrue(endOther.endOther("aC", "xFIOAc"));
    }

    @Test
    @DisplayName("Deve retornar true quando as strings são iguais")
    void testEndOtherStringsIguais() {
        assertTrue(endOther.endOther("abc", "abc"));
        assertTrue(endOther.endOther("ABC", "abc"));
    }

    @Test
    @DisplayName("Deve retornar true quando uma string é vazia")
    void testEndOtherStringVazia() {
        assertTrue(endOther.endOther("", ""));
        assertTrue(endOther.endOther("abc", ""));
        assertTrue(endOther.endOther("", "xyz"));
    }

    @Test
    @DisplayName("Deve funcionar com strings de um caractere")
    void testEndOtherUmCaractere() {
        assertTrue(endOther.endOther("a", "a"));
        assertTrue(endOther.endOther("xa", "a"));
        assertFalse(endOther.endOther("a", "b"));
    }

    @Test
    @DisplayName("Deve retornar false quando não há correspondência")
    void testEndOtherSemCorrespondencia() {
        assertFalse(endOther.endOther("xyz", "abc"));
        assertFalse(endOther.endOther("hello", "world"));
    }

    @Test
    @DisplayName("Deve funcionar quando uma string é maior")
    void testEndOtherTamanhosDiferentes() {
        assertTrue(endOther.endOther("z", "xyz"));
        assertTrue(endOther.endOther("HelloWorld", "world"));
        assertFalse(endOther.endOther("HelloWorld", "worlds"));
    }
}
