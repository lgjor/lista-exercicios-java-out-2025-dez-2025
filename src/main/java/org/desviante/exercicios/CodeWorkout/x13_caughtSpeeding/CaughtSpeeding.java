package org.desviante.exercicios.CodeWorkout.x13_caughtSpeeding;

public class CaughtSpeeding {

    public int caughtSpeeding(int speed, boolean isBirthday)
    {
        int maxSpeed = isBirthday?85:80;
        int minSpeed = isBirthday?65:60;
        if (speed>maxSpeed){
            return 2; // Big ticket in any case
        }
        if (speed<=minSpeed){
            return 0;
        }
        return 1;
    }

}
