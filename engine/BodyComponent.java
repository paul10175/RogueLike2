package engine;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BodyComponent extends Component {
	
	ArrayList<BufferedImage> bodyImgs;
	static int index;

	public BodyComponent(Character parent) {
		super(parent);
		this.setPriority(Priority.BODY);
	}
	
	public void graphics(Graphics2D G) {
		int numFrames = 10;
		int rate = 1;
		BufferedImage sprite;
		int index = EngineCore.LCount % (numFrames*rate);
		sprite = ((Character)parent).getBodyList().get(index/rate);
		
		AffineTransform at = (AffineTransform) parent.at.clone();
		at.translate(10,40);
		G.drawRenderedImage(sprite, at);
	}
	
	public void logic() {
		
	}

}
