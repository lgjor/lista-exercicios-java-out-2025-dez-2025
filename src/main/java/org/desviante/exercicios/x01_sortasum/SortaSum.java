package org.desviante.exercicios.x01_sortasum;

import java.util.Scanner;

/**
 * Exercício: Sorta Sum
 * Soma dois números, mas retorna 20 se a soma estiver entre 10 e 19 (inclusive)
 */
public class SortaSum {
    
    /**
     * Soma dois números com regra especial
     * @param a primeiro número
     * @param b segundo número
     * @return 20 se a soma estiver entre 10 e 19, senão retorna a soma normal
     */
    public int sortaSum(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 19) {
            return 20;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o inteiro válido a: ");
        int a = scanner.nextInt();
        System.out.print("Informe o inteiro válido b: ");
        int b = scanner.nextInt();
        
        SortaSum sortaSum = new SortaSum();
        int sum = sortaSum.sortaSum(a, b);
        System.out.println(sum);
        
        scanner.close();
    }
}

