/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit02;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author 1SANDRESCO Date: Sept 29, 2014 Version: v1.00 Description: Creates an
 * object of movie director
 */
public class Director {

    final int NOT_VALID = -1;
    final boolean DEAD = false;
    final boolean ALIVE = true;
    final String[] preferredGenre = {
        "Action", "Adventure", "Comedy", "Drama", "Mystery", "Romance"
    };
    final int PREFERRED_GENRE_ACTION = 0;
    final int PREFERRED_GENRE_ADVENTURE = 1;
    final int PREFERRED_GENRE_COMEDY = 2;
    final int PREFERRED_GENRE_DRAMA = 3;
    final int PREFERRED_GENRE_MYSTERY = 4;
    final int PREFERRED_GENRE_ROMANCE = 5;

    final String[] homeCountry = {
        "Canada", "USA", "Other"
    };
    final int HOME_COUNTRY_CANADA = 0;
    final int HOME_COUNTRY_USA = 1;
    final int HOME_COUNTRY_OTHER = 2;

    private String firstName;
    private String lastName;
    private int country;
    private String identificationNumber;//SSN and SIN can be same from Canada to USA
    private int netWorth;
    private int age;
    private int typeOfMoviesMade;
    private boolean stateOfHealth;
    private ArrayList<Movie> movies = new ArrayList();

    public Director() {//empty
        System.out.println("Movie has been created.");
       // this.country = NOT_VALID;
       // this.typeOfMoviesMade = NOT_VALID;
    }

    public Director(String identificationNumber, int countryID, boolean health) {
        this();
        this.identificationNumber = identificationNumber;
        this.country = countryID;
        this.stateOfHealth = health;
    }

    public Director(String identificationNumber, int countryID, boolean health, String firstName, String lastName) {
        this();
        this.identificationNumber = identificationNumber;
        this.country = countryID;
        this.stateOfHealth = health;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null && firstName.length() < 30) {
            this.firstName = firstName;
        } else {
            System.out.println("First Name not valid.");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && lastName.length() < 40) {
            this.lastName = lastName;
        } else {
            System.out.println("Last Name not valid.");
        }
    }

    public void setCountry(int country) {
        if (country >= 0 && country <= 2) {
            this.country = country;
        } else {
            System.out.println("Country number given not valid.");
        }

    }

    public void setIdentificationNumber(String identificationNumber) {
        if (identificationNumber.length() == 9) {
            this.identificationNumber = identificationNumber;
        } else {
            System.out.println("Identification Number not valid. Must be 9 digits long.");
        }
    }

    public void setNetWorth(int netWorth) {
        if (netWorth > 0 && netWorth < 999999999) {//shouldn't have more than a billion dollars
            this.netWorth = netWorth;
        } else {
            System.out.println("Sorry, director's net worth is not realistic.");
        }
    }

    public void setAge(int age) {//current or at death
        if (age > 5 && age < 120) {
            this.age = age;
        } else {
            System.out.println("Age not valid. Director too young or old");
        }

    }

    public void setTypeOfMoviesMade(int typeOfMoviesMade) {
        if (typeOfMoviesMade >= 0 && typeOfMoviesMade <= 5) {
            this.typeOfMoviesMade = typeOfMoviesMade;
        } else {
            System.out.println("Typical genre that director directs not listed.");
        }

    }

    public void setStateOfHealth(boolean stateOfHealth) {
        this.stateOfHealth = stateOfHealth;
    }

    public String[] getPreferredGenre() {
        return preferredGenre;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        String fullName = firstName + " " + lastName;
        return fullName;
    }

    public String getCountry() {
        switch (this.country) {
            case HOME_COUNTRY_CANADA:
                return homeCountry[0];
            case HOME_COUNTRY_USA:
                return homeCountry[1];
            case HOME_COUNTRY_OTHER:
                return homeCountry[2];
            default:
                return "Invalid";
        }

    }

//    public String getIdentificationNumber() {//Encapsulation, cannot get SIN or SSN of director
//        return identificationNumber;
//    }
    public int getNetWorth() {
        return netWorth;
    }

    public int getAge() {
        return age;

    }

    public String getTypeOfMoviesMade() {
        switch (typeOfMoviesMade) {
            case PREFERRED_GENRE_ACTION:
                return preferredGenre[0];
            case PREFERRED_GENRE_ADVENTURE:
                return preferredGenre[1];
            case PREFERRED_GENRE_COMEDY:
                return preferredGenre[2];
            case PREFERRED_GENRE_DRAMA:
                return preferredGenre[3];
            case PREFERRED_GENRE_MYSTERY:
                return preferredGenre[4];
            case PREFERRED_GENRE_ROMANCE:
                return preferredGenre[5];
            default:
                return "Preferred genre to direct not Listed";
        }
    }

    public String getStateOfHealth() {
        if (this.stateOfHealth == DEAD) {
            return "Dead";
        } else {
            return "Alive";
        }

    }

    public boolean isValid() {
        if (stateOfHealth == DEAD || identificationNumber == null || country == NOT_VALID) {
            return false;
        } else {
            return true;
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
        final Director other = (Director) obj;
        if (this.country != other.country) {
            return false;
        }
        if (!Objects.equals(this.identificationNumber, other.identificationNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Director{" + "firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + ", identificationNumber=" + identificationNumber + ", netWorth=" + netWorth + ", age=" + age + ", typeOfMoviesMade=" + typeOfMoviesMade + ", stateOfHealth=" + stateOfHealth + '}';
    }

    public int getNumberMovies() {
        return movies.size();
    }

    public void addMovie(Movie movieToBeAdded) {
        boolean duplicate = false;
        if (movieToBeAdded != null) {
            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getTitle() == movieToBeAdded.getTitle() && movies.get(i).getReleaseYear() == movieToBeAdded.getReleaseYear()) {
                    duplicate = true;
                    System.out.println("addMovie: movie has already been added to list.");
                    i = movies.size();
                }
            }
            if (duplicate != true) {
                if (!movieToBeAdded.isValid()) {
                    System.out.println("Movie is not valid.");
                } else {
                    System.out.println("addMovie: " + movieToBeAdded.getTitle() + " has been added");
                    movies.add(movieToBeAdded);
                }
            }
        } else {
            System.out.println("addMovie: cannot add null object");
        }
    }

    private void removeMovieByIndex(int index) {
        if (index >= 0 && index < movies.size()) {
            System.out.println("removieMovieByIndex: " + movies.get(index).getTitle() + " has been removed");
            movies.remove(index);
        } else {
            System.out.println("removieMovieByIndex: index given is not valid");
        }
    }
    
    public void removeMovie(Movie movieToBeRemoved){
        movies.remove(movieToBeRemoved);
    }

    public void removeMovie(String title, int year) {
        boolean exists = false;
        int objectIndex = 0;
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().equalsIgnoreCase(title) && movies.get(i).getReleaseYear() == year) {
                exists = true;
                objectIndex = i;
                i = movies.size();
            }
        }
        if (exists) {
            removeMovieByIndex(objectIndex);
        } else {
            System.out.println("Could not find " + title + " (" + year + ") movie, therefore could not remove.");
        }
    }

    public Movie getMovieByIndex(int index) {
        if (index >= 0 && index < movies.size()) {
            System.out.println("getMovieByIndex: " + movies.get(index).getTitle() + " has been found");
            return movies.get(index);
        } else {
            System.out.println("getMovieByIndex: movie index " + index + " not valid.");
            return null;
        }

    }

    public Movie getMovie(String title, int year) {
        int objectIndex = 0;
        boolean exists = false;
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().equalsIgnoreCase(title) && movies.get(i).getReleaseYear() == year) {
                objectIndex = i;
                exists = true;
                i = movies.size();
            }
        }
        if (exists) {
            return getMovieByIndex(objectIndex);
        } else {
            System.out.println("Could not find " + title + " (" + year + ") movie, therefore could not return.");
            return null;
        }
       
    
    }
    
    public void movieListToString(){
        for (int i = 0; i < movies.size(); i++){
            System.out.println("Index " + i + ": " + movies.get(i).toString());
        }
    }

}
