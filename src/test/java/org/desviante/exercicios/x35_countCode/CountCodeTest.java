package org.desviante.exercicios.x35_countCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes para a classe CountCode")
public class CountCodeTest {

    private CountCode countCode;

    @BeforeEach
    void setUp() {
        countCode = new CountCode();
    }

    @Test
    @DisplayName("Deve contar 'code' no meio da string")
    void testCountCodeNoMeio() {
        assertEquals(1, countCode.countCode("aaacodebbb"));
    }

    @Test
    @DisplayName("Deve contar múltiplas ocorrências de 'code'")
    void testCountCodeMultiplo() {
        assertEquals(2, countCode.countCode("codexxcode"));
    }

    @Test
    @DisplayName("Deve contar padrão co?e com diferentes caracteres")
    void testCountCodePadrao() {
        assertEquals(2, countCode.countCode("cozexxcope"));
    }

    @Test
    @DisplayName("Deve contar apenas padrões válidos co?e")
    void testCountCodePadraoMisto() {
        assertEquals(1, countCode.countCode("cozfxxcope"));
    }

    @Test
    @DisplayName("Deve contar padrão no meio de caracteres aleatórios")
    void testCountCodePadraoMeioAleatorio() {
        assertEquals(1, countCode.countCode("xxcozeyycop"));
    }

    @Test
    @DisplayName("Deve retornar 0 quando não há padrão completo")
    void testCountCodeSemPadraoCompleto() {
        assertEquals(0, countCode.countCode("cozcop"));
    }

    @Test
    @DisplayName("Deve retornar 0 quando não há padrão")
    void testCountCodeSemPadrao() {
        assertEquals(0, countCode.countCode("abcxyz"));
    }

    @Test
    @DisplayName("Deve contar quando a string é exatamente 'code'")
    void testCountCodeExato() {
        assertEquals(1, countCode.countCode("code"));
    }

    @Test
    @DisplayName("Deve retornar 0 para string muito curta")
    void testCountCodeStringCurta() {
        assertEquals(0, countCode.countCode("ode"));
    }

    @Test
    @DisplayName("Deve retornar 0 para string com um caractere")
    void testCountCodeUmCaractere() {
        assertEquals(0, countCode.countCode("c"));
    }

    @Test
    @DisplayName("Deve retornar 0 para string vazia")
    void testCountCodeStringVazia() {
        assertEquals(0, countCode.countCode(""));
    }

    @Test
    @DisplayName("Deve contar múltiplos padrões em string longa")
    void testCountCodeStringLonga() {
        assertEquals(3, countCode.countCode("AAcodeBBcoleCCccoreDD"));
    }

    @Test
    @DisplayName("Deve contar apenas padrões válidos em string longa")
    void testCountCodeStringLongaMisto() {
        assertEquals(2, countCode.countCode("AAcodeBBcoleCCccorfDD"));
    }

    @Test
    @DisplayName("Deve contar padrões com maiúsculas no meio")
    void testCountCodeComMaiusculas() {
        assertEquals(3, countCode.countCode("coAcodeBcoleccoreDD"));
    }
}
