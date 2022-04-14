package com.example.interpreter.lang;

public class RepeatCommandNode extends Node {

    private int number;

    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public void execute(Context context) {
        context.skipToken("repeat");
        // TODO implement of RepeatCommandNode
        number = context.currentNumber();
        context.nextToken();
        for (int i = 0; i < number; i++) {
            commandListNode = new CommandListNode();
            commandListNode.execute(context);
        }
    }

    @Override
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }
}
