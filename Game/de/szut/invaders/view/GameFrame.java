package de.szut.invaders.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import de.szut.invaders.modell.Logic;
import de.szut.invaders.world.Score;

/**
 * Das GameFrame enthält die Spieloberfläche
 * @author Marius Thürmer und Melina Wolle
 */
public class GameFrame extends JFrame {
	
	private static final long serialVersionUID = -3442156591001074345L;
	public static final int DIFFICULTYMENUE = 1;
	public static final int OPTIONMENUE = 2;
	public static final int HELPMENUE = 3;
	public static final int SOUNDMENUE = 8;
	public static final int KEYSETTING = 9;
	public static final int EASY = 5;
	public static final int NORMAL = 6;
	public static final int HARD = 7;
	private MainMenue startGui = new MainMenue();
	private OptionsMenue optionMenue = new OptionsMenue(startGui);
	private SoundMenue soundMenue = new SoundMenue(optionMenue);
	private HelpMenue helpMenue = new HelpMenue(startGui);
	private KeySettings keySettings = new KeySettings(optionMenue);
	private DifficultyMenue difficultyMenue = new DifficultyMenue(startGui);
	private GamePanel gamePanel = GamePanel.getInstance();
	private static GameFrame instance;
	private boolean closingOption;
	
	/**
	 * Das Singelton-Pattern
	 */
	public static GameFrame getInstance() {
		if (instance == null) {
			instance = new GameFrame();
		}
		return instance;
	}
	
	/**
	 * Der Konstruktor
	 */
	private GameFrame() {
		setTitle("Space Invaders");
		setLayout(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		addWindowListener(new FrameListener());
		setContentPane(startGui);
		setSize(startGui.getWidth()+6, startGui.getHeight()+28);
		setVisible(true);
	}
	
	/**
	 * Kehrt ins Hauptmenü zurück
	 */
	public void backToMainMenue() {
		removeKeyListener(this.getKeyListeners()[0]);
		setContentPane(startGui);
		setSize(startGui.getWidth()+6, startGui.getHeight()+28);
	}
	
	/**
	 * Tauscht zwischen den einzelnen Menüs
	 */
	public void switchPanel(int panelNumber) {
		int i = 3;
		switch(panelNumber) {
			case(-1):{
				System.exit(0);
				break;
			}
			case(0):{
				setContentPane(((MenuePanel)(getContentPane())).getParentPanel());
				setSize(getContentPane().getWidth()+6, getContentPane().getHeight()+29);
				break;
			}
			case(OPTIONMENUE): {
				setContentPane(optionMenue);
				setSize(optionMenue.getWidth()+6, optionMenue.getHeight()+29);
				break;
			}
			case(SOUNDMENUE): {
				setContentPane(soundMenue);
				setSize(soundMenue.getWidth()+6, soundMenue.getHeight()+29);
				break;
			}
			case(KEYSETTING):{
				setContentPane(keySettings);
				setSize(keySettings.getWidth()+6, keySettings.getHeight()+29);
				break;
			}
			case(HELPMENUE): {
				setContentPane(helpMenue);
				setSize(helpMenue.getWidth()+6, helpMenue.getHeight()+29);
				break;
			}
			case(DIFFICULTYMENUE): {
				setContentPane(difficultyMenue);
				setSize(difficultyMenue.getWidth()+6, difficultyMenue.getHeight()+29);
				break;
			}
			case(EASY):
				i--;
			case(NORMAL):
				i--;
			case(HARD): {
				this.
				setContentPane(gamePanel);
				setSize(gamePanel.getWidth()+6, gamePanel.getHeight()+29);
				addKeyListener(GameListener.getInstance());
				Logic l = Logic.getInstance(i);
				l.start();
				Score.getInstance();
				Healthbar.getInstance();
				requestFocusInWindow();
				closingOption = true;
				break;
			}
		}
	}
	
	/**
	 * Wird aufgerufen wenn man versucht hat das Spiel zu beenden
	 */
	public void showClosingWindow() {
		if (closingOption) {
			String[] options = {"Fortsetzen", "Beenden"};
			int selection = JOptionPane.showOptionDialog(null, "Wirklich beenden?", "Beenden",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			switch(selection) {
				case (1): {
					System.exit(0);
					break;
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}
