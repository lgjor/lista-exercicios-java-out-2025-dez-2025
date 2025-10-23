package org.desviante.exercicios.x39_getSandwich;

public class GetSandwich {

    public String getSandwich(String str){
        // Trata entrada nula ou vazia
        if (str == null || str.isEmpty()) {
            return "";
        }

        // Encontra primeira e última ocorrência
        int primeiraBread = str.indexOf("bread");
        int ultimaBread = str.lastIndexOf("bread");
        System.out.println("Primeira bread: " + primeiraBread);
        System.out.println("Última bread: " + ultimaBread);

        // Se não há breads ou apenas uma, retorna vazio
        if (primeiraBread == -1 || ultimaBread == -1 || primeiraBread == ultimaBread) {
            return "";
        }
        
        // Extrai o conteúdo entre elas
        int inicio = primeiraBread + 5; // +5 = tamanho de "bread"
        int fim = ultimaBread;
        
        return str.substring(inicio, fim);
    }

    public static void main(String[] args){
        System.out.println("--------------------------------");
        GetSandwich getSandwich = new GetSandwich();
        System.out.println("Case 1: " + getSandwich.getSandwich("breadjotaasdasdasbreadjotajotabreadjota"));
        System.out.println("Case 2: " + getSandwich.getSandwich("breadcontentbreadmorebread"));
        System.out.println("Case 3: " + getSandwich.getSandwich("breadjotabreadoutrabread"));
    }
}


