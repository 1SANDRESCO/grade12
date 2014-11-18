/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit5;

/**
 *
 * @author Owner
 */
public class SongRecord {

    //CLASS CONSTANTS
    public static final int SONG_NAME_LENGTH = 22;
    public static final int BAND_NAME_LENGTH = 22;
    public static final int RECORD_COMPANY_NAME_LENGTH = 20;
    public static final int RECORD_SIZE = (SONG_NAME_LENGTH + BAND_NAME_LENGTH + RECORD_COMPANY_NAME_LENGTH) * 2 + 8 + 8 + 2 + 1; // 2 ints, 1 double, 
    
    
    public static final int MAX_SECONDS = 1200;
    //OBJECT VARIABLES
    private String songName, bandName, recordCompanyName;
    private int secondsLong, copiesSold;
    private double digitalSize;//gigabytes
    private boolean released;
    private char rating;

    public SongRecord() {
        this("TBD", "TBD", "TBD", -1, -1, -1.1, false, 'X');
    }

    public SongRecord(String songName, String bandName, String recordCompanyName, int secondsLong, int copiesSold, double digitalSize, boolean released, char rating) {
        this.setSongName(songName);
        this.setBandName(bandName);
        this.setRecordCompanyName(recordCompanyName);
        this.setCopiesSold(copiesSold);
        this.setDigitalSize(digitalSize);
        this.setReleased(released);
        this.setRating(rating);

    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {

        if (songName != null) {
            StringBuilder temp = new StringBuilder(songName.trim());
            temp.setLength(SONG_NAME_LENGTH);
            // trucates or pads the string
            this.songName = temp.toString();
           // System.out.println("S set to: " + this.songName);
        } else {
            // TODO
            this.songName = "TBD";
        }
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {

        if (bandName != null) {
            StringBuilder temp = new StringBuilder(bandName.trim());
            temp.setLength(BAND_NAME_LENGTH);
            // trucates or pads the string
            this.bandName = temp.toString();
            //System.out.println("B set to: " + this.bandName);
        } else {
            // TODO
            this.bandName = "TBD";
        };

    }

    public String getRecordCompanyName() {
        return recordCompanyName;
    }

    public void setRecordCompanyName(String recordCompanyName) {
        if (recordCompanyName != null) {
            StringBuilder temp = new StringBuilder(recordCompanyName.trim());
            temp.setLength(RECORD_COMPANY_NAME_LENGTH);
            // trucates or pads the string
            this.recordCompanyName = temp.toString();
           // System.out.println("C set to: " + this.recordCompanyName);
        } else {
            // TODO
            this.recordCompanyName = "TBD";
        };
    }

    public int getSecondsLong() {
        return secondsLong;
    }

    public void setSecondsLong(int secondsLong) {
        if (secondsLong > 0 && secondsLong < MAX_SECONDS) {
            this.secondsLong = secondsLong;
        } else {
            this.secondsLong = -1;
        }
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        if (copiesSold > 0) {
            this.copiesSold = copiesSold;
        } else {
            this.copiesSold = -1;
        }
    }

    public double getDigitalSize() {
        return digitalSize;
    }

    public void setDigitalSize(double digitalSize) {
        if (this.digitalSize > 0){
        this.digitalSize = digitalSize;
        } else {
            this.digitalSize = -1.1;
        }
    }

    public boolean isReleased() {
        return released;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }

    public char getRating() {
        return rating;
    }

    public void setRating(char rating) {
        this.rating = rating;
    }
    
    public int getSongRecordSize(){
        return RECORD_SIZE;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "SongRecord{" + "songName=" + songName + ", bandName=" + bandName + ", recordCompanyName=" + recordCompanyName + ", secondsLong=" + secondsLong + ", copiesSold=" + copiesSold + ", digitalSize=" + digitalSize + ", released=" + released + ", rating=" + rating + '}';
    }
    
    

}
