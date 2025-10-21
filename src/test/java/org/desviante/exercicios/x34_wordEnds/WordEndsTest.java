package org.desviante.exercicios.x34_wordEnds;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes para a classe WordEnds")
public class WordEndsTest {

    private WordEnds wordEnds;

    @BeforeEach
    void setUp() {
        wordEnds = new WordEnds();
    }

    @Test
    @DisplayName("Deve funcionar quando a palavra estiver no meio da string, retorna uma letra antes e outra depois")
    void testWordEnds() {
        assertEquals("c13i", wordEnds.wordEnds("abcXY123XYijk", "XY"));
    }

    @Test
    @DisplayName("Quando a palavra estiver no começo da string deve retornar a última letra")
    void testWordEndsNoInicio() {
        assertEquals("1", wordEnds.wordEnds("abc1xyz", "abc"));
    }

    @Test
    @DisplayName("Quando a palavra estiver no final da string deve retornar a primeira letra")
    void testWordEndsNoFinal() {
        assertEquals("z", wordEnds.wordEnds("xyz1", "1"));
    }

    @Test
    @DisplayName("Deve funcionar quando a palavra for repetida")
    void testWordEndsRepetida() {
        assertEquals("1111", wordEnds.wordEnds("abc1abc1abc", "abc"));
    }

    @Test
    @DisplayName("Deve retornar string vazia quando a palavra não for encontrada")
    void testWordEndsNaoEncontrada() {
        assertEquals("", wordEnds.wordEnds("abcdef", "xyz"));
    }

    @Test
    @DisplayName("Deve retornar string vazia quando a palavra for igual à string inteira")
    void testWordEndsIgualString() {
        assertEquals("", wordEnds.wordEnds("abc", "abc"));
    }

    @Test
    @DisplayName("Deve funcionar com palavra no início e fim da string")
    void testWordEndsInicioEFim() {
        assertEquals("13", wordEnds.wordEnds("XY123XY", "XY"));
    }

    @Test
    @DisplayName("Deve incluir caractere duas vezes quando estiver entre duas palavras")
    void testWordEndsCaractereDuplicado() {
        assertEquals("11", wordEnds.wordEnds("XY1XY", "XY"));
    }

    @Test
    @DisplayName("Deve retornar string vazia quando a string estiver vazia")
    void testWordEndsStringVazia() {
        assertEquals("", wordEnds.wordEnds("", "abc"));
    }

    @Test
    @DisplayName("Deve funcionar com palavra de um caractere")
    void testWordEndsPalavraUmCaractere() {
        assertEquals("h", wordEnds.wordEnds("The", "e"));
    }

    @Test
    @DisplayName("Deve funcionar com múltiplas ocorrências distantes")
    void testWordEndsMultiplasOcorrencias() {
        assertEquals("azzb", wordEnds.wordEnds("aXYXYzXYXYb", "XYXY"));
    }

    @Test
    @DisplayName("Deve funcionar quando há apenas letra antes")
    void testWordEndsApenasAntes() {
        assertEquals("a", wordEnds.wordEnds("abcd", "bcd"));
    }

    @Test
    @DisplayName("Deve funcionar quando há apenas letra depois")
    void testWordEndsApenasDepois() {
        assertEquals("d", wordEnds.wordEnds("abcd", "abc"));
    }
}
