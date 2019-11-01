package engine;

import java.awt.Graphics2D;

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
	}
	
	public void graphics(Graphics2D G) {
		G.drawRenderedImage(((Tear)parent).bg, parent.at);
	}
	
	//public boolean outOfBounds() {
		
	//}
}
