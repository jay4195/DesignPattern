package com.example.interpreter.gui;

import com.example.interpreter.lang.Context;
import com.example.interpreter.lang.Node;
import com.example.interpreter.lang.ProgramNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Interpreter
 * 解释器模式
 */
public class MainFrame extends JFrame implements ActionListener {

    // 绘制的历史命令
    private DrawCanvas canvas;

    private TextField textField = new TextField();

    private JButton startButton = new JButton("start");

    private JButton clearButton = new JButton("clear");


    public MainFrame(String title) {
        super(title);
        canvas = DrawCanvas.getInstance();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        startButton.addActionListener(this);
        clearButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(textField);
        buttonBox.add(startButton);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            // press start button
            canvas.init();
            Node node = new ProgramNode();
            node.parse(new Context(textField.getText()));
            node.execute();
        } else if (e.getSource() == clearButton) {
            canvas.repaint();
        }
    }

    public static void main(String[] args) {
        new MainFrame("Interpreter Pattern Sample");
    }
}
