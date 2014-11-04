/*
 * Name:            Let Me Out
 * Date:            Nov, 2014
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit4.pt;

/**
 */
public class LetMeOut {

    private static final char WALL = 'W';
    private static final char EXIT = 'X';
    private static final char OPEN = '.';
    private static final char TRIED = '-';
    private static final char GOOD_PATH = '+';
    private static final char START = 'S';
    private static boolean successful = false;

    private char[][] maze = {
        {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
        {'W', '.', '.', '.', 'W', '.', '.', '.', '.', '.', '.', '.', 'W'},
        {'W', '.', 'W', '.', 'W', '.', 'W', 'W', 'W', '.', 'W', 'W', 'W'},
        {'W', '.', 'W', '.', '.', '.', 'W', 'W', '.', '.', '.', '.', 'W'},
        {'W', '.', 'W', '.', 'W', '.', 'W', 'W', '.', 'W', 'W', 'W', 'W'},
        {'W', '.', 'W', 'W', 'W', 'W', 'W', '.', '.', '.', '.', '.', 'W'},
        {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'X', 'W', 'W', 'W'}
    };
    
    

    /**
     * Display the current maze. 
     */
  public boolean findExitFrom( int row, int col ) {
        if (maze[row][col] == EXIT){
            successful = true;
        } 
        if (successful){
            maze[row][col] = GOOD_PATH;
        }
        

        return successful;
    }
    
    
    public void solve( ) {
        
        // FIND RANDOM START LOCATION
        int row;
        int col;
        do {
            row = (int) ( Math.random() * maze.length );
            col = (int) ( Math.random() * maze[0].length );
        } while( maze[row][col] != OPEN );
        maze[row][col] = START;//show start location
        
        // START!
        System.out.println( "START LOCATION: (" + row + "," + col + ")" );
        
        findExitFrom( row, col );
        
        // SHOW EXIT
        displayMaze();
        
    }
    
    /**
     * Display the current maze. 
     */
    public void displayMaze() {
        for ( int row = 0; row < maze.length; row++ ) {
            for( int col = 0; col < maze[row].length; col++ ) {
                System.out.print( maze[row][col] );
            }
            System.out.println();
        }    
        System.out.println( "-------------------------------" );
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {

        LetMeOut lmo = new LetMeOut();
        lmo.displayMaze();
        lmo.solve();

    }

}
