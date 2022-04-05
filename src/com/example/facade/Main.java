package com.example.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Main {

    private Main() {
    }

    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html");
    }

}
