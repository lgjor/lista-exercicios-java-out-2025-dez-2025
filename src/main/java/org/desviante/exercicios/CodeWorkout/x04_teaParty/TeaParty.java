package org.desviante.exercicios.CodeWorkout.x04_teaParty;

public class TeaParty {
    public int teaParty(int tea, int candy){
        // Caso limite: Se tea ou candy menor que 5 a festa é sempre ruim
        if ( ( tea<5 ) || ( candy<5 ) ){
            return 0; 
        }
        // Caso limite: Se tea ou candy maior ou igual a 2x o outro, a festa é ótima
        if ( (tea>=2*candy) || (candy>=2*tea) ){
            return 2;
        }
        // Caso padrão: Se tea ou candy maior que 5 e menor que 2x o outro, a festa é boa
        return 1;
    }
}
