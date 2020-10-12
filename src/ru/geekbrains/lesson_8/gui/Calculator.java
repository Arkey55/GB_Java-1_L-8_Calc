package ru.geekbrains.lesson_8.gui;

import ru.geekbrains.lesson_8.listener.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    private JFrame mainFrame;
    public Calculator() {
        mainFrame = new JFrame();

        mainFrame.setTitle("Calculator");
        mainFrame.setBounds(700, 300, 300, 500);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //поля кнопок и текста
        mainFrame.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(4, 4));
        JPanel right = new JPanel();
        right.setLayout(new GridLayout(4, 1));


        //поле вывода тектса
        final JTextField outField = new JTextField();
        outField.setEditable(false);
        top.add(outField, BorderLayout.CENTER);

        ButtonListener btnListener = new ButtonListener(outField);

        // цифровые кнопки
        for (int i = 0; i <= 9; i++) {
            JButton digitBtn = new JButton(String.valueOf(i));
            bottom.add(digitBtn);
            digitBtn.addActionListener(btnListener);
        }

        // кнопки действий
        JButton plusBtn = new JButton("+");
        plusBtn.addActionListener(btnListener);
        right.add(plusBtn);

        JButton minusBtn = new JButton("-");
        minusBtn.addActionListener(btnListener);
        right.add(minusBtn);

        JButton multiplyBtn = new JButton("*");
        multiplyBtn.addActionListener(btnListener);
        bottom.add(multiplyBtn);

        JButton divisionBtn = new JButton("/");
        divisionBtn.addActionListener(btnListener);
        bottom.add(divisionBtn);

        JButton cancelBtn = new JButton("C");
        cancelBtn.addActionListener(btnListener);
        right.add(cancelBtn);

        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(btnListener);
        right.add(submitBtn);

        //отображение
        mainFrame.add(top, BorderLayout.NORTH);
        mainFrame.add(bottom, BorderLayout.CENTER);
        mainFrame.add(right, BorderLayout.EAST);
        mainFrame.setVisible(true);
    }
}
