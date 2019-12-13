package engine;

import java.util.ArrayList;

public class BackgroundMusic implements Runnable {

	private static ArrayList<AudioFile> musicFiles;
	private int currSongIndex = 0;
	private boolean running = false;
	private boolean paused;
	
	
	public BackgroundMusic(String...files) {
		musicFiles = new ArrayList<AudioFile>();
		for (String file : files) {
			System.out.println(file);
			musicFiles.add(new AudioFile("Assets/" + file + ".wav"));
		}
	}
	
	
	@Override
	public void run() {
	
		if (running == false) {
			AudioFile song = musicFiles.get(currSongIndex);
			song.play();
			
			running = true;
			currSongIndex = (currSongIndex == 2) ? 0 : currSongIndex + 1;
		} else {
			int prevIndex = (currSongIndex == 0) ? 2 : currSongIndex - 1; 
				
			AudioFile prevSong = musicFiles.get(prevIndex);
			AudioFile currSong = musicFiles.get(currSongIndex);
			
			System.out.println("Right now index is at " + currSongIndex + " and we need to stop " + (currSongIndex - 1));
			prevSong.stop();
			currSong.play();
			currSongIndex = (currSongIndex == 2) ? 0 : currSongIndex + 1;
		}
	}
	
	
	public void pauseSong() {
		AudioFile currSong = musicFiles.get(currSongIndex);
		if (!paused)
			currSong.stop();
		else
			currSong.play(-10);
		paused = !paused;
	}
	
	
	public synchronized void start() {
		this.running = true;
		new Thread(this).start();
	}
	
	
	public synchronized void stop() {
		this.running = false;
		new Thread(this).start();
	}
	
//	public void nextSong() {
//		System.out.println("Trying to play next");
//		currSongIndex++;
//		if (currSongIndex >= musicFiles.size())
//			currSongIndex = 0;
//		song = musicFiles.get(currSongIndex);
//		song.play();
//	}
}

/*public class BackgroundMusic {
	private Clip clip;
	public static BackgroundMusic borat = new BackgroundMusic("src/Assets/borat.wav");
	public static BackgroundMusic curb = new BackgroundMusic("src/Assets/curb.wav");
	
	

	public BackgroundMusic(String fileName) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
			clip = AudioSystem.getClip();
			clip.open(ais);
			System.out.println(clip.isRunning() + " file: " + fileName);
			clip.start();
			System.out.println(clip.isRunning() + " file: " + fileName);
			System.out.println("Clip is opened");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void playBorat() {
//		borat.start();
		borat.play();
	}
	
	public void play() {
		try {
//			System.out.println("IS CLIP ACTIVE?" + isActive());
//			if (clip == null) {
				new Thread() {
					public void run() {
						synchronized (clip) {
							System.out.println("Playing?");
							clip.stop();
							clip.setFramePosition(0);
							clip.start();
						}
					}
				}.start();
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void stop(){
		if(clip == null) return;
		clip.stop();
	}
	
	
	public void loop() {
		try {
			if (clip != null) {
				new Thread() {
					public void run() {
						synchronized (clip) {
							clip.stop();
							clip.setFramePosition(0);
							clip.loop(Clip.LOOP_CONTINUOUSLY);
						}
					}
				}.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean isOpen(){
		return clip.isOpen();
	}
	

}*/
