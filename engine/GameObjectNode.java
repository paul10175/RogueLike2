package engine;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class GameObjectNode extends GameObject {
	GameObject object; // This object's transform is relative to its parent
	Collection<GameObjectNode> children;
	// This node's transform is absolute
	// it should be set by graphics() from the graph
	
	public GameObjectNode(GameObject object) {
		this.object = object;
		Min = object.Min;
		Max = object.Max;
		this.children = new LinkedList<GameObjectNode>();
	}
	
	public Iterator<GameObjectNode> getChildrenIterator() {
		return children.iterator();
	}
	
	public AffineTransform getRelativeTransform() {
		return object.at;
	}
	
	public void setAbsoluteTransform(AffineTransform at) {
		this.at = new AffineTransform(at);
	}
	
	public void addChild(GameObjectNode child) {
		this.children.add(child);
		if (child.Max > Max)
			Max = child.Max;
		if (child.Min < Min)
			Min = child.Min;
	}
	
	public void graphics(int priority, Graphics2D G) {
		// To make objects display in the right place,
		// temporarily replace its affine transform with the one from the graph while calling graphics()
		AffineTransform tempTrans = object.at;
		object.at = this.at;
		object.graphics(priority, G);
		object.at = tempTrans;
//		this.at.setToIdentity();
	}
	
	public void logic(int priority) {
		// Same as graphics I guess, not sure if it's necessary
		object.logic(priority);
	}
}
