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
import javax.swing.SwingUtilities; // will need int[] variable to hold the answers

/**
 */
public class ThePriceIsRight extends JFrame implements ActionListener, MouseListener {

    public static final Dimension D = new Dimension(100, 100);
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 500;
    public static final int DIE_QUESTION_MARK = 8;
    public static final int DIE_BLANK = 7;

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
    private JLabel firstDigitTitle;
    private JLabel carTitle;
    private JLabel carName;
    private JLabel topPanelChoice;
    private JLabel bottomPanelChoice;
    private JLabel rollOutcome;

    private Button rollButton;

    private int carCost;
    int dieRollNumber = 0;

    public ThePriceIsRight() {
        init();
    }

    public void init() {

        // MAIN WINDOW; The Price is Righta
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("The Price is Right!");
        this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        // WINDOW; Border Layout
        this.setLayout(new BorderLayout());
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);

        //spacer panel
        Dimension d3 = new Dimension(50, 10);
        this.spacerPanel = new JPanel();
        this.spacerPanel.setPreferredSize(d3);
        this.spacerPanel.setSize(d3);

        //button
        this.rollButton = new Button();
        this.rollButton.setPreferredSize(d3);
        this.rollButton.setSize(d3);
        this.rollButton.setLabel("ROLL");
        this.rollButton.setActionCommand("ROLL");
        this.rollButton.addActionListener(this);

        //first digit title
        this.firstDigitTitle = new JLabel("The first digit is:", SwingConstants.CENTER);

        //car title
        this.carTitle = new JLabel("\nYour car is a:", SwingConstants.CENTER);
        this.carName = new JLabel("", SwingConstants.CENTER);

        //firstDigitDie
        this.firstDigitDie = new DiePanel();
        this.firstDigitDie.setAlignmentX(SwingConstants.CENTER);

        //left side panel
        this.leftSidePanel = new JPanel();
        this.leftSidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Dimension d2 = new Dimension(150, FRAME_HEIGHT);

        this.leftSidePanel.setPreferredSize(d2);
        this.leftSidePanel.setLayout(new BoxLayout(leftSidePanel, BoxLayout.Y_AXIS));
        this.leftSidePanel.add(carTitle);
        this.leftSidePanel.add(carName);
        this.leftSidePanel.add(spacerPanel);
        this.leftSidePanel.add(firstDigitTitle);
        this.leftSidePanel.add(firstDigitDie);

        this.leftSidePanel.add(rollButton);

        // left side of Middle Panel
        topPanelChoice = new JLabel("Higher?         ", SwingConstants.CENTER);
        bottomPanelChoice = new JLabel("Lower?          ", SwingConstants.CENTER);
        rollOutcome = new JLabel("Your Roll:      ", SwingConstants.CENTER);

        // PARENT PANEL
        this.middlePanel = new JPanel();
        this.middlePanel.setLayout(new BoxLayout(this.middlePanel, BoxLayout.PAGE_AXIS));
        this.middlePanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        this.middlePanel.setBorder(BorderFactory.createBevelBorder(5));

        // TOP DICE; HIGH
        this.topDicePanel = new JPanel();
        this.topDicePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.topDicePanel.add(topPanelChoice);

        // Mid DICE; ROLLed
        this.midDicePanel = new JPanel();
        this.midDicePanel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        this.midDicePanel.add(rollOutcome);

        // BOT DICE; LOW
        this.botDicePanel = new JPanel();
        this.botDicePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.botDicePanel.add(bottomPanelChoice);

        // GENERATE DIE, put them in TOP/BOT Dice Panel
        this.dice = new DiePanel[3][4];
        initDice();

        // TOP / BOT Dice Panel
        this.middlePanel.add(topDicePanel);
        this.middlePanel.add(midDicePanel);
        this.middlePanel.add(botDicePanel);

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
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(topTitlePanel, BorderLayout.PAGE_START);
        this.add(leftSidePanel, BorderLayout.LINE_START);

        //this.pack();
        //pick car
        initCar();

    }

    private void initCar() {
        int randomChoice;
        randomChoice = (int) (Math.random() * 1);

        switch (randomChoice) {
            case 0:
                this.carName.setText("Hennessey Venom");//54321
                this.carName.repaint();
                firstDigitDie.setValue(5);
                firstDigitDie.repaint();
                break;
        }
    }

    private void initDice() {
        DiePanel die;
        //Dimension d = new Dimension( 100, 100 );
        for (int row = 0; row < dice.length; row++) {
            for (int col = 0; col < dice[row].length; col++) {

                die = new DiePanel();
                die.setPreferredSize(D);
                die.setSize(D);
                die.setValue(DIE_BLANK);//make constants
                die.setName(row + "-" + col);
                die.addMouseListener(this);

                if ((row + col) % 2 == 0) {
                    die.setBorder(BorderFactory.createLineBorder(Color.RED));
                    die.setBackground(Color.GREEN);
                } else {
                    die.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                    die.setBackground(Color.RED);
                }

                this.dice[row][col] = die;
                if (row == 0) {
                    this.topDicePanel.add(this.dice[row][col]);
                } else if (row == 1) {
                    this.dice[row][col].setColour(Color.blue);
                    this.midDicePanel.add(this.dice[row][col]);
                } else {
                    this.botDicePanel.add(this.dice[row][col]);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dice[1][dieRollNumber].assignRandomValue();
        this.dice[1][dieRollNumber].repaint();

        
        if (this.dice[1][dieRollNumber].getValue() == 6) {//equals 6
            this.dice[0][dieRollNumber].setValue(6);
            this.dice[0][dieRollNumber].repaint();
        } else if (this.dice[1][dieRollNumber].getValue() == 1) {//equals 1
            this.dice[2][dieRollNumber].setValue(1);
            this.dice[2][dieRollNumber].repaint();
        } else {
            this.dice[0][dieRollNumber].setValue(DIE_QUESTION_MARK);
            this.dice[0][dieRollNumber].repaint();
            this.dice[2][dieRollNumber].setValue(DIE_QUESTION_MARK);
            this.dice[2][dieRollNumber].repaint();
            this.rollButton.setEnabled(false);//Must choose higher or lower
        }
      
        dieRollNumber++;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(dieRollNumber);
        String dieRollNumberString = String.valueOf(dieRollNumber - 1);
        if (e.getComponent().getName().equalsIgnoreCase("0-" + dieRollNumberString)){//CLICK TOP NUMBER
            System.out.println("TOP option CLICKED");
            
        } else if (e.getComponent().getName().equalsIgnoreCase("2-" + dieRollNumberString)){//CLICK TOP NUMBER
            System.out.println("BOTTOm option CLICKED");
        }
        System.out.println("Mouse Clicked on " + e.getComponent().getName());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // DO NOTHING
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // DO NOTHING
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // DO NOTHING
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // DO NOTHING
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ThePriceIsRight().setVisible(true);
            }
        }
        );

    }

}
