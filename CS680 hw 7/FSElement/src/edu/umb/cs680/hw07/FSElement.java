package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public abstract class FSElement {
	
	protected String pname;
	protected int size;
	protected LocalDateTime creationTime;
	protected Directory parent;
	
	public FSElement(Directory parent, String name, int size, LocalDateTime creationTime){	
		this.parent = parent;
		this.pname = name;
		this.size = size;  
		this.creationTime = creationTime;
	}
	
	public Directory getParent() {
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
