package de.szut.invaders.controller;

import de.szut.invaders.modell.Sound;
import de.szut.invaders.view.GameFrame;

/**
 * Die Main sorgt daf�r das das Spiel gestartet wird
 * @author Simeon Kublenz, Jan-Philipp Rogge, Marius Th�rmer und Melina Wolle
 */
public class Main {
	
	/**
	 * Die Main
	 */
	public static void main(String[] args) {
		GameFrame.getInstance();
		new Sound().start();
	}
}