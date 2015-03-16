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
 * Gegner 3
 * @author Simeon Kublenz, Jan-Phillip Rogge und Melina Wolle
 */
public class Enemy_3 implements Enemy {
	
	public static final int HEIGTH = 39;
	public static final int WIDTH = 50;
	public static final int POINTS = 30;
	
	private int xCor = (int)(Math.random()*300) + 100;
	private int yCor = -50;
	private int health = 200;
	private boolean moveRight;
	private boolean moveUp;
	private Image image;
	private ImageIcon icon;
	private int cooldown;
	
	private JLabel enemyLabel;
	 /**
	  * Der Konstruktor
	  */
	public Enemy_3(){
		try {
			image = ImageIO.read(new File("Grafiken/Gegner_3.png"));
			icon = new ImageIcon(image);
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Gegnergrafik nicht gefunden", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		enemyLabel = new JLabel("");
		enemyLabel.setLocation(xCor, yCor);
		enemyLabel.setSize(WIDTH, HEIGTH);
		enemyLabel.setIcon(icon);
		GamePanel.getInstance().add(enemyLabel);
	}
	
	@Override
	public void takeDamage(int damage) {
		health -= damage;
		if (health <= 0) {
			World.getInstance().removeEnemy(this);
			GamePanel.getInstance().remove(enemyLabel);
			Score.getInstance().addScore(POINTS);
		}
	}
	
	@Override
	public void move() {
		if (moveUp) {
			yCor--;
		}
		else {
			yCor++;
		}
		if ((yCor == 50 && moveUp)|| yCor == 250-HEIGTH) {
			moveUp = !moveUp;
		}
		if (moveRight) {
			xCor++;
		}
		else {
			xCor--;
		}
		if (xCor == 0 || xCor == 500-WIDTH) {
			moveRight = !moveRight;
		}
		if (cooldown == 0) {
			World.getInstance().addEnemyBullet(new Bullet_1(xCor + WIDTH/2 - Bullet_1.WIDTH/2, yCor + HEIGTH, 0, 0));
			cooldown = 120;
		}
		else {
			cooldown--;
		}
		enemyLabel.setLocation(xCor, yCor);
	}

	@Override
	public int getXCor() {
		return xCor;
	}

	@Override
	public int getYCor() {
		return yCor;
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeigth() {
		return HEIGTH;
	}
	
	@Override
	public void remove() {
		GamePanel.getInstance().remove(enemyLabel);
	}
}
