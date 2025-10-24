package org.desviante.exercicios.x35_countCode;

public class CountCode {

    public int countCode(String str)
    {
        int count = 0;
        int strLength = str.length();
        for (int i=0; i<strLength;){
            if (i+3<strLength && str.charAt(i)=='c' && str.charAt(i+1)=='o' && str.charAt(i+3)=='e') {
                count++;
                i+=4;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountCode countCode = new CountCode();
        System.out.println("Case 1: "+countCode.countCode("aaacodebbb"));
        System.out.println("Case 2: "+countCode.countCode("codexxcode"));
        System.out.println("Case 3: "+countCode.countCode("cozexxcope"));
        System.out.println("Case 4: "+countCode.countCode("cozfxxcope"));
    }
}
