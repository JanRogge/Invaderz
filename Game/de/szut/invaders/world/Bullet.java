package de.szut.invaders.world;

/**
 * Ein Interface für die Kugeln
 * @author Jan-Philipp Rogge
 */
public interface Bullet {	
	
	/**
	 * Lässt die Kugel sich bewegen
	 */
	public void move();
	
	/**
	 * Gibt die X-Koordinate zurück
	 */
	public int getXCor();
	
	/**
	 * Gibt die Y-Koordinate zurück
	 */
	public int getYCor();

	/**
	 * Gibt den Schaden zurück
	 */
	public int getDamage();

	/**
	 * Entfernt die Kugel von dem Panel
	 */
	public void remove();
}
