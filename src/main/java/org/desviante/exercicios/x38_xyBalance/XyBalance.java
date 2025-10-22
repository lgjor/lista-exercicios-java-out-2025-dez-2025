package org.desviante.exercicios.x38_xyBalance;

public class XyBalance {
    public boolean xyBalance(String str)
    {
        int xCount = 0;
        int yCount = 0;

        if (str.contains("x")){
            // Se a str termina com x, não está balanceada
            if (str.endsWith("x")){
                return false;
            }
            // Se str contém x, mas não contém y, não está balanceada
            else if (!str.contains("y")){
                return false;
            } else {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == 'x'){
                        xCount++;
                    }
                    if (str.charAt(i) == 'y' && xCount > 0){
                        yCount++;
                    }
                }
                // Se contém ao menos 1y depois de x está balanceada
                return yCount>0;
            }
        // Se a str não contém x, retorna true
        } else {
            return true;
        }
    }

    public static void main(String[] args){
        XyBalance xyBalance = new XyBalance();
        System.out.println("Case 1: "+xyBalance.xyBalance("xyyav"));

    }
}
