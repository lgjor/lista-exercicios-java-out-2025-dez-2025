package org.desviante.exercicios.DIO.OrganizarEstoqueProdutos;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OrganizandoEstoque {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String entrada = scanner.nextLine();
        String saida = organizarEstoque(entrada);

        System.out.println(saida);

        scanner.close();
    }

    public static String organizarEstoque(String entrada) {
        // LinkedHashMap para armazenar o total de cada código mantendo a ordem de aparição
        LinkedHashMap<String, Integer> estoqueProdutos = new LinkedHashMap<>();

        String[] lojas = entrada.split(",");

        for (String loja : lojas) {
            String[] partes = loja.split(":");
            String codigo = partes[0].trim();
            int quantidade = Integer.parseInt(partes[1].trim());

            // Atualizar a quantidade total no mapa (soma ao valor atual, se já existir)

            int quantidadeAtual = estoqueProdutos.getOrDefault(codigo, 0);

            estoqueProdutos.put(codigo, quantidadeAtual + quantidade);
        }

        StringBuilder sb = new StringBuilder();

        // Formatar o resultado: "codigo:quantidade,.."
        for (Map.Entry<String, Integer> entradaEstoque : estoqueProdutos.entrySet()) {
            String codigo = entradaEstoque.getKey();
            int quantidade = entradaEstoque.getValue();

            // Adiciona o par "codigo:quantidade" seguido de vírgula (,)
            sb.append(codigo).append(":").append(quantidade).append(",");
        }

        // Remove a última vírgula desnecessária, se houver caracteres
        if (!sb.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}