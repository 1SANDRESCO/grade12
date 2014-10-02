/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit02;

import java.util.Objects;

/**
 * @author 1SANDRESCO
 * Date: Sept 29, 2014
 * Version: v1.00
 * Description: Creates an object of movie 
 */
public class Movie {

    public static final int GENRE_ACTION = 0;
    public static final int GENRE_ADVENTURE = 1;
    public static final int GENRE_COMEDY = 2;
    public static final int GENRE_DRAMA = 3;
    public static final int GENRE_MYSTERY = 4;
    public static final int GENRE_ROMANCE = 5;

    public static final String[] movieType = {
        "Action", "Adventure", "Comedy", "Drama", "Mystery", "Romance"
    };

    public static final boolean ORIGINAL = true;
    public static final boolean REMAKE = false;
    private String title;
    private String leadActor;
    private int releaseYear;
    private int genreOfMovie;
    private int totalGross;//will encapsulate
    private boolean originalMovie;//not remake

    public Movie() {
        
    }

    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public Movie(String title, int releaseYear, int totalGross, boolean originalMovie, String leadActor) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.totalGross = totalGross;
        this.originalMovie = originalMovie;
        this.leadActor = leadActor;
    }

    public void setTitle(String title) {
        if (title != null) {
            this.title = title;
        } else {
            System.out.println("No title has been given!");
        }

    }

    public void setLeadActor(String leadActor) {
        if (leadActor != null) {
            this.leadActor = leadActor;
        } else {
            System.out.println("No lead actor input has been given!");
        }

    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear > 1880 || releaseYear < 2030) {//first movie made in 1880s, can have very late release dates planned
            this.releaseYear = releaseYear;
        } else {
            System.out.println("Year of release not possible.");
        }
    }

    public void setGenreOfMovie(int genreOfMovie) {
        if (genreOfMovie >= 0 && genreOfMovie <= 5){
            this.genreOfMovie = genreOfMovie;
        } else {
            System.out.println("Genre of movie does not match given option.");
        }
        
    }

    
    

//    public void setTotalGross(int totalGross) {
//        this.totalGross = totalGross;
//    }

    public void setOriginalMovie(boolean originalMovie) {
        this.originalMovie = originalMovie;
    }

    public String getTitle() {
        return title;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenreOfMovie() {
        switch (genreOfMovie){
            case GENRE_ACTION:
                return movieType[GENRE_ACTION];
            case GENRE_ADVENTURE:
                return movieType[GENRE_ADVENTURE];
            case GENRE_COMEDY:
                return movieType[GENRE_COMEDY];
            case GENRE_DRAMA:
                return movieType[GENRE_COMEDY];
            case GENRE_MYSTERY:
                return movieType[GENRE_MYSTERY];
            case GENRE_ROMANCE:
                return movieType[GENRE_ROMANCE];
            default:
                return "Movie genre not listed";
                
        }
       
    }

    public int getTotalGross() {
        return totalGross;
    }

    public String isOriginalMovie() {
        if(this.originalMovie == ORIGINAL){
            return "Original";
        } else {
            return "Remake";
        }
    }
    
    public boolean isValid(){
        if (releaseYear <= 2014 && releaseYear > 1880 && title != null){
            return true;    
        } else {
            return false;
        }
        
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (this.releaseYear != other.releaseYear) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", leadActor=" + leadActor + ", releaseYear=" + releaseYear + ", genreOfMovie=" + genreOfMovie + ", totalGross=" + totalGross + ", originalMovie=" + originalMovie + '}';
    }
    
    
    
    
    
    
    
    

}
