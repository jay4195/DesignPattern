package com.example.interpreter.gui;

import com.example.interpreter.lang.Context;
import com.example.interpreter.lang.Node;
import com.example.interpreter.lang.ParseException;
import com.example.interpreter.lang.ProgramNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {

    private DrawCanvas canvas = new DrawCanvas(600, 600);

    private JButton startButton = new JButton("start");

    private TextField textField = new TextField();

    public MainFrame(String title) {
        super(title);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        startButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(textField);
        buttonBox.add(startButton);
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
            // TODO implement of startButton
            Node node = new ProgramNode();
            try {
                node.execute(new Context(textField.getText()));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MainFrame("Interpreter Pattern Sample");
    }

}
