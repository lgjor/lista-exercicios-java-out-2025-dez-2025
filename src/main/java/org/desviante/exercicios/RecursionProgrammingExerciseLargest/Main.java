package org.desviante.exercicios.RecursionProgrammingExerciseLargest;

public class Main {

    public int largest(int[] numbers, int index) {
        if (numbers.length<1 || index == 0){
          return numbers[0];
        }
        return Math.max(numbers[index], largest(numbers, index-1));
      }
}
