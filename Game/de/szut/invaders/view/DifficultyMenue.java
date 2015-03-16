package de.szut.invaders.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Das DifficultyMenue ermöglicht die auswahl zwischen den Schwierigkeitsgraden
 * @author Marius Thürmer
 *
 */
public class DifficultyMenue extends MenuePanel{
	
	private static final long serialVersionUID = 5873155239462552831L;

	/**
	 * Der Konstruktor
	 * @param startGui
	 */
	public DifficultyMenue(JPanel startGui){
		setSize(300,300);
		setLayout(null);
		
		parent = startGui;
		
		JLabel text = new JLabel();
		text.setText("Choose a Difficulty");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text.setBounds(0, 0, 300, 75);
		add(text);
		
		JButton easy = new MenuButton(5);
		easy.setText("Easy");
		easy.setBounds(0, 75, 300, 50);
		easy.addActionListener(MenuListener.getInstance());
		add(easy);
		
		JButton middle = new MenuButton(6);
		middle.setText("Middle");
		middle.setBounds(0, 125, 300, 50);
		middle.addActionListener(MenuListener.getInstance());
		add(middle);
		
		JButton hard = new MenuButton(7);
		hard.setText("Hard");
		hard.setBounds(0, 175, 300, 50);
		hard.addActionListener(MenuListener.getInstance());
		add(hard);
		
		JButton back = new MenuButton(0);
		back.setText("Back");
		back.setBounds(0, 250, 300, 50);
		back.addActionListener(MenuListener.getInstance());
		add(back);
	}
}