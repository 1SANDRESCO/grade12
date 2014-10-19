/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.isc4u.scottsandre.unit3;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.*;
/**
 *
 * @author 1SANDRESCO
 */
public class DiePanel extends Die {

    public static final int PIXEL = SIZE_CONSTANT / 10;
    public static final int CIRCLE_DIAMETER = 2 * PIXEL;
    
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(this.getColour());
    g.fillRect(this.getTopLeftX(), this.getTopLeftY(), this.getSizeFactor() * SIZE_CONSTANT, this.getSizeFactor() * SIZE_CONSTANT);
    }
    private void dot (Graphics g, int row, int col){
        g.setColor(Color.WHITE);
    int y = this.getTopLeftX() + (row * 3 * PIXEL) - 2* PIXEL;
    int x = this.getTopLeftY() + (col * 3 * PIXEL) - 2* PIXEL;
    g.fillOval(x, y, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
    }
    
//    public void drawValue(){
//    if (this.getValue() != 1){ // 2 3 4 5 6
//        dot(g, 1, 1); //top Left
//        dot(g, 3, 3,); // bottom right
//    }
//    if (this.getValue() % 2 == 1){//odd number // 1 3 5
//        dot (g, 2, 2); // midle
//    }
//    if (this.getValue() > 3){ // 4 5 6
//        dot (g, 1, 3);//top right
//        dot (g, 3, 1);//bottom left
//    }
//    if (this.getValue() == 6){ // 6
//        dot (g, 2, 1);//middle left
//        dot (g, 2, 3);//middle right
//    }
    
   // }
    
    

}
