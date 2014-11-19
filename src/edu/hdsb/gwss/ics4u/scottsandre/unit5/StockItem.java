/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit5;

import java.io.Serializable;

/**
 */
public class StockItem implements Serializable {
    
    private String itemName;
    private double cost;

    public StockItem( String itemName, double cost ) {
        this.itemName = itemName;
        this.cost = cost;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName( String itemName ) {
        this.itemName = itemName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost( double cost ) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "StockItem{" + "itemName=" + itemName + ", cost=" + cost + '}';
    }        

}