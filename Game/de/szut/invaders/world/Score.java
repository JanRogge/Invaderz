package de.szut.invaders.world;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import de.szut.invaders.view.GamePanel;

/**
 * Ein Scoreboard für die Punkteanzeige
 * @author Jan-Philipp Rogge
 */
public class Score {
	
	private JLabel score;
	private int points;
	private static Score instance;
	
	/**
	 * Das Singelton-Pattern
	 * @return
	 */
	public static Score getInstance() {
		if (instance == null) {
			instance = new Score();
		}
		return instance;
	}
	
	/**
	 * Der Konstruktor
	 */
	private Score(){
		score = new JLabel(" Score: 0");
		score.setLocation(0,0);
		score.setSize(500,50);
		score.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		score.setForeground(Color.RED);
		GamePanel.getInstance().add(score);
	}
	
	/**
	 * Fügt eine gewünschte Anzahl Punkte hinzu
	 * @param add
	 */
	public void addScore(int add){
		points += add;
		score.setText(" Score: " + points);
	}
	
	/**
	 * Gibt die Aktuellen Punkte zurück
	 * @return
	 */
	public int getScore(){
		return points;
	}
	
	/**
	 * Setzt das Scoreboard zurück
	 */
	public void reset() {
		points = 0;
		score.setText(" Score: 0");
	}
}
