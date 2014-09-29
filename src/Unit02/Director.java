/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit02;

import java.util.Objects;

/**
 *
 * @author 1SANDRESCO
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

    public Director() {//empty
        this.country = NOT_VALID;
        this.typeOfMoviesMade = NOT_VALID;
    }

    public Director(String identificationNumber, int countryID, boolean health) {
        this.identificationNumber = identificationNumber;
        this.country = countryID;
        this.stateOfHealth = health;
    }

    public Director(String identificationNumber, int countryID, boolean health, String firstName, String lastName) {
        this.identificationNumber = identificationNumber;
        this.country = countryID;
        this.stateOfHealth = health;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public void setCountry(int country) {
        if (country >= 0 && country <=2){
         this.country = country;   
        }
        
    }

    public void setIdentificationNumber(String identificationNumber) {
        if (identificationNumber.length() == 9 ){       
            this.identificationNumber = identificationNumber;
        }
    }

    public void setNetWorth(int netWorth) {
        this.netWorth = netWorth;
    }

    public void setAge(int age) {
        if (age > 5){
         this.age = age;   
        } else {
         this.age = NOT_VALID;
        }
        
    }

    public void setTypeOfMoviesMade(int typeOfMoviesMade) {
        if (typeOfMoviesMade >=0 && typeOfMoviesMade <= 5){
            this.typeOfMoviesMade = typeOfMoviesMade;    
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

    public String getCountry() {
        switch(this.country){
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

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public int getNetWorth() {
        return netWorth;
    }

    public int getAge() {
        return age;  
      
        
    }

    public String getTypeOfMoviesMade() {
    switch (typeOfMoviesMade){
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
            return "Not Listed";
    }    
    }

    public String getStateOfHealth() {
        if (DEAD){
            return "Dead";   
        } else {
            return "Alive";
        }
        
    }
    
    public boolean isValid(){
        if (stateOfHealth == DEAD || identificationNumber == null || country == NOT_VALID){
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

    
}
