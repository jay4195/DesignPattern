package com.example.decorator;

/**
 * Decorator 装饰器模式
 * @author jay4195
 * @since 2022-04-04
 */
public abstract class Display {

    public abstract int getColumns();

    public abstract int getRows();

    public abstract String getRowText(int row);

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
