package org.desviante.exercicios.anobissexto;

import java.util.Scanner;

/**
 * Exercício: Verificador de Ano Bissexto
 * Verifica se um ano informado é bissexto ou não.
 */
public class AnoBissexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um ano inteiro válido para verificar se é bissexto: ");
        int year = scanner.nextInt();

        boolean a = (year % 4) == 0;
        boolean b = (year % 100) != 0;
        boolean c = ((year % 100 == 0) && (year % 400 == 0));

        if(a && (b || c))
            System.out.print("Ano Bissexto");
        else
            System.out.print("Não é Ano Bissexto");
        
        scanner.close();
    }
}

