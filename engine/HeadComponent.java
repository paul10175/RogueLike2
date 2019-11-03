package engine;

import java.awt.Graphics2D;

public class HeadComponent extends Component {
	
	public HeadComponent(Character parent) {
		super(parent);
//		this.direction = d;
		this.setPriority(Priority.HEAD);
	}
	
	public void graphics(Graphics2D G) {
		// Animations here
		G.drawRenderedImage(((Character)parent).getHeadList().get(0), ((Character)parent).at);
	}
	
	public void logic() {
		// AffineTransform here
//		System.out.println(InputHandler.W_PRESSED);
		if (InputHandler.W_PRESSED)
			parent.at.translate(0,-1);
		if (InputHandler.A_PRESSED)
			parent.at.translate(-1, 0);
		if (InputHandler.S_PRESSED)
			parent.at.translate(0, 1);
		if (InputHandler.D_PRESSED)
			parent.at.translate(1, 0);
	}
}
