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
    public static final int FRAME_WIDTH = 950;
    public static final int FRAME_HEIGHT = 500;
    public static final int DIE_QUESTION_MARK = 8;
    public static final int DIE_BLANK = 7;
    public static final int CHOSEN_HIGH_OR_LOW = 9;
    public static final int HIGHER = 2;
    public static final int LOWER = 1;

    private String carCostString;
    private String rolledNumberString = "";
    private String endGuessString = "";

    private JPanel middlePanel;
    private JPanel topDicePanel;
    private JPanel midDicePanel;
    private JPanel botDicePanel;
    private JPanel topTitlePanel;
    private JPanel spacerPanel;
    private JPanel leftSidePanel;
    private JPanel rightSidePanel;
    //priavet JPanel

    private DiePanel[][] dice;
    private DiePanel firstDigitDie;

    private JLabel title;
    private JLabel firstDigitTitle;
    private JLabel carTitle;
    private JLabel carName;
    private JLabel topPanelChoice;
    private JLabel bottomPanelChoice;
    private JLabel rollOutcome;

    private JLabel winnerText;//right side panel
    private JLabel costText;
    private JLabel whatYouGuessedText;
    private JLabel endGuess;
    private JLabel rolledNumbersText;
    private JLabel carCostLabel;
    private JLabel rolledNumberLabel;
    private JLabel gameWinOrLose;
    private JLabel guessInfo;
    
    private Button rollButton;

    private int[] carCost;
    private int[] rolledNumbers = new int[4];
    private int[] choiceHigherLower = new int[4];
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

        //right side label texts
        this.guessInfo = new JLabel("L = Lower, H = Higher, C = Correctly");
        this.whatYouGuessedText = new JLabel("       YOU GUESSED:        ", SwingConstants.CENTER);
        this.endGuess = new JLabel("uuu", SwingConstants.CENTER);
        this.winnerText = new JLabel("       WIN OR LOSE:       ", SwingConstants.CENTER);
        this.costText = new JLabel("       CAR COST IS:       ", SwingConstants.CENTER);
        this.rolledNumbersText = new JLabel("       You rolled:        ", SwingConstants.CENTER);
        this.gameWinOrLose = new JLabel("aaa", SwingConstants.CENTER);

        this.carCostLabel = new JLabel("xxx", SwingConstants.CENTER);
        this.rolledNumberLabel = new JLabel("yyy", SwingConstants.CENTER);

        //spacer panel
        Dimension d3 = new Dimension(50, 10);
        this.spacerPanel = new JPanel();
        this.spacerPanel.setPreferredSize(d3);
        this.spacerPanel.setSize(d3);

        //right side panel
        this.rightSidePanel = new JPanel();
        this.rightSidePanel.setLayout(new BoxLayout(rightSidePanel, BoxLayout.Y_AXIS));
        this.rightSidePanel.add(winnerText);
        this.rightSidePanel.add(gameWinOrLose);
        this.rightSidePanel.add(costText);
        this.rightSidePanel.add(carCostLabel);
        this.rightSidePanel.add(rolledNumbersText);
        this.rightSidePanel.add(rolledNumberLabel);
        this.rightSidePanel.add(whatYouGuessedText);
        this.rightSidePanel.add(guessInfo);
        this.rightSidePanel.add(endGuess);

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

        //topTitlePanels
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
        this.add(rightSidePanel, BorderLayout.LINE_END);

        initCar();

    }

    private void initCar() {
        int randomChoice;
        randomChoice = (int) (Math.random() * 2);

        switch (randomChoice) {
            case 0:
                this.carName.setText("Hennessey Venom");//54321
                carCost = new int[]{5, 4, 3, 2, 1};
                carCostString = "54321";
                break;
            case 1:
                this.carName.setText("1999 Honda Accord");//54321
                carCost = new int[]{1, 2, 2, 3, 4};
                carCostString = "12234";
                break;
        }
        this.carName.repaint();
        firstDigitDie.setValue(carCost[0]);
        firstDigitDie.repaint();
    }

    private void initDice() {
        DiePanel die;
        //Dimension d = new Dimension( 100, 100 );
        for (int row = 0; row < dice.length; row++) {
            for (int col = 0; col < dice[row].length; col++) {

                die = new DiePanel();
                die.setPreferredSize(D);
                die.setSize(D);
                die.setValue(DIE_BLANK);//make constantsDIE_BLANK
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
        //System.out.println("first die number is" + dieRollNumber);
        this.dice[1][dieRollNumber].assignRandomValue();
        rolledNumbers[dieRollNumber] = dice[1][dieRollNumber].getValue();
        this.dice[1][dieRollNumber].repaint();
        if (this.dice[1][dieRollNumber].getValue() == carCost[dieRollNumber + 1] ){
            this.dice[0][dieRollNumber].setValue(this.dice[1][dieRollNumber].getValue());
            this.dice[0][dieRollNumber].setColour(Color.green);
            this.dice[0][dieRollNumber].repaint();
            this.dice[2][dieRollNumber].setValue(this.dice[1][dieRollNumber].getValue());
            this.dice[2][dieRollNumber].setColour(Color.green);
            this.dice[2][dieRollNumber].repaint();
        } 
        else if (this.dice[1][dieRollNumber].getValue() == 6) {//equals 6
            this.dice[2][dieRollNumber].setValue(CHOSEN_HIGH_OR_LOW);
            this.dice[2][dieRollNumber].repaint();
            choiceHigherLower[dieRollNumber] = LOWER;//lower

        } else if (this.dice[1][dieRollNumber].getValue() == 1) {//equals 1
            this.dice[0][dieRollNumber].setValue(CHOSEN_HIGH_OR_LOW);
            this.dice[0][dieRollNumber].repaint();
            choiceHigherLower[dieRollNumber] = HIGHER;//higher

        } else { // 2345
            this.dice[0][dieRollNumber].setValue(DIE_QUESTION_MARK);
            this.dice[0][dieRollNumber].repaint();
            this.dice[2][dieRollNumber].setValue(DIE_QUESTION_MARK);
            this.dice[2][dieRollNumber].repaint();
            this.rollButton.setEnabled(false);//Must choose higher or lower
        }

        dieRollNumber++;
        printArrays();
    }

    public void determineAnswer() {
        System.out.println("Determine Answer");
        boolean win = true;
       
            for (int digit = 0; digit < this.choiceHigherLower.length; digit++) {
                if (choiceHigherLower[digit] == LOWER && carCost[digit + 1] <= rolledNumbers[digit]) {//guess lower, car cost is lower than roll
                    System.out.println(digit + ": roll is lower than car cost correct");
                    win = true;
                } else if (choiceHigherLower[digit] == LOWER && carCost[digit + 1] > rolledNumbers[digit]) {//guess lower, car cost is HIGHER than roll
                    System.out.println(digit + ": roll is lower than car cost FALSE");
                    win = false;
                } else if (choiceHigherLower[digit] == HIGHER && carCost[digit + 1] >= rolledNumbers[digit]) {//guess higher, correct
                    System.out.println(digit + ": roll is higher than car cost correct");
                    win = true;
                } else if (choiceHigherLower[digit] == HIGHER && carCost[digit + 1] < rolledNumbers[digit]) {//guess lower, wrong
                    System.out.println(digit + ": roll is higher than car cost FALSE");
                    win = false;

                }
            
        }
        if (win){
           gameWinOrLose.setText("You have won a " + this.carName.getText()) ;
        } else {
           gameWinOrLose.setText("You LOSE! You did not win a " + this.carName.getText()) ; 
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.dieRollNumber < 4) {//user can still roll
            this.rollButton.setEnabled(true);
        } else { // user is done rolling
            // System.out.println("test04");
            this.carCostLabel.setText(carCostString);//final car cost display
            this.carCostLabel.repaint();
            this.rolledNumberLabel.setText(getRolledNumberString());//all numbers rolled displayed
            this.rolledNumberLabel.repaint();
            //determineAnswer();

        }
        System.out.println(dieRollNumber);
        String dieRollNumberString = String.valueOf(dieRollNumber - 1);
        if (e.getComponent().getName().equalsIgnoreCase("0-" + dieRollNumberString)) {//CLICK TOP NUMBER
            System.out.println("TOP option CLICKED");
            choiceHigherLower[dieRollNumber - 1] = HIGHER;//higher
            this.dice[0][dieRollNumber - 1].setValue(CHOSEN_HIGH_OR_LOW);
            this.dice[0][dieRollNumber - 1].repaint();
            this.dice[2][dieRollNumber - 1].setValue(DIE_BLANK);
            this.dice[2][dieRollNumber - 1].repaint();

        } else if (e.getComponent().getName().equalsIgnoreCase("2-" + dieRollNumberString)) {//CLICK TOP NUMBER
            choiceHigherLower[dieRollNumber - 1] = LOWER;//lower
            System.out.println("BOTTOm option CLICKED");
            this.dice[2][dieRollNumber - 1].setValue(CHOSEN_HIGH_OR_LOW);
            this.dice[2][dieRollNumber - 1].repaint();
            this.dice[0][dieRollNumber - 1].setValue(DIE_BLANK);
            this.dice[0][dieRollNumber - 1].repaint();

        }

        System.out.println("Mouse Clicked on " + e.getComponent().getName());

        printArrays();
    }

    public void printArrays() {
        boolean doOnce = true;
        System.out.println("\nPrint car cost: ");
        for (int i = 0; i < carCost.length; i++) {
            System.out.print(carCost[i]);
        }
        System.out.println("\nPrint rolled numbers: ");
        for (int i = 0; i < rolledNumbers.length; i++) {
            System.out.print(rolledNumbers[i]);
            //rolledNumberString += String.valueOf(rolledNumbers[i]);
        }
        System.out.println("\nPrint chosen numbers higher 2, lower 1 : ");
        for (int i = 0; i < choiceHigherLower.length; i++) {
            System.out.print(choiceHigherLower[i]);
        }
        if (choiceHigherLower[3] != 0 && doOnce) {
            displayGuesses();
            doOnce = false;
            determineAnswer();
        }
        // System.out.println("rolled Number String: " + rolledNumberString);
    }

    public void displayGuesses() {
        for (int i = 0; i < choiceHigherLower.length; i++) {
            if (choiceHigherLower[i] == 1) {
                endGuessString += "L";
            } else if (choiceHigherLower[i] == 2) {
                endGuessString += "H";
            } else if (choiceHigherLower[i] == 0){//didn't guess, got it correct by rolling
                endGuessString += "C";
            }
        }
        this.endGuess.setText(endGuessString);
    }

    public String getRolledNumberString() {

        for (int i = 0; i < rolledNumbers.length; i++) {
            //System.out.print(rolledNumbers[i]);
            rolledNumberString += String.valueOf(rolledNumbers[i]);
        }
        return " (" + String.valueOf(carCost[0]) + ") " + rolledNumberString;
        //System.out.println("rolled Number String: " + rolledNumberString); 
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
