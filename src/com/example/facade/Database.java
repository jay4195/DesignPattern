package com.example.facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {

    private Database() {

    }

    public static Properties getProperties(String dbname) {
        String filename = "resources/facade/" + dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.printf("Waring: %s is not found.\n", filename);
        }
        return prop;
    }
}
