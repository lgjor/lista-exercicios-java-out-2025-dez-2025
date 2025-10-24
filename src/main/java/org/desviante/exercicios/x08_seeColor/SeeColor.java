package org.desviante.exercicios.x08_seeColor;

public class SeeColor {

    public String seeColor(String str){

        if ( str == null ) {
            return "";
        }

        // O método startsWith() já possui uma checagem eficiente interna para o tamanho da string menor que o prefixo.
        if ( str.startsWith("red") ){
            return "red";
        }
        else if ( str.startsWith("blue") ){
            return "blue";
        }
        return "";          
    }

}
