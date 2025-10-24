package org.desviante.exercicios.x06_HelloName;

import java.util.Scanner;

public class HelloName {

    public String helloName(String name) {
        return "Hello " + name + "!";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        String helloMessage = new HelloName().helloName(name);
        System.out.println(helloMessage);
        scanner.close();
    }
}
