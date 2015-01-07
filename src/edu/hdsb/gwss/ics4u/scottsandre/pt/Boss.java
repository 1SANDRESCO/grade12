/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.pt;

public class Boss extends Person {
  private int salary;
  private int numEmployees;

  public Boss() {
    //Call the default constructor from Person
    super();
    this.salary = 0;
    this.numEmployees = 0;
  }

  public void hireWorkers(int n) {
    this.numEmployees += n;
  }

  public void fireWorkers(int n) {
    this.numEmployees -= n;
  }

  public void setSalary(int s) {
    this.salary = s;
  }

  public String toString() {
    String output = "";
    output += super.toString();
    output += "Salary: " + salary + "\n";
    output += "Employees: " + numEmployees + "\n";
    return output;
  }
}