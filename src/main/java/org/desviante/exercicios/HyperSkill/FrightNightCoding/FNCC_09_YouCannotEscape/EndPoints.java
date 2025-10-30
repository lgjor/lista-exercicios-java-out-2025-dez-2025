package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_09_YouCannotEscape;

public class EndPoints {
    private Position start;
    private Position goal;

    public EndPoints(Position start, Position goal) {
        this.start = start;
        this.goal = goal;
    }

    public Position getStart() {
        return start;
    }

    public Position getGoal() {
        return goal;
    }

    public void setStart(Position start) {
        this.start = start;
    }
    
    public void setGoal(Position goal) {
        this.goal = goal;
    }
}
