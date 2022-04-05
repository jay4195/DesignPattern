package com.example.visitor;

import java.util.ArrayList;

public class ElementArrayList<E> extends ArrayList<E> implements Element {

    private ArrayList<E> elements = new ArrayList<>();

    @Override
    public boolean add(E e) {
        return elements.add(e);
    }

    public void accept(Visitor v) {
        for (E e : elements) {
            if (e instanceof File) {
                v.visit((File) e);
            } else {
                v.visit((Directory) e);
            }
        }
    }

}
