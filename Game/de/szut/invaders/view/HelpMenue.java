package de.szut.invaders.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Ein Menü für die Hilfe
 * @author Marius Thürmer
 *
 */
public class HelpMenue extends MenuePanel {
	
	private static final long serialVersionUID = -6391720660775306645L;

	/**
	 * Der Konstruktor
	 * @param startGui
	 */
	public HelpMenue(JPanel startGui){
		setSize(300,300);
		setLayout(null);
		
		parent = startGui;
		
		JLabel text = new JLabel();
		text.setText("Help");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text.setBounds(0, 0, 300, 75);
		add(text);
		
		JButton back = new MenuButton(0);
		back.setText("Back");
		back.setBounds(0, 250, 300, 50);
		back.addActionListener(MenuListener.getInstance());
		add(back);
	}
}