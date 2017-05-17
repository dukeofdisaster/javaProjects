/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author joshortiz
 */
public class RouteFrame {

    private int width = 475;
    private int height = 500;
    private JTextArea textField = new JTextArea();
    private Itinerary it = null;
    private JFrame itFrame = new JFrame();
    private NumberFormat costFormat = NumberFormat.getCurrencyInstance();

    public RouteFrame(Itinerary x) {
        it = x;
        itFrame.setSize(width, height);
        itFrame.setVisible(true);
        itFrame.add(textField);
        itFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addTo(String val) {
        textField.append(val);
    }

}
