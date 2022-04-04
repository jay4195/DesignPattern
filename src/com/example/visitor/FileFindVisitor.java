package com.example.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitor extends Visitor {

    private String currentDir;

    private String ext;

    private List<Entry> foundFiles;

    public FileFindVisitor(String ext) {
        this.currentDir = "";
        this.ext = ext;
        this.foundFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        int lastDotId = file.getName().lastIndexOf('.');
        if (lastDotId == -1) {
            return;
        }
        String extName = file.getName().substring(lastDotId);
        if (extName.equals(ext)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentDir + "/" + directory);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.accept(this);
        }
        currentDir = saveDir;
    }

    public List<Entry> getFoundFiles() {
        return foundFiles;
    }

}
