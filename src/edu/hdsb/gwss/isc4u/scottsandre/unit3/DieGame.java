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
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.Box;
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
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;
    JLabel text1;
    JLabel text2;
    JLabel text3;
    Button button1;


    public DieGame() {
        this.gameWindow = new JFrame("Die Game Version 1");//-------------------WINDOW
        this.gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gameWindow.setSize(800, 600);
        this.gameWindow.setVisible(true);

        this.text1 = new JLabel("Die Game by Scott Sandre");//-------------------Title
        Font comicSans = new Font( "Comic Sans MS", Font.ITALIC, 27 );
        this.text1.setForeground(Color.blue);
        this.text1.setFont(comicSans);
        
        //this.text2 = new JLabel("Test");
        this.text3 = new JLabel("Output:");  
        
        
        this.button1 = new Button("Click here to ROLL");//-------------------Button
        this.button1.setActionCommand("roll");
        this.button1.addActionListener(this);

        this.die1 = new DiePanel(0, 0, 2, Color.BLACK, Color.GREEN);//-------------------Make Die
        this.die2 = new DiePanel(0, 0, 2, Color.BLACK, Color.GREEN);

        this.panel2 = new JPanel();//-------------------inside panel 3
        this.panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        
        this.panel = new JPanel();//-------------------Panel is inside panel2, inside panel3
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        this.panel.setAlignmentX(CENTER_ALIGNMENT);
        this.panel.add(die1);
        this.panel.add(die2);
        //this.panel.add(text2);
        this.panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.panel4 = new JPanel();
        this.panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));
        this.panel4.add(panel);
        
        
        this.panel5 = new JPanel();
        this.panel5.setLayout(new BoxLayout (panel5, BoxLayout.PAGE_AXIS));
        this.panel5.add(text3);
        
        this.panel4.add(panel5);
        
        this.panel2.add(panel4);
        this.panel2.add(button1);
        
        this.panel3 = new JPanel();
        this.panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
        this.panel3.setBackground(Color.yellow);
        
        this.panel3.add(text1);
        this.panel3.add(panel2);

        this.gameWindow.add(this.panel3);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("roll")) {
            System.out.println("Worked");
            this.die1.assignRandomValue();
            this.die2.assignRandomValue();
            this.die1.repaint();
            this.die2.repaint();
        }
        if(this.die1.getValue() == this.die2.getValue()){
            this.text3.setName("Hello");
        }
    }

    public void paintComponent() {

    }

}
