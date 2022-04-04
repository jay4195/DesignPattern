package com.example.composite;

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
        File viFile = new File("vi", 10000);
        File latexFile = new File("latex", 20000);
        binDir.add(viFile);
        binDir.add(latexFile);
        rootDir.printList();

        System.out.println(latexFile.getFullPath());
    }

}
