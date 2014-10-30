import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1SANDRESCO
 */
public class SierpinskiTriangle extends JPanel {
    
    public static final int FRAME_HEIGHT = 800;
    public static final int FRAME_WIDTH = 800;
    public static double lineLength = 600.0;
    public JFrame window;

    public SierpinskiTriangle() {
        init();
    }

    public void init() {
         
    }
    
    public void drawTriangle(Graphics g, int topX, int topY, double sideLength){
    g.setColor(Color.black);
   
    g.drawLine(topX, topY, topX - (int) (0.5 * sideLength), topY + (int) (Math.sqrt( Math.pow(sideLength, 2) - Math.pow(sideLength * 0.5, 2))));
    g.drawLine(topX, topY, topX + (int) (0.5 * sideLength), topY + (int) (Math.sqrt( Math.pow(sideLength, 2) - Math.pow(sideLength * 0.5, 2))));    
    g.drawLine(topX - (int) (0.5 * sideLength), topY + (int) (Math.sqrt( Math.pow(sideLength, 2) - Math.pow(sideLength * 0.5, 2))), topX + (int) (0.5 * sideLength), topY + (int) (Math.sqrt( Math.pow(sideLength, 2) - Math.pow(sideLength * 0.5, 2))));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTriangle(g,(int) (FRAME_WIDTH / 2), 0, 700 );
        
    }
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("SierpinskiTriangle!");
        window.setSize(FRAME_HEIGHT, FRAME_WIDTH);
        window.setResizable(false);
        window.getContentPane().setBackground(Color.yellow);
      
        
        SierpinskiTriangle tri = new SierpinskiTriangle();
        
        window.add( tri );
        
        window.setVisible(true);
        
    }
}
