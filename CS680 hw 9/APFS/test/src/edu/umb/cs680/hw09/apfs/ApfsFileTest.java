package edu.umb.cs680.hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsFileTest {
	
	static LocalDateTime localTime = LocalDateTime.now();
	
	private String[] FileToStringArray(ApfsFile d) {
		String[] FileInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString(), 
				d.getParent().getName(), d.getOwnerName(),d.getLastModified().toString()};
		return FileInfo;
	}
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.initFileSystem("root", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "Shivang", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "Shivang", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "Shivang", localTime);
		ApfsDirectory pics = new ApfsDirectory(home, "pics", 0, localTime, "Shivang", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 350, localTime, "Shivang", localTime);
		ApfsFile b = new ApfsFile(home, "b", 700, localTime, "Shivang", localTime);
		ApfsFile c = new ApfsFile(code, "c", 800, localTime, "Shivang", localTime);
		ApfsFile d = new ApfsFile(code, "d", 80, localTime, "Shivang", localTime);
		ApfsFile e = new ApfsFile(pics, "e", 700, localTime, "Shivang", localTime);
		ApfsFile f = new ApfsFile(pics, "f", 870, localTime, "Shivang", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "Shivang", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "Shivang", localTime, a);
	}
	
	@Test
	public void isDirectoryTest() {
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		assertTrue(root.isDirectory());
		assertTrue(root.findDirectoryByName("home").isDirectory());
		assertTrue(root.findDirectoryByName("applications").isDirectory());
		assertTrue(root.findDirectoryByName("code").isDirectory());
		assertTrue(root.findDirectoryByName("applications").isDirectory());
		assertTrue(root.findDirectoryByName("pics").isDirectory());
		assertFalse(root.findFileByName("a").isDirectory());
		assertFalse(root.findFileByName("b").isDirectory());
		assertFalse(root.findFileByName("c").isDirectory());
		assertFalse(root.findFileByName("d").isDirectory());
		assertFalse(root.findFileByName("e").isDirectory());
		assertFalse(root.findFileByName("f").isDirectory());
	}
	
	@Test
	public void verifyApfsFileEqualityA() {
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		String[] expected = {"false", "a", "350", localTime.toString(), "applications", "Shivang", localTime.toString()};
		System.out.println(root.findFileByName("a").getParent().getName());
		ApfsFile actual = root.findFileByName("a");
		assertArrayEquals(expected, FileToStringArray(actual));
	}
	
	@Test
	public void verifyApfsFileEqualityB() {
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		String[] expected = {"false", "b", "700", localTime.toString(), "home", "Shivang", localTime.toString()};
		//System.out.println(root.findFileByName("a").getParent().getName());
		ApfsFile actual = root.findFileByName("b");
		assertArrayEquals(expected, FileToStringArray(actual));
	}
	
	@Test
	public void verifyApfsFileEqualityC() {
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		String[] expected = {"false", "c", "800", localTime.toString(), "code", "Shivang", localTime.toString()};
		//System.out.println(root.findFileByName("a").getParent().getName());
		ApfsFile actual = root.findFileByName("c");
		assertArrayEquals(expected, FileToStringArray(actual));
	}
	
	@Test
	public void verifyApfsFileEqualityD() {
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		String[] expected = {"false", "d", "80", localTime.toString(), "code", "Shivang", localTime.toString()};
		//System.out.println(root.findFileByName("a").getParent().getName());
		ApfsFile actual = root.findFileByName("d");
		assertArrayEquals(expected, FileToStringArray(actual));
	}
	
	@Test
	public void verifyApfsFileEqualityE() {
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		String[] expected = {"false", "e", "700", localTime.toString(), "pics", "Shivang", localTime.toString()};
		//System.out.println(root.findFileByName("a").getParent().getName());
		ApfsFile actual = root.findFileByName("e");
		assertArrayEquals(expected, FileToStringArray(actual));
	}
	
	@Test
	public void verifyApfsFileEqualityF() {
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		String[] expected = {"false", "f", "870", localTime.toString(), "pics", "Shivang", localTime.toString()};
		//System.out.println(root.findFileByName("a").getParent().getName());
		ApfsFile actual = root.findFileByName("f");
		assertArrayEquals(expected, FileToStringArray(actual));
	}
}
