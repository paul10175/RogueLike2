package engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public abstract class GameObject{
	
	protected ArrayList<Component> components = new ArrayList<Component>();
	protected int posX,posY;
	public static int Min, Max;
	
	public void graphics(int priority, Graphics2D G) {
		for (Component component: components) {
			if (component.getPriority().ordinal() == priority)
				component.graphics(G);
		}
	}
	
	public void logic(int priority) {
		for (Component component: components) {
			if (component.getPriority().ordinal() == priority)
				component.logic();
		}
	}
	
	public void addComponent(Component component) {
		Priority priority = component.getPriority();
		if (component.getPriority().ordinal() > Max)
			Max = component.getPriority().ordinal();
		else if (component.getPriority().ordinal() < Min)
			Min = component.getPriority().ordinal();
		
		components.add(component);
	}
	
	public void removeComponent(Class type) {
		components.removeIf(comp -> (comp.getClass() == type));
	}

	public Component getComponent(Class type) {
		for (Component comp: components) {
			if (comp.getClass() == type)
				return comp;
		}
		return null;
	}
}
