/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Owner
 */
public class SongRecordIO  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        System.out.println("Creating 3 Songs:");
//        
//        SongRecord s1 = new SongRecord("Stairway to Heaven", "Led Zeppplin", "Rockstar Music", 453, 100000, 4.51, true, 'A');
//        System.out.println(s1.toString());
//        
//        SongRecord s2 = new SongRecord("Rebellion (Lies) ", "Arcade Fire", "LaLaLa Productions Inc.", 285, 70000, 3.22, true, 'B');
//        System.out.println(s2.toString());
//        
//        SongRecord s3 = new SongRecord("Somebody Told Me", "The Killers", "CheckThisOut LTD", 249, 65200, 9.45, true, 'C');
//        System.out.println(s3.toString());
        
        RandomAccessFile recordFile = new RandomAccessFile( "SongRecordIO.txt", "rw" );
        
        //Start
        //recordFile.seek( recordFile.length() );
        
        
//        recordFile.writeChars(s1.getSongName());
//        recordFile.writeChars(s1.getBandName());
//        recordFile.writeChars(s1.getRecordCompanyName());
//        recordFile.writeInt(s1.getSecondsLong());
//        recordFile.writeInt(s1.getCopiesSold());
//        recordFile.writeDouble(s1.getDigitalSize());
//        recordFile.writeBoolean(s1.isReleased());
//        recordFile.writeChar(s1.getRating());
//        
//        recordFile.writeChars(s2.getSongName());
//        recordFile.writeChars(s2.getBandName());
//        recordFile.writeChars(s2.getRecordCompanyName());
//        recordFile.writeInt(s2.getSecondsLong());
//        recordFile.writeInt(s2.getCopiesSold());
//        recordFile.writeDouble(s2.getDigitalSize());
//        recordFile.writeBoolean(s2.isReleased());
//        recordFile.writeChar(s2.getRating());
//        
//        recordFile.writeChars(s3.getSongName());
//        recordFile.writeChars(s3.getBandName());
//        recordFile.writeChars(s3.getRecordCompanyName());
//        recordFile.writeInt(s3.getSecondsLong());
//        recordFile.writeInt(s3.getCopiesSold());
//        recordFile.writeDouble(s3.getDigitalSize());
//        recordFile.writeBoolean(s3.isReleased());
//        recordFile.writeChar(s3.getRating());
//        
        
        
        
    }
    
}
