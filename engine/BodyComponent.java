package engine;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BodyComponent extends Component {
	
	ArrayList<BufferedImage> bodyImgs;

	public BodyComponent(Character parent) {
		super(parent);
		this.setPriority(Priority.BODY);
	}
	
	public void graphics(Graphics2D G) {
		G.drawRenderedImage(((Character)parent).getBodyList().get(0), parent.at);
	}
	
	public void logic() {
		
	}

}
