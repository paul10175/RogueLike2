package engine;

import java.awt.Graphics2D;

//You may need to import game object based on your package structure 

public class Component {
	
	public GameObject parent = null; 
	public boolean active = true;
	public Priority priority;
	
	
	public Component(GameObject object){
		parent = object;
	}
	
	public void graphics(Graphics2D G) {
		
	}
	
	public void logic() {
		
	}
	
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public Priority getPriority() {
		return this.priority;
	}
}
