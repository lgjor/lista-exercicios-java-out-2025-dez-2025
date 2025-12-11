package org.desviante.exercicios.x37_xyzThere;

import org.desviante.exercicios.CodeWorkout.x37_xyzThere.XyzThere;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for XyzThere")
public class XyzThereTest {

    private XyzThere xyzThere;

    @BeforeEach
    void setUp() {
        xyzThere = new XyzThere();
    }

    @Test
    @DisplayName("Deve retornar true quando xyz aparece no início da string")
    void testXyzAtBeginning() {
        assertTrue(xyzThere.xyzThere("xyzabc"));
        assertTrue(xyzThere.xyzThere("xyz"));
    }

    @Test
    @DisplayName("Deve retornar true quando xyz aparece no meio da string sem ponto antes")
    void testXyzInMiddleWithoutDot() {
        assertTrue(xyzThere.xyzThere("abcxyzdef"));
        assertTrue(xyzThere.xyzThere("abcxyz"));
        assertTrue(xyzThere.xyzThere("xyzabc"));
    }

    @Test
    @DisplayName("Deve retornar false quando xyz aparece precedido por ponto")
    void testXyzWithDotBefore() {
        assertFalse(xyzThere.xyzThere("abc.xyz"));
        assertFalse(xyzThere.xyzThere(".xyz"));
        assertFalse(xyzThere.xyzThere("abc.xyzdef"));
    }

    @Test
    @DisplayName("Deve retornar true quando xyz aparece após ponto mas não imediatamente")
    void testXyzAfterDotButNotImmediately() {
        assertTrue(xyzThere.xyzThere("abc.xyzxyz"));
        assertTrue(xyzThere.xyzThere("abc.xyxyz"));
    }

    @Test
    @DisplayName("Deve retornar false quando não há xyz na string")
    void testNoXyzInString() {
        assertFalse(xyzThere.xyzThere("abc"));
        assertFalse(xyzThere.xyzThere("ab"));
        assertFalse(xyzThere.xyzThere("a"));
        assertFalse(xyzThere.xyzThere(""));
    }

    @Test
    @DisplayName("Deve retornar false quando string é vazia")
    void testEmptyString() {
        assertFalse(xyzThere.xyzThere(""));
    }

    @Test
    @DisplayName("Deve retornar true quando xyz aparece no final da string")
    void testXyzAtEnd() {
        assertTrue(xyzThere.xyzThere("abcxyz"));
        assertTrue(xyzThere.xyzThere("abxyz"));
    }

    @Test
    @DisplayName("Deve retornar true quando há múltiplas ocorrências de xyz, pelo menos uma sem ponto antes")
    void testMultipleXyzOccurrences() {
        assertTrue(xyzThere.xyzThere("xyz.xyz"));
        assertTrue(xyzThere.xyzThere("abc.xyzxyz"));
        assertTrue(xyzThere.xyzThere("xyzxyz"));
    }

    @Test
    @DisplayName("Deve retornar false quando todas as ocorrências de xyz têm ponto antes")
    void testAllXyzWithDotBefore() {
        assertFalse(xyzThere.xyzThere(".xyz.xyz"));
        assertFalse(xyzThere.xyzThere("abc.xyz.xyz"));
    }

    @Test
    @DisplayName("Deve retornar true para casos com caracteres especiais")
    void testXyzWithSpecialCharacters() {
        assertTrue(xyzThere.xyzThere("xyz123"));
        assertTrue(xyzThere.xyzThere("123xyz"));
        assertTrue(xyzThere.xyzThere("xyz!@#"));
    }

    @Test
    @DisplayName("Deve retornar false para casos com xyz precedido por ponto e caracteres especiais")
    void testXyzWithDotAndSpecialCharacters() {
        assertFalse(xyzThere.xyzThere(".xyz123"));
        assertFalse(xyzThere.xyzThere("123.xyz"));
        assertFalse(xyzThere.xyzThere(".xyz!@#"));
    }

    @Test
    @DisplayName("Deve retornar true para string com apenas xyz")
    void testStringWithOnlyXyz() {
        assertTrue(xyzThere.xyzThere("xyz"));
    }

    @Test
    @DisplayName("Deve retornar false para string com apenas .xyz")
    void testStringWithOnlyDotXyz() {
        assertFalse(xyzThere.xyzThere(".xyz"));
    }

    @Test
    @DisplayName("Deve retornar true para casos com espaços")
    void testXyzWithSpaces() {
        assertTrue(xyzThere.xyzThere("xyz abc"));
        assertTrue(xyzThere.xyzThere("abc xyz"));
        assertTrue(xyzThere.xyzThere("abc xyz def"));
    }

    @Test
    @DisplayName("Deve retornar true para casos com ponto e espaços (ponto não imediatamente antes)")
    void testXyzWithDotAndSpaces() {
        assertTrue(xyzThere.xyzThere(". xyz"));
        assertFalse(xyzThere.xyzThere("abc .xyz")); // ponto imediatamente antes do xyz
    }

}
