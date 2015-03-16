package de.szut.invaders.world;

/**
 * Das Interface für die Gegner
 * @author Jan-Philipp Rogge
 */
public interface Enemy {
	
	/**
	 * Läst den Gegner Schaden nehmen
	 * @param damage
	 */
	public void takeDamage(int damage);
	
	/**
	 * Lässt den gegner sich bewegen
	 */
	public void move();
	
	/**
	 * Gibt die X-Koordinate zurück
	 * @return
	 */
	public int getXCor();
	
	/**
	 * Gibt die Y-Koordinate zurück
	 * @return
	 */
	public int getYCor();
	
	/**
	 * Gibt die Breite zurück
	 * @return
	 */
	public int getWidth();
	
	/**
	 * Gibt die Höhe zurück
	 * @return
	 */
	public int getHeigth();
	
	/**
	 * Entfernt den gegner von dem Panel
	 */
	public void remove();
}
