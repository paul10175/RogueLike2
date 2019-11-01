package engine;

import java.awt.image.BufferedImage;

public class Tear extends GameObject{

	protected Direction lastDirection;
	protected BufferedImage bg;
	
	public Tear(int x, int y, Direction lastDirection, BufferedImage img) {
		this.posX = x;
		this.posY = y;
		this.lastDirection = lastDirection;
		this.bg = img;
	}
	
	public Direction getLastDirection() {
		return lastDirection;
	}
	@Override
	public int compareTo(GameObject o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public BufferedImage getImage() {
		return bg;
	}

}
