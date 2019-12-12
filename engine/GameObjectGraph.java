package engine;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.util.Iterator;
import java.util.Stack;

public class GameObjectGraph extends GameObject {
	GameObjectNode head;
	GameObjectNode camera;
	
	public GameObjectGraph(GameObjectNode head, GameObjectNode camera) {
		this.head = head;
		Min = head.Min;
		Max = head.Max;
		this.camera = camera;
	}
	
	public void graphics(int priority, Graphics2D G) {
		Stack<GameObjectNode> nodeStack = new Stack<GameObjectNode>();
		Stack<AffineTransform> transStack = new Stack<AffineTransform>();
		
		nodeStack.push(head);
//		AffineTransform id = new AffineTransform();
//		id.setToIdentity();
//		transStack.push(id);
		
		AffineTransform cameraTrans = new AffineTransform(camera.getRelativeTransform());
		try {
			cameraTrans.invert();
		} catch (NoninvertibleTransformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		nodeStack.push(camera);
		transStack.push(cameraTrans);
		while (!nodeStack.isEmpty()) {
			GameObjectNode currNode = nodeStack.pop();
			AffineTransform currTrans = transStack.pop();
			AffineTransform newTrans = currNode.getRelativeTransform();
//			System.out.println(newTrans);
			currTrans.concatenate(newTrans);
			currNode.setAbsoluteTransform(currTrans);
			currNode.graphics(priority, G);
			Iterator<GameObjectNode> childItr = currNode.getChildrenIterator();
			while (childItr.hasNext()) {
				nodeStack.push(childItr.next());
				transStack.push(new AffineTransform(currTrans));
			}
		}
//		System.out.println("---");
	}
	
	public void logic(int priority) {
		Stack<GameObjectNode> nodeStack = new Stack<GameObjectNode>();
		nodeStack.push(camera);
		nodeStack.push(head);
		while (!nodeStack.isEmpty()) {
			GameObjectNode currNode = nodeStack.pop();
			currNode.logic(priority);
			Iterator<GameObjectNode> childItr = currNode.getChildrenIterator();
			while (childItr.hasNext()) {
				nodeStack.push(childItr.next());
			}
		}
	}
}
