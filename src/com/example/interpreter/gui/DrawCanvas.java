package com.example.interpreter.gui;

import java.awt.*;

public class DrawCanvas extends Canvas {

    private Color color = Color.cyan;

    private int x, y;

    private int direction;

    private static int canvasWidth = 600;

    private static int canvasHeight = 600;

    private static int step = 20;

    private static DrawCanvas canvas;

    private DrawCanvas() {
    }

    public static DrawCanvas getInstance() {
        if (canvas == null) {
            canvas = new DrawCanvas(canvasWidth, canvasHeight);
            return canvas;
        }
        return canvas;
    }

    private DrawCanvas(int width, int height) {
        setSize(width, height);
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
    }

    public void init() {
        Graphics g = getGraphics();
        g.setColor(color);
        direction = 1;
        x = canvasWidth / 2;
        y = canvasHeight / 2;
    }

    public void changeDirection(String name) {
        if ("right".equals(name)) {
            direction++;
            if (direction == 5) {
                direction = 1;
            }
        } else {
            direction--;
            if (direction == 0) {
                direction = 4;
            }
        }
    }

    public void go() {
        Graphics g = getGraphics();
        int xPlus = 0;
        int yPlus = 0;
        switch (direction) {
            case 1:
                // up
                yPlus = step;
                break;
            case 2:
                // right
                xPlus = step;
                break;
            case 3:
                // down
                yPlus = -step;
                break;
            case 4:
                // left
                xPlus = -step;
                break;
        }
        g.drawLine(x, y, x + xPlus, y + yPlus);
        x += xPlus;
        y += yPlus;
        g.fillOval(x, y, 5, 5);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }

}
