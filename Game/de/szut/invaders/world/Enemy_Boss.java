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
 * Der Boss-Gegner
 * @author Simeon Kublenz, Jan-Phillip Rogge und Melina Wolle
 */
public class Enemy_Boss implements Enemy {
	
	public static final int HEIGTH = 217;
	public static final int WIDTH = 150;
	public static final int POINTS = 100;
	
	private int xCor = 175;
	private int yCor = -217;
	private int health = 500;
	private Image image;
	private ImageIcon icon;
	private int cooldown1;
	private int cooldown2;
	private int magazine;
	
	private JLabel enemyLabel;
	 /**
	  * Der Konstruktor
	  */
	public Enemy_Boss(){
		try {
			image = ImageIO.read(new File("Grafiken/Boss.png"));
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
		if (yCor != 20) {
			yCor++;
		}
		if (cooldown2 == 0) {
			if (magazine > 0) {
				if (cooldown1 == 0) {
					World.getInstance().addEnemyBullet(new Bullet_1(xCor + WIDTH/2 - Bullet_1.WIDTH/2, yCor + HEIGTH, -1, 6));
					World.getInstance().addEnemyBullet(new Bullet_1(xCor + WIDTH/2 - Bullet_1.WIDTH/2, yCor + HEIGTH, 1, 6));
					World.getInstance().addEnemyBullet(new Bullet_1(xCor + WIDTH/2 - Bullet_1.WIDTH/2, yCor + HEIGTH, -1, 2));
					World.getInstance().addEnemyBullet(new Bullet_1(xCor + WIDTH/2 - Bullet_1.WIDTH/2, yCor + HEIGTH, 1, 2));
					World.getInstance().addEnemyBullet(new Bullet_1(xCor + WIDTH/2 - Bullet_1.WIDTH/2, yCor + HEIGTH, 0, 0));
					cooldown1 = 10;
					magazine--;
				}
				else {
					cooldown1--;
				}
			}
			else {
				cooldown2 = 200;
				magazine = 10;
			}
		}
		else {
			cooldown2--;
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
