/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit4;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 1SANDRESCO
 */
public class SierpinskiTriangle extends JPanel {
    
    public static final int FRAME_LENGTH = 900;

    public SierpinskiTriangle(){
        
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
    }
    
     public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(FRAME_LENGTH, FRAME_LENGTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Sierpinski Triangle");
        window.setVisible(true);
        window.setResizable(false);  

    }
}
