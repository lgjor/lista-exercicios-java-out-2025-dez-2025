package org.desviante.exercicios.HyperSkill.LocalDate.PrintDatesOfAYearWithAnOffset;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.time.format.DateTimeParseException;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Read the starting date string (e.g., "2017-12-19")
            String fullDateString = scanner.nextLine();

            // Read the offset in days (e.g., 4)
            int daysToAdd = scanner.nextInt();

            // 1. Parse the starting date and identify the target year
            LocalDate startDate = LocalDate.parse(fullDateString);
            int initialYear = startDate.getYear();

            // Initialize the date we will print in the current iteration
            LocalDate currentDate = startDate;

            // Loop Condition: Continue as long as the currentDate remains within the initial year
            while (currentDate.getYear() == initialYear) {

                // Print the current date (This handles the starting date and all subsequent dates)
                System.out.println(currentDate);

                // Calculate the date after applying the offset
                LocalDate nextDate = currentDate.plusDays(daysToAdd);

                // Check the year of the next calculated date.
                // If it is greater than the initial year, the current date was the last valid date,
                // so we break the loop before the next iteration.
                if (nextDate.getYear() > initialYear) {
                    break;
                }

                // Move the current date forward to the next calculated date for the next iteration
                currentDate = nextDate;
            }

        } catch (DateTimeParseException e) {
            System.err.println("Erro: A data deve estar no formato YYYY-MM-DD.");
        } catch (InputMismatchException e) {
            System.err.println("Erro: O offset deve ser um número inteiro válido.");
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

