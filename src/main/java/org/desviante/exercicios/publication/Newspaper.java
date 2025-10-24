package org.desviante.exercicios.publication;

/**
 * Exercício: Publication
 * Jornal - tipo de publicação com fonte
 */
public class Newspaper extends Publication {

    private String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    @Override
    public String getType() {
        return "Newspaper ";
    }

    @Override
    public String getDetails() {
        return "(source - " + source + "): " + super.getDetails();
    }
}

