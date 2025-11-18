package org.desviante.exercicios.DIO;

import java.util.Scanner;

// Classe principal
public class Bicicleta {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Nome do modelo (String)
        String modelo = scanner.nextLine();

        // Nível de bateria (int, lido como String e depois convertido)
        String nivelStr = scanner.nextLine();

        // Converte a string para inteiro
        int nivelBateria = Integer.parseInt(nivelStr);

        // TODO: Crie um objeto da classe Bike(Bicicleta) com os valores lidos:
        Bike bicicleta = new Bike(modelo, nivelBateria);

        // Chama o método que retorna a mensagem formatada e exibe no console
        System.out.println(bicicleta.obterMensagem());

        // Fecha o scanner (boa prática para liberar o recurso)
        scanner.close();
    }
}

// Classe que representa a bicicleta
class Bike {
    private String nome;
    private int battery;

    // Construtor
    public Bike(String nome, int battery) {
        this.nome = nome;
        this.battery = battery;
    }

    // Método que retorna a mensagem no formato solicitado, com uma casa decimal
    public String obterMensagem() {
        // Formata a string de retorno
        return String.format("%s: Distância estimada = %.1f km", this.nome, calcularDistancia());
    }

    // Método para calcular a distância. A especificação diz:
    // "Cada bicicleta pode percorrer, com base no nível atual de bateria,
    // 1% de bateria permite percorrer 0.5 km."
    // Distância = Nível de Bateria (%) * 0.5 km/1%
    public double calcularDistancia() {
        return battery * 0.5;
    }

    // Método get para o nome
    public String getNome() {
        return this.nome;
    }
}