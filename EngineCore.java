package engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class EngineCore extends Canvas implements Runnable{
	public int Width,
		       Height,
		       Scale;
	public String Name;
	public JFrame Frame;
	public Boolean running;
	
	private int SleepTime = 0;
	
	public ArrayList<GameObject> elements,tempElements;
	
	private BufferedImage BackGround;
	private int[] pixels;
	
	public static int FCount = 0;
	public static int LCount = 0;
	
	private String path;
	
	public static int runSpeed = 60;
	public static AssetsCenter assets;
	//public static InputHandler inputs;
	
	public EngineCore(int Size,int Ratio, int Scale, String Name, String path){
	
	
	//initiation the variables
		this.Height = Size;
		this.Width = Size * Ratio;
		this.Scale = Scale;
		this.Name = Name;
		this.path = path;
		this.Frame = new JFrame(Name);
		
		// Starting the data collection/storage systems
		//inputs = new InputHandler(Frame);
		assets = new AssetsCenter(this.path);
		ArrayList<BufferedImage> list = assets.getImageList("empt.png");
		elements = new ArrayList<GameObject>();
		
		
		// Hard-coding the sky-box (not the best thing to do)
		this.BackGround = new BufferedImage (this.Width,this.Height,BufferedImage.TYPE_INT_RGB);
		this.pixels = ((DataBufferInt)BackGround.getRaster().getDataBuffer()).getData();
		
		// Setting up the canvas 
		setMinimumSize(new Dimension(this.Width*this.Scale, this.Height * this.Scale));
		setMaximumSize(new Dimension(this.Width*this.Scale, this.Height * this.Scale));
		setPreferredSize(new Dimension(this.Width*this.Scale, this.Height * this.Scale));
		
		this.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.Frame.setLayout(new BorderLayout());
		
		this.Frame.add(this, BorderLayout.CENTER);
		//Frame.getContentPane().add(new JLabel(new ImageIcon(list.get(0))));
		this.Frame.pack();
		
		this.Frame.setResizable(true);
		this.Frame.setLocationRelativeTo(null);
		this.Frame.setVisible(true);
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
		
		
		BufferedImage img = (BufferedImage) assets.getImage("empt.png", 0);
		BackGround back = new BackGround(img);
		DisplayBackGround display = new DisplayBackGround(back);
		display.setPriority(Priority.BACKGROUND);
		back.addComponent(display);
		Tear t = new Tear(400, 400, Direction.NORTH, (BufferedImage)assets.getImage("boiS.png", 38));
		TearMovement t2 = new TearMovement(t);
		t2.setPriority(Priority.TEAR_NORTH);
		t.addComponent(t2);
		AddObject(back);
		AddObject(t);
		
		while(this.running) {
			Frame.requestFocusInWindow();
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
			//inputs.Reset();
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
		//G.setBackground(Color.LIGHT_GRAY);
		//G.clearRect(0, 0, this.Width*10, this.Height*10);
		//Background color (in most cases you will have an element background, which draws a picture instead)
		//G.setColor(Color.decode("#33FFFF"));
		//G.fillRect(0, 0, 500, 500);
		//BufferedImage img = (BufferedImage) assets.getImage("empt.png", 0);
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
