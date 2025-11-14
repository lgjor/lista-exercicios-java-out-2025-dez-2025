package org.desviante.exercicios.HyperSkill.LocalDate.TwoWeeksAfter;

import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String fullDate = scanner.nextLine();
        LocalDate currentDate = LocalDate.parse(fullDate);
        LocalDate plus2weeksDate = currentDate.plusDays(14);
        System.out.println(plus2weeksDate);

    }
}