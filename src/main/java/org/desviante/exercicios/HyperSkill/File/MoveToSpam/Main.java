package org.desviante.exercicios.HyperSkill.File.MoveToSpam;

import java.io.File;

public class Main {

    public void moveToSpam(String username, File msg) {
        String pathToSpam = username + File.separator + "spam";

        File spamDirectory = new File(pathToSpam);

        if (!spamDirectory.exists()) {
            spamDirectory.mkdir();
        }

        File spamMsg = new File(pathToSpam + File.separator + msg.getName());
        if (!msg.renameTo(spamMsg)) {
            System.err.println("Erro ao mover arquivo");
        }
    }

}
