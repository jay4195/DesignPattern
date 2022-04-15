package com.example.interpreter.lang;

public class PrimitiveCommandNode extends Node {

    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            throw new ParseException(name + " is undefined!");
        }
    }

    @Override
    public void execute() {
        switch (name) {
            case "go":
                // 向前一步
                System.out.println("go");
                break;
            case "right":
                // 右转
                System.out.println("right");
                break;
            case "left":
                // 左转
                System.out.println("left");
                break;
            default:
                throw new ParseException(name + " is undefined!");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
