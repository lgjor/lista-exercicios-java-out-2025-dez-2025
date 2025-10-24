package org.desviante.exercicios.x31_plusOut;

public class PlusOut {

    public String plusOut(String str, String word)
    {
        int wordLength = word.length();
        int strLength = str.length();
        StringBuilder builder = new StringBuilder();

        // Percorre todos os caracteres da str
        for ( int i = 0 ; i < strLength ; ) {
            // Verifica se há espaço suficiente para a palavra E se a palavra está nesta posição
            if ( i + wordLength <= strLength && str.substring(i, i+wordLength).equals(word) ){
                // Encontrou a palavra, adiciona ela inteira
                builder.append( word );
                i += wordLength; // Pula todos os caracteres da palavra
            } else {
                // Não é a palavra ou não há espaço para ser a palavra, substitui por '+'
                builder.append("+");
                i++; // Avança apenas 1 caractere
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        PlusOut plusOut = new PlusOut();
        System.out.println("Case 1: "+plusOut.plusOut("12xy34", "1"));
        System.out.println("Case 2: "+plusOut.plusOut("12xy34xy3435", "xy"));
    }
}