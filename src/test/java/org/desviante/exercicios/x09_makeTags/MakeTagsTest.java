package org.desviante.exercicios.x09_makeTags;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe MakeTags
 */ 
public class MakeTagsTest {

    private MakeTags makeTags;

    @BeforeEach
    void setUp() {
        makeTags = new MakeTags();
    }

    @Test
    @DisplayName("Deve retornar a string HTML com as tags ao redor da palavra")
    void testMakeTags() {
        assertEquals("<i>Yay</i>", makeTags.makeTags("i", "Yay"));
    }

    @Test
    @DisplayName("Se a tag for Null, deve retornar a string HTML com as tag null concatenada")
    void testMakeTagsNull() {
        assertEquals("<null>Yay</null>", makeTags.makeTags(null, "Yay"));
    }

    @Test
    @DisplayName("Se a palavra for Null, deve retornar a string HTML com a palavra null concatenada")
    void testMakeTagsWordNull() {
        assertEquals("<i>null</i>", makeTags.makeTags("i", null));
    }

}
