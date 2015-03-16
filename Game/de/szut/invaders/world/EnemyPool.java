package de.szut.invaders.world;

/**
 * Ein Pool der alle Gegner enthält
 * @author Simeon Kublenz
 */
public class EnemyPool {
	
	private static EnemyPool instance;
	
	boolean b;
	
	/**
	 * Der Konstruktor
	 */
	private EnemyPool() {
		b = false;
	}
	
	/**
	 * Das Singelton-Pattern
	 * @return
	 */
	public static EnemyPool getInstance() {
		if (instance == null) {
			instance = new EnemyPool();
		}
		return instance;
	}
	
	/**
	 * Gibt eine zufällige gegner-ID zurück
	 * @return
	 */
	public int getRandomEnemy() {
		int e = 0; 
		int i = (int)(Math.random()*7);
		System.out.println(i);
		switch(i) {
			case(0): {
			}
			case(1): {
			}
			case(2): {
				e = 1;
				break;
			}
			case(4): {
			}
			case(5): {
				e = 2;
				b = !b;
				break;
			}
			case(6): {
				e = 3;
				break;
			}
		}
		return e;
	}
	
	/**
	 * Gibt zu einer ID ein neues Gegnerobjekt zurück
	 * @param i
	 * @return
	 */
	public Enemy getEnemy(int i) {
		Enemy e = new Enemy_1();
		switch(i) {
			case(1): {
				e = new Enemy_1();
				break;
			}
			case(2): {
				e = new Enemy_2(b);
				b = !b;
				break;
			}
			case(3): {
				e = new Enemy_3();
				break;
			}
		}
		return e;
	}
}
