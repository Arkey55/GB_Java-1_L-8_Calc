package ru.geekbrains.lesson_8.listener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    private ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
    private JTextField outField;
    private StringBuilder sb;

    public ButtonListener(JTextField outField) {
        this.outField = outField;
        this.sb = new StringBuilder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();

        if (jButton.getText().equals("C")){
            outField.setText("");
        } else if(jButton.getText().equals("Submit")){
            try {
                Object expResult1 = scriptEngine.eval(outField.getText());
                outField.setText("" + expResult1);
            } catch (ScriptException ex) {
                ex.printStackTrace();
            }
        } else {
            String val = sb.append(outField.getText()).append(jButton.getText()).toString();
            outField.setText(val);
            sb.setLength(0);
        }
    }
}
