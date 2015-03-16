package de.szut.invaders.world;

import java.util.ArrayList;

/**
 * Die Welt welche alle Kugeln und Einheiten enthält
 * @author Jan-Philipp Rogge, Simeon kublenz und melina Wolle
 */
public class World {
	
	private static World instance;
	private Player player;
	private ArrayList<Enemy> enemies;
	private ArrayList<PlayerBullet> playerBullets;
	private ArrayList<EnemyBullet> enemyBullets;
	
	/**
	 * Der Konstruktor
	 */
	private World() {
		enemies = new ArrayList<Enemy>();
		playerBullets = new ArrayList<PlayerBullet>();
		enemyBullets = new ArrayList<EnemyBullet>();
	}
	
	/**
	 * Das Singelton-Pattern
	 * @return
	 */
	public static World getInstance() {
		if (instance == null) {
			instance = new World();
		}
		return instance;
	}
	
	/**
	 * Setzt den Spieler in der Welt
	 */
	public void setPlayer(Player p) {
		player = p;
	}
	
	/**
	 * Gibt den Spieler zurück
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Fügt einen Gegner hinzu
	 */
	public void addEnemy(Enemy e) {
		enemies.add(e);
	}
	
	/**
	 * Entfernt einen gegner aus der Welt
	 */
	public void removeEnemy(Enemy e) {
		enemies.remove(e);
	}
	
	/**
	 * Gibt alle gegner zurück
	 */
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	/**
	 * Fügt ein Spielergeschoß in der Welt hinzu
	 */
	public void addPlayerBullet(PlayerBullet b) {
		playerBullets.add(b);
	}
	
	/**
	 * Entfernt ein Spielergeschoß aus der Welt
	 */
	public void removePlayerBullet(Bullet b) {
		playerBullets.remove(b);
	}
	
	/**
	 * Gibt alle Spielergeschoße zurück
	 */
	public ArrayList<PlayerBullet> getPlayerBullets() {
		return playerBullets;
	}
	
	/**
	 * Fügt ein Gegnergeschoß in der Welt hinzu
	 */
	public void addEnemyBullet(EnemyBullet b) {
		enemyBullets.add(b);
	}
	
	/**
	 * Entfernt ein Gegnergeschoß aus der Welt
	 */
	public void removeEnemyBullet(Bullet b) {
		enemyBullets.remove(b);
	}
	
	/**
	 * Gibt alle Gegnergeschoße zurück
	 */
	public ArrayList<EnemyBullet> getEnemyBullets() {
		return enemyBullets;
	}
	
	/**
	 * Setzt die Gegner und kugeln zurück
	 */
	public void restart() {
		
		for(Enemy enemy : enemies) {
			enemy.remove();
		}

		
		for(EnemyBullet enemyBullet : enemyBullets) {
			enemyBullet.remove();
		}
		
		for(PlayerBullet playerBullet : playerBullets) {
			playerBullet.remove();
		}
		
		enemyBullets.clear();
		playerBullets.clear();
		enemies.clear();
	}
}
