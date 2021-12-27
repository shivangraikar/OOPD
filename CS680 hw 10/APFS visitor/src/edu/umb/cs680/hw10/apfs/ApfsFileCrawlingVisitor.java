package edu.umb.cs680.hw10.apfs;

import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsVisitor{

	private LinkedList<ApfsFile> files =  new LinkedList<ApfsFile>();
	
	@Override
	public void visit(ApfsLink link) {
		return;
	}

	@Override
	public void visit(ApfsDirectory dir) {
		return;
	}

	@Override
	public void visit(ApfsFile file) {
		this.files.add(file);
	}
	
	public LinkedList<ApfsFile> getFiles() {
		return this.files;
	}

}
