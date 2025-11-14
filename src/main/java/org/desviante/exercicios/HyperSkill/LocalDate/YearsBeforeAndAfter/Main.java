package org.desviante.exercicios.HyperSkill.LocalDate.YearsBeforeAndAfter;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.time.DateTimeException;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fullDate = "";
        LocalDate currentDate = null;
        boolean validInput = false;
        do {
            try{
                fullDate = scanner.nextLine();
                currentDate = LocalDate.parse(fullDate);
                validInput = true;
            } catch (DateTimeException e) {
                System.out.println("Invalid date entered. " + e);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.next(); // Clean the invalid input
            }
        } while (!validInput);
        scanner.close();
        LocalDate plus30y = currentDate.plusYears(30);
        LocalDate less30y = currentDate.minusYears(30);
        System.out.println(less30y);
        System.out.println(plus30y);
    }
}

