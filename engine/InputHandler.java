package engine;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
	
	public static boolean W_PRESSED;
	public static boolean A_PRESSED;
	public static boolean S_PRESSED;
	public static boolean D_PRESSED;
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
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
