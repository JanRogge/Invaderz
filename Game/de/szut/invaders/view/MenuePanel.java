package de.szut.invaders.view;

import javax.swing.JPanel;

/**
 * Das MenuPanel ist ein besonderes Panel welches das Übergeordnete Panel speichern kann 
 * @author Marius Thürmer
 */
public class MenuePanel extends JPanel {
	
	private static final long serialVersionUID = 7193657142067965189L;
	JPanel parent;
	
	/**
	 * Gibt das übergeordnete Panel zurück
	 * @return parent
	 */
	public JPanel getParentPanel(){
		return parent;
	}

}
