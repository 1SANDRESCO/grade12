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
        private String songName, bandName, recordCompany;
        private int numberSales;
        public SongRecord(){
        this("TBD", "TBD", "TBD", -1);    
        }
        
        public SongRecord(String songName, String bandName, String recordCompany, int numberSales){
            
        }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getRecordCompany() {
        return recordCompany;
    }

    public void setRecordCompany(String recordCompany) {
        this.recordCompany = recordCompany;
    }
        
        
        
}
