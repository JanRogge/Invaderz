package de.szut.invaders.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JButton;

/**
 * Speichert die Einstellungen der Steuerung in einer Properties Datei und auf die Knöpfe
 * @author Marius Thürmer
 */
public class KeySaver implements KeyListener {

	private JButton[] buttons;
	private String[] text = {"up", "down", "left", "right", "shot"};
	private static KeySaver instance;
	
	/**
	 * Das Singelton-Pattern
	 */
	public static KeySaver getInstance() {
		if (instance == null) {
			instance = new KeySaver();
		}
		return instance;
	}
	
	/**
	 * Der Konstruktor
	 */
	private KeySaver(){
	}
	
	
	/**
	 * Wird aufgerufen wenn eine Taste gedrückt wurde um ihren Namen auf den Knopf zu legen
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		boolean found = false;
		int i = 0;
		while(!found) {
			if (buttons[i].hasFocus()) {
				found = true;
			}
			else {
				i++;
			}
		}
		
		buttons[i].setText(KeyEvent.getKeyText(arg0.getKeyCode()));
		System.out.println();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent e) {	
	}
	
	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}
	
	/**
	 * Speichert die einstellungen in einer Properties Datei
	 */
	public void save(){
		GameListener.getInstance().setUp(buttons[0].getText());
		GameListener.getInstance().setDown(buttons[1].getText());
		GameListener.getInstance().setLeft(buttons[2].getText());
		GameListener.getInstance().setRight(buttons[3].getText());
		GameListener.getInstance().setShoot(buttons[4].getText());
		
		Properties p=new Properties();
		OutputStream output = null;
		
		try{
			output = new FileOutputStream("Properties/configKey.properties");
			p.setProperty(text[0],buttons[0].getText());
			p.setProperty(text[1],buttons[1].getText());
			p.setProperty(text[2],buttons[2].getText());
			p.setProperty(text[3],buttons[3].getText());
			p.setProperty(text[4],buttons[4].getText());
			p.store(output, null);
		}
		
		catch(IOException io){
		}
		
		finally{
			if(output != null){
				try{
					output.close();
				}
				catch(IOException io){
					io.printStackTrace();
					
				}
			}
		}
	}
}
