package org.desviante.exercicios.numbergenerators;

/**
 * Exercício: Number Generators
 * Gerador de números mágicos
 */
public class MagicNumberGenerator extends NumberGenerator {

    public MagicNumberGenerator(int base) {
        super(base);
    }

    @Override
    protected int getNumber() {
        return this.base + 7;
    }
}

