package org.desviante.exercicios.x96_roundSum;

public class RoundSum {

    public int roundSum(int a, int b, int c)
    {
        return round10(a) + round10(b) + round10(c);
    }

    public int round10(int num)
    {
        int resto = num % 10;
        if(resto>=5 && resto<20){
           return num + (10-resto);
        }
        return num - resto;
    }

    public static void main(String[] args) {
        RoundSum roundSum = new RoundSum();
        System.out.println(roundSum.roundSum(15,16,14));
    }
}
