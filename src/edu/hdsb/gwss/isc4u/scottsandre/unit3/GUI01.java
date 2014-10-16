/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.isc4u.scottsandre.unit3;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Owner
 */
/**
 */
public class GUI01  {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {

        // WINDOW
        JFrame guiWindow = new JFrame( "Hello World GUI" );
        guiWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        guiWindow.setSize( 400, 600 );

        // FONT
        Font redComicSans = new Font( "Comic Sans MS", Font.ITALIC, 24 );

        // LABEL
        JLabel text = new JLabel( "This is my first GUI" );
        text.setBackground( Color.red );
        text.setForeground( Color.yellow );
        text.setFont( redComicSans );

        // LABEL 2
        JLabel text2 = new JLabel( "This is my second component. " );
        text2.setBackground( Color.GREEN );
        text2.setForeground( Color.PINK );
        text2.setFont( redComicSans );
        
        //Label 3
        JLabel text3 = new JLabel("Third component" );
        

        // ADD LABEL 2 to FRAME
        guiWindow.add( text2 );
        guiWindow.add(text3);

        // MAKE VISABLE
        guiWindow.setVisible( true );

    }

}  

