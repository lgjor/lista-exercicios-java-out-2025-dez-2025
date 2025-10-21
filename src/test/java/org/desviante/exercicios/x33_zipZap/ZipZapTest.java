package org.desviante.exercicios.x33_zipZap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes para a classe ZipZap")
public class ZipZapTest {

    private ZipZap zipZap;

    @BeforeEach
    void setUp() {
        zipZap = new ZipZap();
    }

    @Test
    @DisplayName("Deve remover o caractere do meio de 'zip' e de zap em 'zipXzap'")
    void testZipXzap() {
        assertEquals("zpXzp", zipZap.zipZap("zipXzap"));
    }

    @Test
    @DisplayName("Deve remover o caractere do meio de 'zip' em 'zopzop'")
    void testZopzop() {
        assertEquals("zpzp", zipZap.zipZap("zopzop"));
    }

    @Test
    @DisplayName("Deve remover o caractere do meio de 'zip' em 'zzzopzop'")
    void testZzzopzop() {
        assertEquals("zzzpzp", zipZap.zipZap("zzzopzop"));
    }

    @Test
    @DisplayName("Deve lidar com string vazia")
    void testStringVazia() {
        assertEquals("", zipZap.zipZap(""));
    }

    @Test
    @DisplayName("Deve lidar com string sem 'zip'")
    void testSemZip() {
        assertEquals("abc", zipZap.zipZap("abc"));
    }

    @Test
    @DisplayName("Deve lidar com 'zip' no início da string")
    void testZipNoInicio() {
        assertEquals("zpabc", zipZap.zipZap("zipabc"));
    }

    @Test
    @DisplayName("Deve lidar com 'zip' no final da string")
    void testZipNoFinal() {
        assertEquals("abczp", zipZap.zipZap("abczip"));
    }

    @Test
    @DisplayName("Deve lidar com 'zip' repetido")
    void testZipRepetido() {
        assertEquals("zpzpzp", zipZap.zipZap("zipzipzip"));
    }

    @Test
    @DisplayName("Deve lidar com 'zip' sobreposto (não deve remover o 'i' do segundo 'zip')")
    void testZipSobreposto() {
        assertEquals("ziip", zipZap.zipZap("ziip"));
    }

}
