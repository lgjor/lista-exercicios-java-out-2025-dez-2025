package org.desviante.exercicios.HyperSkill.LocalDate.FirstDayOfAMonthOrNot;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        int dayOfMonth = date.getDayOfMonth();
        int lenOfMonth = date.lengthOfMonth();
        // verificar se é o último dia seria dayOfMonth==date.lengthOfMonth()
        System.out.println(dayOfMonth == 1);
    }
}