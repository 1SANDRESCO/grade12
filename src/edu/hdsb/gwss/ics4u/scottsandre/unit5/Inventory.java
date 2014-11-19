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
import java.util.ArrayList;

/**
 */
public class Inventory {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        ArrayList <StockItem> allItems = new ArrayList <> ();
        
        StockItem item1 = new StockItem("Sweatshirt", 59.99);
        StockItem item2 = new StockItem("Ball Cap", 19.99);
        StockItem item3 = new StockItem("Team Jacket", 119.99);
        StockItem item4 = new StockItem("Hundo Swag", 45.12);
        StockItem item5 = new StockItem("Awesome Car", 1231.22);
        
        allItems.add(item1);
        allItems.add(item2);
        allItems.add(item3);
        allItems.add(item4);
        allItems.add(item5);

        //
        // WRITE OBJECTS
        //
        // OUTPUT STREAM & OBJECT OUTPUT STREAM
        File file = new File("inventory.dat");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream output = new ObjectOutputStream(fos);

        // WRITE OBJECT
        for (int i = 0; i < allItems.size(); i++){
            output.writeObject( allItems.get(i));
        }
        
//        output.writeObject(item1);
//        output.writeObject(item2);
//        output.writeObject(item3);
//        output.writeObject(item4);

        // CLOSE FILE
        output.close();

        //
        // READ OBJECTS
        //
        // INPUT STREAM & OBJECT INPUT STREAM
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream input = new ObjectInputStream(fis);
        
        for (int i = 0; i < allItems.size(); i++){
            System.out.println("#" + (i + 1) + ": " + input.readObject().toString());
        }
        

//        StockItem saleItem1 = (StockItem) input.readObject();
//        StockItem saleItem2 = (StockItem) input.readObject();
//        StockItem saleItem3 = (StockItem) input.readObject();
//        StockItem saleItem4 = (StockItem) input.readObject();
//
//        System.out.println(saleItem1.toString());
//        System.out.println(saleItem2.toString());
//        System.out.println(saleItem3.toString());
//        System.out.println(saleItem4.toString());

        System.out.println(file.length());

    }

}
