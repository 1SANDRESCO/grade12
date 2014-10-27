package edu.hdsb.gwss.ics4u.scottsandre.unit3;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.hdsb.gwss.isc4u.scottsandre.unit3;
//
//import java.awt.Color;
//import javax.swing.JPanel;
//
///**
// *
// * @author 1SANDRESCO
// */
//public class Die extends JPanel {
//   // public static final int PIXEL = SIZE_CONSTANT / 10;
//    //public static final int CIRCLE_DIAMETER = 2 * PIXEL;
//    public static final int SIZE_CONSTANT = 100;
//    public static final int MIN_VALUE = 1;
//    public static final int MAX_VALUE = 6;
//    public static final int MAX_X = JPanel.WIDTH;
//    public static final int MAX_Y = JPanel.HEIGHT;
//    public static final int DEFAULT_XY = 0;
//    public static final Color DEFAULT_COLOUR = Color.RED;
//    private int value;
//    private Color colour;
//    private int sizeFactor;
//    private int topLeftX;
//    private int topLeftY;
//    
//    public Die (){
//     this((int) (Math.random() * MAX_VALUE) + 1, DEFAULT_XY, DEFAULT_XY, 1, DEFAULT_COLOUR.red );
//    }
//    
//    public Die (int value, int xLoc, int yLoc, int sizeFactor, Color colour){
//    if (value >= MIN_VALUE && value <= MAX_VALUE) {
//        this.value = value;
//    }
//    this.topLeftX = xLoc;
//    this.topLeftY = yLoc;
//    this.sizeFactor = sizeFactor;
//    this.colour = colour;
//    System.out.println("Die Created!");
//    }
//    
//    public void setValue(int value) {
//        if (value >= MIN_VALUE && value <= MAX_VALUE) {
//            System.out.println("setValue: value set to " + value);
//            this.value = value;
//        } else {
//            System.out.println("value not valid");
//
//        }
//    }
//
//    public void setColour(Color colour) {
//        this.colour = colour;
//    }
//
//    public void setSizeFactor(int sizeFactor) {
//        if (sizeFactor > 0) {
//            System.out.println("setSizeFactor: sizefactor set to " + sizeFactor);
//            this.sizeFactor = sizeFactor;
//        }else {
//            System.out.println("Size Factor not valid");
//        }
//    }
//
//    public void setTopLeftX(int topLeftX) {
//        if (topLeftX >= 0 ) { // && topLeftX < MAX_X - (SIZE_CONSTANT * sizeFactor
//            System.out.println("setTopLeftX: xValue set to " + topLeftX);
//            this.topLeftX = topLeftX;
//        } else {
//            System.out.println("X value not valid");
//        }
//    }
//
//    public void setTopLeftY(int topLeftY) {
//        if (topLeftY >= 0 ) { // && topLeftY < MAX_Y - (SIZE_CONSTANT * sizeFactor
//            System.out.println("setTopLeftX: xValue set to " + topLeftY);
//            this.topLeftY = topLeftY;
//        } else {
//            System.out.println("X value not valid");
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Die{" + "value=" + value + ", colour=" + colour + ", sizeFactor=" + sizeFactor + ", topLeftX=" + topLeftX + ", topLeftY=" + topLeftY + '}';
//    }
//    
//    
//
//    public int getValue() {
//        return value;
//    }
//
//    public Color getColour() {
//        return colour;
//    }
//
//    public int getSizeFactor() {
//        return sizeFactor;
//    }
//
//    public int getTopLeftX() {
//        return topLeftX;
//    }
//
//    public int getTopLeftY() {
//        return topLeftY;
//    }
//    
//    public void paintComponent(Graphics g){
//    super.paintComponent(g);
//    g.setColor(this.getColour());
//    g.fillRect(this.getTopLeftX(), this.getTopLeftY(), this.getSizeFactor() * SIZE_CONSTANT, this.getSizeFactor() * SIZE_CONSTANT);
//    }
//    private void dot (Graphics g, int row, int col){
//        g.setColor(Color.WHITE);
//    int y = this.getTopLeftX() + (row * 3 * PIXEL) - 2* PIXEL;
//    int x = this.getTopLeftY() + (col * 3 * PIXEL) - 2* PIXEL;
//    g.fillOval(x, y, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
//    }
//    
////    public void drawValue(){
////    if (this.getValue() != 1){ // 2 3 4 5 6
////        dot(g, 1, 1); //top Left
////        dot(g, 3, 3,); // bottom right
////    }
////    if (this.getValue() % 2 == 1){//odd number // 1 3 5
////        dot (g, 2, 2); // midle
////    }
////    if (this.getValue() > 3){ // 4 5 6
////        dot (g, 1, 3);//top right
////        dot (g, 3, 1);//bottom left
////    }
////    if (this.getValue() == 6){ // 6
////        dot (g, 2, 1);//middle left
////        dot (g, 2, 3);//middle right
////    }
//    
//   // }
//
//    
//    
//    
//
//}
