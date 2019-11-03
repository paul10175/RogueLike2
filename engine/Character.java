package engine;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Character extends GameObject{

	Direction lastDirection = Direction.SOUTH;
	AffineTransform h_at;
	ArrayList<BufferedImage> bodyList, headList;
	
	public Character(int x, int y, ArrayList<BufferedImage> imageList) {
		at = new AffineTransform();
//		h_at = new AffineTransform();
		at.setToIdentity();
//		h_at.setToIdentity();
//		at.translate(x+10, y+40);
		at.translate(x,y);
//		h_at.translate(x, y);
		headList = new ArrayList<BufferedImage>(imageList.subList(0, 8));
		bodyList = new ArrayList<BufferedImage>(imageList.subList(8, 38));
	}
	
	public ArrayList<BufferedImage> getHeadList() {
		return headList;
	}
	
	public ArrayList<BufferedImage> getBodyList() {
		return bodyList;
	}
	
	public void setDirection(Direction dir) {
		this.lastDirection = dir;
	}
}
