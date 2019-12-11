package engine;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class TearMovement extends Component{
	
	protected Enum<Direction> lastDirection;
	
	public TearMovement(Tear parent) {
		super(parent);
		this.lastDirection = parent.lastDirection;
		if (lastDirection == Direction.NORTH)
			this.setPriority(Priority.TEAR_NORTH);
		else
			this.setPriority(Priority.TEAR_SOUTH);
		
	}
	
	public void logic() {
		if (lastDirection == Direction.NORTH) {
			parent.at.translate(0, -5);
		} else if (lastDirection == Direction.EAST) {
			parent.at.translate(5, 0);
		} else if (lastDirection == Direction.SOUTH) {
			parent.at.translate(0, 5);
		} else {
			parent.at.translate(-5, 0);
		}
		if (outOfBounds()) {
			EngineCore.elements.remove(parent);
		}
	}
	
	public void graphics(Graphics2D G) {
		BufferedImage img = (BufferedImage)EngineCore.assets.getImage("boiS.png", 38);
		G.drawRenderedImage(img, parent.at);
	}
	
	public boolean outOfBounds() {
		double x = parent.at.getTranslateX();
		double y = parent.at.getTranslateY();
		if (x <= 0 || x >= EngineCore.Frame.getWidth() || y <= 0 || y >= EngineCore.Frame.getHeight()) {
			System.out.println("Tear out of bounds");
			return true;
		}
		return false;
	}
}
