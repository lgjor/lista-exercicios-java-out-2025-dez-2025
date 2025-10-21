package org.desviante.exercicios.x33_zipZap;

public class ZipZap {

    public String zipZap(String str){
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length;) {
            if (i < length - 2 && str.charAt(i) == 'z' && str.charAt(i + 2) == 'p'){
                sb.append(str.charAt(i));
                sb.append(str.charAt(i + 2));
                i += 3;
            } else {
                sb.append(str.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZipZap zipZap = new ZipZap();
        System.out.println("Case 1: "+zipZap.zipZap("zipXzap"));
    }

}
