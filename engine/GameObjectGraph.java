package engine;

import java.awt.geom.AffineTransform;
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
		while (!nodeStack.isEmpty()) {
			GameObjectNode currNode = nodeStack.pop();
			AffineTransform currTrans = transStack.pop();
		}
	}
	
	public void logic() {
		Stack<GameObjectNode> nodeStack = new Stack<GameObjectNode>();
	}
}
