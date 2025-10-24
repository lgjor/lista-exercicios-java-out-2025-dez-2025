package org.desviante.exercicios.x42_frontPiece;

import java.util.Arrays;

public class FrontPiece {

    public int[] frontPiece(int[] nums)
    {
        if (nums == null){
            return null;
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
