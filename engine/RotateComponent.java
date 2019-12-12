package engine;

import java.awt.geom.AffineTransform;

public class RotateComponent extends Component {

	public RotateComponent(GameObject parent) {
		super(parent);
//		this.setPriority(Priority.values()[parent.Min]);
		this.setPriority(Priority.BACKGROUND);
	}
	
	public void logic() {
		if (InputHandler.Q_PRESSED) {
			AffineTransform tempTrans = new AffineTransform(parent.at);
			this.parent.at.setToIdentity();
			this.parent.at.rotate(0.01d);
			this.parent.at.concatenate(tempTrans);
		}
		if (InputHandler.E_PRESSED) {
			AffineTransform tempTrans = new AffineTransform(parent.at);
			this.parent.at.setToIdentity();
			this.parent.at.rotate(-0.01d);
			this.parent.at.concatenate(tempTrans);
		}
	}

}
