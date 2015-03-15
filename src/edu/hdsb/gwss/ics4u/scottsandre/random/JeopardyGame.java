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
    private static final Dimension topPanelDimension = new Dimension(WINDOW_SIZE, 50);
    private static final Dimension dButton1 = new Dimension(100, 100);

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

    private JLabel topTitleText;

    private JFrame window2;

    public JeopardyGame() {
        initialize();
    }

    public void initialize() {
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
        this.onePlayer.setPreferredSize(dButton1);
        this.onePlayer.setFont(new Font("TimesRoman", Font.BOLD, 14));
        this.onePlayer.setForeground(Color.BLACK);
        this.onePlayer.setLabel(ONE_PLAYER);
        this.onePlayer.setActionCommand(ONE_PLAYER);
        
        this.twoPlayers = new Button();
        this.twoPlayers.setBackground(Color.GREEN);
        this.twoPlayers.setPreferredSize(dButton1);
        this.twoPlayers.setFont(new Font("TimesRoman", Font.BOLD, 14));
        this.twoPlayers.setForeground(Color.BLACK);
        this.twoPlayers.setLabel(TWO_PLAYERS);
        this.twoPlayers.setActionCommand(TWO_PLAYERS);
        
        this.threePlayers = new Button();
        this.threePlayers.setBackground(Color.YELLOW);
        this.threePlayers.setPreferredSize(dButton1);
        this.threePlayers.setFont(new Font("TimesRoman", Font.BOLD, 14));
        this.threePlayers.setForeground(Color.BLACK);
        this.threePlayers.setLabel(THREE_PLAYERS);
        this.threePlayers.setActionCommand(THREE_PLAYERS);
        
        this.fourPlayers = new Button();
        this.fourPlayers.setBackground(Color.MAGENTA);
        this.fourPlayers.setPreferredSize(dButton1);
        this.fourPlayers.setFont(new Font("TimesRoman", Font.BOLD, 14));
        this.fourPlayers.setForeground(Color.BLACK);
        this.fourPlayers.setLabel(FOUR_PLAYERS);
        this.fourPlayers.setActionCommand(FOUR_PLAYERS);

        //add stuff
        this.topTitlePanel.add(this.topTitleText);
        this.bottomPannelScreen1.add(onePlayer);
        this.bottomPannelScreen1.add(twoPlayers);
        this.bottomPannelScreen1.add(threePlayers);
        this.bottomPannelScreen1.add(fourPlayers);

        this.add(topTitlePanel, BorderLayout.PAGE_START);
        this.add(test, BorderLayout.CENTER);
        this.add(bottomPannelScreen1);

        //SCREEN 2
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (screenNumber == 1) {
            if (evt.getActionCommand().equals("TEST")) {
                this.setVisible(false);
                this.dispose();

                window2 = new JFrame();
                window2.setVisible(true);
                window2.setSize(WINDOW_SIZE, WINDOW_SIZE);
            } else if (evt.getActionCommand().equals(ONE_PLAYER)) {
                numberPlayers = 1;
                System.out.print("Number of players = " + 1);
            } else if (evt.getActionCommand().equals(TWO_PLAYERS)) {
                numberPlayers = 2;
                System.out.print("Number of players = " + 2);
            } else if (evt.getActionCommand().equals(THREE_PLAYERS)) {
                numberPlayers = 3;
                System.out.print("Number of players = " + 3);
            } else if (evt.getActionCommand().equals(FOUR_PLAYERS)) {
                numberPlayers = 4;
                System.out.print("Number of players = " + 4);
            }
        }
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
            public void run() {
                new JeopardyGame().setVisible(true);
            }
        });

    }

}
