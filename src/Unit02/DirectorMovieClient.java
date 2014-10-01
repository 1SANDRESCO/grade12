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
        System.out.println(director1.toString());
        
        
     
        System.out.println();
        
        Movie movie1 = new Movie ();
        movie1.setTitle("Dark Knight");
        movie1.setReleaseYear(2008);
        movie1.setOriginalMovie(true);
        movie1.setGenreOfMovie(0);
        movie1.setLeadActor("Christian Bale");
        
        System.out.println(movie1.toString());
        
        Movie movie2 = new Movie("Ben Hur", 1800, 50000, true, "Scott Sandre");
        Movie movie3 = new Movie("GODZILLA", 2000, 50000, true, "Scott Sandre");
        Movie movie4 = new Movie("KING KONG", 2000, 50000, true, "Scott Sandre");
        Movie movie5 = new Movie("SPIDERMAN", 2003, 50000, true, "Scott Sandre");
        Movie movie6 = new Movie("FIGHT CLUB", 2010, 50000, true, "Scott Sandre");
        director1.addMovie(movie6);
        director1.addMovie(movie5);
        
        
        System.out.println();
        System.out.println();
        
        System.out.println("-----------------------------------------");
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
        System.out.println();
        //Test Case 3: adding null object
        System.out.println("Add > Case 4 NULL object > Before length: " +director1.getNumberMovies() );
        director1.addMovie(null);
        System.out.println("Add > Case 4 > After length: " +director1.getNumberMovies() );
        System.out.println();
        
        director1.addMovie(movie4);
        director1.addMovie(movie3);
        System.out.println("Current number of movies of Director1: " + director1.getNumberMovies());
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println();
        director1.movieListToString();
        System.out.println();
        System.out.println();
        //Remove
        //Test Case 1: properly removes a valid object from list via index
        System.out.println("REMOVE > Case 1 INDEX good object > Before length: " +director1.getNumberMovies() );
       // director1.removeMovieByIndex(0);
        System.out.println("REMOVE > Case 1  > After length: " +director1.getNumberMovies() );
        System.out.println();
        
        //Test Case 2: check if object actually exists in list
        System.out.println("REMOVE > Case 2 object exists good tittle/year> before length: " + director1.getNumberMovies());
        director1.removeMovie("GODZILLA", 2000);
        System.out.println("REMOVE > Case 2 object exists > after length: " + director1.getNumberMovies());
        System.out.println();
        
        //Test Case 3: invalid index 
        System.out.println("REMOVE > Case 3 index BAD object > Before length: " +director1.getNumberMovies() );
        //director1.removeMovieByIndex(99);
        System.out.println("REMOVE > Case 3  > after length: " +director1.getNumberMovies() );
        System.out.println();
        
        //Test Case 4: remove by passing an object
        System.out.println("REMOVE > case 4 > pass it a object.Before length: " +director1.getNumberMovies() );
        director1.removeMovie(movie6);
        System.out.println("REMOVE > case 4 > pass it a object.after length: " +director1.getNumberMovies() );
        
        
        //test case 4: invalid object
        System.out.println("Remove > case 5 incorrect tittle or year. . Before length: " +director1.getNumberMovies() );
        director1.removeMovie("thisDoesn'tExist", 1999);
        System.out.println("REMOVE > Case 5 object does not exist > after length: " + director1.getNumberMovies());
        System.out.println();
        System.out.println("-----------------------------------------");
        //get
        //Test Case 1: valid index
        System.out.println("GET by index> Case 1 valid index  > Before length: " +director1.getNumberMovies() );
        System.out.println(director1.getMovieByIndex(0).getTitle());
        System.out.println();
        //Test Case 2: check if objects exists in list
        System.out.println("GET by search > SPIDERMAN, 2003 > Case 2 if object exists  > " );
        System.out.println(director1.getMovie("SPIDERMAN", 2003).getTitle());

        System.out.println();
        //test Case 3: invalid index
        System.out.println("GET, invalid index 99 search. ");
        director1.getMovieByIndex(99);
        System.out.println();
        //Test Case 4: get object that doesn't exist
        System.out.println("GET > object that doesn't exist");
        director1.getMovie("xxxxx123", 2003);
        System.out.println();
        director1.movieListToString();
    }
    
}
