/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.pt;

public class HourlyWorker extends Person {
  private double wagePerHour;
  private double hoursPerWeek;

  public HourlyWorker() {
    //Call the default constructor from Person
    super();
    this.wagePerHour = Math.random() * 10.0 + 15.0;
    this.hoursPerWeek = 37.0;
  }

  public void displayCheque() {
    System.out.println("Cheque: "+(wagePerHour*hoursPerWeek));
  }

  public String toString() {
    String output = "";
    output += super.toString();
    output += "Wage: " + wagePerHour + "\n";
    output += "Hours Per Week: " + hoursPerWeek + "\n";
    return output;
  }
}