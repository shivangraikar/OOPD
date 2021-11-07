package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DrawerClosedNotPlayingTest {

	private DrawerClosedNotPlaying drawerClosedNotPlaying = DrawerClosedNotPlaying.getInstance();
	ByteArrayOutputStream outVariable = new  ByteArrayOutputStream();
	
	@BeforeEach
	public void setStreams() {
		System.setOut(new PrintStream(outVariable));
	}
	
	@Test
	public void OpenCloseButtonPushedTest() {
		drawerClosedNotPlaying.openCloseButtonPushed();
		assertEquals(outVariable.toString().replaceAll("\\s+", ""), "Draweropenmethodinvoked");
	}
	
	@Test
	public void playButtonPushedTest() {
		drawerClosedNotPlaying.playButtonPushed();
		assertEquals(outVariable.toString().replaceAll("\\s+", ""), "Playmethodinvoked");
	}
	
	@Test
	public void stopButtonPushedTest() {
		drawerClosedNotPlaying.stopButtonPushed();
		assertEquals(outVariable.toString().replaceAll("\\s+", ""), "Alreadynothingisplaying");
	}
	
}
