/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.pt;

public class WorkersTester {
  public static void main(String[] args) {
    Boss b1 = new Boss();
    b1.setName("Steve", "Jobs");
    b1.setAge(46);
    b1.setSalary(1000000);
    b1.hireWorkers(2500);

    HourlyWorker n1 = new HourlyWorker();
    n1.setName("Alice", "Smith");
    n1.setAge(23);
    n1.setMale(false);

    HourlyWorker n2 = new HourlyWorker();
    n2.setName("Henry", "Jones");
    n2.setAge(51);

    //Display the 3 workers manually
    System.out.println(b1);
    System.out.println(n1);
    System.out.println(n2);

    System.out.println("-------------------------------");
    System.out.println("Printing out an array of 3 Person "
      + "objects using a loop");

    //HourlyWorker & Boss objects belong to the Person class
    //They are allowed into an array of Persons
    Person ppl[] = new Person[3];
    ppl[0] = b1;
    ppl[1] = n1;
    ppl[2] = n2;

    for (int i = 0; i < ppl.length; i++) {
      System.out.println(ppl[i]);
    }
  }
}