package engine;

import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.util.Stack;

public class GameObjectGraph extends GameObject {
	GameObjectNode head;
	GameObjectNode camera;
	
	public GameObjectGraph(GameObjectNode head, GameObjectNode camera) {
		this.head = head;
		this.camera = camera;
	}
	
	public void graphics() {
		Stack<GameObjectNode> nodeStack = new Stack<GameObjectNode>();
		Stack<AffineTransform> transStack = new Stack<AffineTransform>();
		// Invert the camera transform and push it into the stack first
//		AffineTransform cameraTrans = camera.object.at;
//		try {
//			cameraTrans.invert();
//		} catch (NoninvertibleTransformException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		nodeStack.push(camera);
//		transStack.push(cameraTrans);
		nodeStack.push(head);
		transStack.push(head.object.at);
		while (!nodeStack.isEmpty()) {
			GameObjectNode currNode = nodeStack.pop();
			AffineTransform currTrans = transStack.pop();
		}
	}
	
	public void logic() {
		Stack<GameObjectNode> nodeStack = new Stack<GameObjectNode>();
	}
}
