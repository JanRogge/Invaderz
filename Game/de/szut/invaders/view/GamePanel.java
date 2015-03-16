package de.szut.invaders.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.szut.invaders.world.Player;
import de.szut.invaders.world.World;

/**
 * Das gamePanel enthält die Spieloberfläche während dem Spielen
 * @author Jan-Philipp Rogge
 */
public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = -2208167475352950167L;
	private static GamePanel instance;
	private BufferedImage image;
	public static JLabel player;
	private Player play;
	
	/**
	 * Das Singelton-Pattern
	 */
	public static GamePanel getInstance() {
		if (instance == null) {
			instance = new GamePanel();
		}
		return instance;
	}
	 /**
	  * Der Konstruktor
	  */
	private GamePanel() {
		player = new JLabel("");
		play = new Player(player);
		World.getInstance().setPlayer(play);
		setBackground(Color.BLACK);
    	setSize(500, 799);
    	setLayout(null);
    	try {
        	image = ImageIO.read(new File("Grafiken/background.png"));
        } catch (IOException ex) {
        	JOptionPane.showMessageDialog(null, "Hintergrund nicht gefunden", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    	player.setLocation(play.getXCor(), play.getYCor());
		player.setSize(52, 76);
		player.setIcon(play.getImage());
		add(player);
		repaint();
		revalidate();
	}
	
	/**
	 * zeichnet den Hintergrund
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, 500, 800, null);
	}
	
	/**
	 * Startet das Scoreboard und die Healthbar neu und erzeugt einen neuen Spieler
	 */
	public void restart() {
		play = new Player(player);
		player.setLocation(play.getXCor(), play.getYCor());
		World.getInstance().setPlayer(play);
		Healthbar.getInstance().reset(play);
	}
}
