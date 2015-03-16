package de.szut.invaders.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import de.szut.invaders.view.GamePanel;
import de.szut.invaders.world.Player;
import de.szut.invaders.world.World;

/**
 * Die Healthbar zeigt an wie viele Leben der Spieler noch besitzt
 * @author Jan-Philipp Rogge
 */
public class Healthbar {
	private JLabel live1;
	private JLabel live2;
	private JLabel live3;
	private Image healt_full;
	private Image healt_emty;
	private static Healthbar instance;
	private Player player;
	
	/**
	 * Das Singelton-Pattern
	 * @return instance
	 */
	public static Healthbar getInstance() {
		if (instance == null) {
			instance = new Healthbar();
		}
		return instance;
	}
	
	/**
	 * Der Konstruktor
	 */
	private Healthbar(){
		try {
			healt_full = ImageIO.read(new File("Grafiken/Healt_Full.png"));
			healt_emty = ImageIO.read(new File("Grafiken/Healt_Emty.png"));
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Lebensgrafik nicht gefunden", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		live1 = new JLabel(new ImageIcon(healt_full));
		live2 = new JLabel(new ImageIcon(healt_full));
		live3 = new JLabel(new ImageIcon(healt_full));
		live1.setBounds(395, 10, 25, 25);
		live2.setBounds(430, 10, 25, 25);
		live3.setBounds(465, 10, 25, 25);
		GamePanel.getInstance().add(live1);
		GamePanel.getInstance().add(live2);
		GamePanel.getInstance().add(live3);
		player = World.getInstance().getPlayer();
	}
	
	/**
	 * Lässt die Lebensanzeige des Spielers sinken
	 */
	public void reduceHealt(){
		if(player.getLives() == 2){
			live1.setIcon(new ImageIcon(healt_emty));
		}
		else if(player.getLives() == 1){
			live2.setIcon(new ImageIcon(healt_emty));
		}
		else{
			live3.setIcon(new ImageIcon(healt_emty));
		}
	}
	
	/**
	 * Setzt die Variablen auf Startwerte zurück
	 * @param p
	 */
	public void reset(Player p) {
		live1.setIcon(new ImageIcon(healt_full));
		live2.setIcon(new ImageIcon(healt_full));
		live3.setIcon(new ImageIcon(healt_full));
		player = p;
	}
}
