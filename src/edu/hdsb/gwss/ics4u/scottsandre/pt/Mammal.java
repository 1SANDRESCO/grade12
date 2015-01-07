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
public class Mammal {
    private static int numberMammals = 0;
    private int age;
    private int numberLegs;
    private boolean male;
    private boolean alive;
    private boolean hungry;
    private boolean needsToPoo;
    private double weight;  
    private String name;
    private String species;
    private String countryOfOrigin;
    
    public Mammal(int age, int numberLegs, boolean gender, boolean alive, boolean hungry, boolean needsToPoo, double weight, String name, String species, String countryOfOrigin){
        this.setAge(age);
        this.setNumberLegs(numberLegs);
        this.setMale(gender);
        
        
    }
    
    public void eat(){
        this.hungry = false;
        this.needsToPoo = true;
    }
    
    public void poo(){
        this.hungry = true;
        this.needsToPoo = false;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberLegs() {
        return numberLegs;
    }

    public void setNumberLegs(int numberLegs) {
        this.numberLegs = numberLegs;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public boolean isNeedsToPoo() {
        return needsToPoo;
    }

    public void setNeedsToPoo(boolean needsToPoo) {
        this.needsToPoo = needsToPoo;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
    
    
            
    
}
