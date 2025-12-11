package org.desviante.exercicios.x06_HelloName;

import org.desviante.exercicios.CodeWorkout.x06_HelloName.HelloName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe HelloName
 */
public class HelloNameTest {

    private HelloName helloName;

    @BeforeEach
    void setUp() {
        helloName = new HelloName();
    }

    @Test
    @DisplayName("Deve retornar 'Hello X!' para nome de um caractere")
    void testHelloNameSingleChar() {
        assertEquals("Hello X!", helloName.helloName("X"));
    }

    @Test
    @DisplayName("Deve retornar 'Hello Bob!' para o nome 'Bob'")
    void testHelloNameBob() {
        assertEquals("Hello Bob!", helloName.helloName("Bob"));
    }

    @Test
    @DisplayName("Deve retornar 'Hello !' para o nome ''")
    void testHelloNameEmpty() {
        assertEquals("Hello !", helloName.helloName(""));       
    }

    @Test
    @DisplayName("Deve retornar 'Hello Null!' para nome null")
    void testHelloNameNull() {
        assertEquals("Hello null!", helloName.helloName(null));
    }
}
