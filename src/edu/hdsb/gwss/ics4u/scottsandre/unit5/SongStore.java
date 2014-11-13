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

    public static void main(String[] args) throws Exception {
        long position, recordNumber;
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Scott Sandre's Song Store: ");
        makeFile();
        readInFile();
        System.out.print("1 to choose which file to look at, 9 to see all of them:  ");
        choice = input.nextInt();
        
        

        System.out.println("Which record do you want [1 - " + numRecords + "] or 0 to exit?");
        recordNumber = input.nextLong();
        position = sRecord.RECORD_SIZE * (recordNumber - 1);
        recordFile.seek(position);

        System.out.println("Record number " + recordNumber + ": ");
        System.out.println(sRecord.toString());

    }
    
    public static void makeFile() throws IOException{
        sRecord = new SongRecord("", "", "", 0, 0, 0.0, false, 'Z');
        SongRecordFileMaker makeSong = new SongRecordFileMaker("store1.txt", "rw");//print the files

        numRecords = recordFile.length() / sRecord.RECORD_SIZE;
        System.out.println("\nThere are " + numRecords + " records currently in the file.");
    }

    public static void readInFile() throws IOException {
        char songName[] = new char[sRecord.SONG_NAME_LENGTH];//read SONG NAME
        for (int i = 0; i < sRecord.SONG_NAME_LENGTH; i++) {
            songName[i] = recordFile.readChar();
        }
        sRecord.setSongName(new String(songName));
        char comName[] = new char[sRecord.RECORD_COMPANY_NAME_LENGTH];//read COMPANY NAME
        for (int i = 0; i < sRecord.RECORD_COMPANY_NAME_LENGTH; i++) {
            comName[i] = recordFile.readChar();
        }
        sRecord.setRecordCompanyName(new String(comName));//numbers and char
        sRecord.setSecondsLong(recordFile.readInt());
        sRecord.setCopiesSold(recordFile.readInt());
        sRecord.setDigitalSize(recordFile.readDouble());
        sRecord.setReleased(recordFile.readBoolean());
        sRecord.setRating(recordFile.readChar());
    }

}
