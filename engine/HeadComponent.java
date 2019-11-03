package engine;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class HeadComponent extends Component {
	protected Character character;
	protected boolean rightEyeUsed = true;
	
	
	public HeadComponent(Character parent) {
		super(parent);
//		this.direction = d;
		this.character = parent;
		this.setPriority(Priority.HEAD);
	}
	
	public void graphics(Graphics2D G) {
		// Animations here
		G.drawRenderedImage(((Character)parent).getHeadList().get(0), ((Character)parent).at);
	}
	
	public void logic() {
		// AffineTransform here
//		System.out.println(InputHandler.W_PRESSED);
		if (InputHandler.W_PRESSED) {
			parent.at.translate(0,-2);
			character.setDirection(Direction.NORTH);
		}if (InputHandler.A_PRESSED) {
			parent.at.translate(-2, 0);
			character.setDirection(Direction.WEST);
		}if (InputHandler.S_PRESSED) {
			parent.at.translate(0, 2);
			character.setDirection(Direction.SOUTH);
		}if (InputHandler.D_PRESSED) {
			parent.at.translate(2, 0);
			character.setDirection(Direction.EAST);
		}if (InputHandler.SPACE_PRESSED) {
			Character character = (Character)parent;
			Tear tear = new Tear((int)parent.at.getTranslateX(), (int)parent.at.getTranslateY(), character.lastDirection, rightEyeUsed);
			tear.addComponent(new TearMovement(tear));
			EngineCore.elements.add(tear);
			rightEyeUsed = !rightEyeUsed;
			InputHandler.SPACE_PRESSED = false;
		}
			
	}
}
