package org.desviante.exercicios.X07_endsLy;

public class EndsLy {

    public boolean endsLy(String str){
        if (str == null) {
            return false;
        }
        return str.endsWith("ly");
    }
}