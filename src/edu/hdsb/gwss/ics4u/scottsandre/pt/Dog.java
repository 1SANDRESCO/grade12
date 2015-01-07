/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.pt;

/**
 *
 * @author Scott
 */
public class Dog extends Mammal{
    public double tailLength;
    
    public Dog(int age, int numberLegs, boolean gender, boolean alive, boolean hungry, boolean needsToPoo, double weight, String name, String species, String countryOfOrigin) {
        super(age, numberLegs, gender, alive, hungry, needsToPoo, weight, name, species, countryOfOrigin);
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }
    
    @Override
    public void eat(){
        super.eat();
        System.out.println("Licking teeth on bone now");
    }
    
}
