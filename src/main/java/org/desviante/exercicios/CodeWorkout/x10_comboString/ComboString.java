package org.desviante.exercicios.CodeWorkout.x10_comboString;

public class ComboString {
    public String comboString(String a, String b)
    {
        if (a == null || b == null) {
            return "";
        }
        if (a.length()==b.length()){
            return a + b + a;
        }
        // Uso da expressão ternária: "condiçãoVerdadeira?RetornaIsso:SeNãoRetornaIsso"
        return (a.length() < b.length())? a + b + a:b + a + b;
    }
}
