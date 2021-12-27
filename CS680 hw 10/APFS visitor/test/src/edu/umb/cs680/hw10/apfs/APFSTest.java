package edu.umb.cs680.hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class APFSTest {

	static LocalDateTime localTime = LocalDateTime.now();
	
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		FilesystemofApfs.initFileSystem("root", 3500);
	}
	
	
	@Test
	public void verifyInstanceEquality() {
		APFS apfs1 = APFS.getAPFSFileSystem();
		APFS apfs2 = APFS.getAPFSFileSystem();
		assertEquals(apfs1,apfs2);
	}
	
	@Test
	public void capacityTest() {
		int expected = 3500;
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		FilesystemofApfs.initFileSystem("root", 3500);
		int actual = FilesystemofApfs.getCapacity();
		assertEquals(expected, actual);
	}

}
