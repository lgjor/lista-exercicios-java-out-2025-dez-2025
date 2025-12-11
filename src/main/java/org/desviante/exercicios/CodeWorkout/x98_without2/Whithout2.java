package org.desviante.exercicios.CodeWorkout.x98_without2;

public class Whithout2 {

    public String without2(String str)
    {
        if (str.length()<2){
            return str;
        }
        if (str.length()==2){
            return "";
        }
        final String prefix = str.substring(0,2);
        final String sulfix = str.substring(str.length()-2);

        if (prefix.equals(sulfix)){
            return str.substring(2);
        }
        return str;
    }

    public static void main(String[] args) {
        Whithout2 whithout2 = new Whithout2();
        System.out.println(whithout2.without2("Hiallaloiu"));
    }
}
