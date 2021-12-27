package edu.umb.cs680.hw10.apfs;

public class ApfsCountingVisitor implements ApfsVisitor{
	
	private int dirNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;
	
	@Override
	public void visit(ApfsLink link) {
		linkNum++;
	}

	@Override
	public void visit(ApfsDirectory dir) {
		dirNum++;
	}

	@Override
	public void visit(ApfsFile file) {
		fileNum++;
	}
	
	public int getFileCount() {
		return fileNum;
	}
	
	public int getLinkCount() {
		return linkNum;
	}
	
	public int getDirCount() {
		return dirNum;
	}
	
}
