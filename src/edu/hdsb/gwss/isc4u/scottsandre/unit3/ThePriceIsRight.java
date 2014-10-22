/*
 *
 */
package edu.hdsb.gwss.isc4u.scottsandre.unit3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 */
public class ThePriceIsRight extends JFrame implements ActionListener, MouseListener {
    public static final Dimension D = new Dimension( 100, 100 );
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 500;
    private JPanel middlePanel;
    private JPanel topDicePanel;
    private JPanel midDicePanel;
    private JPanel botDicePanel;
    private JPanel topTitlePanel;
    private JPanel spacerPanel;
    private JPanel leftSidePanel;
    
    private DiePanel[][] dice;
    private DiePanel firstDigitDie;
    private JLabel title;
    
    private Button rollButton;
    public ThePriceIsRight() {
        init();
    }

    public void init() {

        // MAIN WINDOW; The Price is Righta
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setTitle( "The Price is Right!" );

        // WINDOW; Border Layout
        this.setLayout( new BorderLayout() );
        this.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        
        //spacer panel
        Dimension d3 = new Dimension (50, 50);
        this.spacerPanel = new JPanel();
        this.spacerPanel.setPreferredSize(d3);
        this.spacerPanel.setSize(d3);
        
          //button
        this.rollButton = new Button();
       this.rollButton.setPreferredSize(d3);
       this.rollButton.setSize(d3);
        this.rollButton.setLabel("ROLL");
        
        //firstDigitDie
        DiePanel firstDigitDie = new DiePanel();
       
        
        //left side panel
        this.leftSidePanel = new JPanel();
        this.leftSidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Dimension d2 = new Dimension(150, FRAME_HEIGHT);
        
        this.leftSidePanel.setPreferredSize(d2);
        this.leftSidePanel.setLayout(new BoxLayout(leftSidePanel, BoxLayout.Y_AXIS));
        this.leftSidePanel.add(spacerPanel);
        this.leftSidePanel.add(firstDigitDie);
        this.leftSidePanel.add(rollButton);
        
        // PARENT PANEL
        this.middlePanel = new JPanel();
        this.middlePanel.setLayout(new BoxLayout( this.middlePanel, BoxLayout.PAGE_AXIS ) );
        this.middlePanel.setBorder( BorderFactory.createLineBorder( Color.YELLOW ) );
        this.middlePanel.setBorder(BorderFactory.createBevelBorder(5));
        // TOP DICE; HIGH
        this.topDicePanel = new JPanel();
        this.topDicePanel.setBorder( BorderFactory.createLineBorder( Color.BLUE ) );
        
        // Mid DICE; ROLLed
        this.midDicePanel = new JPanel();
        this.midDicePanel.setBorder( BorderFactory.createLineBorder( Color.MAGENTA ) );
        // this.midDicePanel.add(new DiePanel() );
        // BOT DICE; LOW
        this.botDicePanel = new JPanel();
        this.botDicePanel.setBorder( BorderFactory.createLineBorder( Color.BLUE ) );
        //this.botDicePanel.add(rollButton);
        //this.botDicePanel.add(spacerPanel);
        
        // GENERATE DIE, put them in TOP/BOT Dice Panel
        this.dice = new DiePanel[3][4];
        initDice();

        // TOP / BOT Dice Panel
        this.middlePanel.add( topDicePanel );
        this.middlePanel.add( midDicePanel );
        this.middlePanel.add( botDicePanel );
        
        //topTitlePanel
        this.topTitlePanel = new JPanel();
        this.topTitlePanel.setBackground(Color.yellow);
        this.topTitlePanel.setBorder(BorderFactory.createEtchedBorder());
        //title label
        this.title = new JLabel("Welcome to The Price is Right!", SwingConstants.CENTER);
        this.title.setAlignmentX(CENTER_ALIGNMENT);
        Dimension d1 = new Dimension(FRAME_WIDTH, 40);
        this.title.setPreferredSize(d1);
        this.topTitlePanel.add(title);
        
      
        
        // ADD ITEMS TO middlePanel
        this.add(middlePanel, BorderLayout.CENTER );
        this.add(topTitlePanel, BorderLayout.PAGE_START );
        this.add( leftSidePanel, BorderLayout.LINE_START );
        this.add( new JLabel( "LINE_END" ), BorderLayout.LINE_END );
        this.add( new JLabel( "PAGE_END" ), BorderLayout.PAGE_END );
        //this.pack();

    }

    private void initDice() {
        DiePanel die;
        //Dimension d = new Dimension( 100, 100 );
        for ( int row = 0; row < dice.length; row++ ) {
            for ( int col = 0; col < dice[row].length; col++ ) {

                die = new DiePanel();
                die.setPreferredSize( D);
                die.setSize( D );
                die.setName( row + "-" + col );
                die.addMouseListener( this );

                if ( ( row + col ) % 2 == 0 ) {
                    die.setBorder( BorderFactory.createLineBorder( Color.RED ) );
                    die.setBackground( Color.GREEN );
                } else {
                    die.setBorder( BorderFactory.createLineBorder( Color.GREEN ) );
                    die.setBackground( Color.RED );
                }

                this.dice[row][col] = die;
                if ( row == 0 ) {
                    this.topDicePanel.add( this.dice[row][col] );
                } else if ( row == 1 ) {
                    this.midDicePanel.add( this.dice[row][col] );
                } else {
                    this.botDicePanel.add( this.dice[row][col] );
                }
            }
        }
    }

    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
        // BUTTON PRESSED!!
        System.out.println( "DO SOMETHING?" );
        
        
    }   

    @Override
    public void mouseClicked( MouseEvent e ) {
        System.out.println( "Mouse Clicked on " + e.getComponent().getName() );  
    }

    @Override
    public void mousePressed( MouseEvent e ) {
        // DO NOTHING
    }

    @Override
    public void mouseReleased( MouseEvent e ) {
        // DO NOTHING
    }

    @Override
    public void mouseEntered( MouseEvent e ) {
        // DO NOTHING
    }

    @Override
    public void mouseExited( MouseEvent e ) {
        // DO NOTHING
    }

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new ThePriceIsRight().setVisible( true );
                    }
                }
        );

    }

}
