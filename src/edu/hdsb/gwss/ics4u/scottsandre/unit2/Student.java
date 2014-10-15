/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit2;

/**
 *
 * @author 1SANDRESCO
 */
public class Student {
    //object variables
    private String firstName;
    private String lastName;
    private int age;
    private int OEN;
    private double average;
    private double height;

    public Student() {//empty, one has unique identifier for object, minimum
        System.out.println("Student object created");
        
    }
    
    public Student(String name) {
        this();
        System.out.println("Student object created: " + name);
        
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void setOEN(int OEN) {
        this.OEN = OEN;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getOEN() {
        return OEN;
    }

    public double getAverage() {
        return average;
    }

    public double getHeight() {
        return height;
    }
    
    
}
