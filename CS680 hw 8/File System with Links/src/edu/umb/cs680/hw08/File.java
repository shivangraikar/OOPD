package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class File extends FSElement{

	public File(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		parent.appendChild(this);
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

}