package org.desviante.exercicios.HyperSkill.LocalDate.TheLastDayOfAMonth;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.DateTimeException;

class TheLastDayOfAMonth {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = 0;
        int day = 0;
        LocalDate date = null; // Inicialize date como null
        boolean dataValida = false;

        while (!dataValida) {
            try {
                year = scanner.nextInt();
                day = scanner.nextInt();
                date = LocalDate.ofYearDay(year, day);
                dataValida = true;
            } catch (DateTimeException e) {
                System.out.println("Data informada inválida " + e);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida");
                scanner.next(); // Limpar a entrada inválida
            }
        }
        scanner.close();

        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth(); // 25
        int lenOfMonth = date.lengthOfMonth();
        System.out.println(dayOfMonth == lenOfMonth);
    }
}