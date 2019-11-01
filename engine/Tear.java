package engine;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Tear extends GameObject{

	protected Direction lastDirection;
	protected BufferedImage bg;
	
	public Tear(int x, int y, Direction lastDirection, BufferedImage img) {
		at = new AffineTransform();
		at.setToIdentity();
		at.setToScale(.2, .2);
		at.translate(x, y);
		this.lastDirection = lastDirection;
		this.bg = img;
	}
	
	public Direction getLastDirection() {
		return lastDirection;
	}
	
	public BufferedImage getImage() {
		return bg;
	}

}
