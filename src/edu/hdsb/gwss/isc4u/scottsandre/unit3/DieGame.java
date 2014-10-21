/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.isc4u.scottsandre.unit3;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class DieGame extends JFrame implements ActionListener {

    //WINDOW

    JFrame gameWindow;

    //DICE
    DiePanel die1;
    DiePanel die2;
    JPanel panel;
    JPanel panel2;
    JLabel text1;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    public DieGame() {
        this.gameWindow = new JFrame("Die Game Version 1");//window
        this.gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gameWindow.setSize(800, 600);
        this.gameWindow.setVisible(true);

        this.text1 = new JLabel("Title 01");
        this.button1 = new Button("Test One");
        this.button1.setActionCommand("roll");
        this.button1.addActionListener(this);
        

        this.die1 = new DiePanel(0, 0, 2, Color.BLACK, Color.GREEN);
        this.die2 = new DiePanel(0, 0, 2, Color.RED, Color.GRAY);

        this.panel2 = new JPanel();
        this.panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        this.panel = new JPanel();

        this.panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        this.panel.setAlignmentX(CENTER_ALIGNMENT);
        this.panel.add(die1);
        this.panel.add(die2);
        this.panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.panel2.add(panel);
        this.panel2.add(button1);

        //this.panel = new JPanel( new BorderLayout() );
        //this.panel.add(die1, BorderLayout.EAST);
        //this.panel.add(die2, BorderLayout.WEST);
        this.gameWindow.add(this.panel2);

        //this.pack()  
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("roll")) {
            System.out.print("Worked");
            this.die1 = new DiePanel(0, 0, 2, Color.BLACK, Color.GREEN);
            this.die2 = new DiePanel(0, 0, 2, Color.RED, Color.GRAY);
             this.panel.add(die1);
        this.panel.add(die2);
        this.panel2.add(button1);
        }
    }

    public void paintComponent() {

    }

    //action listener lisstens/waits for action
    //action performed
    //layout manager
    //diePanel has two Die inside
    //window.add(DiePanel);
    //window, die 1, die2, JPanel dicePanel = new JPanel (new Flow Layout (FlowLayout.CENTRE, 15 , 15), 
    //dicePanel.setlayoutManager,dicePanel.add(die01)
    //button
    //layout opf window in constructor
    //window.add(dicePanel, borderlayout)
    //window.setLayout(borderlayout)
    //button.setSize, button.setText, button.addActionListener(rg);
    //
}
