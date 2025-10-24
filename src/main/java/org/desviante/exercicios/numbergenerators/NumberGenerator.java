package org.desviante.exercicios.numbergenerators;

/**
 * Exercício: Number Generators
 * Gerador de números que estende BaseNumberGenerator
 */
public class NumberGenerator extends BaseNumberGenerator {

    public NumberGenerator(int base) {
        super(base);
    }

    @Override
    public int generate() {
        return super.generate() + getNumber();
    }

    protected int getNumber() {
        return this.base - 7;
    }
}

