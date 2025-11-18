package org.desviante.exercicios.HyperSkill.File.CleanASpam;

import java.io.File;

public class CleanASpam {

    public void cleanSpam(String username) {
        File spamDir = new File(username + File.separator + "spam");
        if (spamDir.exists()) {
            for (File msg : spamDir.listFiles()) {
                msg.delete();
                
            }
            spamDir.delete();

        }
    }
}
