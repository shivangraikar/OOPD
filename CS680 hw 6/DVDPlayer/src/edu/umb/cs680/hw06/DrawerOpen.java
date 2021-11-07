package edu.umb.cs680.hw06;

public class DrawerOpen implements State{
	
	
	private static DrawerOpen drawerOpen = null;
	
	public static DrawerOpen getInstance() {
		if (drawerOpen == null) {
			drawerOpen = new DrawerOpen();
		}
		return drawerOpen;
	}
	
	private DVDPlayer player;
	private DrawerOpen() {
		player = player.getInstance();
	}
	
	

	@Override
	public void openCloseButtonPushed() {
		// TODO Auto-generated method stub
		
		player.close();
		player.changeState(DrawerClosedNotPlaying.getInstance());
		
	}

	@Override
	public void playButtonPushed() {
		// TODO Auto-generated method stub
		
		player.close();
		player.play();
		player.changeState(DrawerClosedPlaying.getInstance());
	}

	@Override
	public void stopButtonPushed() {
		// TODO Auto-generated method stub
		System.out.println("Empty Method");
	}
	
	
	
}
