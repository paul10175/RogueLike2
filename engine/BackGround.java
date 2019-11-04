package engine;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class BackGround extends GameObject{

	protected BufferedImage bg;
	
	public BackGround(BufferedImage bg) {
		this.bg = bg;
		this.at = new AffineTransform();
		this.at.setToIdentity();
//		this.at.setToScale(0.5, 1); // Fix these numbers
	}
	
	public BufferedImage getImage() {
		return bg;
	}
}
