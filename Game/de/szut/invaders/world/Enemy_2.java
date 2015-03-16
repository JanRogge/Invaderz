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
 * Gegner 2
 * @author Simeon Kublenz, Jan-Phillip Rogge und Melina Wolle
 */
public class Enemy_2 implements Enemy {
	
	public static final int HEIGTH = 23;
	public static final int WIDTH = 50;
	public static final int POINTS = 20;
	
	private int xCor;
	private int yCor = 50;
	private int health = 50;
	private boolean moveRight;
	private Image image;
	private ImageIcon icon;
	private int cooldown;
	
	private JLabel enemyLabel;
	 /**
	  * Der Konstruktor
	  */
	public Enemy_2(boolean right){
		try {
			image = ImageIO.read(new File("Grafiken/Gegner_2.png"));
			icon = new ImageIcon(image);
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Gegnergrafik nicht gefunden", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		if (right) {
			moveRight = true;
			xCor = -23;
		}
		else {
			moveRight = false;
			xCor = 523;
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
		if (moveRight) {
			xCor++;
		}
		else {
			xCor--;
		}
		if ((xCor == 0 && !moveRight) || (xCor == 500-WIDTH && moveRight)) {
			moveRight = !moveRight;
		}
		if (cooldown == 0) {
			World.getInstance().addEnemyBullet(new Bullet_1(xCor + WIDTH/2 - Bullet_1.WIDTH/2, yCor + HEIGTH, -1, 3));
			World.getInstance().addEnemyBullet(new Bullet_1(xCor + WIDTH/2 - Bullet_1.WIDTH/2, yCor + HEIGTH, 1, 3));
			World.getInstance().addEnemyBullet(new Bullet_1(xCor + WIDTH/2 - Bullet_1.WIDTH/2, yCor + HEIGTH, 0, 0));
			cooldown = 200;
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
