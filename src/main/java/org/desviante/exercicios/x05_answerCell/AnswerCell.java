package org.desviante.exercicios.x05_answerCell;

public class AnswerCell {
    public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep)
    {
        // Se estiver dormindo, nunca atenderei o telefone
        if (isAsleep) {
            return false;
        // Se não estiver dormindo e estiver de manhã só atenderei o chamado da mãe
        } else if (isMorning){
            return isMom;
        // Se não estiver dormindo e não for de manhã, atenderei
        } else {
            return true;
        }
    }
}
