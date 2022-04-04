package com.example.visitor.test;


import com.example.visitor.Directory;
import com.example.visitor.File;
import com.example.visitor.ListVisitor;

public class Main {

    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");
        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);
        File viFile = new File("vi", 1000);
        File latexFile = new File("latex", 2000);
        binDir.add(viFile);
        binDir.add(latexFile);
        rootDir.accept(new ListVisitor());

    }

}
