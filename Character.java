package engine;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Character extends GameObject{

	Direction lastDirection;
	ArrayList<BufferedImage> bodyList, headList;
	
	public Character(ArrayList<BufferedImage> imageList) {
		bodyList = new ArrayList<BufferedImage>(imageList.subList(0, 6));
		headList = new ArrayList<BufferedImage>(imageList.subList(7, 36));
	}
	
	public ArrayList<BufferedImage> getHeadList() {
		return headList;
	}
	
	public ArrayList<BufferedImage> getBodyList() {
		return bodyList;
	}
}
