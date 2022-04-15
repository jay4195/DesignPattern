package com.example.interpreter.lang;

import com.example.interpreter.gui.DrawCanvas;

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
        System.out.println(name);
        switch (name) {
            case "go":
                // 向前一步
                DrawCanvas.getInstance().go();
                break;
            case "right":
            case "left":
                DrawCanvas.getInstance().changeDirection(name);
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
