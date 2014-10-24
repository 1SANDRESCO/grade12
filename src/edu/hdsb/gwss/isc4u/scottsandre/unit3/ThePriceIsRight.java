/*
 *
 */
package edu.hdsb.gwss.isc4u.scottsandre.unit3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
    public static final int FRAME_WIDTH = 1200;
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
    private JPanel rightSideLeft;
    private JPanel rightSideRight;
    
    private JPanel empty;
    private JLabel emptyText;

    private JLabel carIcon;
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
    private JLabel guessInfo1;
    private JLabel guessInfo2;
    private JLabel guessInfo3;
    private JLabel correctGuessText;
    private JLabel correctGuessesAnswer;
    private JLabel wrongGuessText;
    private JLabel wrongGuessesAnswer;

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
        //this.setResizable(false);
        
        //
        this.emptyText = new JLabel ("x ");
        this.empty = new JPanel();
        this.empty.add(emptyText);
        
        //right side label texts
        this.carIcon = new JLabel();
        this.guessInfo1 = new JLabel            (" L = Lower            ");
        this.guessInfo1.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.orange));
        this.guessInfo1.setForeground(Color.RED);
        this.guessInfo2 = new JLabel            (" H = Higher            ");
        this.guessInfo2.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.white));
        this.guessInfo3 = new JLabel            (" C = Correctly        ");
        this.guessInfo3.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.orange));
        
        this.whatYouGuessedText = new JLabel    (" You Guessed:-----", SwingConstants.CENTER);
        this.whatYouGuessedText.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.white));
        this.whatYouGuessedText.setAlignmentX(SwingConstants.CENTER);
        this.endGuess = new JLabel("uuu", SwingConstants.CENTER);
        this.winnerText = new JLabel            ( " Win or Lose:------", SwingConstants.CENTER);
        this.winnerText.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.white));
        this.costText = new JLabel              (" Car Cost Is:--------", SwingConstants.CENTER);
        this.rolledNumbersText = new JLabel     (" You rolled:---------", SwingConstants.CENTER);
        this.rolledNumbersText.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.orange));
        this.gameWinOrLose = new JLabel("aaa", SwingConstants.CENTER);
        this.correctGuessText = new JLabel      (" Correct Answers:", SwingConstants.CENTER);
        this.wrongGuessText = new JLabel        (" Wrong Answers:-", SwingConstants.CENTER);
        this.carCostLabel = new JLabel("xxx", SwingConstants.CENTER);
        this.rolledNumberLabel = new JLabel("yyy", SwingConstants.CENTER);
        this.correctGuessesAnswer = new JLabel("ddd", SwingConstants.CENTER);
        this.wrongGuessesAnswer = new JLabel("ccc", SwingConstants.CENTER);

        //
        //spacer panel
        Dimension d3 = new Dimension(50, 10);
        this.spacerPanel = new JPanel();
        this.spacerPanel.setPreferredSize(d3);
        this.spacerPanel.setSize(d3);
        
        
        this.rightSideLeft = new JPanel();
        this.rightSideLeft.setLayout(new BoxLayout(rightSideLeft, BoxLayout.Y_AXIS));
        this.rightSideLeft.setAlignmentX(SwingConstants.CENTER);
        this.rightSideRight = new JPanel();
        this.rightSideRight.setLayout(new BoxLayout(rightSideRight, BoxLayout.Y_AXIS));

        this.rightSideLeft.add(winnerText);

        this.rightSideRight.add(gameWinOrLose);
        this.rightSideLeft.add(rolledNumbersText);
        this.rightSideRight.add(rolledNumberLabel);
        this.rightSideLeft.add(whatYouGuessedText);
        this.rightSideLeft.add(guessInfo1);
        this.rightSideLeft.add(guessInfo2);
        this.rightSideLeft.add(guessInfo3);
        //this.rightSideRight.add(spacerPanel);
        this.rightSideRight.add(endGuess);
        //this.rightSideRight.add(empty);
        //this.rightSideRight.add(empty);
        //this.rightSideRight.add(empty);
        this.rightSideLeft.add(costText);
        this.rightSideRight.add(carCostLabel);
        this.rightSideLeft.add(correctGuessText);
        this.rightSideRight.add(correctGuessesAnswer);
        this.rightSideLeft.add(wrongGuessText);
        this.rightSideRight.add(wrongGuessesAnswer);

        

        //right side panel
        this.rightSidePanel = new JPanel();
        this.rightSidePanel.setLayout(new BoxLayout(rightSidePanel, BoxLayout.X_AXIS));
        this.rightSidePanel.add(rightSideLeft);
        this.rightSidePanel.add(rightSideRight);

        //button
        this.rollButton = new Button();
        this.rollButton.setBackground(Color.green);
        this.rollButton.setPreferredSize(d3);
        this.rollButton.setSize(d3);
        this.rollButton.setFont(new Font("TimesRoman", Font.BOLD, 14));
        this.rollButton.setForeground(Color.BLACK);
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
        this.leftSidePanel.setAlignmentX(SwingConstants.CENTER);

        Dimension d2 = new Dimension(180, FRAME_HEIGHT);

        this.leftSidePanel.setPreferredSize(d2);
        this.leftSidePanel.setLayout(new BoxLayout(leftSidePanel, BoxLayout.Y_AXIS));
        this.leftSidePanel.add(carTitle);
        this.leftSidePanel.add(carName);
        //this.leftSidePanel.add(carIcon);-----------------------------------------------------------
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
        this.title = new JLabel("Welcome to The Price is Right! Hosted by Scott Sandre", SwingConstants.CENTER);
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
        randomChoice = (int) (Math.random() * 5);

        switch (randomChoice) {
            case 0:
                this.carName.setText("Hennessey Venom");//54321
                carCost = new int[]{5, 4, 3, 2, 1};
                carCostString = "54321";
                //this.carIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/hdsb/gwss/isc4u/scottsandre/unit3/car2.jpg"))); 

                break;
            case 1:
                this.carName.setText("1999 Honda Accord");//54321
                carCost = new int[]{1, 2, 2, 3, 4};
                carCostString = "12234";
                //this.carIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/hdsb/gwss/isc4u/scottsandre/unit3/car1.jpg"))); 
                break;
            case 2:
                this.carName.setText("Ford GT");//35126
                carCost = new int[]{3, 5, 1, 2, 6};
                carCostString = "35126";
                //this.carIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/hdsb/gwss/isc4u/scottsandre/unit3/car1.jpg"))); 
                break;
            case 3:
                this.carName.setText("Lambourghini");//35126
                carCost = new int[]{6, 6, 6, 6, 6};
                carCostString = "66666";
                //this.carIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/hdsb/gwss/isc4u/scottsandre/unit3/car1.jpg"))); 
                break;
            case 4:
                this.carName.setText("Mercedes SLSAMG");//35126
                carCost = new int[]{4, 6, 1, 2, 3};
                carCostString = "46123";
                //this.carIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/hdsb/gwss/isc4u/scottsandre/unit3/car1.jpg"))); 
                break;

        }
        this.carName.repaint();
        firstDigitDie.setValue(carCost[0]);
        firstDigitDie.repaint();
        Dimension d4 = new Dimension(300, 200);
        this.carIcon.setPreferredSize(d4);
        this.carIcon.setSize(d4);
        this.carIcon.repaint();
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
        this.rollButton.setBackground(Color.LIGHT_GRAY);
        this.rollButton.setForeground(Color.LIGHT_GRAY);
        //System.out.println("first die number is" + dieRollNumber);
        this.dice[1][dieRollNumber].assignRandomValue();
        rolledNumbers[dieRollNumber] = dice[1][dieRollNumber].getValue();
        this.dice[1][dieRollNumber].repaint();
        if (this.dice[1][dieRollNumber].getValue() == carCost[dieRollNumber + 1]) {
            this.dice[0][dieRollNumber].setValue(this.dice[1][dieRollNumber].getValue());
            this.dice[0][dieRollNumber].setColour(Color.green);
            this.dice[0][dieRollNumber].repaint();
            this.dice[2][dieRollNumber].setValue(this.dice[1][dieRollNumber].getValue());
            this.dice[2][dieRollNumber].setColour(Color.green);
            this.dice[2][dieRollNumber].repaint();
            this.rollButton.setBackground(Color.green);
            this.rollButton.setForeground(Color.black);
            
        } else if (this.dice[1][dieRollNumber].getValue() == 6) {//equals 6
            this.dice[2][dieRollNumber].setValue(CHOSEN_HIGH_OR_LOW);
            this.dice[2][dieRollNumber].repaint();
            choiceHigherLower[dieRollNumber] = LOWER;//lower
            this.rollButton.setBackground(Color.green);
            this.rollButton.setForeground(Color.black);

        } else if (this.dice[1][dieRollNumber].getValue() == 1) {//equals 1
            this.dice[0][dieRollNumber].setValue(CHOSEN_HIGH_OR_LOW);
            this.dice[0][dieRollNumber].repaint();
            choiceHigherLower[dieRollNumber] = HIGHER;//higher
            this.rollButton.setBackground(Color.green);
            this.rollButton.setForeground(Color.black);

        } else { // 2345
            this.dice[0][dieRollNumber].setValue(DIE_QUESTION_MARK);
            this.dice[0][dieRollNumber].repaint();
            this.dice[2][dieRollNumber].setValue(DIE_QUESTION_MARK);
            this.dice[2][dieRollNumber].repaint();
            this.rollButton.setEnabled(false);//Must choose higher or lower
        }

        dieRollNumber++;
        System.out.println("Die Roll Number ++ die roll number is now : " + dieRollNumber);
        printArrays();
    }

    public void determineAnswer() {
        System.out.println("Determine Answer");
        String correctInfo = "";
        String wrongInfo = "";
        int win = 0;

        for (int digit = 0; digit < this.choiceHigherLower.length; digit++) {
            if (choiceHigherLower[digit] == LOWER && carCost[digit + 1] <= rolledNumbers[digit]) {//guess lower, car cost is lower than roll
                System.out.println(digit + ": roll is lower than car cost correct");
                win ++;
                
            } else if (choiceHigherLower[digit] == LOWER && carCost[digit + 1] > rolledNumbers[digit]) {//guess lower, car cost is HIGHER than roll
                System.out.println(digit + ": roll is lower than car cost FALSE");
                
            } else if (choiceHigherLower[digit] == HIGHER && carCost[digit + 1] >= rolledNumbers[digit]) {//guess higher, correct
                System.out.println(digit + ": roll is higher than car cost correct");
                win++;
            } else if (choiceHigherLower[digit] == HIGHER && carCost[digit + 1] < rolledNumbers[digit]) {//guess lower, wrong
                System.out.println(digit + ": roll is higher than car cost FALSE");
               

            }

        }
        if (win == 4) {
            gameWinOrLose.setText("You have won a " + this.carName.getText());
        } else {
            gameWinOrLose.setText("You LOSE! You did not win a " + this.carName.getText());
        }
        
        correctGuessesAnswer.setText(correctInfo);
        wrongGuessesAnswer.setText(wrongInfo);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("dieRollNumber: " + dieRollNumber);
        if (this.dieRollNumber < 4) {//user can still roll
            this.rollButton.setEnabled(true);
            this.rollButton.setBackground(Color.green);
            this.rollButton.setForeground(Color.black);
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
            } else if (choiceHigherLower[i] == 0) {//didn't guess, got it correct by rolling
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
