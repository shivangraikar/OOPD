package edu.umb.cs680.hw10.apfs;

import java.util.LinkedList;

public class ApfsFileSearchVisitor implements ApfsVisitor{

	private String fileName;
	private LinkedList<ApfsFile> foundFiles = new LinkedList<>();
	
	public void setFileName(String name) {
		this.fileName = name;
	}
	
	public String getName() {
		return this.fileName;
	}
	
	public LinkedList<ApfsFile> getFoundFiles() {
		return this.foundFiles;
	}
	
	@Override
	public void visit(ApfsLink link) {
		return ;
	}

	@Override
	public void visit(ApfsDirectory dir) {
		return;
	}

	@Override
	public void visit(ApfsFile file) {
		if(fileName.equals(file.getName())) {
			foundFiles.add(file);
		}
	}

}
