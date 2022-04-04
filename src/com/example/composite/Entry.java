package com.example.composite;

/**
 * Composite 组合模式
 * @author jay4195
 * @since 2022-04-04
 */
public abstract class Entry {

    protected String name;

    protected int size;

    protected Entry parent;

    public String getName() {
        return name;
    }

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    protected void setParent(Entry entry) {
        this.parent = entry;
    }

    protected Entry getParent() {
        return parent;
    }

    protected String getFullPath() {
        StringBuilder fullPath = new StringBuilder();
        Entry current = this;
        while (current != null) {
            fullPath.insert(0, current.getName()).insert(0, "/");
            current = current.getParent();
        }
        return fullPath.toString();
    }

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

}
