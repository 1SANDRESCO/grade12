/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 */
public class Inventory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        StockItem item1 = new StockItem( "Sweatshirt", 59.99 );
        StockItem item2 = new StockItem( "Ball Cap", 19.99 );
        StockItem item3 = new StockItem( "Team Jacket", 119.99 );
        
        //
        // WRITE OBJECTS
        //
        
        // OUTPUT STREAM & OBJECT OUTPUT STREAM
        File file = new File( "inventory.dat" );
        FileOutputStream fos = new FileOutputStream( file );
        ObjectOutputStream output = new ObjectOutputStream( fos );
        
        // WRITE OBJECT
        output.writeObject( item1 );
        output.writeObject( item2 );
        output.writeObject( item3 );
        
        // CLOSE FILE
        output.close();
        
        //
        // READ OBJECTS
        //
        
        // INPUT STREAM & OBJECT INPUT STREAM
        FileInputStream fis = new FileInputStream( file );
        ObjectInputStream input = new ObjectInputStream( fis );        
        
        StockItem saleItem1 = (StockItem) input.readObject();
        StockItem saleItem2 = (StockItem) input.readObject();
        StockItem saleItem3 = (StockItem) input.readObject();
        
        System.out.println( saleItem1.toString() );
        System.out.println( saleItem2.toString() );
        System.out.println( saleItem3.toString() );

    }

}