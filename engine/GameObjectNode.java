package engine;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class GameObjectNode extends GameObject {
	GameObject object;
	Collection<GameObjectNode> children;
	
	public GameObjectNode(GameObject object) {
		this.object = object;
		this.children = new LinkedList<GameObjectNode>();
	}
	
	public Iterator<GameObjectNode> getChildrenIterator() {
		return children.iterator();
	}
	
	public void graphics() {
		// To make objects display in the right place,
		// temporarily replace its affine transform with the one from the graph while calling graphics()
	}
	
	public void logic() {
		// Same as graphics I guess, not sure if it's necessary
	}
}
