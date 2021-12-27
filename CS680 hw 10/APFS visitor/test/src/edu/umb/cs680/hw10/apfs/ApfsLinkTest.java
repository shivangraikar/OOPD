package edu.umb.cs680.hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsLinkTest {
	
static LocalDateTime localTime = LocalDateTime.now();
	
	private String[] LinkToStringArray(ApfsLink d) {
		String[] LinkInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString(), 
				d.getParent().getName(), d.getOwnerName(),d.getLastModified().toString(), d.getTarget().getName()};
		return LinkInfo;
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
	public void verifyLinkEqualityX() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		String[] expected = {"false", "x", "0", localTime.toString(), "home", "Shivang", localTime.toString(), "applications"};
		ApfsLink actual = root.findLinkByName("x");
		assertArrayEquals(expected, LinkToStringArray(actual));
	}
	
	@Test
	public void verifyLinkEqualityY() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		String[] expected = {"false", "y", "0", localTime.toString(), "code", "Shivang", localTime.toString(), "a"};
		ApfsLink actual = root.findLinkByName("y");
		assertArrayEquals(expected, LinkToStringArray(actual));
	}
	
	@Test
	public void checkSizeOfTarget() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		assertEquals(0, root.findLinkByName("x").getTarget().getSize());
		assertEquals(350, root.findLinkByName("y").getTarget().getSize());
	}
	
	@Test
	public void checkParentOfTarget() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		assertEquals("root", root.findLinkByName("x").getTarget().getParent().getName());
		assertEquals("applications", root.findLinkByName("y").getTarget().getParent().getName());
	}
}
