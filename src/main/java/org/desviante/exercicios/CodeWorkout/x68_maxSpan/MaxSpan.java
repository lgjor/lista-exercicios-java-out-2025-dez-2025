package org.desviante.exercicios.CodeWorkout.x68_maxSpan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSpan {

    public int maxSpan(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maiorSpan = 0;

        // Loop externo: Começa no índice da possível "ocorrência mais à esquerda"
        for (int i = 0; i < nums.length; i++) {
            int valorAtual = nums[i];
            int indiceEsquerdo = i;
            int indiceDireito = i; // Inicialmente, a ocorrência mais à direita é o próprio 'i'
            // Loop aninhado (interno): Busca a ocorrência mais à direita do valorAtual
            // Começamos em 'i' e vamos até o final do array.
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == valorAtual) {
                    indiceDireito = j;
                }
            }

            // Calcular o intervalo (span) para o valorAtual
            // Intervalo = (Último Índice - Primeiro Índice) + 1
            int spanAtual = indiceDireito - indiceEsquerdo + 1;

            // Atualizar o maior intervalo encontrado
            if (spanAtual > maiorSpan) {
                maiorSpan = spanAtual;
            }
        }

        return maiorSpan;
    }


}
