/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit2;

import java.util.ArrayList;

/**
 *
 * @author 1SANDRESCO
 */
public class ThreeObjectsClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ThreeObjects car1 = new ThreeObjects();
        car1.setSerialNumber("ABC123");
        car1.setTypeName("Veneno");
        car1.setClassName("Lambourghini");
        car1.setMaxSpeed(350);
        car1.setCost(300000);
        
        System.out.println(car1.getCost());
        System.out.println(car1.toString());        
        ThreeObjects car2 = new ThreeObjects();
        car2.setSerialNumber("DEF456");
        car2.setTypeName("Civic");
        car2.setClassName("Honda");
        car2.setMaxSpeed(190);
        car2.setCost(19000);
        
        ThreeObjects car3 = new ThreeObjects();
        car3.setSerialNumber("GHI789");
        car3.setTypeName("Edge");
        car3.setClassName("Ford");
        car3.setMaxSpeed(215);
        car3.setCost(34000);
        
        ThreeObjects car4 = new ThreeObjects();
        car4.setSerialNumber("JKL999");
        car4.setTypeName("Venom");
        car4.setClassName("Hennessey");
        car4.setMaxSpeed(450);
        car4.setCost(1000000);
   
        ThreeObjects car5 = new ThreeObjects();
        car5.setSerialNumber("JKL999");
        car5.setTypeName("Veyron");
        car5.setClassName("Bugatti");
        car5.setMaxSpeed(450);
        car5.setCost(977000);
        
        ArrayList allCars = new ArrayList();
        allCars.add(car1);
        allCars.add(car2);
        allCars.add(car3);
        allCars.add(car4);
        allCars.add(car5);
        
        System.out.println();
        System.out.println();
                
        
        for (int i = 0; i < allCars.size(); i++){
            System.out.println(allCars.get(i));
        }
    }
    
}
