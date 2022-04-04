package com.example.decorator;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {

    private int column;

    private List<String> multiText;

    public MultiStringDisplay() {
        this.multiText = new ArrayList<>();
        this.column = 0;
    }

    @Override
    public int getColumns() {
        return column;
    }

    @Override
    public int getRows() {
        return multiText.size();
    }

    @Override
    public String getRowText(int row) {
        return multiText.get(row);
    }

    public void add(String text) {
        multiText.add(text);
        if (text.length() > column) {
            column = text.length();
        }
    }

}
