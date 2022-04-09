package com.example.memento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Memento
 * 备忘录模式
 */
public class Memento implements Serializable {

    int money;

    ArrayList<String> fruits;

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    void addFruits(String fruit) {
        this.fruits.add(fruit);
    }

    List<String> getFruits() {
        return (List<String>) fruits.clone();
    }
}
