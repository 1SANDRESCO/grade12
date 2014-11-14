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
    public static long recordNumber;
    public static Scanner input = new Scanner(System.in);
    public static boolean exit = false;
    public static long position;

    public static void main(String[] args) throws Exception {
        openStore();
        closeStore();
    }

    public static void modifySong() throws IOException {
        long x;
        //long n;
        int option;
        System.out.print("Which # song would you like to change? [1 - " + numRecords + "]: ");
        x = input.nextLong();
        // n = sRecord.RECORD_SIZE * (x - 1);

        displaySong(sRecord.RECORD_SIZE * (x - 1), x);

        System.out.println("How many entries do you want to change (roughly)...");
        System.out.print("Enter [0] for a few, or [1] for all of them: ");
        option = input.nextInt();
        if (option == 0) {

            System.out.println("1 -- > Song Name");
            System.out.println("2 -- > Band Name");
            System.out.println("3 -- > Company Name");
            System.out.println("4 -- > Seconds Long");
            System.out.println("5 -- > Copies Sold");
            System.out.println("6 -- > Digital Size (Gb)");
            System.out.println("7 -- > Released status");
            System.out.println("8 -- > Rating");
            modifySongInputInfo(x);
        } else if (option == 1) {
            String s = input.nextLine();
            System.out.print("Enter [new song name] or [k]eep current subject name: ");//song name
             s = input.nextLine();
            if (!"k".equals(s)) {
                sRecord.setSongName(s);
            }
            s = input.nextLine();
            System.out.print("Enter [new band name] or [k]eep current subject name: ");//band name
            s = input.nextLine();
            if (!"k".equals(s)) {
                sRecord.setBandName(s);
            }
            
            System.out.print("Enter [new record company name] or [k]eep current subject name: ");//company name
            s = input.nextLine();
            if (!"k".equals(s)) {
                sRecord.setRecordCompanyName(s);
            }
            
            System.out.print("Enter [new song length] or -1 to keep it the same");//length
            int p = input.nextInt();
            if (p!= -1) {
                sRecord.setSecondsLong(p);
            }
            System.out.print("Enter [new # sold] or -1 to keep it the same");//sold
            p = input.nextInt();
            if (p!= -1) {
                sRecord.setCopiesSold(p);
            }
            System.out.print("Enter [new song size] or -1 to keep it the same");//size
            double vv = input.nextDouble();
            if (vv!= -1) {
                sRecord.setDigitalSize(vv);
            }
            
            System.out.print("Enter released status (true or false): ");//released
            sRecord.setReleased(input.nextBoolean());
            
           // System.out.print("Enter [new song rating] or S to keep it the same");//rating
//            char vvv = input.next().charAt(0);
//            if (vvv!= 'S') {
//                sRecord.setRating(vvv);
//            }
            //sRecord.setRating(input.next().charAt(0));
            
            position = sRecord.getSongRecordSize() * (recordNumber - 1);
            writeToFile(sRecord, position);
            
        } else {
            System.out.println("You are silly...");
        }

    }

    public static void modifySongInputInfo(long songIndex) throws IOException {
        //changeInfo = input.nextInt();
        System.out.print("Change #: ");
        int changeInfo = input.nextInt();
        String y;

        switch (changeInfo) {
            case 1:
                y = input.nextLine();
                System.out.print("Enter new song name: ");
                y = input.nextLine();
                sRecord.setSongName(y);
                break;
            case 2:
                y = input.nextLine();
                System.out.print("Enter new band name: ");
                y = input.nextLine();
                sRecord.setBandName(y);
                break;
            case 3:
                y = input.nextLine();
                System.out.print("Enter new record company name: ");
                y = input.nextLine();
                sRecord.setRecordCompanyName(y);
                break;
            case 4:
                //int x = input.nextInt();
                System.out.print("Enter new song length (s): ");
                int x = input.nextInt();
                // x = input.nextInt();
                sRecord.setSecondsLong(x);
                break;
            case 5:
                //int j = input.nextInt();
                System.out.print("Enter new copies sold: ");
                int j = input.nextInt();
                // j = input.nextInt();
                sRecord.setCopiesSold(j);
                break;
            case 6:
                //double k = input.nextDouble;
                System.out.print("Enter new digital size (Gb): ");
                double k = input.nextDouble();
                sRecord.setDigitalSize(k);
                break;
            case 7:

                System.out.print("Enter new realsed status: ");
                boolean m = input.nextBoolean();
                sRecord.setReleased(m);
                break;
            case 8:
                System.out.print("Enter new rating: ");
                char r = input.next().charAt(0);
                sRecord.setRating(r);
                break;
        }
        String another = input.nextLine();
        System.out.print("Change another info? Y or N: ");
        another = input.nextLine();
        if ("Y".equalsIgnoreCase(another)) {
            modifySongInputInfo(songIndex);
        } else if ("N".equalsIgnoreCase(another)) {
            position = sRecord.getSongRecordSize() * (songIndex - 1);
            writeToFile(sRecord, position);
        } else {
            System.out.println("Incorrect entry. Printing and going to menu.");
        }
    }

    public static void showStoreMenu() throws IOException {

        int choice;
        boolean exit = false;
        while (exit == false) {
            System.out.println();
            System.out.println("Main Menu:");
            System.out.println("1 -> to look at just one song");
            System.out.println("2 -> to add new song.");
            System.out.println("3 -> to update a song.");
            System.out.println("4 -> Delete a song.");
            System.out.println("9 -> to see all songs");
            System.out.println("0 -> EXIT");
            System.out.print("Your choice is: ");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:

                    System.out.println("Which song do you want to see [1 - " + numRecords + "]?");
                    recordNumber = input.nextLong();
                    position = sRecord.RECORD_SIZE * (recordNumber - 1);
                    displaySong(position, recordNumber);
                    break;
                case 2:
                    addSong();
                    break;
                case 3:
                    modifySong();
                    break;
                case 4:
                    deleteSong();
                    break;
                case 9:
                    for (int i = 1; i <= numRecords; i++) {
                        position = sRecord.RECORD_SIZE * (i - 1);
                        displaySong(position, i);
                    }
                    break;

            }
        }
    }

    public static void deleteSong() {

        System.out.print("Which song do you want to delete [1 - " + numRecords + "]?");
        recordNumber = input.nextLong();
        //sRecord.setSongName(null);
        //numRecords--;

    }

    public static void openStore() throws IOException {

        System.out.println("Welcome to Scott Sandre's Song Store: ");
        System.out.println();
        makeFile();
        showStoreMenu();
    }

    public static void closeStore() throws IOException {
        recordFile.close();

    }

    public static void displaySong(long position, long songNumber) throws IOException {
        readInFile(position);
        System.out.println("#" + songNumber + ": " + sRecord.toString());
    }

    public static void addSong() throws IOException {
        numRecords++;
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
        writeToFile(addMe, recordFile.length());

        System.out.println("'" + addMe.getSongName() + "' has been added.");
        System.out.println(addMe.toString());
        //int x = input.nextInt();
        System.out.print("Add another song? 1 -> Yes, 2 ->Menu: ");
        if (input.nextInt() == 1) {
            addSong();
        } else if (input.nextInt() == 2) {
            showStoreMenu();
        } else {
            System.out.println(".........You are silly......");
        }

    }

    public static void writeToFile(SongRecord song, long fileID) throws IOException {
        recordFile.seek(fileID);
        recordFile.writeChars(song.getSongName());
        recordFile.writeChars(song.getBandName());
        recordFile.writeChars(song.getRecordCompanyName());
        recordFile.writeInt(song.getSecondsLong());
        recordFile.writeInt(song.getCopiesSold());
        recordFile.writeDouble(song.getDigitalSize());
        recordFile.writeBoolean(song.isReleased());
        recordFile.writeChar(song.getRating());

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
