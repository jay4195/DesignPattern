package com.example.interpreter.lang;

import java.util.ArrayList;
import java.util.List;

public class CommandListNode extends Node {

    private List<Node> list = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing 'end'");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public void execute() {
        for (Node n : list) {
            n.execute();
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
