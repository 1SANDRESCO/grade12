/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.isc4u.scottsandre.unit3;

import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class DieGame extends JFrame { //implements ActionListener{
    //WINDOW
    JFrame gameWindow;
    
    //DICE
    DiePanel die1;   
    DiePanel die2;
    JPanel panel;
    JLabel text1;
    Button button1 ;
    
    public DieGame(){
        this.gameWindow = new JFrame();//window
        this.gameWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.gameWindow.setSize( 800, 600 );
        //this.gameWindow.setVisible(true);
        //this.gameWindow.setLayout();
        
        this.die1 = new DiePanel();
        this.die2 = new DiePanel();
        this.panel = new JPanel();
        this.text1 = new JLabel("Title 01");
        
        this.panel.setLayout(new BorderLayout());
        this.panel.add(this.text1,BorderLayout.PAGE_START );
        this.panel.add(this.die1, BorderLayout.LINE_START);
        this.panel.add(this.die2, BorderLayout.LINE_END);
        
        
        this.pack();
        
        
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
    
    public void paintComponent() {

    }
}
