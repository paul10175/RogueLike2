package engine;

public class RotateComponent extends Component {

	public RotateComponent(GameObject parent) {
		super(parent);
//		this.setPriority(Priority.values()[parent.Min]);
		this.setPriority(Priority.BACKGROUND);
	}
	
	public void logic() {
		if (InputHandler.Q_PRESSED) {
			this.parent.at.rotate(0.01d);
		}
		if (InputHandler.E_PRESSED) {
			this.parent.at.rotate(-0.01d);
		}
		if (InputHandler.LEFT_PRESSED) {
			this.parent.at.translate(-2,0);
		}
		if (InputHandler.RIGHT_PRESSED) {
			this.parent.at.translate(2,0);
		}
	}

}
