package de.szut.invaders.view;

import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 * Aktualisiert das Label neben den SoundSlidern
 * @author Marius Thürmer
 */
public class RefreshSoundSlider extends Thread {
	
	private JLabel lbl;
	private JSlider sld;
	
	/**
	 * Der Konstruktor
	 * @param label
	 * @param slider
	 */
	public RefreshSoundSlider(JLabel label, JSlider slider){
		lbl = label;
		sld = slider;
	}
	
	/**
	 * Aktualisiert das Label
	 */
	public void run(){
		while(true){
			lbl.setText(sld.getValue()+"%");
		}
	}
}
