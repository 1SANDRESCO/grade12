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
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    JPanel panel6;
    JPanel panel7;
    JLabel text1;
    JLabel text2;
    JLabel text3;
    JLabel text4;
    JLabel text5;
    JLabel text6;
    
    JLabel counterText;
    JLabel userWinsText;
    JLabel computerWinsText;
    

    Button button1;
    int counter;
    int userCounter;
    int computerCounter;
    //String counterS;

    public DieGame() {
        this.gameWindow = new JFrame("Die Game Version 1");//-------------------WINDOW
        this.gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gameWindow.setSize(700, 380);
        this.gameWindow.setVisible(true);

        this.text1 = new JLabel("Die Game by Scott Sandre");//-------------------Title
        Font comicSans = new Font("Comic Sans MS", Font.ITALIC, 27);
        this.text1.setForeground(Color.blue);
        this.text1.setFont(comicSans);

        this.text2 = new JLabel("Output");
        this.text4 = new JLabel("Number of Rolls: ");
        this.text3 = new JLabel("");
        this.text3.setText("Draw - no outcome");
        this.counterText = new JLabel("0");
        this.computerWinsText = new JLabel("0");
        this.userWinsText = new JLabel("0");
        this.text5 = new JLabel("Number of User Wins: ");
        this.text6 = new JLabel("Number of Computer Wins: ");
        //INTS
        this.counter = 0;
        this.userCounter = 0;
        this.computerCounter = 0;
        // this.counterS = String.valueOf(counter);

        this.button1 = new Button("Click here to ROLL");//-------------------Button
        this.button1.setActionCommand("roll");
        this.button1.addActionListener(this);
        this.button1.setBackground(Color.magenta);

        this.die1 = new DiePanel(0, 0, 2, Color.BLACK, Color.GREEN);//-------------------Make Die
        this.die2 = new DiePanel(0, 0, 2, Color.red, Color.white);

        //--------------------------------------------------------------------------
        this.panel3 = new JPanel();//Biggest
        this.panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
        this.panel3.setBackground(Color.yellow);

        this.panel2 = new JPanel();//Inside Panel 3, bellow text
        this.panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));

        this.panel4 = new JPanel();//inside panel 2, beside Button
        this.panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));

        this.panel5 = new JPanel();//inside of panel 4, contains panel 6 and panel 7 beside each other
        this.panel5.setLayout(new BoxLayout(panel5, BoxLayout.PAGE_AXIS));
        this.panel5.setAlignmentY(TOP_ALIGNMENT);
        
        this.panel = new JPanel();//-------------------Panel is inside panel2, inside panel3
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        this.panel.setAlignmentX(CENTER_ALIGNMENT);
        
        this.panel6 = new JPanel();//in panel 5, to left of panel 7
        this.panel6.setLayout(new BoxLayout(panel6, BoxLayout.LINE_AXIS));
        
        this.panel7 = new JPanel();//in panel 5, to rigth of panel 6
        this.panel7.setLayout(new BoxLayout(panel7, BoxLayout.PAGE_AXIS));
        this.panel7.setAlignmentY(TOP_ALIGNMENT);
        //--------------------------------------------------------------------------
        
        this.panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.panel.add(die1);
        this.panel.add(die2);
        
        this.panel5.add(text4);
        this.panel5.add(text2);
        this.panel5.add(text5);
        this.panel5.add(text6);
        
        this.panel7.add(counterText);
        this.panel7.add(text3);
        this.panel7.add(userWinsText);
        this.panel7.add(computerWinsText);
        
        this.panel6.add(panel5);
        this.panel6.add(panel7);
        
        this.panel4.add(panel);
        this.panel4.add(panel6);

        this.panel2.add(panel4);
        this.panel2.add(button1);

        this.panel3.add(text1);
        this.panel3.add(panel2);
 
        this.gameWindow.add(this.panel3);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("roll")) {
            this.counter++;//Counter Text
            this.counterText.setText(String.valueOf(counter));
            this.counterText.repaint();

            this.die1.assignRandomValue();//Change die
            this.die2.assignRandomValue();
            this.die1.repaint();
            this.die2.repaint();

            if (this.die1.getValue() == this.die2.getValue()) {//Win
                this.text3.setText("You win!");
                this.userCounter++;
                this.userWinsText.setText(String.valueOf(userCounter));
                this.userWinsText.repaint();
                this.text3.repaint();
            } else if (this.die1.getValue() + this.die2.getValue() == 7) {//Lose
                this.text3.setText("You Lose!!");
                this.computerCounter++;
                this.computerWinsText.setText(String.valueOf(computerCounter));
                this.computerWinsText.repaint();
                this.text3.repaint();
            } else {
                this.text3.setText("Draw - no outcome");//No outcome message
                this.text3.repaint();
            }
        }

    }

}
