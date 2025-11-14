package org.desviante.exercicios.HyperSkill.LocalDate.ConvertNumbersToDays;

import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int days1 = scanner.nextInt();
        int days2 = scanner.nextInt();
        int days3 = scanner.nextInt();
        LocalDate daysOne = LocalDate.ofYearDay(year, days1);
        LocalDate daysTwo = LocalDate.ofYearDay(year, days2);
        LocalDate daysThree = LocalDate.ofYearDay(year, days3);
        System.out.println(daysOne) ;
        System.out.println(daysTwo) ;
        System.out.println(daysThree) ;
    }
}

