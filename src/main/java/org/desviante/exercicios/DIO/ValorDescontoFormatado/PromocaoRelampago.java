package org.desviante.exercicios.DIO.ValorDescontoFormatado;

import java.math.BigDecimal;
import java.util.Scanner;

public class PromocaoRelampago {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String valorCompra = scanner.nextLine();
        System.out.println(calcularDesconto(valorCompra));
        scanner.close();
    }

    public static String calcularDesconto(String valorCompra) {
        BigDecimal valor = new BigDecimal(valorCompra);
        BigDecimal descontoPercentual;
        final BigDecimal LIMITE_100 = new BigDecimal("100.00");
        final BigDecimal LIMITE_50 = new BigDecimal("50.00");

        String valorDeDescontoFormatado = "Desconto de ";

        // Se valor > 100.00 (compareTo > 0)
        if (valor.compareTo(LIMITE_100) > 0) {
            valorDeDescontoFormatado += "20%";
            // Exemplo de cálculo: aplicarDesconto(valor, new BigDecimal("0.20"));

            // Se valor <= 100.00 e valor >= 50.00 (compareTo >= 0)
        } else if (valor.compareTo(LIMITE_50) >= 0) {
            valorDeDescontoFormatado += "10%";
            // Exemplo de cálculo: aplicarDesconto(valor, new BigDecimal("0.10"));

            // Se valor < 50.00 (Caso padrão, a última condição)
        } else {
            valorDeDescontoFormatado += "0%";
        }

        return valorDeDescontoFormatado;
    }
}
