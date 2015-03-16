package de.szut.invaders.world;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import de.szut.invaders.view.GamePanel;

/**
 * Die Spielerkugel
 * @author Simeon Kublenz, Melina Wolle und Jan-Philipp Rogge
 */
public class NormalPlayerBullet implements PlayerBullet {
	
	public static final int HEIGTH = 46;
	public static final int WIDTH = 16;
	
	private int xCor;
	private int yCor;
	private int damage = 50;
	private Image image;
	private ImageIcon icon;
	
	private JLabel shootLabel;
	
	/**
	 * Der Konstruktor
	 * @param x
	 * @param y
	 */
	public NormalPlayerBullet(int x, int y) {
		xCor = x;
		yCor = y;
		try {
			image = ImageIO.read(new File("Grafiken/Player_Schuss.png"));
			icon = new ImageIcon(image);
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Schussgrafik nicht gefunden", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		shootLabel = new JLabel("");
		shootLabel.setLocation(xCor, yCor);
		shootLabel.setSize(WIDTH, HEIGTH);
		shootLabel.setIcon(icon);
		GamePanel.getInstance().add(shootLabel);
	}
	
	@Override
	public void move() {
		yCor -= 2;
		shootLabel.setLocation(xCor, yCor);
	}
	
	@Override
	public int getXCor() {
		return xCor;
	}

	@Override
	public int getYCor() {
		return yCor;
	}

	public int getDamage() {
		return damage;
	}

	@Override
	public void remove() {
		GamePanel.getInstance().remove(shootLabel);
	}
}
