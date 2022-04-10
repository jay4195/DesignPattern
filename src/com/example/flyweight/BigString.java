package com.example.flyweight;

public class BigString {

    private BigChar[] bigChars;

    public BigString(String string, boolean shared) {
        bigChars = new BigChar[string.length()];
        if (true) {
            BigCharFactory factory = BigCharFactory.getInstance();
            for (int i = 0; i < bigChars.length; i++) {
                bigChars[i] = factory.getBigChar(string.charAt(i));
            }
        } else {
            for (int i = 0; i < bigChars.length; i++) {
                bigChars[i] = new BigChar(string.charAt(i));
            }
        }
    }

    public BigString(String string) {
        bigChars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigChars.length; i++) {
            bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    public void print() {
        for (BigChar bigChar : bigChars) {
            bigChar.print();
        }
    }
}
