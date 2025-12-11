package org.desviante.exercicios.CodeWorkout.x42_frontPiece;

import java.util.Arrays;

public class FrontPiece {

    public int[] frontPiece(int[] nums)
    {
        // Se o array de entrada for 'null', retorne 'null' (mantendo o comportamento atual para null)
        if (nums == null){
            return null;
        }

        // Fix para o erro de retorno null para array de tamanho zero
        if (nums.length == 0){
            return new int[0];
        }
        int[] frontPieceNums = new int[nums.length>=2?2:1];
        for (int i=0; i<frontPieceNums.length; i++){
            frontPieceNums[i]=nums[i];
        }
        return frontPieceNums;
        // Alternativa em uma linha, retornar a cópia do array com 0 1 ou no máximo 2 elementos.
        //return Arrays.copyOf(nums, Math.min(nums.length, 2) );
    }

    public static void main(String[] args) {
        FrontPiece frontPiece = new FrontPiece();
        int[] case01 = {1, 2, 3, 4, 5};
        System.out.println("Case 1: "+Arrays.toString(frontPiece.frontPiece(case01)));
        int[] case02 = {1};
        System.out.println("Case 2: "+Arrays.toString(frontPiece.frontPiece(case02)));
    }

}
