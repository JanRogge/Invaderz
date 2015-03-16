package de.szut.invaders.view;

import javax.swing.JButton;

/**
 * Der MenuButton ermöglicht mittels einer Nummer die Navigation durch das Menü;
 * @author Marius Thürmer
 */
public class MenuButton extends JButton {
	
	private static final long serialVersionUID = 4824375292608193984L;
	private int number;
	
	/**
	 * Der konstruktor
	 * @param number
	 */
	public MenuButton(int number) {
		this.number = number;
	}
	
	/**
	 * Gibt die Nummer dieses Knopfes zurück
	 * @return
	 */
	public int getNumber() {
		return number;
	}
}
