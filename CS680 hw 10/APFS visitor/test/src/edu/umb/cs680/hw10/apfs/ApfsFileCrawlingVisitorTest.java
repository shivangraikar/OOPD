package edu.umb.cs680.hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsFileCrawlingVisitorTest {
		
	static LocalDateTime localTime = LocalDateTime.now();
	
	private String[] fileListToString(LinkedList<ApfsFile> files) {
		String[] fileInfo= new String[files.size()];
		int i=0;
		for(ApfsFile f: files) {
			fileInfo[i] = f.getName();
			//System.out.println(fileInfo[i]);
			i++;
		}
		return fileInfo;
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
	void fileEqualityCheckCode() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory pictures = root.findDirectoryByName("code");
		pictures.accept(visitor);
		String[] expected = {"c","d"};
		LinkedList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,fileListToString(actual));
	}
	
	@Test
	void fileEqualityCheckPics() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory pictures = root.findDirectoryByName("pics");
		pictures.accept(visitor);
		String[] expected = {"e","f"};
		LinkedList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,fileListToString(actual));
	}
	
	@Test
	void fileEqualityCheckApplications() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory pictures = root.findDirectoryByName("applications");
		pictures.accept(visitor);
		String[] expected = {"a"};
		LinkedList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,fileListToString(actual));
	}
	
	@Test
	void fileEqualityCheckHome() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory pictures = root.findDirectoryByName("home");
		pictures.accept(visitor);
		String[] expected = {"c","d","e","f","b"};
		LinkedList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,fileListToString(actual));
	}
	
	@Test
	void fileEqualityCheckRoot() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory pictures = root.findDirectoryByName("root");
		pictures.accept(visitor);
		String[] expected = {"a","c","d","e","f","b"};
		LinkedList<ApfsFile> actual= visitor.getFiles();
		for(ApfsFile f: actual) {
			System.out.println(f.getName());
		}
		assertArrayEquals(expected,fileListToString(actual));
	}
}
