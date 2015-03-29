/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Scott
 */
public class AssassinsGame {

    /**
     * @param args the command line arguments
     */
    public static RandomAccessFile file;
    public static ArrayList<AssassinStudent> allStudents = new ArrayList<>();
    public static int numberPlayers = 68;
    public static int[] targets = new int[numberPlayers];
    private static char[] readInName = new char[AssassinStudent.NAME_LENGTH];
    private static char[] readInTarget = new char[AssassinStudent.NAME_LENGTH];
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Scott, if you have added a new person, delete the current list and change the number of players");

        //make student record class (name, number)
        //make all of the student records 
        // write to file (random access file)
        // be able to display them all
        //assign numbers (int array ?)
        //print out number, kid, assigned target number, assigned target name
        openFile();//adds names to File if empty, then creates it
        assignRandomTargets();
        displayInfo();

    }

    public static void displayInfo() throws IOException {
        int h;
        int targetNumber;
        String pName, tName;
        for (long i = 0; i < numberPlayers; i++) {
            
            file.seek(i * AssassinStudent.RECORD_SIZE);//for person
            readInName = new char[AssassinStudent.NAME_LENGTH];
            for (int x = 0; x < AssassinStudent.NAME_LENGTH; x++) {
                readInName[x] = file.readChar();
            }
            pName = new String(readInName);
            //h = file.readInt();//h should be i + 1
            targetNumber = targets[ (int) i];
            
            file.seek( (targetNumber-1) * AssassinStudent.RECORD_SIZE);//for target
            readInTarget = new char[AssassinStudent.NAME_LENGTH];
            for (int x = 0; x < AssassinStudent.NAME_LENGTH; x++) {
                readInTarget[x] = file.readChar();
            }
            tName = new String (readInTarget);
            System.out.println( (i + 1) + " : " + pName + " ---> " + targetNumber + " : " + tName);
        }
    }

    public static void assignRandomTargets() {
        int r;

        int[] freeNumbers = new int[numberPlayers];
        for (int i = 1; i <= numberPlayers; i++) {
            freeNumbers[i - 1] = i;
        }

        for (int i = 1; i <= numberPlayers; i++) {
            r = (int) (Math.random() * numberPlayers) + 1;
            if (freeNumbers[r - 1] != -1 && freeNumbers[r - 1] != i) {
                freeNumbers[r - 1] = -1;
                //System.out.println("Person " + i + " --> " + r );
                targets[i- 1] = r;//puts the target number in the array number
            } else {
                i--;
            }

        }
    }

    public static void addNames(String name) {
       
        AssassinStudent x = new AssassinStudent(name);
        allStudents.add(x);
    }

    public static void openFile() throws FileNotFoundException, IOException {
        file = new RandomAccessFile("assassinsList.txt", "rw");
        if (file.length() == 0) {
            addNames("Jared Hines");
            addNames("Alex Lai");
            addNames("AJ Sharma");
            addNames("Meagan McKay");
            addNames("Nour Alyousef");
            addNames("Aya Ali");
            addNames("Didi Lambert");
            addNames("Nikhil B");
            addNames("AJ Guatam");
            addNames("Austin Georgas");
            addNames("Jess Kool");
            addNames("Hannah Lintott");
            addNames("Sophina McEwan");
            addNames("Tyler Rymal");
            addNames("Ali Hassan");
            addNames("Tyler Little");
            addNames("Daniel Peric");
            addNames("Tran Zau");
            addNames("Connor Lyttle");
            addNames("Thomas Law");
            addNames("Brandonw Wong");
            addNames("Jenna Collins");
            addNames("Brandan Kahn 1");
            addNames("Maddy Jones");
            addNames("Maddy Decocco");
            addNames("Mohammad Aldaour");
            addNames("Matthew Guirgus");
            addNames("Ryan MacDonald");
            addNames("Nathan G");
            addNames("Khaled Askar");
            addNames("Jagdeep");
            addNames("Meky");
            addNames("Ahmed Terawi");
            addNames("Nick Howie");
            addNames("Ahmed Elgamal");       
            addNames("Moe Hantash");
            addNames("Boston Elliot");
            addNames("Steven Lee");
            addNames("Leon Wang");
            addNames("York");
            addNames("Aryan GM");
            addNames("Kael Bosland");
            addNames("Matt McFarland");
            addNames("Connor Renton");
            addNames("Fares Isa");
            addNames("Tanveer Sheera");
            addNames("Tala Tabari");
            addNames("James Brett");
            addNames("Lisa Mishko");
            addNames("Alex Mehi");
            addNames("Bree G");
            addNames("Camil Zanzana");
            addNames("Chelsea W");
            addNames("Joseph Marturano");
            addNames("Olivia Langill");
            addNames("Nick Dias");
            addNames("Nneka Lemon");
            addNames("Sidney Whitney");
            addNames("Athanasios Sipsis");
            addNames("Emma K");
            addNames("Tawfiq Kamal");
            addNames("Ryan Heinzel");
            addNames("Jacob DeBryune");
            addNames("Haley DeBruyne");
            addNames("Mandeep");
            addNames("Malek Abesa");
            addNames("Ata Dogan");
            addNames("Sam Newby");
            
           
            file.seek(0);
            for (int i = 0; i < numberPlayers; i++) {
                file.writeChars(allStudents.get(i).getStudentName());
                file.writeInt(allStudents.get(i).getStudentNumber());
            }

        }
    }

}
