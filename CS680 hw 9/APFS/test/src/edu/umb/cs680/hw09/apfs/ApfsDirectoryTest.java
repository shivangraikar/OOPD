package edu.umb.cs680.hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsDirectoryTest {

	static LocalDateTime localTime = LocalDateTime.now();
	
	private String[] dirToStringArray(ApfsDirectory d) {
		Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(d.getParent());
		String[] dirInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString(), 
				optionalDirectory.isPresent()?d.getParent().getName():null, Integer.toString(d.getTotalSize()), Integer.toString(d.CountChildren()), d.getOwnerName(),d.getLastModified().toString()};
		return dirInfo;
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
	public void verifyApfsDirectoryEqualityHome() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		String[] expected = {"true", "home", "0", localTime.toString(), "root", "3150", "4", "Shivang", localTime.toString()};
		ApfsDirectory actual = root.findDirectoryByName("home");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	public void verifyApfsDirectoryEqualityApplications() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		String[] expected = {"true", "applications", "0", localTime.toString(), "root", "350", "1", "Shivang", localTime.toString()};
		ApfsDirectory actual = root.findDirectoryByName("applications");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	public void verifyApfsDirectoryEqualityCode() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		String[] expected = {"true", "code", "0", localTime.toString(), "home", "880", "3", "Shivang", localTime.toString()};
		ApfsDirectory actual = root.findDirectoryByName("code");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	public void verifyApfsDirectoryEqualityPics() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		String[] expected = {"true", "pics", "0", localTime.toString(), "home", "1570", "2", "Shivang", localTime.toString()};
		ApfsDirectory actual = root.findDirectoryByName("pics");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	public void checkNamesOfFilesAndDirectories() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		assertSame("home", root.findDirectoryByName("home").getName());
		assertSame("applications", root.findDirectoryByName("applications").getName());
		assertSame("code", root.findDirectoryByName("code").getName());
		assertSame("pics", root.findDirectoryByName("pics").getName());
		assertSame("a", root.findFileByName("a").getName());
		assertSame("b", root.findFileByName("b").getName());
		assertSame("c", root.findFileByName("c").getName());
		assertSame("d", root.findFileByName("d").getName());
		assertSame("e", root.findFileByName("e").getName());
		assertSame("f", root.findFileByName("f").getName());
	}
	
	@Test
	public void FileNamesInSubdirectoriesTest() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		assertSame("a", root.findDirectoryByName("applications").getFiles().get(0).getName());
		assertSame("b", root.findDirectoryByName("home").getFiles().get(0).getName());
		assertSame("c", root.findDirectoryByName("code").getFiles().get(0).getName());
		assertSame("d", root.findDirectoryByName("code").getFiles().get(1).getName());
		assertSame("e", root.findDirectoryByName("pics").getFiles().get(0).getName());
		assertSame("f", root.findDirectoryByName("pics").getFiles().get(1).getName());
	}
	
	@Test
	void SubDirectoriesTest() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)fileSystemApfs.getRootDir();
		assertSame("applications", root.findDirectoryByName("root").getSubDirectory().get(0).getName());
		assertSame("home", root.findDirectoryByName("root").getSubDirectory().get(1).getName());
		assertSame("code", root.findDirectoryByName("home").getSubDirectory().get(0).getName());
		assertSame("pics", root.findDirectoryByName("home").getSubDirectory().get(1).getName());
	}
	
	
}
