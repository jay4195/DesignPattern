package com.example.flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {

    private static final String filePathPrefix = "resources/flyweight/";

    private char charName;

    private String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathPrefix + "big" + charName + ".txt"))) {
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line).append("\n");
            }
            this.fontData = buf.toString();
        } catch (IOException e) {
            this.fontData = charName + "?";
        }
    }

    public void print() {
        System.out.println(fontData);
    }

}
