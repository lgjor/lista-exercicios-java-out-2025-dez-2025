package org.desviante.exercicios.numbergenerators;

/**
 * Exercício: Number Generators
 * Classe principal para testar os geradores de números
 */
public class Main {
    public static void main(String[] args) {
        BaseNumberGenerator generator = new MagicNumberGenerator(10);
        System.out.println(generator.generate());
    }
}

