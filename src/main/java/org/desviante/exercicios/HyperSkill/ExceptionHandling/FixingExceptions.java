package org.desviante.exercicios.HyperSkill.ExceptionHandling;

class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        try{
            System.out.printf("%d", (int) Math.pow(array[index],2) );
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception!");
        } catch (NullPointerException e){
            System.out.println("Exception!");
        }
        catch (Exception e){
            System.out.println("Exception!");
        }
    }
    public static void main(String[] args) {
        calculateSquare(new int[]{1, 2, 3, 4, 5}, -1);
    
    }
}