package de.szut.invaders.view;

import javax.swing.JPanel;

/**
 * Das MenuPanel ist ein besonderes Panel welches das �bergeordnete Panel speichern kann 
 * @author Marius Th�rmer
 */
public class MenuePanel extends JPanel {
	
	private static final long serialVersionUID = 7193657142067965189L;
	JPanel parent;
	
	/**
	 * Gibt das �bergeordnete Panel zur�ck
	 * @return parent
	 */
	public JPanel getParentPanel(){
		return parent;
	}

}
