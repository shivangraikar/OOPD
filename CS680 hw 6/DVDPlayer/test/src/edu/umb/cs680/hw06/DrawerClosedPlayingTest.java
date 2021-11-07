package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DrawerClosedPlayingTest {

	private DrawerClosedPlaying drawerClosedPlaying = DrawerClosedPlaying.getInstance();
	ByteArrayOutputStream outVariable = new  ByteArrayOutputStream();
	
	@BeforeEach
	public void setStreams() {
		System.setOut(new PrintStream(outVariable));
	}
	
	@Test
	public void OpenCloseButtonPushedTest() {
		drawerClosedPlaying.openCloseButtonPushed();
		assertEquals(outVariable.toString().replaceAll("\\s+", ""), "StopmethodinvokedDraweropenmethodinvoked");
	}
	
	@Test
	public void playButtonPushedTest() {
		drawerClosedPlaying.playButtonPushed();
		assertEquals(outVariable.toString().replaceAll("\\s+", ""), "Playingcontent");
	}
	
	@Test
	public void stopButtonPushedTest() {
		drawerClosedPlaying.stopButtonPushed();
		assertEquals(outVariable.toString().replaceAll("\\s+", ""), "Stopmethodinvoked");
	}
}
