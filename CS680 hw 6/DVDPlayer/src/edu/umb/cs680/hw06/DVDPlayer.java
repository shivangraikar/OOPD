package edu.umb.cs680.hw06;

public class DVDPlayer {
	
	private static DVDPlayer dvdPlayer=null;
	private static State state;
	
	private DVDPlayer() {}
	
	public static DVDPlayer getInstance() {
		if(dvdPlayer == null) {
			dvdPlayer = new DVDPlayer();
		}
		return dvdPlayer;
	}
	
	public void changeState(State state) {
		DVDPlayer.state = state; 
	}
	
	public void openCLoseButtonPushed() {
		state.openCloseButtonPushed();
	}
	
	public void playButtonPushed() {
		state.playButtonPushed();
	}
	
	public void stopButtonPushed() {
		state.stopButtonPushed();
	}
	
	public void open() {
		System.out.println("Drawer open method invoked");
	}
	
	public void close() {
		System.out.println("Drawer close method invoked");
		
	}
	
	public void play() {
		System.out.println("Play method invoked");
	}
	
	public void stop() {
		System.out.println("Stop method invoked");
	}
	
}
