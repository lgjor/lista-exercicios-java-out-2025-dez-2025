package org.desviante.exercicios.CodeWorkout.x60_fizzBuzz;

import java.util.Arrays;

public class FizzBuzz {

    public String[] fizzBuzz(int start, int end)
    {
        final int lengthOfFizzBuzz = end-start;
        final int firstNumberOfFizzBuzz = start;

        String[] fizzBuzzString = new String[lengthOfFizzBuzz];

        // This loop ensures it runs exactly 'lengthOfFizzBuzz' times.
        // For lengthOfFizzBuzz = 1, it will only run for i = 0.
        int actual = start;
        for (int i=0; i<lengthOfFizzBuzz; i++){
            // This calculates the current number correctly:
            // If firstNumberOfFizzBuzz = 2 and i = 0, currentNumber = 2.
            int currentNumber = firstNumberOfFizzBuzz + i;

            String output = "";

            if (currentNumber % 3 == 0) {
                output += "Fizz";
            }
            if (currentNumber % 5 == 0) {
                output += "Buzz";
            }

            if (output.isEmpty()) {
                fizzBuzzString[i]=(String.valueOf(currentNumber));
            } else {
                fizzBuzzString[i]=(output);
            }

        }
        return fizzBuzzString;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(Arrays.toString(fizzBuzz.fizzBuzz(1, 6)));
    }

}
