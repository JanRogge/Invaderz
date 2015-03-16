package de.szut.invaders.modell;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * Sound ist dafür verantwortlich dass die Hintergrundmusik abgespielt wird
 * @author Melina Wolle
 */
public class Sound extends Thread{
	private static long songPeriod;
	static Clip music;
	
	/**
	 * Spielt die Hintergrundmusik ab
	 */
	public void run() {
		try {
			AudioInputStream song = null;
			song = AudioSystem.getAudioInputStream(new File("Sound/Backgroundsound.wav"));
			AudioFormat audioFormat = song.getFormat();
			int size = (int) (audioFormat.getFrameSize() * song.getFrameLength());
			byte[] sound = new byte[size];
			DataLine.Info info = new DataLine.Info(Clip.class, audioFormat, size);
			song.read(sound, 0, size);
			songPeriod = song.getFrameLength() / (long) audioFormat.getFrameRate();
			music = (Clip) AudioSystem.getLine(info);
			music.open(audioFormat, sound, 0, size);
			music.start();
			
			sleep(songPeriod * 960);
			
		}
		
		catch (Exception e) {
		}
	}
}