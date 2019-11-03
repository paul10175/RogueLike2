package engine;

import java.awt.Graphics2D;

public class HeadComponent extends Component {
//	Direction direction;
//	Priority priority;
	
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
	}
}
