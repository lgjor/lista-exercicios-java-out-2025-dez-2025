package org.desviante.exercicios.HyperSkill.LocalDate.FirstAndLastDayOfAMonth;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = 0;
        int month = 0;
        LocalDate date = null; // Inicialize date como null
        boolean dataValida = false;

        while (!dataValida) {
            try {
                year = scanner.nextInt();
                month = scanner.nextInt();
                date = LocalDate.of(year, month, 1);
                dataValida = true;
            } catch (DateTimeException e) {
                System.out.println("Data informada inválida " + e);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida");
                scanner.next(); // Limpar a entrada inválida
            }
        }
        scanner.close();
        int monthDays = date.lengthOfMonth();
        System.out.println(date + " " + date.plusDays(monthDays-1));
    }
}