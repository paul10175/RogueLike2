package engine;

import java.awt.geom.AffineTransform;

public class Camera extends GameObject {
	public Camera() {
		this.at = new AffineTransform();
		this.at.setToIdentity();
	}
}
