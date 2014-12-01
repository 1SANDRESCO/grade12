/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

/**
 *
 * @author 1SANDRESCO
 */
public class Person {
    private int ID;
    private String firstName;
    private String lastName;
    private int telNum;
    
    public Person() {

    }

    public Person(int ID, int telNum, String firstName, String lastName) {

    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        if (ID > -1) {
            this.ID = ID;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTelNum() {
        return telNum;
    }

    public void setTelNum(int telNum) {
        this.telNum = telNum;
    }
    
}
