
public class HeadComponent {
	Direction direction;
	Priority priority;
	
	public HeadComponent(Direction d) {
		this.direction = d;
		this.priority = Priority.HEAD;
	}
	
	public void graphics() {
		// Animations here
	}
	
	public void logic() {
		// AffineTransform here
	}
}
