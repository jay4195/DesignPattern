package com.example.decorator;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------Test BasicClass-------");
        Display b1 = new StringDisplay("Hello, world!");
        Display b2 = new SideBorder(b1, '#');
        Display b3 = new FullBorder(b2);

        b1.show();
        b2.show();
        b3.show();

        Display b4 = new SideBorder(new FullBorder(new FullBorder(new SideBorder(new FullBorder(new StringDisplay("你好，世界。")), '*'))), '/');
        b4.show();

        System.out.println();
        System.out.println("-------Test UpDownBorder-------");

        Display b5 = new UpDownBorder(b1, '-');
        b5.show();

        System.out.println();
        System.out.println("-------Test MultiStringDisplay-------");

        MultiStringDisplay md = new MultiStringDisplay();
        md.add("早上好。");
        md.add("下午好。");
        md.add("晚安、明天见。");
        md.show();

        Display d1 = new SideBorder(md, '#');
        d1.show();

        Display d2 = new FullBorder(md);
        d2.show();
    }

}
