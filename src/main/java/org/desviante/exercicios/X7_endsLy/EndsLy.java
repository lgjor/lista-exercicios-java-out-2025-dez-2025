package org.desviante.exercicios.X7_endsLy;

public class EndsLy {

    public boolean endsLy(String str){
        if (str == null) {
            return false;
        }
        return str.endsWith("ly");
    }
}