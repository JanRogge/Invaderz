package de.szut.invaders.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Der SoundLoader lädt die Sounddateien
 * @author Marius Thürmer
 */
public class SoundLoader {
	
	private Properties p = new Properties();
	private InputStream input = null;
	private static SoundLoader instance;
	
	/**
	 * Das Singelton-Pattern
	 * @return
	 */
	public static SoundLoader getInstance() {
		if (instance == null) {
			instance = new SoundLoader();
		}
		return instance;
	}
	
	/**
	 * Der Konstruktor
	 */
	private SoundLoader() {
	}
	
	/**
	 * Lädt die Soundeinstellungen aus der Properties Datei
	 */
	public void load(){
		try{
			input = new FileInputStream("Properties/configSound.properties");
			p.load(input);
			p.getProperty("Backgroundsound");
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