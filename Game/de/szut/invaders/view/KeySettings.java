package de.szut.invaders.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Das KeySettings Panel wird dazu genutzt die Steuerung zu ändern 
 * @author Marius Thürmer
 */
public class KeySettings extends MenuePanel {
	
	private static final long serialVersionUID = -3768635193112511798L;
	private JButton[] b;
	private JButton up;
	private JButton down;
	private JButton left;
	private JButton right;
	private JButton shot;
	
	/**
	 * Der Konstruktor
	 * @param optionsMenue
	 */
	public KeySettings(JPanel optionsMenue){
		
		b = new JButton[5];
		
		setSize(300,400);
		setLayout(null);
		
		parent = optionsMenue;
		
		JLabel text = new JLabel();
		text.setText("Key Settings");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text.setBounds(0, 0, 300, 75);
		add(text);
		
		JLabel upText = new JLabel();
		upText.setText("UP:");
		upText.setHorizontalAlignment(SwingConstants.CENTER);
		upText.setFont(new Font("Times New Roman", Font.BOLD, 15));
		upText.setBounds(0, 75, 150, 50);
		add(upText);
		
		up = new JButton();
		up.setText(GameListener.getInstance().getUp());
		up.setHorizontalAlignment(SwingConstants.CENTER);
		up.setFont(new Font("Times New Roman", Font.BOLD, 15));
		up.setBounds(150, 75, 150, 50);
		add(up);
		up.addKeyListener(KeySaver.getInstance());
		
		JLabel downText = new JLabel();
		downText.setText("DOWN:");
		downText.setHorizontalAlignment(SwingConstants.CENTER);
		downText.setFont(new Font("Times New Roman", Font.BOLD, 15));
		downText.setBounds(0, 125, 150, 50);
		add(downText);
		
		down = new JButton();
		down.setText(GameListener.getInstance().getDown());
		down.setHorizontalAlignment(SwingConstants.CENTER);
		down.setFont(new Font("Times New Roman", Font.BOLD, 15));
		down.setBounds(150, 125, 150, 50);
		add(down);
		down.addKeyListener(KeySaver.getInstance());
		
		JLabel rightText = new JLabel();
		rightText.setText("Right:");
		rightText.setHorizontalAlignment(SwingConstants.CENTER);
		rightText.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rightText.setBounds(0, 175, 150, 50);
		add(rightText);
		
		right = new JButton();
		right.setText(GameListener.getInstance().getRight());
		right.setHorizontalAlignment(SwingConstants.CENTER);
		right.setFont(new Font("Times New Roman", Font.BOLD, 15));
		right.setBounds(150, 175, 150, 50);
		add(right);
		right.addKeyListener(KeySaver.getInstance());
		
		JLabel leftText = new JLabel();
		leftText.setText("LEFT:");
		leftText.setHorizontalAlignment(SwingConstants.CENTER);
		leftText.setFont(new Font("Times New Roman", Font.BOLD, 15));
		leftText.setBounds(0, 225, 150, 50);
		add(leftText);
		
		left = new JButton();
		left.setText(GameListener.getInstance().getLeft());
		left.setHorizontalAlignment(SwingConstants.CENTER);
		left.setFont(new Font("Times New Roman", Font.BOLD, 15));
		left.setBounds(150, 225, 150, 50);
		add(left);
		left.addKeyListener(KeySaver.getInstance());
		
		JLabel shotText = new JLabel();
		shotText.setText("SHOT:");
		shotText.setHorizontalAlignment(SwingConstants.CENTER);
		shotText.setFont(new Font("Times New Roman", Font.BOLD, 15));
		shotText.setBounds(0, 275, 150, 50);
		add(shotText);
		
		shot = new JButton();
		shot.setText(GameListener.getInstance().getShoot());
		shot.setHorizontalAlignment(SwingConstants.CENTER);
		shot.setFont(new Font("Times New Roman", Font.BOLD, 15));
		shot.setBounds(150, 275, 150, 50);
		add(shot);
		shot.addKeyListener(KeySaver.getInstance());
		
		b[0] = up;
		b[1] = down;
		b[2] = left;
		b[3] = right;
		b[4] = shot;
		KeySaver.getInstance().setButtons(b);
	
		MenuButton back = new MenuButton(0);
		back.setText("Back");
		back.setBounds(0, 350, 300,50);
		back.addActionListener(MenuListener.getInstance());
		back.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				KeySaver o = KeySaver.getInstance();
				o.save();
			}
		});
		add(back);
	}
}
