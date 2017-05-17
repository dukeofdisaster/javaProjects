/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author joshortiz
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quiz extends JPanel {

    private JPanel panel = new JPanel(new FlowLayout());
    private JFrame frame = new JFrame("Meal Calculator");
    private JLabel label1 = new JLabel("Enter entree cost:");
    private JTextField entree = new JTextField(10);
    private JLabel label2 = new JLabel("Tax amount: ");
    private JTextField tax = new JTextField(10);
    private JLabel label3 = new JLabel("Tip:");
    private JTextField tip = new JTextField(10);
    private JButton calculateButton = new JButton("Calculate the Total");

    private JTextArea totalDisplay = new JTextArea();

    public void createGUI() {

        frame.setLayout(new FlowLayout());
        frame.add(panel);

        panel.add(label1);

        panel.add(entree);

        panel.add(label2);

        panel.add(tax);

        panel.add(label3);

        panel.add(tip);

        frame.setSize(500, 500);
        frame.setVisible(true);

        panel.add(calculateButton);
        ActionListener button = new buttonListener();
        calculateButton.addActionListener(button);

        panel.add(totalDisplay);

    }

    private class buttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double entreecost = Double.parseDouble(entree.getText());
            double taxAmount = Double.parseDouble(tax.getText());
            double tipCost = Double.parseDouble(tip.getText());
            double total = (entreecost * taxAmount) + entreecost + tipCost;
            totalDisplay.append("Total: " + total);
        }
    }

    public static void main(String[] args) {
        quiz showME = new quiz();
        showME.createGUI();
    }
}
