/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.hdsb.gwss.ics4u.scottsandre.unit5;

import java.io.File;
import java.util.*;
public class SongStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    long position, recordNumber;
    Scanner input1 = new Scanner( System.in );
    Scanner input2;
    SongRecord sRecord = new SongRecord ("", "", "", 0, 0 ,0.0, false, 'Z');
    SongRecordFileMaker makeSong = new SongRecordFileMaker ("store1.txt", "rw");//print the files
    
//    input2 = new Scanner(store1);
//    
//    long numRecords = songsFile.length() / songsFile.RECORD_SIZE;
    
    //System.out.println( "\nThere are " + numRecords + " records currently in the file." );
    
    

    }
    
}
