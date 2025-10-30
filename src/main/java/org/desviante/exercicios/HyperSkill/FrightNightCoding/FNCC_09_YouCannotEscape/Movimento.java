package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_09_YouCannotEscape;

public enum Movimento {
    UP(-1, 0, 'U'),
    DOWN(1, 0, 'D'),
    LEFT(0, -1, 'L'),
    RIGHT(0, 1, 'R');

    private final int deltaRow;
    private final int deltaCol;
    private final char simbolo;

    Movimento(int deltaRow, int deltaCol, char simbolo) {
        this.deltaRow = deltaRow;
        this.deltaCol = deltaCol;
        this.simbolo = simbolo;
    }

    public int getDeltaRow() {
        return deltaRow;
    }

    public int getDeltaCol() {
        return deltaCol;
    }

    public char getSimbolo() {
        return simbolo;
    }

    // Obter o movimento reverso, útil para reconstrução reversa do caminho
    public Movimento getInverso() {
        switch (this) {
            case UP: return DOWN;
            case DOWN: return UP;
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            default: throw new IllegalStateException("Movimento desconhecido: " + this);
        }
    }

    public static Movimento fromChar(char c) {
        for (Movimento mov : values()) {
            if (mov.simbolo == c) return mov;
        }
        throw new IllegalArgumentException("Direção inválida: " + c);
    }
}
