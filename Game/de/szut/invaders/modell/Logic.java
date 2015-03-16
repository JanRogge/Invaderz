package de.szut.invaders.modell;

import java.util.ArrayList;
import java.util.Iterator;

import de.szut.invaders.view.GameListener;
import de.szut.invaders.world.Enemy;
import de.szut.invaders.world.EnemyBullet;
import de.szut.invaders.world.EnemyPool;
import de.szut.invaders.world.Enemy_Boss;
import de.szut.invaders.world.NormalPlayerBullet;
import de.szut.invaders.world.Player;
import de.szut.invaders.world.PlayerBullet;
import de.szut.invaders.world.World;

/**
 * Die Logic sorgt dafür dass sich die Figuren bewegen und für die Hitdetection
 * @author Simeon Kublenz
 */
public class Logic extends Thread{
	
	private boolean running;
	private World world;
	private Player player;
	private int shootCooldown;
	private GameListener listener;
	private int counter;
	private int timer;
	private ArrayList<Integer> enemyList;
	private boolean bossWave;
	private static Logic instance;
	
	/**
	 * Der Konstruktor
	 * @param difficulty
	 */
	private Logic(int difficulty) {
		enemyList = new ArrayList<Integer>();
		running = true;
		counter = 0;
		bossWave = false;
		world = World.getInstance();
		player = world.getPlayer();
		listener = GameListener.getInstance();
	}
	
	/**
	 * Das Singelton-Pattern
	 * @param difficulty
	 */
	public static Logic getInstance(int difficulty) {
		if (instance == null) {
			instance = new Logic(difficulty);
		}
		return instance;
	}
	
	/**
	 * Die Dauerlaufmethode die für die Arbeit der logic verrichtet
	 */
	public void run() {
		while(true) {
			System.out.println(); //Dieses Syso wird aus unerklärlichen gründen dafür gebracht dass das Spiel nach der Niederlage beim neustart nicht einfriert
			while(running) {
				//Spielerbewegung
				int x = 0;
				int y = 0; 
				if (listener.isForward()) {
					y--;
				}
				if (listener.isBackward()) {
					y++;
				}
				if (listener.isLeft()) {
					x--;
				}
				if (listener.isRight()) {
					x++;
				}
				if (player.getXCor() + x <= -1 || player.getXCor() + x >= 500 - Player.WIDTH) {
					x = 0;
				}
				if (player.getYCor() + y <= -1 || player.getYCor() + y >= 799 - Player.HEIGTH ) {
					y = 0;
				}
				player.move(x, y);
				
				//Spieler schießt
				if (listener.isShoot() && shootCooldown == 0) {
					world.addPlayerBullet(new NormalPlayerBullet(player.getXCor()
							+ Player.WIDTH / 2 - PlayerBullet.WIDTH/2, player.getYCor()));
					shootCooldown = 50;
				}
				if (shootCooldown > 0) {
					shootCooldown--;
				}
				
				//Gegnerbewegung
				for (Enemy e : world.getEnemies()) {
					e.move();
				}
				
				//Spielerkugelbewegung
				ArrayList<PlayerBullet> playerBulletsToRemove = new ArrayList<PlayerBullet>();
				for (PlayerBullet b : World.getInstance().getPlayerBullets()) {
					b.move();
					if (b.getXCor() < 0 - PlayerBullet.WIDTH || b.getXCor() > 500
							|| b.getYCor() < 0 - PlayerBullet.HEIGTH || b.getYCor() > 800) {
						playerBulletsToRemove.add(b);
					}
				}
				for (PlayerBullet b : playerBulletsToRemove) {
					world.removePlayerBullet(b);
					b.remove();
				}
				
				//Gegnerkugelbewegung
				ArrayList<EnemyBullet> enemyBulletsToRemove = new ArrayList<EnemyBullet>();
				for (EnemyBullet b : World.getInstance().getEnemyBullets()) {
					b.move();
					if (b.getXCor() < 0 - EnemyBullet.WIDTH || b.getXCor() > 500
							|| b.getYCor() < 0 - EnemyBullet.HEIGTH || b.getYCor() > 800) {
						enemyBulletsToRemove.add(b);
					}
				}
				for (EnemyBullet b : enemyBulletsToRemove) {
					world.removeEnemyBullet(b);
					b.remove();
				}
				
				//Hitdetection
				int bX;
				int bY;
				int eX;
				int eY;
				playerBulletsToRemove = new ArrayList<PlayerBullet>();
				for (Iterator<PlayerBullet> playerBulletIterator = World.getInstance().getPlayerBullets().iterator(); playerBulletIterator.hasNext();) {
					PlayerBullet b = playerBulletIterator.next();
					boolean stop = false;
					for (Iterator<Enemy> enemyIterator = World.getInstance().getEnemies().iterator(); enemyIterator.hasNext() && !stop;) {
						try {
							Enemy e = enemyIterator.next();
							bX = b.getXCor();
							bY = b.getYCor();
							eX = e.getXCor();
							eY = e.getYCor();
							if (bX < eX + e.getWidth() && bX + PlayerBullet.WIDTH > eX && bY < eY + e.getHeigth() && bY + PlayerBullet.HEIGTH > eY) {
								e.takeDamage(b.getDamage());
								b.remove();
								playerBulletsToRemove.add(b);
							}
						}
						catch(Exception e) {
							stop = true;
						}
					}
				}
				for(PlayerBullet b : playerBulletsToRemove) {
					world.removePlayerBullet(b);
				}
				
				int pX;
				int pY;
				enemyBulletsToRemove = new ArrayList<EnemyBullet>();
				for (Iterator<EnemyBullet> enemyBulletIterator = World.getInstance().getEnemyBullets().iterator(); enemyBulletIterator.hasNext();) {
					EnemyBullet b = enemyBulletIterator.next();
					player = world.getPlayer();
					try {
						bX = b.getXCor();
						bY = b.getYCor();
						pX = player.getXCor();
						pY = player.getYCor();
						if (bX < pX + Player.WIDTH && bX + EnemyBullet.WIDTH > pX && bY < pY + Player.HEIGTH && bY + EnemyBullet.HEIGTH > pY) {
							player.die();
							b.remove();
							enemyBulletsToRemove.add(b);
						}
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				for(EnemyBullet b : enemyBulletsToRemove) {
					world.removeEnemyBullet(b);
				}
				
				//Gegnerspawn
				try {
					World.getInstance().getEnemies().get(0);
				}
				catch(Exception e) {
					if (enemyList.size() != 0 && enemyList.size() % 5 == 0 && !bossWave) {
						bossWave = true;
						counter = 0;
						World.getInstance().addEnemy(new Enemy_Boss());
					}
					else {
						if (timer == 0) {
							if (counter == 0) {
								counter = 1;
								enemyList.add(EnemyPool.getInstance().getRandomEnemy());
							}
							else {
								counter--;
							}
							bossWave = false;
							timer = 200;
							for (int i : enemyList) {
								World.getInstance().addEnemy(EnemyPool.getInstance().getEnemy(i));
							}
						}
						else {
							timer--;
						}
					}
				}
				
				
				try {
					sleep(5);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * setzt die Variablen auf Startwerte zurück
	 */
	public void restart() {
		counter = 0;
		timer = 0;
		bossWave = false;
		enemyList.clear();
		System.out.println("restart");
	}
	
	/**
	 * Läst den Thread für den Spielneustart kurzzeitig leerlaufen
	 */
	public void switchRunning() {
		System.out.println("Baum");
		running = !running;
		System.out.println(running);
	}
}