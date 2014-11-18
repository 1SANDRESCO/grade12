/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit5;

import java.io.*;
import java.util.*;
import static edu.hdsb.gwss.ics4u.scottsandre.unit5.SongRecordFileMaker.recordFile;

public class SongStore2 {

    /// SCOTT parseint or boolean for nextLine dont use next ,or use exceptionhandler methods
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

    public static double exceptionHandlerDouble(String question, int low, int high) {
        boolean noError = true;
        double answer = -1;
        while (noError) {
            System.out.print(question);

            try {
                answer = Double.parseDouble((input.nextLine()));
                if (answer >= low && answer <= high) {
                    noError = false;
                } else {
                    System.out.println("Number not within . Lowest # can be" + low + " and highest is " + high);
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a number, no letters or other characters, please");
            }

        }
        return answer;
    }

    public static int exceptionHandlerInt(String question, int low, int high) {
        boolean noError = true;
        int answer = -1;
        while (noError) {
            System.out.print(question);

            try {
                answer = Integer.parseInt((input.nextLine()));
                if (answer >= low && answer <= high) {
                    noError = false;
                } else {
                    System.out.println("Integer not within range. Lowest # can be " + low + " and highest is " + high);
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer, not letters or decimals. please");
            }

        }
        return answer;
    }

    public static long exceptionHandlerLong(String question, int low, long high) {
        boolean noError = true;
        long answer = -1;
        while (noError) {
            System.out.print(question);

            try {
                answer = Integer.parseInt((input.nextLine()));
                if (answer >= low && answer <= high) {

                    noError = false;
                } else {
                    System.out.println("Long # not within range. Lowest # can be " + low + " and highest is " + high);
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer (long), not letters or decimals. please");
            }

        }
        return answer;
    }

    public static String exceptionHandlerString(String question, int length) {
        String answer = "";
        String myInput = "g";
        boolean error = true;
        System.out.print(question);
        while (error) {

            myInput = input.nextLine().trim();
            if (myInput.length() <= length && myInput.length() > 0) {
                answer = myInput;
                error = false;
            } else {
                System.out.print("\n" + question);
            }

        }
        return answer;
    }

    public static void modifySong() throws IOException {
        long x;
        //long n;
        int option;

        x = exceptionHandlerLong("Which # song would you like to change? [1 - " + numRecords + "]: ", 1, numRecords);

        displaySong(SongRecord.RECORD_SIZE * (x - 1), x);

        System.out.println("How many entries do you want to change (roughly)...");
        option = exceptionHandlerInt("Enter [0] for a few, or [1] for all of them: ", 0, 1);
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

            String s;
            s = exceptionHandlerString("Enter [new song name] or [k]eep current subject name: ", SongRecord.SONG_NAME_LENGTH);
            if (!"k".equals(s)) {//SONG 
                sRecord.setSongName(s);
            }
            s = exceptionHandlerString("Enter band name or [k]eep current subject name: ", SongRecord.BAND_NAME_LENGTH);
            if (!"k".equals(s)) {//BAND
                sRecord.setBandName(s);
            }

            s = exceptionHandlerString("Enter Company name or [k]eep current subject name: ", SongRecord.RECORD_COMPANY_NAME_LENGTH);
            if (!"k".equals(s)) {//COMPANY
                sRecord.setRecordCompanyName(s);
            }

            int p = exceptionHandlerInt("Enter length (s) long or -1 current subject name: ", -1, SongRecord.MAX_SECONDS);
            if (p != -1) {//LENGTH
                sRecord.setSecondsLong(p);
            }
            p = exceptionHandlerInt("Enter number copies sold or -1 current subject name: : ", -1, 1000000000);
            if (p != -1) {//COPES 
                sRecord.setCopiesSold(p);
            }

            double vv = exceptionHandlerDouble("Enter [new song size] or -1 to keep it the same", -1, 1000000000);
            if (vv != -1) {
                sRecord.setDigitalSize(vv);
            }

            boolean b = false;
            boolean good = false;
            while (good == false) {
                s = exceptionHandlerString("Released? 'true' or 'false': ", 5);
                if (s.equalsIgnoreCase("true")) {
                    b = true;
                    good = true;
                } else if (s.equalsIgnoreCase("false")) {
                    b = false;
                    good = true;
                }
            }
            sRecord.setReleased(b);

            s = exceptionHandlerString("Enter [new song rating] or [S] to keep it the same", 1);
            char ch = s.charAt(0);
            if (ch != 'S') {
                sRecord.setRating(ch);
            }

            position = sRecord.getSongRecordSize() * (x - 1);
            writeToFile(sRecord, position);

        } else {
            System.out.println("You are silly...");
        }

    }

    public static void modifySongInputInfo(long songIndex) throws IOException {

        int changeInfo = exceptionHandlerInt("Change #: ", 1, 8);

        String newS, newB, newC, s;

        switch (changeInfo) {
            case 1:
                newS = exceptionHandlerString("Enter new song name: ", SongRecord.SONG_NAME_LENGTH);
                sRecord.setSongName(newS);
                break;
            case 2:
                newB = exceptionHandlerString("Enter new band name: ", SongRecord.BAND_NAME_LENGTH);
                sRecord.setBandName(newB);
                break;
            case 3:
                newC = exceptionHandlerString("Enter new record company name: ", SongRecord.RECORD_COMPANY_NAME_LENGTH);
                sRecord.setRecordCompanyName(newC);
                break;
            case 4:
                int x = exceptionHandlerInt("Enter new song length (s) :", 0, SongRecord.MAX_SECONDS);
                sRecord.setSecondsLong(x);
                break;
            case 5:
                int j = exceptionHandlerInt("Enter new copes sold: ", 0, 100000000);
                sRecord.setCopiesSold(j);
                break;
            case 6:
                double k = exceptionHandlerDouble("Enter new digital size (Gb): ", 0, 100000000);
                sRecord.setDigitalSize(k);
                break;
            case 7:
                boolean b = false;
                boolean good = false;
                while (good == false) {
                    s = exceptionHandlerString("Released? 'true' or 'false': ", 5);
                    if (s.equalsIgnoreCase("true")) {
                        b = true;
                        good = true;
                    } else if (s.equalsIgnoreCase("false")) {
                        b = false;
                        good = true;
                    }
                }
                sRecord.setReleased(b);
                break;
            case 8:
                s = exceptionHandlerString("Enter new song rating: ", 1);
                char ch = s.charAt(0);
                sRecord.setRating(ch);
                break;
        }
        String another = exceptionHandlerString("Change another info? Y or N: ", 1);
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
            System.out.println("5 -> to see all songs");
            System.out.println("0 -> EXIT");
            //System.out.print("Your choice is: ");
            choice = exceptionHandlerInt("Your choice is: ", 0, 5);
            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    recordNumber = exceptionHandlerLong("Which song do you want to see [1 - " + numRecords + "]? ", 1, numRecords);
                    position = SongRecord.RECORD_SIZE * (recordNumber - 1);
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
                case 5:
                    for (int i = 1; i <= numRecords; i++) {
                        position = SongRecord.RECORD_SIZE * (i - 1);
                        displaySong(position, i);
                    }
                    break;

            }
        }
    }

    public static void deleteSong() throws IOException {
        recordNumber = exceptionHandlerLong("Which song do you want to delete [1 - " + numRecords + "]?: ", 1, numRecords);
       
        for (long i = recordNumber; i < numRecords; i++){
            position = SongRecord.RECORD_SIZE * (recordNumber);//record after
            sRecord = readInFile(position);
            position = SongRecord.RECORD_SIZE * (recordNumber - 1);//current record
            writeToFile(sRecord, position );//write over that record
        }
        numRecords --;
        System.out.println("Song deleted. " + numRecords + " remaining.");
        

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
        String songName, bandName, comName, s;
        int secondsLong, copiesSold;
        double digitalSize;//gigabytes
        boolean released = false;
        char rating;

        songName = exceptionHandlerString("Enter song name: ", SongRecord.SONG_NAME_LENGTH);
        bandName = exceptionHandlerString("Enter band name: ", SongRecord.BAND_NAME_LENGTH);
        comName = exceptionHandlerString("Enter Company name: ", SongRecord.RECORD_COMPANY_NAME_LENGTH);
        secondsLong = exceptionHandlerInt("Enter length (s) long: ", 0, SongRecord.MAX_SECONDS);
        copiesSold = exceptionHandlerInt("Enter number copies sold: ", 0, 1000000000);
        digitalSize = exceptionHandlerDouble("Enter digital size (Gb): ", 0, 100000000);
       
                boolean good = false;
                while (good == false) {
                    s = exceptionHandlerString("Released? 'true' or 'false': ", 5);
                    if (s.equalsIgnoreCase("true")) {
                        released = true;
                        good = true;
                    } else if (s.equalsIgnoreCase("false")) {
                        released = false;
                        good = true;
                    }
                }
        s = exceptionHandlerString("Enter new song rating: ", 1);//rating
        rating = s.charAt(0);
        ;

        SongRecord addMe = new SongRecord(songName, bandName, comName, secondsLong, copiesSold, digitalSize, released, rating);
        writeToFile(addMe, recordFile.length());

        System.out.println("'" + addMe.getSongName() + "' has been added.");
        System.out.println(addMe.toString());
        int x = exceptionHandlerInt("Add another song? 1 > YES, 2 - MENU: ", 1, 2);

        if (x == 1) {
            addSong();
        } else {
            showStoreMenu();
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

    public static SongRecord readInFile(long position) throws IOException {
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
        
        return sRecord;
    }

}
