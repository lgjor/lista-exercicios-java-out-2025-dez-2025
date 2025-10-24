package org.desviante.exercicios.x30_repeatEnd;

public class RepeatEnd {

    public String repeatEnd(String str, int n)
    {
        // Desnecessário, pelo enunciado deve considerar que a n é de 0 ao tamanho da string,
        // mesmo assim, foi mantido, caso seja informado um n maior, retorna a str
        if (n>str.length()){
            return str;
        }
        String substring = str.substring(str.length()-n);
        StringBuilder builder = new StringBuilder();
        builder.append(substring.repeat(Math.max(0, n)));

        return builder.toString();
    }
}
