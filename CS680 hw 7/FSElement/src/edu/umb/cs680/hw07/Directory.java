package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{
	
	private LinkedList<FSElement> children;
	private LinkedList<Directory> directory;
	private LinkedList<File> file;
	
	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		if(parent!= null) {
			parent.appendChild(this);
		}
		children = new LinkedList<FSElement>();
	}
	
	public LinkedList<FSElement> getChildren() {
		return this.children;
	}
	
	public void appendChild(FSElement child) {
		this.children.add(child);
	}
	
	public int countChildren() {
		int count=0;
		for(FSElement f: this.children) {
			count+=1;
		}
		return count;
	}
	
	public LinkedList<Directory> getSubDirectory(){
		for(FSElement s: getChildren()) {
			if(s instanceof Directory) {
				directory.add((Directory) s);
			}
		}
		return directory;
	}
	
	public LinkedList<File> getFiles(){
		for(FSElement s: getChildren()) {
			if(s instanceof File) {
				file.add((File) s);
			}
		}
		return file;
	}
	
	public int getTotalSize() {
		int totalSize=0;
		for(FSElement f: getChildren()) {
			if(f instanceof Directory) {
				totalSize+= ((Directory)f).getTotalSize();
			}
			else {
				totalSize+= f.getSize();
			}
		}
		return totalSize;
	}
	
	

	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		if(this instanceof Directory) {
			return true;
		}
		return false;
	}
	
	
}
