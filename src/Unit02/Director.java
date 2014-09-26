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
public class Director {
    final boolean DEAD = false;
    final boolean ALIVE = true;
    final String[]  preferredGenre = {
    "Action", "Adventure", "Comedy", "Drama", "Mystery", "Romance"
    };
    final int PREFERRED_GENRE_ACTION = 0;
    final int PREFERRED_GENRE_ADVENTURE = 1;
    final int PREFERRED_GENRE_COMEDY= 2;
    final int PREFERRED_GENRE_DRAMA= 3;
    final int PREFERRED_GENRE_MYSTERY = 4;
    final int PREFERRED_GENRE_ROMANCE= 5;
    
    final String[] homeCountry = {
    "Canada", "USA", "Other"    
    };
    final int HOME_COUNTRY_CANADA = 0;
    final int HOME_COUNTRY_USA = 1;
    final int HOME_COUNTRY_OTHER = 2;
    
    private String firstName;
    private String lastName;
    private int county;
    private int identificationNumber;//SSN and SIN can be same from Canada to USA
    private int netWorth;
    private int age;
    private int typeOfMoviesMade;
    private boolean stateOfHealth;
    
    public Director(){//empty
        
    }
    
    public Director(int identificationNumber, int countryID, boolean health){
    this.identificationNumber = identificationNumber;    
    this.county = countryID;
    this.stateOfHealth = health;
    }
    
    public Director(int identificationNumber, int countryID, boolean health, String firstName, String lastName){
    this.identificationNumber = identificationNumber;    
    this.county = countryID;
    this.stateOfHealth = health;
    this.firstName = firstName;
    this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCounty(int county) {
        this.county = county;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setNetWorth(int netWorth) {
        this.netWorth = netWorth;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTypeOfMoviesMade(int typeOfMoviesMade) {
        this.typeOfMoviesMade = typeOfMoviesMade;
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

    public int getCounty() {
        return county;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public int getNetWorth() {
        return netWorth;
    }

    public int getAge() {
        return age;
    }

    public int getTypeOfMoviesMade() {
        return typeOfMoviesMade;
    }

    public boolean isStateOfHealth() {
        return stateOfHealth;
    }
    
    
    
    
}


