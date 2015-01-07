/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

/**
 *
 * @author Scott
 */
public class Chair {
    private int weight;
    private double cost;
    private String wood;
    
    public Chair(){
        this(0, 0, null);
    }
    
    public Chair(int weight, double cost, String wood){
        this.setWeight(weight);
        this.setCost(cost);
        this.setWood(wood);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.weight;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        return hash;
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
