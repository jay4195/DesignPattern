package com.example.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {

    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
        parent = null;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) throws FileTreatmentException {
        directory.add(entry);
        entry.setParent(this);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        }
    }

}
