package org.desviante.exercicios.HyperSkill.LocalDate.TenDaysBefore;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.DateTimeException;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String dateString = "";
        LocalDate date = null; // Inicialize date como null
        boolean dataValida = false;

        while (!dataValida) {
            try {
                dateString = scanner.nextLine();
                date = LocalDate.parse(dateString);
                dataValida = true;
            } catch (DateTimeException e) {
                System.out.println("Data informada inválida " + e);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida");
                scanner.next(); // Limpar a entrada inválida
            }
        }
        scanner.close();

        LocalDate tenDaysBefore = date.minusDays(10);
        System.out.println(tenDaysBefore);
    }
}
