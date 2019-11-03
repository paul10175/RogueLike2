package engine;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Tear extends GameObject{

	protected Direction lastDirection;
	protected boolean useRightEye;
	
	public Tear(int x, int y, Direction lastDirection, boolean whichEye) {
		this.useRightEye = whichEye;
		this.lastDirection = lastDirection;
		at = new AffineTransform();
		at.setToIdentity();
		at.translate(x, y);
		setXYPosition();
	}
	
	
	//Four different cases we have to deal with when placing the tear in the correct position.
	//North, east, south and west. In each case we have to check which eye we need to use. 
	public void setXYPosition() {
		if (lastDirection == Direction.NORTH) {
			if (useRightEye == true)
				at.translate(35, 25);
			else 
				at.translate(5, 25);
		} else if (lastDirection == Direction.SOUTH) {
			if (useRightEye == true)
				at.translate(5, 25);
			else 
				at.translate(35, 25);
		} else if (lastDirection == Direction.EAST) {
			at.translate(30,20);
		} else 
			at.translate(10, 20);
		
		at.scale(.25, .25);
	}
	
	public Direction getLastDirection() {
		return lastDirection;
	}
}
