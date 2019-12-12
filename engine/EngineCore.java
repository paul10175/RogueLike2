package engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * Jason: BodyComponent, InputHandler, AffineTransformations
 * Fritz: HeadComponent, Direction, Priority
 * Paul: Character, Tear, TearMovement, Background, DisplayBackground, GameObject
 */
public class EngineCore extends Canvas implements Runnable{
	public int Width,
		       Height,
		       Scale;
	public String Name;
	public static JFrame Frame;
	public Boolean running;
	
	private int SleepTime = 0;
	
	public static ArrayList<GameObject> elements,tempElements;
	
	private BufferedImage BackGround;
	private int[] pixels;
	
	public static int FCount = 0;
	public static int LCount = 0;
	
	private String path;
	
	public static int runSpeed = 60;
	public static AssetsCenter assets;
	public static InputHandler inputs;
	
	public EngineCore(int Size,int Ratio, int Scale, String Name, String path){
	
	//initiation the variables
		this.Height = Size;
		this.Width = Size * Ratio;
		this.Scale = Scale;
		this.Name = Name;
		this.path = path;
		EngineCore.Frame = new JFrame(Name);
		
		// Starting the data collection/storage systems
		inputs = new InputHandler();
		EngineCore.Frame.addKeyListener(inputs);
		assets = new AssetsCenter(this.path);
		elements = new ArrayList<GameObject>();
		
		
		// Hard-coding the sky-box (not the best thing to do)
//		this.BackGround = new BufferedImage (this.Width,this.Height,BufferedImage.TYPE_INT_RGB);
//		this.pixels = ((DataBufferInt)BackGround.getRaster().getDataBuffer()).getData();
		
		// Setting up the canvas 
		setMinimumSize(new Dimension(this.Width*this.Scale, this.Height * this.Scale));
		setMaximumSize(new Dimension(this.Width*this.Scale, this.Height * this.Scale));
		setPreferredSize(new Dimension(this.Width*this.Scale, this.Height * this.Scale));
		
		EngineCore.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EngineCore.Frame.setLayout(new BorderLayout());
		
		EngineCore.Frame.add(this, BorderLayout.CENTER);
		EngineCore.Frame.pack();

		EngineCore.Frame.setResizable(true);
		EngineCore.Frame.setLocationRelativeTo(null);
		EngineCore.Frame.setVisible(true);
		
		BufferedImage img = (BufferedImage) assets.getImage("empt.png", 0);
		BackGround back = new BackGround(img);
		DisplayBackGround display = new DisplayBackGround(back);
		display.setPriority(Priority.BACKGROUND);
		back.addComponent(display);
		Character c = new Character(500, 100, assets.getImageList("boiS.png"));
		HeadComponent hc = new HeadComponent(c);
		BodyComponent bc = new BodyComponent(c);
		c.addComponent(bc);
		c.addComponent(hc);
//		AddObject(back);
//		AddObject(c);
		GameObjectNode backNode = new GameObjectNode(back);
		BackGround rotPlane = new BackGround(img);
		RotateComponent rc = new RotateComponent(rotPlane);
//		rotPlane.addComponent(rc);
		DisplayBackGround display2 = new DisplayBackGround(rotPlane);
		display2.setPriority(Priority.BACKGROUND);
		rotPlane.addComponent(display2);
		GameObjectNode rotPlaneNode = new GameObjectNode(rotPlane);
		GameObjectNode charNode = new GameObjectNode(c);
		rotPlaneNode.addChild(charNode);
		backNode.addChild(rotPlaneNode);
		
		Camera cam = new Camera(0,0);
		CameraComponent cc = new CameraComponent(cam);
		cam.addComponent(cc);
		GameObjectNode camNode = new GameObjectNode(cam);
		
		GameObjectGraph graph = new GameObjectGraph(backNode, camNode);
		AddObject(graph);
	}
	
	public synchronized void start() {
		this.running = true;
		new Thread(this).start();
	}
	
	public synchronized void stop() {
		this.running = false;
		new Thread(this).start();
	}
	
	
	public void run() {
		long now = System.nanoTime();
		long lasttime = System.nanoTime();
		long LT = System.nanoTime();
		double nsPL = 1000000000D/ runSpeed;
		
		double delta = 0;
		
		while(this.running) {
//			Frame.requestFocusInWindow();
			tempElements = new ArrayList<GameObject>(elements);
			boolean render = true;
			//Time Management variables
			now = System.nanoTime();
			delta += (now - lasttime) / nsPL;
			lasttime = now;
			
			//Logic set to perform only 60 times per second
			if(delta >= 1) {
				LCount++;
				logic();
				delta -=1;
				render = true;
			}

			//Sleep to limit the number of graphic updates (too much would slow the logic too)
			try {
				Thread.sleep(SleepTime);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(render) {
				FCount++;
				graphic();
			}

			//Graphics update free to use all available resources. 
			if(System.nanoTime() - LT >= 1000000000) {

				LT += 1000000000;
				System.out.println("FPS: " + FCount +" LPS: " + LCount);
				LCount = 0;
				FCount = 0;
			}

			//resets
//			inputs.Reset();
			//GridCollider.reset();
		}


	}
	
	public void logic() {
		for(int i = GameObject.Min; i <= GameObject.Max; i++) {
			for(GameObject j: tempElements)
				j.logic(i);
		}
	}
	
	
	
	
	public void graphic() {

		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
			
		Graphics2D G = (Graphics2D) bs.getDrawGraphics();
		G.clearRect(0, 0, Frame.getWidth(), Frame.getHeight());

		//calling the graphic methods of every element
		for(int i = GameObject.Min; i <= GameObject.Max; i++) {
			for(GameObject j: tempElements)
				j.graphics(i,G);
		}
		
		
		G.dispose();
		bs.show();
	}
	
	public void AddObject(GameObject newObject) {
		elements.add(newObject);
	}
}
