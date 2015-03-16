package de.szut.invaders.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Enthält die Slider zur Soundeinstellung
 * @author Marius Thürmer
 */
public class SoundMenue extends MenuePanel {
	
	private static final long serialVersionUID = -60925547909927293L;
	
	/**
	 * Der Konstruktor
	 * @param OptionMenue
	 */
	public SoundMenue(JPanel OptionMenue){
		setSize(300,300);
		setLayout(null);
		
		parent = OptionMenue;
		
		JLabel text = new JLabel();
		text.setText("Sound");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text.setBounds(0, 0, 300, 75);
		add(text);
		
		JLabel backgroundMusicText = new JLabel();
		backgroundMusicText.setText("Background Music");
		backgroundMusicText.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundMusicText.setFont(new Font("Times New Roman", Font.BOLD, 12));
		backgroundMusicText.setBounds(0, 75, 200, 50);
		add(backgroundMusicText);
		
		final JSlider backgroundMusic = new JSlider();
		backgroundMusic.setBounds(0, 125, 200, 50);

		add(backgroundMusic);
		
		JLabel sight1 = new JLabel();
		sight1.setText(backgroundMusic.getValue()+"%");
		backgroundMusicText.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundMusicText.setFont(new Font("Times New Roman", Font.BOLD, 12));
		sight1.setBounds(200, 125, 100, 50);
		add(sight1);
		
		RefreshSoundSlider re1 = new RefreshSoundSlider(sight1, backgroundMusic);
		re1.start();
		
		JButton back = new MenuButton(0);
		back.setText("Back");
		back.setBounds(0, 250, 300,50);
		back.addActionListener(MenuListener.getInstance());
		add(back);
		back.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			SoundSaver o = new SoundSaver(backgroundMusic);
				o.save();	
			}
		});
	}
	
}