package de.szut.invaders.world;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import de.szut.invaders.modell.Restart;
import de.szut.invaders.view.GameFrame;
import de.szut.invaders.view.Healthbar;

/**
 * Der Spieler
 * @author Jan-Philipp Rogge, Melina Wolle und Simeon Kublenz
 */
public class Player {
	
	public static final int HEIGTH = 76;
	public static final int WIDTH = 52;
	
	private int xCor;
	private int yCor;
	private int lives;
	private Image image;
	private ImageIcon icon;
	
	private JLabel playerLabel;
	
	/**
	 * Der Konstruktor
	 * @param label
	 */
	public Player(JLabel label) {
		lives = 3;
		xCor = 224;
		yCor = 690;
		playerLabel = label;
		try {
			image = ImageIO.read(new File("Grafiken/Rocket.png"));
			icon = new ImageIcon(image);
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Raketengrafik nicht gefunden", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * L�sst den Spieler in die gew�nschte Richtung laufen
	 */
	public void move(int x, int y) {
		xCor += x;
		yCor += y;
		playerLabel.setLocation(xCor, yCor);
	}
	
	/**
	 * Gibt die X-Koordinate des Spielers zur�ck
	 */
	public int getXCor() {
		return xCor;
	}
	
	/**
	 * Gibt die Y-Koordinate des Spielers zur�ck
	 */
	public int getYCor() {
		return yCor;
	}
	
	/**
	 * L�sst den Spieler sterben
	 */
	public void die() {
		lives--;
		Healthbar.getInstance().reduceHealt();
		if (lives == 0) {
			String[] options = {"Hauptmen�", "Neustart"};
			int selected = JOptionPane.showOptionDialog(null,
					"Sie haben " + Score.getInstance().getScore() + " Punkte erreicht",
					"Game Over",
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, 
					null, options, options[0]);
			if (selected == 1) {
				new Restart().start();
			}
			else {
				GameFrame.getInstance().backToMainMenue();
			}
		}
	}
	
	/**
	 * Gibt die aktuelle Anzahl Leben zur�ck
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * Gibt die Grafik der Rakete zur�ck
	 */
	public ImageIcon getImage() {
		return icon;
	}
}
