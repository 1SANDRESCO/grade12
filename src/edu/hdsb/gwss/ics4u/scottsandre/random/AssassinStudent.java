/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

/**
 *
 * @author Scott
 */
public class AssassinStudent {
    public static int NAME_LENGTH = 16;
    public static int RECORD_SIZE = NAME_LENGTH * 2 + 4;
    
    private String studentName;
    private int studentNumber;
    
    private int counter = 1;
    
    public AssassinStudent(){
        
    }
    
    public AssassinStudent(String name, int x){
        this.setStudentName(name);
        this.setStudentNumber(x);
        
    }
    
    public AssassinStudent(String name){
        this.setStudentName(name);
        this.setStudentNumber(counter);
        counter++;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
        if ( studentName != null ) {
            StringBuilder temp = new StringBuilder( studentName.trim() );
            temp.setLength( NAME_LENGTH );

            // trucates or pads the string
            this.studentName = temp.toString();
        } else {
            // TODO
            this.studentName = "TBD";
        }
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    private void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "AssassinStudent{" + "studentName=" + studentName + ", studentNumber=" + studentNumber + '}';
    }
    
    
    
    
    
    
    
}
