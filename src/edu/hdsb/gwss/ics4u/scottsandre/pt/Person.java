/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.pt;

public class Person {
  private String fName, lName;
  private int age;
  private boolean male;

  public Person() {
    this.fName = "John";
    this.lName = "Doe";
    this.age = 21;
    this.male = true;
  }

  public String getName() {
    return fName + " " + lName;
  }

  public void setName(String newFName, String newLName) {
    this.fName = newFName;
    this.lName = newLName;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int newAge) {
    this.age = newAge;
  }

  public boolean getMale() {
    return this.male;
  }

  public void setMale(boolean isMale) {
    this.male = isMale;
  }

  public String toString() {
    String output = "";
    output += "Name: " + fName + " " + lName + "\n";
    if (male) {
      output += "Sex: Male\n";
    } else {
      output += "Sex: Female\n";
    }
    output += "Age: " + age + "\n";
    return output;
  }
}