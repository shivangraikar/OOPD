package edu.umb.cs680.hw10.apfs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw10.fs.FSElement;

public abstract class ApfsElement extends FSElement{
	protected String OwnerName;
	protected LocalDateTime lastModified;
	
	ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String OwnerName, LocalDateTime LD){
		super(parent, name, size, creationTime);
		this.OwnerName = OwnerName;
		this.lastModified = LD;
	}
	
	public String getOwnerName() {
		return this.OwnerName;
	}
	
	public LocalDateTime getLastModified() {
		return this.lastModified;
	}
	
	public abstract void accept(ApfsVisitor v);
	public abstract boolean isDirectory();
}
