package org.desviante.exercicios.x26_atFirst;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes para AtFirst")
public class AtFirstTest {

    private final AtFirst atFirst = new AtFirst();

    @Test
    @DisplayName("Deve retornar os dois primeiros caracteres para string com 2 ou mais caracteres")
    void deveRetornarDoisPrimeirosCaracteres() {
        assertEquals("he", atFirst.atFirst("hello"));
        assertEquals("hi", atFirst.atFirst("hi"));
        assertEquals("ab", atFirst.atFirst("abcdef"));
        assertEquals("co", atFirst.atFirst("coding"));
    }

    @Test
    @DisplayName("Deve retornar o primeiro caractere seguido de @ para string com 1 caractere")
    void deveRetornarPrimeiroCaractereComArroba() {
        assertEquals("h@", atFirst.atFirst("h"));
        assertEquals("a@", atFirst.atFirst("a"));
        assertEquals("x@", atFirst.atFirst("x"));
    }


    @Test
    @DisplayName("Deve retonrar @@ para string vazia")
    void deveRetornarDoisArroba() {
        assertEquals("@@", atFirst.atFirst(""));
    }

}
