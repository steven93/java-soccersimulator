package soccersim.gui;

import soccersim.team.Team;
import soccersim.team.brute.BruteTeam;
import soccersim.base.DefendingSide;
import soccersim.base.GameHandler;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by IntelliJ IDEA.
 * User: frank
 * Date: Sep 17, 2007
 * Time: 8:47:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class TextFieldGui implements Runnable {

    private JTextArea fieldTextArea;
    private JButton startButton;
    private JButton pauseButton;
    private JPanel mainPanel;
    private JButton stopButton;
    private JComboBox speedComboBox;

    private Thread paintThread;

	Team eastTeam = new BruteTeam(DefendingSide.East);
	Team westTeam = new BruteTeam(DefendingSide.West);
	private GameHandler game;
	private int speed = 50;
    private boolean isPaused = false;
    private boolean shouldStop = false;

    public TextFieldGui() {
        initialize();
        addActionListeners();
        initializeThread();
    }

    private void initializeThread() {
        game = new GameHandler(eastTeam, westTeam);
        paintThread = new Thread(this);
    }

    private void initialize() {
        String[] speedOptions = {"Slower", "Slow", "Normal", "Fast", "Faster"};
        speedComboBox = new JComboBox(speedOptions);
        speedComboBox.setSelectedIndex(2);
    }

    private void addActionListeners() {
         startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (eastTeam == null || westTeam == null) {
                    // TODO: popup message saying user must pick teams
                }
                if (!paintThread.isAlive()) {
                    shouldStop = false;
                    initializeThread();
                    paintThread.start();
                }
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isPaused = !isPaused;
                if (isPaused) {
                    pauseButton.setText("Resume");
                } else {
                    pauseButton.setText("Pause");
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shouldStop = true;
            }
        });

        speedComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (speedComboBox.getSelectedIndex()) {
                    case 0 : speed = 1000; break;
                    case 1 : speed = 500; break;
                    case 2 : speed = 100; break;
                    case 3 : speed = 50; break;
                    case 4 : speed = 10; break;
                }
            }
        });
    }

    public void run() {
        while (game.gameInProgress() && !shouldStop) {
            while (isPaused) {
                try {paintThread.wait();} catch(Exception ex) {}
            }

            game.executeStep();
            String score = "Score: " 
               + westTeam.getName() + ": " + game.getScore().getScore(DefendingSide.West) + "\t"
               + eastTeam.getName() + ": " + game.getScore().getScore(DefendingSide.East);
            fieldTextArea.setText(score + "\n" + game.getField().toString());
            fieldTextArea.repaint();
            try {java.lang.Thread.sleep(this.speed); } catch (Exception ex) {}
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JFrame frame = new JFrame("SoccerSim Gui - Text Based");
        frame.setContentPane(new TextFieldGui().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
