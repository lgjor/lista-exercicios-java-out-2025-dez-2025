package org.desviante.exercicios.CodeWorkout.x37_xyzThere;

public class XyzThere {
    public boolean xyzThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("xyz")) {
                if (i == 0 || str.charAt(i - 1) != '.') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        XyzThere xyzThere = new XyzThere();
        System.out.println("Case 1: " + xyzThere.xyzThere("abcxyz")); // true
        System.out.println("Case 2: " + xyzThere.xyzThere("abc.xyz")); // false
        System.out.println("Case 3: " + xyzThere.xyzThere("xyz.abc")); // true
        System.out.println("Case 4: " + xyzThere.xyzThere("abcxy")); // false
        System.out.println("Case 5: " + xyzThere.xyzThere("xyz")); // true
        System.out.println("Case 6: " + xyzThere.xyzThere("xxyz")); // true
        System.out.println("Case 7: " + xyzThere.xyzThere("x.xyz")); // false
        System.out.println("Case 8: " + xyzThere.xyzThere("x.xxyz")); // true
    }

}
