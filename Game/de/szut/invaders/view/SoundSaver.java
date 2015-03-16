package de.szut.invaders.view;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JSlider;

/**
 * Speichert die Soundeinstellungen der Slider
 * @author Marius Thürmer
 */
public class SoundSaver {

	private JSlider background1;
	
	/**
	 * Der Konstruktor
	 * @param background
	 */
	public SoundSaver(JSlider background){
		
		background1 = background;	
	}
	
	/**
	 * Speichert die Soundeinstellungen
	 */
	public void save(){
		
		Properties p=new Properties();
		OutputStream output = null;
		
		try{
			output = new FileOutputStream("Properties/configSound.properties");
			p.setProperty("BackgroundSound", background1.getValue()+"");		
			p.store(output, null);
			background1.setValue(Integer.parseInt(p.getProperty("BackgroundSound")));
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
