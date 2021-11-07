package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem {
	
	private FileSystem() {};
	private static FileSystem fileSystem = null;
	
	public static FileSystem getFileSystem() {
		if(fileSystem == null) {
			fileSystem = new FileSystem();
		}
		return fileSystem;
	} 
	
	LinkedList<Directory> directory =new LinkedList<Directory>();
	
	public LinkedList<Directory> getRootDir(){
		return this.directory;
	}
	
	public void addRootDir(Directory root) {
		directory.add(root);
	}
}
