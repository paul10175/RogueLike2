package engine;

import java.awt.image.BufferedImage;

public class BackGround extends GameObject{

	protected BufferedImage bg;
	
	public BackGround(BufferedImage bg) {
		this.bg = bg;
	}
	
	public BufferedImage getImage() {
		return bg;
	}
}
