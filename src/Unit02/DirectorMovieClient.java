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
        Movie movie2 = new Movie("Ben Hur", 1800, 50000, true, "Scott Sandre");
        Movie movie3 = new Movie("GODZILLA", 2000, 50000, true, "Scott Sandre");
        Movie movie4 = new Movie("KING KONG", 2000, 50000, true, "Scott Sandre");
        Movie movie5 = new Movie("SPIDERMAN", 2003, 50000, true, "Scott Sandre");
        Movie movie6 = new Movie("FIGHT CLUB", 2010, 50000, true, "Scott Sandre");
        director1.addMovie(movie2);
        director1.addMovie(movie3);
        director1.addMovie(movie4);
        director1.addMovie(movie5);
        director1.addMovie(movie6);
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
        
       
        
        System.out.println("Current number of movies of Director1: " + director1.getNumberMovies());
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println("Printing all movies...");
        director1.movieListToString();
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();   
        
        //Remove
        //Test Case 1: proper title and year
        System.out.println("REMOVE > Case 1 > proper title and year > GODZILLA (2000)> before length: " + director1.getNumberMovies());
        director1.removeMovie("GODZILLA", 2000);
        System.out.println("REMOVE > Case 1 propre title and year > after length: " + director1.getNumberMovies());
        System.out.println();
        
        //Test Case 2: remove by passing an object
        System.out.println("REMOVE > case 2 > pass it a object > movie6 object (fight club) > Before length: " +director1.getNumberMovies() );
        director1.removeMovie(movie6);
        System.out.println("REMOVE > case2 > pass it a object.after length: " +director1.getNumberMovies() );
        System.out.println(); 
        
        //test case 3: invalid object
        System.out.println("REMOVE > case 3 incorrect tittle or year. . Before length: " +director1.getNumberMovies() );
        director1.removeMovie("thisDoesn'tExist", 1999);
        System.out.println("REMOVE > Case 3 object does not exist > after length: " + director1.getNumberMovies());
        System.out.println();
        System.out.println("-----------------------------------------");
        

        //GET
        //Test Case 1: mvoie > check if title and year exists in list
        System.out.println("GET > movie > proper title and year > SPIDERMAN, 2003 > Case 2 > " );
        System.out.println(director1.getMovie("SPIDERMAN", 2003).getTitle());
        System.out.println();
     
        //Test Case 2: movie > get title and year that doesn't exist
        System.out.println("GET > movie > non-propre title and year, xxxxx123, 2003, object that doesn't exist");
        director1.getMovie("xxxxx123", 2003);
        System.out.println();
        
        //Test Case 3: director > get info. such as name and age
        System.out.println("GET > director > get non-encapsulated data >");
        System.out.println("Get age: " + director1.getAge());
        System.out.println("Get full name: " + director1.getFullName());
        System.out.println("Get preffered genre to direct: " + director1.getPreferredGenre());
        System.out.println("Get home country: " + director1.getCountry());
        System.out.println();
        
        //Test Case 4: director > get encapsulated info
        System.out.println("GET > director > get encapsulated data like SIN/SSN");
        System.out.println("Identification number: " + director1.getIdentificationNumber());
        
        System.out.println();
        System.out.println("Printing all movies...");
        director1.movieListToString();
        System.out.println();
    }
    
}
