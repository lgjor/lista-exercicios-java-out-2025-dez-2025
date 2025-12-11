package org.desviante.exercicios.x05_answerCell;

import org.desviante.exercicios.CodeWorkout.x05_answerCell.AnswerCell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe AnswerCell
 */
public class AnswerCellTest {

    private AnswerCell answerCell;

    @BeforeEach
    void setUp() {
        answerCell = new AnswerCell();
    }

    @Test
    @DisplayName("Deve retornar false se estiver dormindo")
    void testIsAsleep() {
        assertFalse(answerCell.answerCell(false, false, true),
            "Dormindo, não atende (manhã: não, mãe: não)");
        assertFalse(answerCell.answerCell(true, false, true),
            "Dormindo, não atende (manhã: sim, mãe: não)");
        assertFalse(answerCell.answerCell(false, true, true),
            "Dormindo, não atende (manhã: não, mãe: sim)");
        assertFalse(answerCell.answerCell(true, true, true),
            "Dormindo, não atende (manhã: sim, mãe: sim)");
    }

    @Test
    @DisplayName("Deve retornar true se não estiver de manhã e não estiver dormindo")
    void testNotMorningNotAsleep() {
        assertTrue(answerCell.answerCell(false, false, false),
            "Não de manhã, não mãe, não dormindo: deve atender");
        assertTrue(answerCell.answerCell(false, true, false),
            "Não de manhã, mãe, não dormindo: deve atender");
    }

    @Test
    @DisplayName("Deve retornar true se for de manhã, for a mãe e não estiver dormindo")
    void testMorningMomNotAsleep() {
        assertTrue(answerCell.answerCell(true, true, false),
            "De manhã, mãe, não dormindo: deve atender");
    }

    @Test
    @DisplayName("Deve retornar false se for de manhã, não for a mãe e não estiver dormindo")
    void testMorningNotMomNotAsleep() {
        assertFalse(answerCell.answerCell(true, false, false),
            "De manhã, não mãe, não dormindo: não deve atender");
    }

}
