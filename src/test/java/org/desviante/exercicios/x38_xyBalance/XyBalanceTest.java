package org.desviante.exercicios.x38_xyBalance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for XyBalance")
public class XyBalanceTest {
    private XyBalance xyBalance;

    @BeforeEach
    void setUp() {
        xyBalance = new XyBalance();
    }

    @Test
    @DisplayName("Deve retornar true quando string não contém x")
    void testNoXInString() {
        assertTrue(xyBalance.xyBalance(""));
        assertTrue(xyBalance.xyBalance("a"));
        assertTrue(xyBalance.xyBalance("abc"));
        assertTrue(xyBalance.xyBalance("y"));
        assertTrue(xyBalance.xyBalance("yyy"));
        assertTrue(xyBalance.xyBalance("abcde"));
    }

    @Test
    @DisplayName("Deve retornar false quando string termina com x")
    void testStringEndsWithX() {
        assertFalse(xyBalance.xyBalance("x"));
        assertFalse(xyBalance.xyBalance("ax"));
        assertFalse(xyBalance.xyBalance("abcx"));
        assertFalse(xyBalance.xyBalance("xyx"));
        assertFalse(xyBalance.xyBalance("xx"));
    }

    @Test
    @DisplayName("Deve retornar false quando string contém x mas não contém y")
    void testHasXButNoY() {
        assertFalse(xyBalance.xyBalance("x"));
        assertFalse(xyBalance.xyBalance("axb"));
        assertFalse(xyBalance.xyBalance("abcxdef"));
        assertFalse(xyBalance.xyBalance("xx"));
        assertFalse(xyBalance.xyBalance("axbx"));
    }

    @Test
    @DisplayName("Deve retornar true para casos balanceados (x seguido de y)")
    void testBalancedCases() {
        assertTrue(xyBalance.xyBalance("xy"));
        assertTrue(xyBalance.xyBalance("axy"));
        assertTrue(xyBalance.xyBalance("xyb"));
        assertTrue(xyBalance.xyBalance("axyb"));
        assertTrue(xyBalance.xyBalance("xxy"));
        assertTrue(xyBalance.xyBalance("xyy")); // x no final
        assertTrue(xyBalance.xyBalance("xxyy"));
        assertFalse(xyBalance.xyBalance("yaxb")); // x no final
    }

    @Test
    @DisplayName("Deve retornar false para casos não balanceados")
    void testUnbalancedCases() {
        assertFalse(xyBalance.xyBalance("yx")); // x no final
        assertFalse(xyBalance.xyBalance("yax")); // x no final
        assertFalse(xyBalance.xyBalance("xyx")); // x no final
        assertTrue(xyBalance.xyBalance("yxy")); // x seguido de y
        assertFalse(xyBalance.xyBalance("yxx")); // x no final
    }

    @Test
    @DisplayName("Deve retornar true para casos com múltiplos x e y balanceados")
    void testMultipleXAndYBalanced() {
        assertTrue(xyBalance.xyBalance("xxyy"));
        assertTrue(xyBalance.xyBalance("xyxy"));
        assertTrue(xyBalance.xyBalance("xxxyyy"));
        assertTrue(xyBalance.xyBalance("yxxy"));
        assertTrue(xyBalance.xyBalance("yaxxy"));
    }

    @Test
    @DisplayName("Deve retornar false para casos com múltiplos x e y não balanceados")
    void testMultipleXAndYUnbalanced() {
        assertFalse(xyBalance.xyBalance("yxx")); // x no final
        assertFalse(xyBalance.xyBalance("xyyx")); // x no final
        assertFalse(xyBalance.xyBalance("yxyx")); // x no final
        assertTrue(xyBalance.xyBalance("xxyxy")); // x seguido de y, depois outro x seguido de y
    }

    @Test
    @DisplayName("Deve retornar true para string vazia")
    void testEmptyString() {
        assertTrue(xyBalance.xyBalance(""));
    }

    @Test
    @DisplayName("Deve retornar true para string com apenas y")
    void testStringWithOnlyY() {
        assertTrue(xyBalance.xyBalance("y"));
        assertTrue(xyBalance.xyBalance("yy"));
        assertTrue(xyBalance.xyBalance("yyy"));
    }

    @Test
    @DisplayName("Deve retornar false para string com apenas x")
    void testStringWithOnlyX() {
        assertFalse(xyBalance.xyBalance("x"));
        assertFalse(xyBalance.xyBalance("xx"));
        assertFalse(xyBalance.xyBalance("xxx"));
    }

    @Test
    @DisplayName("Deve retornar true para casos complexos balanceados")
    void testComplexBalancedCases() {
        assertFalse(xyBalance.xyBalance("yaaxbb")); // x no final
        assertTrue(xyBalance.xyBalance("aaxyaa")); // x seguido de y
        assertTrue(xyBalance.xyBalance("aaxaay")); // x seguido de y
        assertTrue(xyBalance.xyBalance("aaxyaay")); // x no final
    }

    @Test
    @DisplayName("Deve retornar false para casos complexos não balanceados")
    void testComplexUnbalancedCases() {
        assertTrue(xyBalance.xyBalance("aaxya")); // x seguido de y
        assertFalse(xyBalance.xyBalance("aaxa")); // x sem y
        assertFalse(xyBalance.xyBalance("yaax")); // x no final
        assertFalse(xyBalance.xyBalance("aaxyaax")); // x no final
    }

    @Test
    @DisplayName("Deve retornar true para casos com caracteres especiais")
    void testWithSpecialCharacters() {
        assertTrue(xyBalance.xyBalance("x1y"));
        assertTrue(xyBalance.xyBalance("x@y"));
        assertTrue(xyBalance.xyBalance("x y"));
        assertTrue(xyBalance.xyBalance("x!y"));
    }

    @Test
    @DisplayName("Deve retornar false para casos com caracteres especiais não balanceados")
    void testWithSpecialCharactersUnbalanced() {
        assertFalse(xyBalance.xyBalance("y1x"));
        assertFalse(xyBalance.xyBalance("y@x"));
        assertFalse(xyBalance.xyBalance("y x"));
        assertFalse(xyBalance.xyBalance("y!x"));
    }

}
