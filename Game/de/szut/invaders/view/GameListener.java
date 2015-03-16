package de.szut.invaders.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Der GameListener sorgt dafür das das Spiel erkennt welche Taste gedrückt wird
 * @author Simeon Kublenz
 */
public class GameListener implements KeyListener{
	
	private String shootKey = "Y";
	private String rightKey = "Rechts";
	private String leftKey = "Links";
	private String forwardKey = "Oben";
	private String backKey = "Unten";
	
	
	private static GameListener instance;
	
	private boolean shoot;
	private boolean right;
	private boolean left;
	private boolean forward;
	private boolean backward;
	
	/**
	 * Das Singelton-Pattern
	 */
	public static GameListener getInstance() {
		if (instance == null) {
			instance = new GameListener();
		}
		return instance;
	}
	
	/**
	 * Der Konstruktor
	 */
	private GameListener() {
	}
	
	/**
	 * wird aufgerufen wenn eine Taste gedrückt wurde
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		if (KeyEvent.getKeyText((arg0.getKeyCode())).equals(shootKey)) {
			shoot = true;
		}
		else if (KeyEvent.getKeyText((arg0.getKeyCode())).equals(leftKey)) {
			left = true;
		}
		else if (KeyEvent.getKeyText((arg0.getKeyCode())).equals(rightKey)) {
			right = true;
		}
		else if (KeyEvent.getKeyText((arg0.getKeyCode())).equals(backKey)) {
			backward = true;
		}
		else if (KeyEvent.getKeyText((arg0.getKeyCode())).equals(forwardKey)) {
			forward = true;
		}
	}
	
	/**
	 * wird aufgerufen wenn eine Taste losgelassen wurde
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		if (KeyEvent.getKeyText((arg0.getKeyCode())).equals(shootKey)) {
			shoot = false;
		}
		else if (KeyEvent.getKeyText((arg0.getKeyCode())).equals(leftKey)) {
			left = false;
		}
		else if (KeyEvent.getKeyText((arg0.getKeyCode())).equals(rightKey)) {
			right = false;
		}
		else if (KeyEvent.getKeyText((arg0.getKeyCode())).equals(backKey)) {
			backward = false;
		}
		else if (KeyEvent.getKeyText((arg0.getKeyCode())).equals(forwardKey)) {
			forward = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	public boolean isShoot() {
		return shoot;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isLeft() {
		return left;
	}
	
	public boolean isForward() {
		return forward;
	}

	public boolean isBackward() {
		return backward;
	}
	
	public String getUp() {
		return forwardKey;
	}
	
	public void setUp(String up) {
		if (up != null) {
			forwardKey = up;
		}
	}
	
	public String getDown() {
		return backKey;
	}
	
	public void setDown(String down) {
		if (down != null) {
			backKey = down;
		}
	}
	
	public String getLeft() {
		return leftKey;
	}
	
	public void setLeft(String left) {
		if (left != null) {
			leftKey = left;
		}
	}
	
	public String getRight() {
		return rightKey;
	}
	
	public void setRight(String right) {
		if (right != null) {
			rightKey = right;
		}
	}
	
	public String getShoot() {
		return shootKey;
	}
	
	public void setShoot(String shoot) {
		if (shoot != null) {
			shootKey = shoot;
		}
	}
	
	public void restart() {
		forward = false;
		backward = false;
		left = false;
		right = false;	
		shoot = false;
	}
}
