package org.desviante.exercicios.x28_theEnd;

import org.desviante.exercicios.CodeWorkout.x28_theEnd.TheEnd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes para TheEnd")
public class TheEndTest {

    private final TheEnd theEnd = new TheEnd();

    @Test
    @DisplayName("Deve retornar o primeiro caractere quando front é verdadeiro")
    void deveRetornarPrimeiroCaractereQuandoFrontVerdadeiro() {
        assertEquals("H", theEnd.theEnd("Hello", true));
        assertEquals("O", theEnd.theEnd("Oh", true));
        assertEquals("X", theEnd.theEnd("X", true));
        assertEquals("A", theEnd.theEnd("Apple", true));
    }

    @Test
    @DisplayName("Deve retornar o último caractere quando front é falso")
    void deveRetornarUltimoCaractereQuandoFrontFalso() {
        assertEquals("o", theEnd.theEnd("Hello", false));
        assertEquals("h", theEnd.theEnd("Oh", false));
        assertEquals("X", theEnd.theEnd("X", false));
        assertEquals("e", theEnd.theEnd("Apple", false));
    }

    @Test
    @DisplayName("Deve lidar com strings de um único caractere")
    void deveLidarComStringsDeUmUnicoCaractere() {
        assertEquals("A", theEnd.theEnd("A", true));
        assertEquals("A", theEnd.theEnd("A", false));
        assertEquals("Z", theEnd.theEnd("Z", true));
        assertEquals("Z", theEnd.theEnd("Z", false));
    }

    @Test
    @DisplayName("Deve lidar com strings mais longas")
    void deveLidarComStringsMaisLongas() {
        assertEquals("C", theEnd.theEnd("Coding", true));
        assertEquals("g", theEnd.theEnd("Coding", false));
        assertEquals("S", theEnd.theEnd("Spring", true));
        assertEquals("g", theEnd.theEnd("Spring", false));
    }


}
