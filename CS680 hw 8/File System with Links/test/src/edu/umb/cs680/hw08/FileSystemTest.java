package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class FileSystemTest {

static LocalDateTime localTime = LocalDateTime.now();
	
	private String[] StringArrayForDirectory(Directory d) {
		String Info[] = {null, d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString()};
		return Info;
	}
	
	@Test
	public void checkSingletonFileSystem() {
		FileSystem FS1 = FileSystem.getFileSystem();
		FileSystem FS2 = FileSystem.getFileSystem();
		assertEquals(FS1,FS2);
	}
	
	@Test
	public void checkRootDir() {
		Directory root = new Directory(null, "root", 0, localTime);
		String expected[] = {null, "root", "0", localTime.toString()};
		FileSystem.getFileSystem().addRootDir(root);
		Directory actual = FileSystem.getFileSystem().getRootDir().get(0);
		assertArrayEquals(expected, StringArrayForDirectory(actual));
	}

}
