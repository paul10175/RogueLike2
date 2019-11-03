package engine;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BodyComponent extends Component {
	
	ArrayList<BufferedImage> bodyImgs;
//	static int index;
//	BufferedImage sprite;

	public BodyComponent(Character parent) {
		super(parent);
		this.bodyImgs = parent.bodyList;
		this.setPriority(Priority.BODY);
	}
	
	public void graphics(Graphics2D G) {
		BufferedImage sprite = bodyImgs.get(0);
		int numFrames = 10;
		int rate = 3;
		int index = EngineCore.LCount % (numFrames*rate);
		if (InputHandler.W_PRESSED || InputHandler.S_PRESSED) {
			sprite = bodyImgs.get(index/rate);
		}
		if (InputHandler.D_PRESSED) {
			sprite = bodyImgs.get(10 + index/rate);
		}
		if (InputHandler.A_PRESSED) {
			sprite = bodyImgs.get(20 + index/rate);
		}
		
		AffineTransform at = (AffineTransform) parent.at.clone();
		at.translate(10,40);
		G.drawRenderedImage(sprite, at);
	}
	
	public void logic() {
	}

}
