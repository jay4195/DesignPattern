package com.example.memento;

public class Main {

    public static void main(String[] args) throws Exception {
        Gamer gamer = new Gamer();
        Memento memento = gamer.getDefaultMemento(100);
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("当前状态：" + gamer);

            gamer.bet();

            System.out.println("所持金钱为" + gamer.getMoney() + "元。");
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("     （所持金钱增加了许多，因此保存游戏当前的状态)");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("     （所持金钱减少了许多，因此将游戏恢复至以前的状态)");
                memento = gamer.restoreMemento();
            }
            Thread.sleep(1000);
            System.out.println();
        }
    }
}
