package engine;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
	
	public static boolean W_PRESSED;
	public static boolean A_PRESSED;
	public static boolean S_PRESSED;
	public static boolean D_PRESSED;
	public static boolean Q_PRESSED;
	public static boolean E_PRESSED;
	public static boolean UP_PRESSED;
	public static boolean DOWN_PRESSED;
	public static boolean LEFT_PRESSED;
	public static boolean RIGHT_PRESSED;
	public static boolean SPACE_PRESSED;
	
	public InputHandler() {
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int code = arg0.getKeyCode();
		if (code == KeyEvent.VK_W)
			W_PRESSED = true;
		else if (code == KeyEvent.VK_A)
			A_PRESSED = true;
		else if (code == KeyEvent.VK_S)
			S_PRESSED = true;
		else if (code == KeyEvent.VK_D)
			D_PRESSED = true;
		else if (code == KeyEvent.VK_Q)
			Q_PRESSED = true;
		else if (code == KeyEvent.VK_E)
			E_PRESSED = true;
		else if (code == KeyEvent.VK_UP)
			UP_PRESSED = true;
		else if (code == KeyEvent.VK_DOWN)
			DOWN_PRESSED = true;
		else if (code == KeyEvent.VK_LEFT)
			LEFT_PRESSED = true;
		else if (code == KeyEvent.VK_RIGHT)
			RIGHT_PRESSED = true;
		else if (code == KeyEvent.VK_SPACE)
			SPACE_PRESSED = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		int code = arg0.getKeyCode();
		if (code == KeyEvent.VK_W)
			W_PRESSED = false;
		else if (code == KeyEvent.VK_A)
			A_PRESSED = false;
		else if (code == KeyEvent.VK_S)
			S_PRESSED = false;
		else if (code == KeyEvent.VK_D)
			D_PRESSED = false;
		else if (code == KeyEvent.VK_Q)
			Q_PRESSED = false;
		else if (code == KeyEvent.VK_E)
			E_PRESSED = false;
		else if (code == KeyEvent.VK_UP)
			UP_PRESSED = false;
		else if (code == KeyEvent.VK_DOWN)
			DOWN_PRESSED = false;
		else if (code == KeyEvent.VK_LEFT)
			LEFT_PRESSED = false;
		else if (code == KeyEvent.VK_RIGHT)
			RIGHT_PRESSED = false;
		else if (code == KeyEvent.VK_SPACE)
			SPACE_PRESSED = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
