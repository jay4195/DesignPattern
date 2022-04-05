package com.example.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PageMaker {

    private PageMaker() {
    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailProp = Database.getProperties("maildata");
            String username = mailProp.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename, StandardCharsets.UTF_8));
            writer.title(String.format("Welcome to %s's page!", username));
            writer.paragraph(String.format("欢迎来到%s的主页", username));
            writer.paragraph("等着你的邮件哦！ ");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.printf("%s is created for %s (%s)\n", filename, mailaddr, username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
