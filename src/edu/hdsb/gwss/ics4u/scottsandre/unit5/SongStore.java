/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit5;

import java.io.*;
import java.util.*;
import static edu.hdsb.gwss.ics4u.scottsandre.unit5.SongRecordFileMaker.recordFile;

public class SongStore {

    public static SongRecord sRecord;
    public static long numRecords;
    public static Scanner input = new Scanner(System.in);
    public static boolean exit = false;

    public static void main(String[] args) throws Exception {
        long position, recordNumber;
        int choice;
        boolean exit = false;

        System.out.println("Welcome to Scott Sandre's Song Store: ");
        System.out.println();
        makeFile();

        while (exit == false) {
            System.out.println();
            System.out.println("Main Menu:");
            System.out.println("1 -> to look at just one song");
            System.out.println("2 -> to add new song.");
            System.out.println("3 -> to update a song.");
            System.out.println("9 -> to see all songs");
            System.out.println("0 -> EXIT");
            System.out.print("Your choice is: ");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:

                    System.out.println("Which record do you want [1 - " + numRecords + "] or 0 to exit?");
                    recordNumber = input.nextLong();
                    position = sRecord.RECORD_SIZE * (recordNumber - 1);
                    readInFile(position);

                    System.out.println("Record number " + recordNumber + ": ");
                    System.out.println(sRecord.toString());
                    break;
                case 2:
                    addSong();
                    break;
                case 9:
                    for (int i = 1; i <= numRecords; i++) {
                        position = sRecord.RECORD_SIZE * (i - 1);
                        readInFile(position);
                        System.out.println(sRecord.toString());
                        
                    }
                break;

            }
        }
    }

    public static void addSong() throws IOException {
        String songName, bandName, comName;
        int secondsLong, copiesSold;
        double digitalSize;//gigabytes
        boolean released;
        char rating;
        songName = input.nextLine();
        System.out.print("Enter song name: ");
        songName = input.nextLine();
        System.out.print("Enter band name: ");
        bandName = input.nextLine();
        System.out.print("Enter record Company name: ");
        comName = input.nextLine();
        System.out.print("Enter length (s) of song: ");
        secondsLong = input.nextInt();
        System.out.print("Enter number copies sold: ");
        copiesSold = input.nextInt();
        System.out.print("Enter digital Size (Gb): ");
        digitalSize = input.nextDouble();
        System.out.print("Released? 'true' or 'false': ");
        released = input.nextBoolean();
        System.out.print("Letter rating 'A' ... 'Z' : ");
        rating = input.next().charAt(0);

        SongRecord addMe = new SongRecord(songName, bandName, comName, secondsLong, copiesSold, digitalSize, released, rating);

        recordFile.writeChars(addMe.getSongName());
        recordFile.writeChars(addMe.getBandName());
        recordFile.writeChars(addMe.getRecordCompanyName());
        recordFile.writeInt(addMe.getSecondsLong());
        recordFile.writeInt(addMe.getCopiesSold());
        recordFile.writeDouble(addMe.getDigitalSize());
        recordFile.writeBoolean(addMe.isReleased());
        recordFile.writeChar(addMe.getRating());

        System.out.println("'" + addMe.getSongName() + "' has been added.");
        System.out.println(addMe.toString());
        //int x = input.nextInt();
        System.out.print("Add another song? 1 -> Yes, 2 ->Menu: ");
        if (input.nextInt() == 1){
            addSong();
        } else if (input.nextInt() == 2){
            
        } else {
            System.out.println(".........You are silly......");
        }

    }

    public static void makeFile() throws IOException {
        sRecord = new SongRecord("", "", "", 0, 0, 0.0, false, 'Z');
        SongRecordFileMaker makeSong = new SongRecordFileMaker("store1.txt", "rw");//print the files

        numRecords = recordFile.length() / sRecord.RECORD_SIZE;
        System.out.println("\nThere are " + numRecords + " records currently in the file.");
    }

    public static void readInFile(long position) throws IOException {
        recordFile.seek(position);
        char songName[] = new char[sRecord.SONG_NAME_LENGTH];//read SONG NAME
        for (int i = 0; i < sRecord.SONG_NAME_LENGTH; i++) {
            songName[i] = recordFile.readChar();
        }
        sRecord.setSongName(new String(songName));

        char bandName[] = new char[sRecord.BAND_NAME_LENGTH];//read BAND NAME
        for (int i = 0; i < sRecord.BAND_NAME_LENGTH; i++) {
            bandName[i] = recordFile.readChar();
        }
        sRecord.setBandName(new String(bandName));

        char comName[] = new char[sRecord.RECORD_COMPANY_NAME_LENGTH];//read COMPANY NAME
        for (int i = 0; i < sRecord.RECORD_COMPANY_NAME_LENGTH; i++) {
            comName[i] = recordFile.readChar();
        }
        sRecord.setRecordCompanyName(new String(comName));

        sRecord.setSecondsLong(recordFile.readInt());//numers and char
        sRecord.setCopiesSold(recordFile.readInt());
        sRecord.setDigitalSize(recordFile.readDouble());
        sRecord.setReleased(recordFile.readBoolean());
        sRecord.setRating(recordFile.readChar());
    }

}
