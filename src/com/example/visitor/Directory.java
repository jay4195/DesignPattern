package com.example.visitor;

import com.example.composite.FileTreatmentException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends Entry {

    private String name;

    private int size;

    private List<Entry> dir = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry e : dir) {
            size += e.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) throws FileTreatmentException {
        dir.add(entry);
        return this;
    }

    @Override
    public Iterator<Entry> iterator() throws FileTreatmentException {
        return dir.iterator();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
