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

    public static final int WINDOW_SIZE = 700;
    public static int numberPlayers;
    public static int screenNumber = 1;
    public static int turnNumber = 1;
    public static int[] moneyHolder;

    private static final Dimension topPanelDimension = new Dimension(WINDOW_SIZE, 50);
    private static final Dimension dButton1 = new Dimension(100, 100);
    private static final Dimension centralPanelScreen2Dimension = new Dimension(WINDOW_SIZE - 50, 400);
    private static final Dimension bottomPannelScreen2D = new Dimension(WINDOW_SIZE - 50, 150);
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

    private JPanel topTitlePanel;
    private JPanel bottomPannelScreen1;
    private JPanel centralPanelScreen2;
    private JPanel bottomPannelScreen2;
    private JPanel bottomPlayerHolder;
    private JPanel[] playersPanel;
    private JPanel turnPanel;
    private JPanel subjectsPanel;

    private JLabel topTitleText;
    private JLabel centreTextScreen1;
    private JLabel bottomTextScreen2;
    private JLabel[][] playersInfo;
    private JLabel turnText;

    private JFrame window2;

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
        infoD = new Dimension (WINDOW_SIZE / (numberPlayers + 1), 30);

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
        
        this.subjectsPanel = new JPanel();
        this.subjectsPanel.setBorder(BorderFactory.createEtchedBorder());
        this.subjectsPanel.setBackground(Color.PINK);

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
        
        for (int r = 0; r < numberPlayers + 1; r ++){//SET SIZES
            for (int c = 0; c < 3; c++){
                playersInfo[r][c].setSize(infoD);
                playersInfo[r][c].setPreferredSize(infoD);
            }
        }

        this.topTitleText = new JLabel("Welcome to Scott Sandre's Jeapordy game!", SwingConstants.CENTER);
        this.topTitleText.setAlignmentX(CENTER_ALIGNMENT);

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
