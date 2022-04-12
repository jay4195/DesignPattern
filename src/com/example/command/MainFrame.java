package com.example.command;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;

public class MainFrame extends JFrame implements ActionListener {

    // 绘制的历史命令
    private MacroCommand history = new MacroCommand();

    private ColorCommand colorCommand;

    private DrawCanvas canvas = new DrawCanvas(400, 400, history);

    private JButton clearButton = new JButton("clear");

    private TextField textField = new TextField("red");

    private JButton setColorButton = new JButton("set color");

    private JButton undoButton = new JButton("undo");

    public MainFrame(String title) {
        super(title);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command cmd = new DrawCommand(canvas, e.getPoint());
                history.append(cmd);
                cmd.execute();
            }
        });
        clearButton.addActionListener(this);
        undoButton.addActionListener(this);
        setColorButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(undoButton);
        buttonBox.add(textField);
        buttonBox.add(setColorButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        } else if (e.getSource() == setColorButton) {
            Color newColor;
            try {
                Field field = Color.class.getField(textField.getText());
                newColor = (Color)field.get(null);
            } catch (Exception ex) {
                newColor = Color.RED; // Default Color.RED
            }
            Command cmd = new ColorCommand(canvas, newColor);
            history.append(cmd);
            cmd.execute();
        } else if (e.getSource() == undoButton) {
            history.undo();
            canvas.repaint();
        }
    }

    public static void main(String[] args) {
        new MainFrame("Command Pattern Sample");
    }
}
