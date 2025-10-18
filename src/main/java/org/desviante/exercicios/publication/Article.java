package org.desviante.exercicios.publication;

/**
 * Exercício: Publication
 * Artigo - tipo de publicação com autor
 */
public class Article extends Publication {

    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String getType() {
        return "Article";
    }

    @Override
    public String getDetails() {
        return " (author - " + author + "): " + super.getDetails();
    }
}

