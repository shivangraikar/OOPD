package edu.umb.cs680.hw12.apfs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw12.fs.FSElement;
import edu.umb.cs680.hw12.fs.FileSystem;

public class APFS extends FileSystem{

	private static LocalDateTime localTime = LocalDateTime.now();
	private static APFS instance = null;
	private APFS() {}
	
	public static APFS getAPFSFileSystem() {
		if(instance == null) {
			instance = new APFS();
		}
		return instance;
	}
	
	
	@Override
	protected FSElement createDefaultRoot() {
		ApfsDirectory root = new ApfsDirectory(null,"root", 0 , localTime, "Shivang", localTime);
		return root;
	}


}
