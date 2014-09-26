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
public class Movie {
    final int GENRE_ACTION = 0;
    final int GENRE_ADVENTURE = 1;
    final int GENRE_COMEDY= 2;
    final int GENRE_DRAMA= 3;
    final int GENRE_MYSTERY = 4;
    final int GENRE_ROMANCE= 5;
    
    final boolean ORIGINAL = true;
    final boolean REMAKE = false; 
    private String title;
    private String leadActor;
    private int releaseYear;
    private int genreOfMovie;
    private int totalGross;
    private boolean originalMovie;//not remake
}
