package org.desviante.exercicios.x39_getSandwich;

import org.desviante.exercicios.CodeWorkout.x39_getSandwich.GetSandwich;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for GetSandwich")
public class GetSandwichTest {
    private GetSandwich getSandwich;

    @BeforeEach
    void setUp() {
        getSandwich = new GetSandwich();
    }

    @Test
    @DisplayName("Deve retornar a palavra que está entre duas ocorrências de pão")
    void testTwoBreadsSandwich(){
        assertEquals("sandwich", getSandwich.getSandwich("breadsandwichbread"));
        assertEquals("sandwich", getSandwich.getSandwich("breadsandwichbreadsandwich"));
        assertEquals("sandwich", getSandwich.getSandwich("sandwichbreadsandwichbreadsandwich"));
        assertEquals("sandwich", getSandwich.getSandwich("breadsandwichbread "));
        assertEquals("sandwich", getSandwich.getSandwich(" breadsandwichbread"));
    }

    @Test
    @DisplayName("Caso não haja duas ocorrências de pão deve retornar string vazia")
    void testNoBreadSandwich() {
        assertEquals("", getSandwich.getSandwich("onlyonebread"));
        assertEquals("", getSandwich.getSandwich("breadonlyone"));
        assertEquals("", getSandwich.getSandwich("noonenosandwich"));
    }

    @Test
    @DisplayName("Deve retornar string vazia para entrada nula ou vazia")
    void testNullAndEmptyInput() {
        assertEquals("", getSandwich.getSandwich(null));
        assertEquals("", getSandwich.getSandwich(""));
    }

    @Test
    @DisplayName("Deve retornar string vazia quando há apenas uma ocorrência de bread")
    void testSingleBread() {
        assertEquals("", getSandwich.getSandwich("bread"));
        assertEquals("", getSandwich.getSandwich("breadonly"));
        assertEquals("", getSandwich.getSandwich("onlybread"));
    }

    @Test
    @DisplayName("Deve retornar string vazia quando há duas breads consecutivas")
    void testConsecutiveBreads() {
        assertEquals("", getSandwich.getSandwich("breadbread"));
        assertEquals("", getSandwich.getSandwich("breadbreadmore"));
        assertEquals("", getSandwich.getSandwich("morebreadbread"));
    }

    @Test
    @DisplayName("Deve retornar conteúdo correto entre primeira e última bread")
    void testFirstAndLastBread() {
        assertEquals("jota", getSandwich.getSandwich("breadjotabread"));
        assertEquals("jotabreadoutra", getSandwich.getSandwich("breadjotabreadoutrabread"));
        assertEquals("contentbreadmore", getSandwich.getSandwich("breadcontentbreadmorebread"));
    }

    @Test
    @DisplayName("Deve funcionar com múltiplas breads no meio")
    void testMultipleBreadsInMiddle() {
        assertEquals("jotabreadoutra", getSandwich.getSandwich("breadjotabreadoutrabread"));
        assertEquals("abreadb", getSandwich.getSandwich("breadabreadbbread"));
    }

    @Test
    @DisplayName("Deve funcionar com breads no início e fim")
    void testBreadsAtStartAndEnd() {
        assertEquals("middle", getSandwich.getSandwich("breadmiddlebread"));
        assertEquals("content", getSandwich.getSandwich("breadcontentbread"));
    }

    @Test
    @DisplayName("Deve funcionar com espaços e caracteres especiais")
    void testWithSpacesAndSpecialChars() {
        assertEquals("a b c", getSandwich.getSandwich("breada b cbread"));
        assertEquals("test@123", getSandwich.getSandwich("breadtest@123bread"));
        assertEquals("hello world", getSandwich.getSandwich("breadhello worldbread"));
    }
}
