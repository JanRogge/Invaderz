package de.szut.invaders.view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Verhindert ein sofortiges Beenden beim schließen
 * @author Marius Thürmer
 */
public class FrameListener implements WindowListener{
	
	@Override
	public void windowActivated(WindowEvent arg0) {
	}
	
	@Override
	public void windowClosed(WindowEvent arg0) {
	}
	
	/**
	 * Wird aufgerufen wenn man das Frame schließt
	 */
	@Override
	public void windowClosing(WindowEvent arg0) {
		GameFrame.getInstance().showClosingWindow();
	}
	
	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}
	
	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}
	
	@Override
	public void windowIconified(WindowEvent arg0) {
	}
	
	@Override
	public void windowOpened(WindowEvent arg0) {
	}
}
