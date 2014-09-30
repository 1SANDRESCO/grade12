/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Unit02;

/**
 *
 * @author Owner
 */
public class DirectorMovieClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Director director1 = new Director();//("123456789", 1, true, "Christopher", "Nolan");
        director1.setAge(45);
        director1.setCountry(1);
        director1.setFirstName("Christopher");
        director1.setLastName("Nolan");
        director1.setIdentificationNumber("124556789");
        director1.setNetWorth(50000000);
        director1.setStateOfHealth(false);
        director1.setTypeOfMoviesMade(8);
        System.out.println("Valid??? " + director1.isValid());
        System.out.println("Country: " + director1.getCountry());
        System.out.println("Types of Movies made: " + director1.getTypeOfMoviesMade());
        System.out.println("State of health " + director1.getStateOfHealth() );
        System.out.println("Full name: " + director1.getFullName());
        System.out.println(director1.toString());
        
        System.out.println();
        
        Movie movie1 = new Movie ();
        movie1.setTitle("Dark Knight");
        movie1.setReleaseYear(2008);
        movie1.setOriginalMovie(true);
        movie1.setGenreOfMovie(0);
        movie1.setLeadActor("Christian Bale");
        System.out.println(movie1);
        
        Movie movie2 = new Movie("Ben Hur", 1800, 50000, true, "Scott Sandre");
        
        System.out.println("IS movie two valid.." + movie2.isValid());
        System.out.println();
        System.out.println();
        
        //Add
        //Test Case 1: adding a valid object to list
        //Compare before length of array list to afte
        System.out.println("Add > Case 1 valid object > Before length: " + director1.getNumberMovies());
        director1.addMovie(movie1);
        System.out.println("Add > Case 1 > After length: " + director1.getNumberMovies());
        //System.out.println("Getting movie:" + director1.getMovie(0));
        System.out.println();
        
        //Test Case 2: adding a duplicate object to list
        System.out.println("Add > Case 2 duplicate object > Before length: " +director1.getNumberMovies() );
        director1.addMovie(movie1);
        System.out.println("Add > Case 2  > After length: " +director1.getNumberMovies() );
        System.out.println();
        
        //Test Case 3: adding an invalid object to list
        System.out.println("Add > Case 3 invalid object > Before length: " +director1.getNumberMovies() );
        System.out.println("Adding new movie2 with an invalid release year...");
        director1.addMovie(movie2);
        System.out.println("Add > Case 3  > after length: " +director1.getNumberMovies() );
        
        //Test Case 3: adding null object
        System.out.println("Add > Case 4 NULL object > Before length: " +director1.getNumberMovies() );
        //director1.addMovie(null);
        System.out.println("Add > Case 4 > After length: " +director1.getNumberMovies() );
       
    }
    
}
