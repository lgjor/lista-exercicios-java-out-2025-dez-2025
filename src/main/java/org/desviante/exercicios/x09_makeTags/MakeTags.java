package org.desviante.exercicios.x09_makeTags;

public class MakeTags {
    public String makeTags(String tag, String word){
        return "<" + tag + ">" + word + "</" + tag + ">";
    }
}
