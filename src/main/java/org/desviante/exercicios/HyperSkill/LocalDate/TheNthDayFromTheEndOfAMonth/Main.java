package org.desviante.exercicios.HyperSkill.LocalDate.TheNthDayFromTheEndOfAMonth;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = 0;
        int month = 0;
        int days = 0;
        LocalDate firstDayOfMonth = null;
        LocalDate selectedDate = null;
        boolean dataValida = false;

        do {
            try {
                System.out.println("Enter year and month (e.g., 2024 11):");

                year = scanner.nextInt();
                month = scanner.nextInt();
                days = scanner.nextInt();
                firstDayOfMonth = LocalDate.of(year, month, 1);
                selectedDate = LocalDate.of(year, month,firstDayOfMonth.lengthOfMonth()+1-days);
                dataValida = true;

            } catch (DateTimeException e) {
                System.out.println("Data informada inválida: O ano ou mês não é válido.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida: Por favor, insira números inteiros.");
                scanner.next(); // Consume the invalid token to prevent an infinite loop
            }
        } while (!dataValida);
        scanner.close();
        System.out.println(selectedDate);
    }
}
