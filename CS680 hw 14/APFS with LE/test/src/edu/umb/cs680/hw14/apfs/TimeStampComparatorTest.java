package edu.umb.cs680.hw14.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TimeStampComparatorTest {

	static LocalDateTime localTime1 = LocalDateTime.of(2021, 04 , 10, 20, 20);
	static LocalDateTime localTime2 = LocalDateTime.of(2021, 04, 25, 11, 11);
	
	private String[] ApfsEleToString(LinkedList<ApfsElement> l) {
		String[] info = new String[l.size()];
		int i=0;
		for(ApfsElement e: l) {
			info[i] = e.getName();
			//System.out.println(info[i]);
			i++;
		}
        return info;
		
	}
	
	private String[] APFSFileToString(LinkedList<ApfsFile> l) {
		String[] info = new String[l.size()];
		int i=0;
		for(ApfsFile e: l) {
			info[i] = e.getName();
			//System.out.println(info[i]);
			i++;
		}
        return info;
    }
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setUpFileStructure() {
		APFS apfsFileSystem = APFS.getAPFSFileSystem();
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
		ApfsFile g = new ApfsFile(pics, "g", 1, localTime, "Shivang", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "Shivang", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "Shivang", localTime, a);
	}
	
	@Test
	public void FilesInCodeTimeComparatorTest() {
		String[] expected = {"c","d"};
		APFS FileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) FileSystemApfs.getRootDir();
		LinkedList<ApfsFile> l = root.findDirectoryByName("code").getFiles((ApfsElement arg1, ApfsElement arg2)-> arg1.getCreationTime().toString().compareTo(arg2.getCreationTime().toString()));
		assertArrayEquals(expected, APFSFileToString(l));
	}
	
	@Test
	public void FilesInPicsTimeComparatorTest() {
		String[] expected = {"f","e"};
		APFS FileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) FileSystemApfs.getRootDir();
		LinkedList<ApfsFile> l = root.findDirectoryByName("pics").getFiles((ApfsElement arg1, ApfsElement arg2)-> arg1.getCreationTime().toString().compareTo(arg2.getCreationTime().toString()));
		assertArrayEquals(expected, APFSFileToString(l));
	}
	
	@Test
	public void ChildrenHomeTimeComparatorTest() {
		String[] expected = {"code","pics","b","g","x"};
		APFS FileSystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) FileSystemApfs.getRootDir();
		LinkedList<ApfsElement> l = root.findDirectoryByName("home").getChildren((ApfsElement arg1, ApfsElement arg2)-> arg1.getCreationTime().toString().compareTo(arg2.getCreationTime().toString()));
		assertArrayEquals(expected, ApfsEleToString(l));
	}
	
	@Test
	public void RootDirectoryTimeComparatorTest() {
		String[] expected = {"applications","home"};
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		LinkedList<ApfsElement> l = root.findDirectoryByName("root").getChildren((ApfsElement arg1, ApfsElement arg2)-> arg1.getCreationTime().toString().compareTo(arg2.getCreationTime().toString()));
		assertArrayEquals(expected, ApfsEleToString(l));
	}
	
	@Test
	public void FileInHomeDirectoryTimeComparatorTest() {
		String[] expected = {"b","g"};
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		LinkedList<ApfsFile> l = root.findDirectoryByName("home").getFiles((ApfsElement arg1, ApfsElement arg2)-> arg1.getCreationTime().toString().compareTo(arg2.getCreationTime().toString()));
		assertArrayEquals(expected, APFSFileToString(l));
	}


}
