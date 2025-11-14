package org.desviante.exercicios.HyperSkill.LocalDate.AllMondays;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.InputMismatchException;
import java.util.Scanner;

class AllMondays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = 0;
        int month = 0;
        LocalDate firstDayOfMonth = null;
        boolean dataValida = false;

        do {
            try {
                System.out.println("Enter year and month (e.g., 2024 11):");

                year = scanner.nextInt();
                month = scanner.nextInt();

                firstDayOfMonth = LocalDate.of(year, month, 1);
                dataValida = true;

            } catch (DateTimeException e) {
                System.out.println("Data informada inválida: O ano ou mês não é válido.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida: Por favor, insira números inteiros.");
                scanner.next(); // Consume the invalid token to prevent an infinite loop
            }
        } while (!dataValida);
        scanner.close();

        LocalDate currentMonday = firstDayOfMonth.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));


        int targetMonthValue = firstDayOfMonth.getMonthValue();

        System.out.println("Mondays in " + firstDayOfMonth.getMonth() + " " + year + ":");

        // Adding 7 days until the month changes
        while (currentMonday.getMonthValue() == targetMonthValue) {
            System.out.println(currentMonday);

            // Jump directly to the next Monday (7 days later)
            currentMonday = currentMonday.plusWeeks(1);
        }
    }
}