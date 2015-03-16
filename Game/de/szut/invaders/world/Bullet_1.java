package de.szut.invaders.world;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import de.szut.invaders.view.GamePanel;

public class Bullet_1 implements EnemyBullet {
	
	private int xCor;
	private int yCor;
	private int damage = 1;
	private Image image;
	private ImageIcon icon;
	private int cooldownTimer;
	private int currentCooldown;
	private int askew;
	
	private JLabel shootLabel;
	
	public Bullet_1(int x, int y, int askew, int cooldown) {
		cooldownTimer = cooldown;
		this.askew = askew;
		xCor = x;
		yCor = y;
		try {
			image = ImageIO.read(new File("Grafiken/Gegner_Schuss.png"));
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
		yCor += 2;
		if (askew != 0) {
			if (currentCooldown == 0) {
				xCor += askew;
				currentCooldown = cooldownTimer;
			}
			else {
				currentCooldown--;
			}
		}
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
