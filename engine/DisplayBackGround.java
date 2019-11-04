package engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class DisplayBackGround extends Component{

	BackGround parent;
	
	public DisplayBackGround(BackGround object) {
		super(object);
		this.parent = object;
	}
	
	public void logic() {
		
	}
	
	public void graphics(Graphics2D G) {
		BufferedImage temp = parent.getImage();
//		G.drawImage(temp, 0, 0, null);
		G.drawRenderedImage(temp, parent.at);
	}

}
