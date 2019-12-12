package engine;

import java.awt.geom.AffineTransform;

public class Camera extends GameObject {
	public Camera(int x, int y) {
		this.at = new AffineTransform();
		this.at.setToIdentity();
		this.at.translate(x, y);
	}
}
