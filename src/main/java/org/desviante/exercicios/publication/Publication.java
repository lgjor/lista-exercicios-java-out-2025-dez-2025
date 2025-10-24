package org.desviante.exercicios.publication;

/**
 * Exercício: Publication
 * Classe base para publicações
 */
public class Publication {

    private String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        return getType() + getDetails();
    }

    public String getType() {
        return "Publication: ";
    }

    public String getDetails() {
        return title;
    }
}

