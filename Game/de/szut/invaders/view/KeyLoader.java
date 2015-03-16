package de.szut.invaders.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Der KeyLoader lädt die Einstellungen aus der Properties Datei
 * @author Marius Thürmer
 */
public class KeyLoader {
	
	private Properties p = new Properties();
	private InputStream input = null;
	private static KeyLoader instance;
	
	/**
	 * Das Singelton-Pattern
	 * @return
	 */
	public static KeyLoader getInstance() {
		if (instance == null) {
			instance = new KeyLoader();
		}
		return instance;
	}
	
	/**
	 * Der Konstruktor
	 */
	private KeyLoader() {
	}
	
	/**
	 * Lädt die einstellungen aus der Properties Datei
	 */
	public void load(){
		try{
			input = new FileInputStream("Properties/configKey.properties");
			p.load(input);
			GameListener.getInstance().setUp(p.getProperty("up"));
			GameListener.getInstance().setDown(p.getProperty("down"));
			GameListener.getInstance().setLeft(p.getProperty("left"));
			GameListener.getInstance().setRight(p.getProperty("right"));
			GameListener.getInstance().setShoot(p.getProperty("shot"));
		}
		catch(IOException io){		
		}
		finally{
			if (input != null){
				try{
					input.close();
				}
				catch(IOException io){
				}
			}
		}
	}
}
