package org.desviante.exercicios.CodeWorkout.x34_wordEnds;

public class WordEnds {

    public String wordEnds(String str, String word)
    {
        StringBuilder sb = new StringBuilder();
        int strLength = str.length();
        int wordLength = word.length();

        for ( int i = 0; i<strLength; ){
            if ( i + wordLength <= strLength && str.substring(i, i+wordLength).equals(word) ) {
                // Encontrou a palavra, adiciona a letra antes dela e a letra depois
                if ((i-1)>=0){
                    sb.append(str.charAt(i-1));
                }
                if ((i+wordLength)<strLength){
                    sb.append(str.charAt(i+wordLength));
                }
                i=i+wordLength; // Pula todos os caracteres da palavra
            }
            // Caso não encontre a palavra
            else {
                i++; // Avança apenas 1 caractere
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        WordEnds wordEnds = new WordEnds();
        System.out.println("Case 1: "+wordEnds.wordEnds("The", "e"));
        System.out.println("Case 2: "+wordEnds.wordEnds("abcXY123XYijk", "XY")); // -> "c13i"
        System.out.println("Case 2: "+wordEnds.wordEnds("XY123XY", "XY")); // -> "13"
        System.out.println("Case 2: "+wordEnds.wordEnds("XY1XY", "XY")); // -> "11"
    }
}
