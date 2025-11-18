package org.desviante.exercicios.HyperSkill.File.CheckFileProperties;

import java.io.File;

public class CheckFileProperties {
    public static void main( String [] args) {
        File tempFile = new File("tempFile.txt");
        String fileInfo = "File exists: " + tempFile.exists() +
                "\nFile path: " + tempFile.getAbsolutePath()  +
                "\nFile is readable: " + tempFile.canRead()   +
                "\nFile is writable: " + tempFile.canWrite();
        System.out.println(fileInfo);
    }
}