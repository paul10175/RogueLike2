package engine;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BodyComponent extends Component {
	
	ArrayList<BufferedImage> bodyImgs;

	public BodyComponent(Character parent) {
		super(parent);
		this.setPriority(Priority.BODY);
	}
	
	public void graphics(Graphics2D G) {
		AffineTransform at = (AffineTransform) parent.at.clone();
		at.translate(10,40);
		G.drawRenderedImage(((Character)parent).getBodyList().get(0), at);
	}
	
	public void logic() {
		
	}

}
