package de.szut.invaders.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Der Menu Listener erm�glicht die Navigation durch das Men�
 * @author Marius Th�rmer
 */
public class MenuListener implements ActionListener{
	
	private static MenuListener instance;
	
	/**
	 * Das Singelton-Pattern
	 */
	public static MenuListener getInstance() {
		if (instance == null) {
			instance = new MenuListener();
		}
		return instance;
	}
	
	/**
	 * Der Konstruktor
	 */
	private MenuListener() {
	}
	
	/**
	 * Informiert das GameFrame �ber den Mausklick auf einen MenuButton
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		GameFrame.getInstance().switchPanel(((MenuButton)(arg0.getSource())).getNumber());
		
	}
}
