package de.szut.invaders.world;

/**
 * Das Interface f�r die Gegner
 * @author Jan-Philipp Rogge
 */
public interface Enemy {
	
	/**
	 * L�st den Gegner Schaden nehmen
	 * @param damage
	 */
	public void takeDamage(int damage);
	
	/**
	 * L�sst den gegner sich bewegen
	 */
	public void move();
	
	/**
	 * Gibt die X-Koordinate zur�ck
	 * @return
	 */
	public int getXCor();
	
	/**
	 * Gibt die Y-Koordinate zur�ck
	 * @return
	 */
	public int getYCor();
	
	/**
	 * Gibt die Breite zur�ck
	 * @return
	 */
	public int getWidth();
	
	/**
	 * Gibt die H�he zur�ck
	 * @return
	 */
	public int getHeigth();
	
	/**
	 * Entfernt den gegner von dem Panel
	 */
	public void remove();
}
