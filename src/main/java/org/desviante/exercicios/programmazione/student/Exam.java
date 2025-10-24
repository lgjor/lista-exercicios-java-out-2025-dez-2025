package org.desviante.exercicios.programmazione.student;

import java.util.GregorianCalendar;

/**
 * Exercício: Student (Programmazione OOP - Interfacce)
 * Representa um exame com tópico, data e nota
 */
public class Exam {
    private final String topic;
    private final GregorianCalendar date;
    private final int grade;

    public Exam(String topic, GregorianCalendar date, int grade) {
        this.topic = topic;
        this.date = date;
        this.grade = grade;
    }

    public String getTopic() {
        return topic;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public int getGrade() {
        return grade;
    }
}

