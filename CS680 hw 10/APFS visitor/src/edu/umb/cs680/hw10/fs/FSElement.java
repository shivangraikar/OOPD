package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw10.apfs.ApfsDirectory;

public abstract class FSElement {
	protected String pname;
	protected int size;
	protected LocalDateTime creationTime;
	protected ApfsDirectory parent;
	
	public FSElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime){	
		this.parent = parent;
		this.pname = name;
		this.size = size;  
		this.creationTime = creationTime;
	}
	
	public ApfsDirectory getParent() {
		return this.parent;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public LocalDateTime getCreationTime() {
		return this.creationTime;
	}
		
	public String getName() {
		return this.pname;
	}
	
	public abstract boolean isDirectory();
}


