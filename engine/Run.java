package engine;

public class Run {

	public static void main(String[] args) {
		EngineCore core = new EngineCore(10, 2, 2, "hello", "Assets");
		core.start();
		core.run();
	}

}
