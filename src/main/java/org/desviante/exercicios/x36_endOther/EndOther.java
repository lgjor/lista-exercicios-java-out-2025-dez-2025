package org.desviante.exercicios.x36_endOther;

public class EndOther {

    public boolean endOther(String a, String b)
    {
        String lowerA = a.toLowerCase();
        String lowerB = b.toLowerCase();
        return lowerA.endsWith(lowerB) || lowerB.endsWith(lowerA);
    }

    public static void main(String[] args) {
        EndOther endOther = new EndOther();
        System.out.println("Case 1: "+endOther.endOther("Hiabc", "abc"));
        System.out.println("Case 2: "+endOther.endOther("AbC", "HiaBc"));
        System.out.println("Case 3: "+endOther.endOther("abc", "abXabcf"));
    }
}
