/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit3;

/**
 *
 * @author Owner
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class RandomStringsPanel extends JPanel {

   private String message;  // The message to be displayed.  This can be set in
                            // the constructor.  If no value is provided in the
                            // constructor, then the string "Java!" is used.
   
   private Font font1, font2, font3, font4, font5;  // The five fonts.
   
   /**
    * Default constructor creates a panel that displays the message "Java!".
    */
   public RandomStringsPanel() {
      this(null);  // Call the other constructor, with parameter null.
   }
   
   /**
    * Constructor creates a panel to display 25 copies of a specified message.
    * @param messageString The message to be displayed.  If this is null,
    * then the default message "Java!" is displayed.
    */
   public RandomStringsPanel(String messageString) {
   
      message = messageString;
      if (message == null)
          message = "Java!";
         
      font1 = new Font("Serif", Font.BOLD, 14);
      font2 = new Font("SansSerif", Font.BOLD + Font.ITALIC, 24);
      font3 = new Font("Monospaced", Font.PLAIN, 30);
      font4 = new Font("Dialog", Font.PLAIN, 36);
      font5 = new Font("Serif", Font.ITALIC, 48);
      
      setBackground(Color.BLACK);
      
   }
   
   /**
    * The paintComponent method is responsible for drawing the content of the panel.
    * It draws 25 copies of the message string, using a random color, font, and
    * position for each string.
    */
   public void paintComponent(Graphics g) {
   
      super.paintComponent(g);  // Call the paintComponent method from the 
                                // superclass, JPanel.  This simply fills the 
                                // entire panel with the background color, black.
      
      int width = getWidth();
      int height = getHeight();
     
      for (int i = 0; i < 25; i++) {

          // Draw one string.  First, set the font to be one of the five
          // available fonts, at random.  

          int fontNum = (int)(5*Math.random()) + 1;
          switch (fontNum) {
             case 1:
                g.setFont(font1);
                break;
             case 2:
                g.setFont(font2);
                break;
             case 3:
                g.setFont(font3);
                break;
             case 4:
                g.setFont(font4);
                break;
             case 5:
                g.setFont(font5);
                break;
           } // end switch

           // Set the color to a bright, saturated color, with random hue.

           float hue = (float)Math.random();
           g.setColor( Color.getHSBColor(hue, 1.0F, 1.0F) );

           // Select the position of the string, at random.

           int x,y;
           x = -50 + (int)(Math.random()*(width+40));
           y = (int)(Math.random()*(height+20));

           // Draw the message.

           g.drawString(message,x,y);

      } // end for
  
   } // end paintComponent()
   

}  // end class RandomStringsPanel

