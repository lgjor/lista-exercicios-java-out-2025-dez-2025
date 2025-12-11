package org.desviante.exercicios.CodeWorkout.x32_mixString;

public class MixString {

    public String mixString(String a, String b)
    {
        StringBuilder sb = new StringBuilder(a.length()+b.length());
        int minLength = Math.min(a.length(), b.length());

        // caracteres alternados até o tamanho da menor string
        for (int i = 0; i < minLength; i++) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }
        // Pega todos os caracteres restantes da string a partir do tamanho da menor string e adiciona
        sb.append(a.substring(minLength));
        sb.append(b.substring(minLength));

        return sb.toString();
    }

    public static void main(String[] args) {
        MixString mixString = new MixString();
        System.out.println("Case 1: "+mixString.mixString("abc", "xyz"));
        System.out.println("Case 2: "+mixString.mixString("Hi", "There"));
        System.out.println("Case 3: "+mixString.mixString("xxxx", "There"));
        System.out.println("Case 4: "+mixString.mixString("xxxx", "yy"));
    }

}
