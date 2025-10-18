package org.desviante.exercicios.numbergenerators;

/**
 * Exercício: Number Generators
 * Classe base para geradores de números
 */
public class BaseNumberGenerator {

    protected int base;

    public BaseNumberGenerator(int base) {
        this.base = base;
    }

    public int generate() {
        return base + 11;
    }
}

