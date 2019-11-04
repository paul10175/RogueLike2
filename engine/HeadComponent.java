package engine;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HeadComponent extends Component {
	ArrayList<BufferedImage> headImgs;
	protected Character character;
	protected boolean rightEyeUsed = true;
	protected BufferedImage prevHead;
	protected Direction direction;
	
	
	public HeadComponent(Character parent) {
		super(parent);
		this.headImgs = parent.headList;
		this.character = parent;
		this.direction = Direction.SOUTH;
		this.prevHead = headImgs.get(0);
		this.setPriority(Priority.HEAD);
	}
	
	public void graphics(Graphics2D G) {
		// Animations here
		BufferedImage sprite = this.prevHead;
		int numFrames = 2;
		int rate = 3;
		int index = EngineCore.LCount % (numFrames * rate);
		
		if (InputHandler.DOWN_PRESSED || InputHandler.W_PRESSED || InputHandler.A_PRESSED || InputHandler.S_PRESSED || InputHandler.D_PRESSED) {
			sprite = headImgs.get(0);
			this.direction = Direction.SOUTH;
		}
		if (InputHandler.RIGHT_PRESSED) {
			sprite = headImgs.get(2);
			this.direction = Direction.EAST;
		}
		if (InputHandler.UP_PRESSED) {
			sprite = headImgs.get(4);
			this.direction = Direction.NORTH;
		}
		if (InputHandler.LEFT_PRESSED) {
			sprite = headImgs.get(6);
			this.direction = Direction.WEST;
		}
		if (InputHandler.SPACE_PRESSED) {
			if (this.direction == Direction.SOUTH) 
				sprite = headImgs.get(index/rate);
			if (this.direction == Direction.EAST) 
				sprite = headImgs.get(2+index/rate);
			if (this.direction == Direction.NORTH) 
				sprite = headImgs.get(4+index/rate);
			if (this.direction == Direction.WEST) 
				sprite = headImgs.get(6+index/rate);
		}
		
		this.prevHead = sprite;
		AffineTransform at = (AffineTransform) parent.at.clone();
		G.drawRenderedImage(this.prevHead, at);
	}
	
	public void logic() {
		// AffineTransform here
//		System.out.println(InputHandler.W_PRESSED);
		if (InputHandler.W_PRESSED) {
			parent.at.translate(0,-2);
			character.setDirection(Direction.NORTH);
		}if (InputHandler.A_PRESSED) {
			parent.at.translate(-2, 0);
			character.setDirection(Direction.WEST);
		}if (InputHandler.S_PRESSED) {
			parent.at.translate(0, 2);
			character.setDirection(Direction.SOUTH);
		}if (InputHandler.D_PRESSED) {
			parent.at.translate(2, 0);
			character.setDirection(Direction.EAST);
		}if (InputHandler.SPACE_PRESSED) {
//			Character character = (Character)parent;
			Tear tear = new Tear((int)parent.at.getTranslateX(), (int)parent.at.getTranslateY(), this.direction, rightEyeUsed);
			tear.addComponent(new TearMovement(tear));
			EngineCore.elements.add(tear);
			rightEyeUsed = !rightEyeUsed;
			InputHandler.SPACE_PRESSED = false;
		}
			
	}
}
