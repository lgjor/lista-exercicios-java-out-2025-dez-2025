package org.desviante.exercicios.x42_frontPiece;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Testes para FrontPiece")
public class FrontPieceTest {

    private FrontPiece frontPiece;

    @BeforeEach
    void setUp() {
        frontPiece = new FrontPiece();
    }

    @DisplayName("Deve retornar null caso o array seja nulo")
    @Test
    void testNullArray(){
        assertNull(frontPiece.frontPiece(null));
    };

    @DisplayName("Deve retornar array com um elemento caso o array de entrada tenha tamanho 1")
    @Test
    void testOneArray(){
        Assertions.assertArrayEquals(new int[]{1}, frontPiece.frontPiece(new int[]{1}));
    };

    @DisplayName("Deve retornar array com 2 elementos caso o array de entrada tenha tamanho 2")
    @Test
    void testTwoArray(){
        Assertions.assertArrayEquals(new int[]{1,2}, frontPiece.frontPiece(new int[]{1,2}));
        Assertions.assertArrayEquals(new int[]{3,99}, frontPiece.frontPiece(new int[]{3,99}));
    };

    @DisplayName("Deve retornar array com 2 elementos caso o array de entrada tenha tamanho maior que 2")
    @Test
    void testMoreThanTwoArray(){
        Assertions.assertArrayEquals(new int[]{1, 2}, frontPiece.frontPiece(new int[]{1, 2, 3, 4, 5}));
        Assertions.assertArrayEquals(new int[]{9, 8}, frontPiece.frontPiece(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    };

}
