package edu.umb.cs680.hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsCountingVisitorTest {
	
	static LocalDateTime localTime = LocalDateTime.now();
	
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
	public void checkNumberOfFilesCode() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.findDirectoryByName("code").accept(visitor);
		int expected = 2;
		int actual = visitor.getFileCount();
		assertSame(expected, actual);
	}
	
	@Test
	public void checkNumberOfFilesPics() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.findDirectoryByName("pics").accept(visitor);
		int expected = 2;
		int actual = visitor.getFileCount();
		assertSame(expected, actual);
	}
	
	@Test
	public void checkNumberOfFilesApplicaions() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.findDirectoryByName("applications").accept(visitor);
		int expected = 1;
		int actual = visitor.getFileCount();
		assertSame(expected, actual);
	}
	
	@Test
	public void checkNumberOfFilesHome() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.findDirectoryByName("home").accept(visitor);
		int expected = 5;
		int actual = visitor.getFileCount();
		assertSame(expected, actual);
	}
	
	@Test
	public void checkNmberOfLinksHome() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.findDirectoryByName("home").accept(visitor);
		int expected = 2;
		int actual = visitor.getLinkCount();
		assertSame(expected, actual);
	}
	
	@Test
	public void checkNmberOfLinksCode() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.findDirectoryByName("code").accept(visitor);
		int expected = 1;
		int actual = visitor.getLinkCount();
		assertSame(expected, actual);
	}
	
	@Test
	public void checkNmberOfDirectoriesCode() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.findDirectoryByName("code").accept(visitor);
		int expected = 1;
		int actual = visitor.getDirCount();
		assertSame(expected, actual);
	}
	
	@Test
	public void checkNmberOfDirectoriesPics() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.findDirectoryByName("pics").accept(visitor);
		int expected = 1;
		int actual = visitor.getDirCount();
		assertSame(expected, actual);
	}
	
	@Test
	public void checkNmberOfDirectoriesHome() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.findDirectoryByName("home").accept(visitor);
		int expected = 3;
		int actual = visitor.getDirCount();
		assertSame(expected, actual);
	}
	
	@Test
	public void checkNmberOfDirectoriesApplications() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.findDirectoryByName("applications").accept(visitor);
		int expected = 1;
		int actual = visitor.getDirCount();
		assertSame(expected, actual);
	}
	
	@Test
	public void checkNmberOfDirectoriesRoot() {
		APFS fileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) fileSystemApfs.getRootDir();
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.findDirectoryByName("root").accept(visitor);
		int expected = 5;
		int actual = visitor.getDirCount();
		assertSame(expected, actual);
	}
}
