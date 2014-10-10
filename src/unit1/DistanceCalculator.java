/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unit1;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class DistanceCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String place1Name;
        String place2Name;
        double lat1, lat2, long1, long2;
        double distance;
        
        System.out.print("Place 1 Name:");
        place1Name = input.nextLine();
        System.out.print("Latitude of " + place1Name + ": ");
        lat1 = input.nextDouble();
        System.out.print("Longtiude of " + place1Name + ": ");
        long1 = input.nextDouble();
        
  
        
        
        System.out.print("Place 2 Name:");
        place2Name = input.nextLine();
        System.out.print("Latitude of " + place2Name + ": ");
        lat2 = input.nextDouble();
        System.out.print("Longtiude of " + place2Name + ": ");
        long2 = input.nextDouble();
        
        distance = 6378.8 * Math.acos(Math.sin(lat1/57.29577951)) * Math.sin(lat2/57.29577951) + Math.cos(lat1/57.29577951) * Math.cos(lat2/57.29577951) * Math.cos(long2/57.29577951 - long1/57.29577951);
        
        System.out.println("The distance from " + place1Name + " to " + place2Name + " is: " + distance + " kilometers as the crow flies.");
        //6378.8 * arccos[sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon2 - lon1)]
    }
    
}
