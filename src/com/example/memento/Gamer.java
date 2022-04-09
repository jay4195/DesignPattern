package com.example.memento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {

    private final String gameDatPath = "resources/memento/game.dat";

    private int money;

    private List<String> fruits = new ArrayList<>();

    private Random random = new Random();

    private static String[] fruitsName = {"苹果", "葡萄", "香蕉", "橘子"};

    public Gamer() {
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金钱增加了100。");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金钱减半了。");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.printf("获得了水果(%s)。\n", f);
            fruits.add(f);
        } else {
            System.out.println("什么都没有发生");
        }
    }

    public Memento getDefaultMemento(int money) throws Exception {
        File gameDat = new File(gameDatPath);
        Memento memento;
        if (gameDat.exists()) {
            memento = restoreMemento();
        } else {
            this.money = money;
            memento = createMemento();
        }
        return memento;
    }

    public Memento createMemento() throws Exception {
        File gameDat = new File(gameDatPath);
        Memento m = new Memento(money);
        for (String fruit : fruits) {
            if (fruit.startsWith("好吃的")) {
                m.addFruits(fruit);
            }
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(gameDat))) {
            objectOutputStream.writeObject(m);
        }
        return m;
    }

    public Memento restoreMemento() throws Exception {
        File gameDat = new File(gameDatPath);
        Memento memento;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(gameDat))) {
            memento = (Memento) objectInputStream.readObject();
        }
        this.money = memento.money;
        this.fruits = memento.getFruits();
        return memento;
    }

    @Override
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }

    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "好吃的";
        }
        return prefix + fruitsName[random.nextInt(fruitsName.length)];
    }
}
