package com.example.flyweight;

public class Main {

    public static void main(String[] args) {
        BigString bs = new BigString("1212123", true);
        bs.print();
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() -  Runtime.getRuntime().freeMemory();
        System.out.printf("使用内存：%d\n", used);
    }

}
