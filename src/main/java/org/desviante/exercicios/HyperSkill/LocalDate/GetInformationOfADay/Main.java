package org.desviante.exercicios.HyperSkill.LocalDate.GetInformationOfADay;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
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
        System.out.println(date.getDayOfYear()+" "+date.getDayOfMonth());
    }
}
