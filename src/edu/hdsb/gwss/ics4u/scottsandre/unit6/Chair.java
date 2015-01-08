/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

import java.util.Objects;

/**
 *
 * @author Scott
 */
public class Chair {
    private int weight;
    private static int numberCreated = 0;
    private int serialNumber;
    private double cost;
    private String wood;
    
    public Chair(){
        this(0, 0, null);
    }
    
    public Chair(int weight, double cost, String wood){
        this.setWeight(weight);
        this.setCost(cost);
        this.setWood(wood);
        this.setSerialNumber(numberCreated);
        numberCreated++;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.serialNumber;
        return hash;
    }


    @Override
    public String toString() {
        if (this != null){
        return "Chair{" + "weight=" + weight + ", cost=" + cost + ", wood=" + wood + ", serialNumber= " + serialNumber + '}';
        } else {
            return "NULL";
        }
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    private void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
    

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }
    

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
    
    
}
