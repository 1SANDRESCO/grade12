/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit3;

import javax.swing.SwingUtilities;

/**
 *
 * @author Owner
 */
public class DieGameTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater( 
            new Runnable() {
                public void run() {
                    new DieGame().setVisible(true);
                }
            }
        );
        
  
        
    }
    
}
