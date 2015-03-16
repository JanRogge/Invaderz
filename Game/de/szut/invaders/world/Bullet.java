package de.szut.invaders.world;

/**
 * Ein Interface f�r die Kugeln
 * @author Jan-Philipp Rogge
 */
public interface Bullet {	
	
	/**
	 * L�sst die Kugel sich bewegen
	 */
	public void move();
	
	/**
	 * Gibt die X-Koordinate zur�ck
	 */
	public int getXCor();
	
	/**
	 * Gibt die Y-Koordinate zur�ck
	 */
	public int getYCor();

	/**
	 * Gibt den Schaden zur�ck
	 */
	public int getDamage();

	/**
	 * Entfernt die Kugel von dem Panel
	 */
	public void remove();
}
