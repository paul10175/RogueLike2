package engine;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class TearMovement extends Component{
	
	protected int lastXPos, lastYPos;
	protected Enum lastDirection;
	
	public TearMovement(Tear parent) {
		super(parent);
		lastDirection = parent.lastDirection;
		
	}
	
	public void logic() {
		lastXPos = parent.posX;
		lastYPos = parent.posY;
		
		if (lastDirection == Direction.NORTH) {
			parent.posY -= 30;
		} else if (lastDirection == Direction.EAST) {
			parent.posX += 30;
		} else if (lastDirection == Direction.SOUTH) {
			parent.posY += 30;
		} else {
			parent.posX -= 30;
		}
	}
	
	public void graphics(Graphics2D G) {
		Tear temp = (Tear)parent;
		//System.out.print("This is the post" + parent.posX + "\n and this is the second" + parent.posY);
		AffineTransform at = AffineTransform.getScaleInstance(.2, .2);
		at.translate(parent.posX, parent.posY);
		G.drawRenderedImage(temp.getImage(), at);
	}
	
	//public boolean outOfBounds() {
		
	//}
}
