package de.szut.invaders.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Das MainMenue wird beim Spielstart aufgerufen
 * @author Marius Thürmer
 */
public class MainMenue extends MenuePanel{
	
	private static final long serialVersionUID = -8179490551338745998L;

	/**
	 * Der Konstruktor
	 */
	public MainMenue(){
		setSize(300,301);
		setLayout(null);
		
		SoundLoader.getInstance().load();
		KeyLoader.getInstance().load();
		
		JLabel text = new JLabel();
		text.setText("Main menue");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text.setBounds(0, 0, 300, 75);
		add(text);
		
		JButton gameStart = new MenuButton(1);
		gameStart.setText("Start Game");
		gameStart.setBounds(0, 75, 300, 50);
		gameStart.addActionListener(MenuListener.getInstance());
		add(gameStart);	
		
		JButton options = new MenuButton(2);
		options.setText("Options");
		options.setBounds(0, 125, 300, 50);
		options.addActionListener(MenuListener.getInstance());
		add(options);
		
		JButton help = new MenuButton(3);
		help.setText("Help");
		help.setBounds(0, 175, 300, 50);
		help.addActionListener(MenuListener.getInstance());
		add(help);
		
		JButton exit = new MenuButton(-1);
		exit.setText("Exit");
		exit.setBounds(0, 250, 300, 50);
		exit.addActionListener(MenuListener.getInstance());
		add(exit);
	}	
}