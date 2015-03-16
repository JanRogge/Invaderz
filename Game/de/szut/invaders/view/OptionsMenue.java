package de.szut.invaders.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Das options Menu enthält die Optionseinstellungen
 * @author Marius Thürmer
 */
public class OptionsMenue extends MenuePanel {
	
	private static final long serialVersionUID = -9186952329852180634L;

	/**
	 * Der Konstruktor
	 * @param startGui
	 */
	public OptionsMenue(JPanel startGui){
		setSize(300,300);
		setLayout(null);
		
		parent = startGui;
		
		JLabel text = new JLabel();
		text.setText("Options");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text.setBounds(0, 0, 300, 75);
		add(text);
		
		JButton sound = new MenuButton(8);
		sound.setText("Sound");
		sound.setBounds(0, 75, 300,50);
		sound.addActionListener(MenuListener.getInstance());
		add(sound);
		
		JButton keys = new MenuButton(9);
		keys.setText("Keys");
		keys.setBounds(0, 125, 300,50);
		keys.addActionListener(MenuListener.getInstance());
		add(keys);
		
		JButton back = new MenuButton(0);
		back.setText("Back");
		back.setBounds(0, 250, 300,50);
		back.addActionListener(MenuListener.getInstance());
		add(back);	
	}
}