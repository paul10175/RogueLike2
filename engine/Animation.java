package engine;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Animation {

	public Animation() {
		
	}
	
	public void iterateThroughArray(BufferedImage[] arr, double time, double lastTime, Graphics2D G, AffineTransform a) {
		int i = 0;
		double timePerImage = time / (double)arr.length;
		
		while (true) {
				lastTime = System.currentTimeMillis();
				G.drawRenderedImage(arr[i], a);
				i++;
			
			
			if (i == arr.length)
				break;
		}
	}
}
