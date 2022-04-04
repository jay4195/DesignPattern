package com.example.visitor;

/**
 * Visitor 访问者模式
 * @author jay4195
 * @since 2022-04-04
 */
public abstract class Visitor {

    public abstract void visit(File file);

    public abstract void visit(Directory directory);

}
