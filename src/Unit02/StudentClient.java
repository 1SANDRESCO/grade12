/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit02;

/**
 *
 * @author 1SANDRESCO
 */
public class StudentClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String string1 = new String();
        String string2 = new String("Hello Word");
        String string3 = new String();
        Student student1 = new Student();
        student1.setFirstName ( "Scott" );
        student1.setLastName ("Sandre");
        //student1.setOEN (123123123);
        student1.setAge  (17);
       
        Student student2 = new Student("fred");
        Student student3 = new Student();
        
    }
    
}
