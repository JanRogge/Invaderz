package de.szut.invaders.modell;

import de.szut.invaders.view.GameListener;
import de.szut.invaders.view.GamePanel;
import de.szut.invaders.world.Score;
import de.szut.invaders.world.World;

/**
 * Restart sorgt für einen vernünftigen Neustart des Spiels
 * @author Simeon Kublenz
 */
public class Restart extends Thread{
	
	/**
	 * Lässt das Spiel neustarten
	 */
	public void run() {
		Logic.getInstance(0).switchRunning();
		try {
			sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		World.getInstance().restart();
		GamePanel.getInstance().restart();
		GamePanel.getInstance().revalidate();
		GamePanel.getInstance().repaint();
		GameListener.getInstance().restart();
		Score.getInstance().reset();
		Logic.getInstance(0).restart();
		System.out.println("Hier");
		Logic.getInstance(0).switchRunning();
	}
}
