package edu.umb.cs680.hw10.apfs;

public interface ApfsVisitor {
	
	public void visit(ApfsLink link) ;
	public void visit(ApfsDirectory dir);
	public void visit(ApfsFile file);
	
}
