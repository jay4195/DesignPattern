package com.example.decorator;

public class FullBorder extends Border {

    public FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        // 两侧边框
        return 2 + display.getColumns();
    }

    @Override
    public int getRows() {
        // 上下边框
        return 2 + display.getRows();
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == display.getRows() + 1) {
            return '+' + makeLine('-', display.getColumns()) + '+';
        } else {
            return '|' + display.getRowText(row - 1) + '|';
        }
    }

    private String makeLine(char ch, int count) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
