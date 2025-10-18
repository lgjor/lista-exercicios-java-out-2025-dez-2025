package org.desviante.exercicios.programmazione.dice;

import java.util.Random;
import java.util.Scanner;

/**
 * Exercício: Dice (Programmazione OOP)
 * Jogo de dados com apostas
 */
public class Dice {

    public static void main(String[] args) {
        BankAccount playerAccount = new BankAccount(1000);
        BankAccount casinoAccount = new BankAccount(100000);
        int predictedValue, actualValue;
        double bet;
        String choice = "no";
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        do {
            System.out.print("Qual valor você prevê? (1-6): ");
            predictedValue = in.nextInt();
            
            System.out.print("Quanto você quer apostar? ");
            bet = in.nextDouble();
            
            actualValue = random.nextInt(6) + 1;
            System.out.println("O dado mostrou: " + actualValue);
            
            if (predictedValue == actualValue) {
                System.out.println("Você ganhou!");
                playerAccount.deposit(bet);
                casinoAccount.withdraw(bet);
            } else {
                System.out.println("Você perdeu!");
                playerAccount.withdraw(bet);
                casinoAccount.deposit(bet);
            }
            
            System.out.println("Seu saldo: " + playerAccount.getBalance());
            System.out.println("Saldo do casino: " + casinoAccount.getBalance());
            
            System.out.print("Deseja continuar jogando? (yes/no): ");
            choice = in.next();
            
        } while (choice.equalsIgnoreCase("yes") && playerAccount.getBalance() > 0);

        System.out.println("O teu saldo é " + playerAccount.getBalance());
        in.close();
    }
}

