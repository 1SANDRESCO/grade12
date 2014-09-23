/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit02;

/**
 *
 * @author 1SANDRESCO
 */
public class ThreeObjects {
    private String serialNumber;
    private String typeName;
    private String className;
    private String manufacturedLocation;
    private int cost;
    private int horsePower;
    private int maxSpeed;
    private double zeroToSixtyTime;
    private boolean streetLegal;
    private boolean hasAirBags;
    
    public ThreeObjects(){
        
    }
    
    public ThreeObjects(String serialNumber, String typeName, String className){
        this.serialNumber = serialNumber;
        this.className = className;
        this.typeName = typeName;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setManufacturedLocation(String manufacturedLocation) {
        this.manufacturedLocation = manufacturedLocation;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setZeroToSixtyTime(double zeroToSixtyTime) {
        this.zeroToSixtyTime = zeroToSixtyTime;
    }

    public void setStreetLegal(boolean streetLegal) {
        this.streetLegal = streetLegal;
    }

    public void setHasAirBags(boolean hasAirBags) {
        this.hasAirBags = hasAirBags;
    }
    

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getClassName() {
        return className;
    }

    public String getManufacturedLocation() {
        return manufacturedLocation;
    }

    public int getCost() {
        return cost;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getZeroToSixtyTime() {
        return zeroToSixtyTime;
    }

    public boolean isStreetLegal() {
        return streetLegal;
    }

    public boolean isHasAirBags() {
        return hasAirBags;
    }

    @Override
    public String toString() {
        return "ThreeObjects{" + "serialNumber=" + serialNumber + ", typeName=" + typeName + ", className=" + className + ", cost=" + cost + ", maxSpeed=" + maxSpeed + '}';
    }

    
    
    
    
}
