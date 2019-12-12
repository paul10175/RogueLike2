package engine;

import java.awt.geom.AffineTransform;

public class CameraComponent extends Component {

	public CameraComponent(Camera parent) {
		super(parent);
		this.setPriority(Priority.CAMERA);
	}
	
	public void logic() {
		if (InputHandler.I_PRESSED) {
			parent.at.translate(0, -2);
		}
		if (InputHandler.J_PRESSED) {
			parent.at.translate(-2, 0);
		}
		if (InputHandler.K_PRESSED) {
			parent.at.translate(0, 2);
		}
		if (InputHandler.L_PRESSED) {
			parent.at.translate(2, 0);
		}
		if (InputHandler.U_PRESSED) {
			this.parent.at.translate(EngineCore.Frame.getWidth()/2, EngineCore.Frame.getHeight()/2);
			this.parent.at.rotate(0.01d);
			this.parent.at.translate(-EngineCore.Frame.getWidth()/2, -EngineCore.Frame.getHeight()/2);
		}
		if (InputHandler.O_PRESSED) {
			this.parent.at.translate(EngineCore.Frame.getWidth()/2, EngineCore.Frame.getHeight()/2);
			this.parent.at.rotate(-0.01d);
			this.parent.at.translate(-EngineCore.Frame.getWidth()/2, -EngineCore.Frame.getHeight()/2);
		}
		if (InputHandler.H_PRESSED) {
			this.parent.at.translate(EngineCore.Frame.getWidth()/2, EngineCore.Frame.getHeight()/2);
			this.parent.at.scale(1.01d, 1.01d);
			this.parent.at.translate(-EngineCore.Frame.getWidth()/2, -EngineCore.Frame.getHeight()/2);
		}
		if (InputHandler.SEMICOLON_PRESSED) {
			this.parent.at.translate(EngineCore.Frame.getWidth()/2, EngineCore.Frame.getHeight()/2);
			this.parent.at.scale(0.99d, 0.99d);
			this.parent.at.translate(-EngineCore.Frame.getWidth()/2, -EngineCore.Frame.getHeight()/2);
		}
	}

}
