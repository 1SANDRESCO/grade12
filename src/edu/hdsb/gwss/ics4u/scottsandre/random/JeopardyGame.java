/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.random;

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
import javax.swing.SwingUtilities;

public class JeopardyGame extends JFrame implements ActionListener, MouseListener {

    public static final int WINDOW_SIZE = 750;
    public static final int QUESTION_SIZE = 400;
    public static int numberPlayers;
    public static int screenNumber = 1;
    public static int turnNumber = 1;
    public static int[] moneyHolder;
    public static int questionNumber;

    private static final Dimension topPanelDimension = new Dimension(WINDOW_SIZE, 50);
    private static final Dimension dButton1 = new Dimension(100, 100);
    private static final Dimension dButton2 = new Dimension(100, 80);
    private static final Dimension dButton3 = new Dimension(80, 80);
    private static final Dimension centralPanelScreen2Dimension = new Dimension(WINDOW_SIZE - 50, 400);
    private static final Dimension bottomPannelScreen2D = new Dimension(WINDOW_SIZE - 50, 150);
    private static final Dimension subjectsD = new Dimension(WINDOW_SIZE - 50, 400);
    private static final Dimension questionD = new Dimension(QUESTION_SIZE, QUESTION_SIZE / 2);

    private static final String physicsQ0 = "ZZZZZZZZZZZZZZ";
    private static final String physicsA00 = "aa";
    private static final String physicsA01 = "bb";
    private static final String physicsA02 = "cc";
    private static final String physicsA03 = "dd";

    private static final String physicsQ1 = "QQQQQQQQQQQQQQQ";
    private static final String physicsQ2 = "WWWWWWWWWWWWW";

    private static Dimension playersD;
    private static Dimension infoD;

    private final String ONE_PLAYER = "ONE PLAYER";
    private final String TWO_PLAYERS = "TWO PLAYERS";
    private final String THREE_PLAYERS = "THREE PLAYERS";
    private final String FOUR_PLAYERS = "FOUR PLAYERS";

    private Button test;
    private Button onePlayer;
    private Button twoPlayers;
    private Button threePlayers;
    private Button fourPlayers;
    private Button[][] questions = new Button[3][3];
    private Button[] answers = new Button[4];

    private JPanel topTitlePanel;
    private JPanel bottomPannelScreen1;
    private JPanel centralPanelScreen2;
    private JPanel bottomPannelScreen2;
    private JPanel bottomPlayerHolder;
    private JPanel[] playersPanel;
    private JPanel turnPanel;
    private JPanel subjectsPanel;
    private JPanel[][] subjectsHolder = new JPanel[4][3];
    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private JPanel row4;
    private JPanel questionRow;
    private JPanel answerRow;

    private JLabel topTitleText;
    private JLabel centreTextScreen1;
    private JLabel bottomTextScreen2;
    private JLabel[][] playersInfo;
    private JLabel turnText;
    private JLabel[] categories = new JLabel[3];
    private JLabel questionLabel;

    private JFrame window2;

    private JFrame window00;
    private JFrame window01;
    private JFrame window02;

    private JFrame window10;
    private JFrame window11;
    private JFrame window12;

    private JFrame window20;
    private JFrame window21;
    private JFrame window22;

    public JeopardyGame() {
        initializeScreen1();
    }

    public void initializeScreen1() {
        //create window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Jeopardy Game!");
        this.setSize(WINDOW_SIZE, WINDOW_SIZE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        //SCREEN 1        
        //top panel, title screen
        this.topTitlePanel = new JPanel();
        this.topTitlePanel.setBackground(Color.blue);
        this.topTitlePanel.setBorder(BorderFactory.createEtchedBorder());
        this.topTitlePanel.setSize(topPanelDimension);

        //label text inside of top panel
        this.topTitleText = new JLabel("Welcome to Scott Sandre's Jeapordy game!", SwingConstants.CENTER);
        this.topTitleText.setAlignmentX(CENTER_ALIGNMENT);
        this.topTitleText.setPreferredSize(topPanelDimension);

        //bottom banel
        this.bottomPannelScreen1 = new JPanel();
        this.bottomPannelScreen1.setBackground(Color.blue);
        this.bottomPannelScreen1.setBorder(BorderFactory.createEtchedBorder());
        this.bottomPannelScreen1.setSize(topPanelDimension);
        this.bottomPannelScreen1.setLayout(new BoxLayout(bottomPannelScreen1, BoxLayout.X_AXIS));

        //BUTTONS
        this.test = new Button();
        this.test.setBackground(Color.LIGHT_GRAY);
        this.test.setPreferredSize(dButton1);
        this.test.setSize(dButton1);
        this.test.setFont(new Font("TimesRoman", Font.BOLD, 14));
        this.test.setForeground(Color.BLACK);
        this.test.setLabel("TEST");
        this.test.setActionCommand("TEST");
        this.test.addActionListener(this);
        this.test.setEnabled(true);

        this.onePlayer = new Button();
        this.onePlayer.setBackground(Color.CYAN);
        this.onePlayer.setSize(dButton1);
        this.onePlayer.setPreferredSize(dButton1);
        this.onePlayer.setFont(new Font("TimesRoman", Font.BOLD, 14));
        this.onePlayer.setForeground(Color.BLACK);
        this.onePlayer.setLabel(ONE_PLAYER);
        this.onePlayer.setActionCommand(ONE_PLAYER);
        this.onePlayer.addActionListener(this);
        this.onePlayer.setEnabled(true);

        this.twoPlayers = new Button();
        this.twoPlayers.setBackground(Color.GREEN);
        this.twoPlayers.setPreferredSize(dButton1);
        this.twoPlayers.setFont(new Font("TimesRoman", Font.BOLD, 14));
        this.twoPlayers.setForeground(Color.BLACK);
        this.twoPlayers.setLabel(TWO_PLAYERS);
        this.twoPlayers.setActionCommand(TWO_PLAYERS);
        this.twoPlayers.addActionListener(this);
        this.twoPlayers.setEnabled(true);

        this.threePlayers = new Button();
        this.threePlayers.setBackground(Color.YELLOW);
        this.threePlayers.setPreferredSize(dButton1);
        this.threePlayers.setFont(new Font("TimesRoman", Font.BOLD, 14));
        this.threePlayers.setForeground(Color.BLACK);
        this.threePlayers.setLabel(THREE_PLAYERS);
        this.threePlayers.setActionCommand(THREE_PLAYERS);
        this.threePlayers.addActionListener(this);
        this.threePlayers.setEnabled(true);

        this.fourPlayers = new Button();
        this.fourPlayers.setBackground(Color.MAGENTA);
        this.fourPlayers.setSize(dButton1);
        this.fourPlayers.setPreferredSize(dButton1);
        this.fourPlayers.setFont(new Font("TimesRoman", Font.BOLD, 14));
        this.fourPlayers.setForeground(Color.BLACK);
        this.fourPlayers.setLabel(FOUR_PLAYERS);
        this.fourPlayers.setActionCommand(FOUR_PLAYERS);
        this.fourPlayers.addActionListener(this);
        this.fourPlayers.setEnabled(true);

        this.centreTextScreen1 = new JLabel("Please enter the number of people playing", SwingConstants.CENTER);

        //add stuff
        this.topTitlePanel.add(this.topTitleText);
        this.bottomPannelScreen1.add(onePlayer);
        this.bottomPannelScreen1.add(twoPlayers);
        this.bottomPannelScreen1.add(threePlayers);
        this.bottomPannelScreen1.add(fourPlayers);

        this.add(topTitlePanel, BorderLayout.PAGE_START);
        //this.add(test, BorderLayout.CENTER);
        this.add(centreTextScreen1, BorderLayout.CENTER);
        this.add(bottomPannelScreen1, BorderLayout.SOUTH);

    }

    public void initializeScreen2() {
        //SCREEN 2 // window2
        moneyHolder = new int[numberPlayers];
        playersD = new Dimension(WINDOW_SIZE / (numberPlayers + 1), 150);
        infoD = new Dimension(WINDOW_SIZE / (numberPlayers + 1), 30);

        this.topTitlePanel.setBackground(Color.blue);
        this.topTitleText.setForeground(Color.black);
        this.topTitleText.setText("Scott Sandre's Jeapordy Game Main Page");

        this.centralPanelScreen2 = new JPanel();
        this.centralPanelScreen2.setBorder(BorderFactory.createEtchedBorder());
        this.centralPanelScreen2.setSize(centralPanelScreen2Dimension);
        this.centralPanelScreen2.setLayout(new BoxLayout(centralPanelScreen2, BoxLayout.Y_AXIS));

        this.turnPanel = new JPanel();
        this.turnPanel.setBorder(BorderFactory.createEtchedBorder());
        this.turnPanel.setSize(topPanelDimension);
        this.turnPanel.setPreferredSize(topPanelDimension);

        this.turnText = new JLabel("Player #" + turnNumber + ": It is your turn", SwingConstants.CENTER);
        this.turnText.setSize(topPanelDimension);
        this.turnText.setPreferredSize(topPanelDimension);

        this.subjectsPanel = new JPanel();
        this.subjectsPanel.setBorder(BorderFactory.createEtchedBorder());
        this.subjectsPanel.setBackground(Color.PINK);
        this.subjectsPanel.setSize(subjectsD);
        this.subjectsPanel.setPreferredSize(subjectsD);
        this.subjectsPanel.setLayout(new BoxLayout(subjectsPanel, BoxLayout.Y_AXIS));

        this.bottomPannelScreen2 = new JPanel();
        this.bottomPannelScreen2.setBackground(Color.GRAY);
        this.bottomPannelScreen2.setBorder(BorderFactory.createEtchedBorder());
        this.bottomPannelScreen2.setSize(bottomPannelScreen2D);
        this.bottomPannelScreen2.setPreferredSize(bottomPannelScreen2D);
        this.bottomPannelScreen2.setLayout(new BoxLayout(bottomPannelScreen2, BoxLayout.Y_AXIS));

        this.bottomTextScreen2 = new JLabel("Player Information:", SwingConstants.CENTER);
        this.bottomTextScreen2.setAlignmentX(CENTER_ALIGNMENT);
        this.bottomTextScreen2.setBackground(Color.white);
        this.bottomTextScreen2.setForeground(Color.red);

        this.bottomPlayerHolder = new JPanel();
        this.bottomPlayerHolder.setBackground(Color.yellow);
        this.bottomPlayerHolder.setBorder(BorderFactory.createEtchedBorder());
        this.bottomPlayerHolder.setSize(bottomPannelScreen2D);
        this.bottomPlayerHolder.setPreferredSize(bottomPannelScreen2D);
        this.bottomPlayerHolder.setLayout(new BoxLayout(bottomPlayerHolder, BoxLayout.X_AXIS));

        playersPanel = new JPanel[numberPlayers + 1];
        playersPanel[0] = new JPanel();
        playersPanel[0].setSize(playersD);
        playersPanel[0].setPreferredSize(playersD);
        //playersPanel[0].setLayout(new BoxLayout(playersPanel[0], BoxLayout.Y_AXIS));
        playersPanel[0].setBackground(Color.RED);
        bottomPlayerHolder.add(playersPanel[0]);

        for (int i = 1; i < numberPlayers + 1; i++) {
            playersPanel[i] = new JPanel();

            playersPanel[i].setSize(playersD);
            playersPanel[i].setPreferredSize(playersD);
            // playersPanel[i].setLayout(new BoxLayout(playersPanel[i], BoxLayout.Y_AXIS));
            switch (i) {
                case 1:
                    playersPanel[i].setBackground(Color.CYAN);
                    break;
                case 2:
                    playersPanel[i].setBackground(Color.GREEN);
                    break;
                case 3:
                    playersPanel[i].setBackground(Color.YELLOW);
                    break;
                case 4:
                    playersPanel[i].setBackground(Color.MAGENTA);
                    break;
            }
            bottomPlayerHolder.add(playersPanel[i]);
        }
        //PLAYER LABELS
        playersInfo = new JLabel[numberPlayers + 1][3];
        playersInfo[0][0] = new JLabel("PLAYER #: ", SwingConstants.CENTER);
        playersInfo[0][1] = new JLabel("TURN: ", SwingConstants.CENTER);
        playersInfo[0][2] = new JLabel("MONEY: ", SwingConstants.CENTER);

        playersPanel[0].add(playersInfo[0][0]);
        playersPanel[0].add(playersInfo[0][1]);
        playersPanel[0].add(playersInfo[0][2]);

        for (int i = 1; i < numberPlayers + 1; i++) {
            playersInfo[i][0] = new JLabel("" + i, SwingConstants.CENTER);
            playersInfo[i][1] = new JLabel("XXX", SwingConstants.CENTER);
            playersInfo[i][2] = new JLabel("$" + moneyHolder[i - 1], SwingConstants.CENTER);

            playersPanel[i].add(playersInfo[i][0]);
            playersPanel[i].add(playersInfo[i][1]);
            playersPanel[i].add(playersInfo[i][2]);
        }

        for (int r = 0; r < numberPlayers + 1; r++) {//SET SIZES
            for (int c = 0; c < 3; c++) {
                playersInfo[r][c].setSize(infoD);
                playersInfo[r][c].setPreferredSize(infoD);
            }
        }
        //////////////////////////////////////

        this.topTitleText = new JLabel("Welcome to Scott Sandre's Jeapordy game!", SwingConstants.CENTER);
        this.topTitleText.setAlignmentX(CENTER_ALIGNMENT);

        //questions, subjectsHolder
        //CATEGORIES TOP
        //subjectsHolder = new JPanel[4][3];
        subjectsHolder[0][0] = new JPanel();
        subjectsHolder[0][0].setSize(dButton1);
        subjectsHolder[0][0].setPreferredSize(dButton1);
        subjectsHolder[0][0].setBackground(Color.BLACK);
        subjectsHolder[0][0].setForeground(Color.white);
        categories[0] = new JLabel("PHYSICS", SwingConstants.CENTER);
        categories[0].setForeground(Color.WHITE);
        subjectsHolder[0][0].add(categories[0]);

        subjectsHolder[0][1] = new JPanel();
        subjectsHolder[0][1].setSize(dButton1);
        subjectsHolder[0][1].setBackground(Color.RED);
        subjectsHolder[0][1].setForeground(Color.BLACK);
        subjectsHolder[0][1].setPreferredSize(dButton1);
        categories[1] = new JLabel("CHEMISTRY", SwingConstants.CENTER);
        subjectsHolder[0][1].add(categories[1]);

        subjectsHolder[0][2] = new JPanel();
        subjectsHolder[0][2].setSize(dButton1);
        subjectsHolder[0][2].setBackground(Color.BLACK);
        subjectsHolder[0][2].setForeground(Color.WHITE);

        subjectsHolder[0][2].setPreferredSize(dButton1);
        categories[2] = new JLabel("BIOLOGY", SwingConstants.CENTER);
        categories[2].setForeground(Color.WHITE);
        subjectsHolder[0][2].add(categories[2]);

        this.row1 = new JPanel();
        this.row1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.row1.add(subjectsHolder[0][0]);
        this.row1.add(subjectsHolder[0][1]);
        this.row1.add(subjectsHolder[0][2]);

        //BUTTONS
        for (int r = 0; r < questions.length; r++) {
            for (int c = 0; c < questions[r].length; c++) {
                this.questions[r][c] = new Button();
                this.questions[r][c].setSize(dButton2);
                this.questions[r][c].setPreferredSize(dButton2);
                this.questions[r][c].setFont(new Font("TimesRoman", Font.BOLD, 14));
                this.questions[r][c].setForeground(Color.ORANGE);
                this.questions[r][c].setBackground(Color.WHITE);
                this.questions[r][c].setEnabled(true);
                this.questions[r][c].setLabel(("" + (100 * r + 100)));
                this.questions[r][c].setActionCommand(r + "-" + c);
                this.questions[r][c].addActionListener(this);
                System.out.println(this.questions[r][c].getActionCommand());
            }

        }

        this.row2 = new JPanel();
        this.row2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.row2.add(questions[0][0]);
        this.row2.add(questions[0][1]);
        this.row2.add(questions[0][2]);

        this.row3 = new JPanel();
        this.row3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.row3.add(questions[1][0]);
        this.row3.add(questions[1][1]);
        this.row3.add(questions[1][2]);

        this.row4 = new JPanel();
        this.row4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.row4.add(questions[2][0]);
        this.row4.add(questions[2][1]);
        this.row4.add(questions[2][2]);

        // ADD ROWS
        this.subjectsPanel.add(row1);
        this.subjectsPanel.add(row2);
        this.subjectsPanel.add(row3);
        this.subjectsPanel.add(row4);

        //add stuff
        this.topTitlePanel.add(topTitleText);
        this.bottomPannelScreen2.add(bottomTextScreen2);
        this.bottomPannelScreen2.add(bottomPlayerHolder);

        this.turnPanel.add(turnText);

        this.centralPanelScreen2.add(turnPanel);
        this.centralPanelScreen2.add(subjectsPanel);

        this.window2.add(topTitlePanel, BorderLayout.NORTH);
        this.window2.add(centralPanelScreen2, BorderLayout.CENTER);
        this.window2.add(bottomPannelScreen2, BorderLayout.SOUTH);
    }

    public void playGame(int q, JFrame x, String text1, String text2, String text3, String text4, String text5) {
        this.questionRow = new JPanel();
        this.questionRow.setSize(questionD);
        this.questionRow.setPreferredSize(questionD);
        this.questionRow.setBackground(Color.WHITE);
        this.questionRow.setBorder(BorderFactory.createEtchedBorder());
        
        this.answerRow = new JPanel();
        this.answerRow.setSize(questionD);
        this.answerRow.setPreferredSize(questionD);
        this.answerRow.setBackground(Color.WHITE);
        this.answerRow.setBorder(BorderFactory.createEtchedBorder()); 
        this.answerRow.setLayout(new BoxLayout(answerRow, BoxLayout.X_AXIS));
        
        this.questionLabel = new JLabel (text1, SwingConstants.CENTER);
        this.questionLabel.setForeground(Color.BLACK);
        this.questionRow.add(questionLabel);
        
        for (int i = 0 ; i < 4; i ++){
            answers[i] = new Button();
            answers[i].setSize(dButton3);
            answers[i].setName(text5);
            answers[i].setPreferredSize(dButton3);
            answers[i].setBackground(Color.red);
            answers[i].setForeground(Color.BLACK);
            answers[i].setFont(new Font("TimesRoman", Font.BOLD, 14));
            answers[i].setEnabled(true);
            answers[i].addActionListener(this);
            answers[i].setActionCommand("answer" + i);
            
            
        }
        
//        answers[0].setLabel(text2);
//        answers[1].setLabel(text3);
//        answers[2].setLabel(text4);
//        answers[3].setLabel(text5);
        
        this.answerRow.add(answers[0]);
        this.answerRow.add(answers[1]);
        this.answerRow.add(answers[2]);
        this.answerRow.add(answers[3]);

        
        x.add(questionRow);
        x.add(answerRow);
        x.setTitle("Jeopardy Game! Physics 100");
        x.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (screenNumber == 1) {
            switch (evt.getActionCommand()) {
                case "ONE PLAYER":
                    numberPlayers = 1;
                    System.out.print("Number of players = " + 1);
                    this.onePlayer.setBackground(Color.black);
                    this.onePlayer.setForeground(Color.white);
                    this.repaint();
                    break;
                case TWO_PLAYERS:
                    numberPlayers = 2;
                    System.out.print("Number of players = " + 2);
                    this.twoPlayers.setBackground(Color.black);
                    this.twoPlayers.setForeground(Color.white);
                    break;
                case THREE_PLAYERS:
                    numberPlayers = 3;
                    System.out.print("Number of players = " + 3);
                    this.threePlayers.setBackground(Color.black);
                    this.threePlayers.setForeground(Color.white);
                    break;
                case FOUR_PLAYERS:
                    numberPlayers = 4;
                    System.out.print("Number of players = " + 4);
                    this.fourPlayers.setBackground(Color.black);
                    this.fourPlayers.setForeground(Color.white);
                    break;

            }
            this.closeScreen1MakeScreen2();
        } else if (screenNumber == 2) {
            switch (evt.getActionCommand()) {
                case "0-0":
                    this.questions[0][0].setEnabled(false);
                    this.questions[0][0].setBackground(Color.DARK_GRAY);
                    this.window00 = new JFrame();
                    this.window00.setVisible(true);
                    this.window00.setSize(QUESTION_SIZE, QUESTION_SIZE);
                    this.window00.setTitle("Jeopardy Game! Physics 100");
                    this.window00.setResizable(false);
                    //this.window00.setLayout(new BoxLayout(window00, BoxLayout.Y_AXIS));
                    //questionNumber = 0;
                    playGame(0, window00, physicsQ1, physicsA00, physicsA01, physicsA02, physicsA03);

                    break;
                case "0-1":
                    this.questions[0][1].setEnabled(false);
                    this.questions[0][1].setBackground(Color.DARK_GRAY);
                    this.window01 = new JFrame();
                    this.window01.setVisible(true);
                    this.window01.setSize(QUESTION_SIZE, QUESTION_SIZE);

                    this.window01.setTitle("Jeopardy Game! Chemistry 100");
                    this.window01.setResizable(false);
                    
                    break;
                case "0-2":
                    this.questions[0][2].setEnabled(false);
                    this.questions[0][2].setBackground(Color.DARK_GRAY);
                    this.window02 = new JFrame();
                    this.window02.setVisible(true);
                    this.window02.setSize(QUESTION_SIZE, QUESTION_SIZE);

                    this.window02.setTitle("Jeopardy Game! Biology 100");
                    this.window02.setResizable(false);
                   
                    break;
                case "1-0":
                    this.questions[1][0].setEnabled(false);
                    this.questions[1][0].setBackground(Color.DARK_GRAY);
                    this.window10 = new JFrame();
                    this.window10.setVisible(true);
                    this.window10.setSize(QUESTION_SIZE, QUESTION_SIZE);

                    this.window10.setTitle("Jeopardy Game! Physics 200");
                    this.window10.setResizable(false);
                    
                    break;
                case "1-1":
                    this.questions[1][1].setEnabled(false);
                    this.questions[1][1].setBackground(Color.DARK_GRAY);
                    this.window11 = new JFrame();
                    this.window11.setVisible(true);
                    this.window11.setSize(QUESTION_SIZE, QUESTION_SIZE);

                    this.window11.setTitle("Jeopardy Game! Chemistry 200");
                    this.window11.setResizable(false);
                   
                    break;
                case "1-2":
                    this.questions[1][2].setEnabled(false);
                    this.questions[1][2].setBackground(Color.DARK_GRAY);
                    this.window12 = new JFrame();
                    this.window12.setVisible(true);
                    this.window12.setSize(QUESTION_SIZE, QUESTION_SIZE);

                    this.window12.setTitle("Jeopardy Game! Biology 200");
                    this.window12.setResizable(false);
                    
                    break;
                case "2-0":
                    this.questions[2][0].setEnabled(false);
                    this.questions[2][0].setBackground(Color.DARK_GRAY);
                    this.window20 = new JFrame();
                    this.window20.setVisible(true);
                    this.window20.setSize(QUESTION_SIZE, QUESTION_SIZE);

                    this.window20.setTitle("Jeopardy Game! Physics 300");
                    this.window20.setResizable(false);
                   
                    break;
                case "2-1":
                    this.questions[2][1].setEnabled(false);
                    this.questions[2][1].setBackground(Color.DARK_GRAY);
                    this.window21 = new JFrame();
                    this.window21.setVisible(true);
                    this.window21.setSize(QUESTION_SIZE, QUESTION_SIZE);

                    this.window21.setTitle("Jeopardy Game! Chemistry 300");
                    this.window21.setResizable(false);
                   
                    break;
                case "2-2":
                    this.questions[2][2].setEnabled(false);
                    this.questions[2][2].setBackground(Color.DARK_GRAY);
                    this.window22 = new JFrame();
                    this.window22.setVisible(true);
                    this.window22.setSize(QUESTION_SIZE, QUESTION_SIZE);
                    this.window22.setTitle("Jeopardy Game! Biology 300");
                    this.window22.setResizable(false);
                    
                    break;

            }

            this.repaint();
        }
    }

    public void closeScreen1MakeScreen2() {
        screenNumber = 2;
        this.setVisible(false);
        this.dispose();
        window2 = new JFrame();
        window2.setVisible(true);
        window2.setSize(WINDOW_SIZE, WINDOW_SIZE);
        initializeScreen2();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        e.getComponent().setBackground(Color.yellow);
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JeopardyGame().setVisible(true);
            }
        });

    }

}
