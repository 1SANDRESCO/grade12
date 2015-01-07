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


public class Human extends Mammal{
    public String language;

    public Human(int age, int numberLegs, boolean gender, boolean alive, boolean hungry, boolean needsToPoo, double weight, String name, String species, String countryOfOrigin) {
        super(age, numberLegs, gender, alive, hungry, needsToPoo, weight, name, species, countryOfOrigin);
        
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    @Override
    public void eat(){
        super.eat();
        System.out.println("Washing hands and brushing teeth now.");
    }
    
}
