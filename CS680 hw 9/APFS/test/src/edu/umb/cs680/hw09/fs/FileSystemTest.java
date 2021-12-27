package edu.umb.cs680.hw09.fs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

class FileSystemTest {
	static LocalDateTime localTime = LocalDateTime.now();
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.initFileSystem("drive", 3500);
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
	public void testforrootinstance() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		assertSame(root.getOwnerName(), "Shivang");
	}
	
	private String[] dirToStringArray(ApfsDirectory dir) {
		Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(dir.getParent());
		String[] infofordirectory = { Boolean.toString(dir.isDirectory()), dir.getName(), Integer.toString(dir.getSize()),  
				optionalDirectory.isPresent()?dir.getParent().getName():null, Integer.toString(dir.getTotalSize()),
						Integer.toString(dir.CountChildren()),dir.getOwnerName()};
		return infofordirectory;
	}
	
	@Test
	public void RootCheck() {
		APFS FileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FileSystemApfs.getRootDir();
		String[] expected = { "true", "root", "0", null, "3500", "2", "Shivang"};
		System.out.println(root.findDirectoryByName("root"));
		ApfsDirectory actual = root.findDirectoryByName("root");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	

}
