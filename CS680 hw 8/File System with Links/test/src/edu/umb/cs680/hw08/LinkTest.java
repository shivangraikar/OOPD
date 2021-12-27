package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class LinkTest {
	
static LocalDateTime localTime = LocalDateTime.now();
	
	
	Directory root = new Directory(null,"root",0, localTime);
	Directory applications = new Directory(root,"applications",0, localTime);
	Directory home = new Directory(root,"home",0, localTime);
	Directory code = new Directory(home,"code",0, localTime);
	Directory pics = new Directory(home,"pics",0, localTime);
		
	File a = new File(applications,"a",1,localTime);
	File b = new File(home,"b",1,localTime);
	File c = new File(code,"c",1,localTime);
	File d = new File(code,"d",1,localTime);
	File e = new File(pics,"e",1,localTime);
	File f = new File(pics,"f",1,localTime);
	
	Link x = new Link(home, "x", 0, localTime, applications);
	Link y = new Link(code, "y", 0, localTime, a);
	
	private String[] LinkToStringArray(Link l) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(l.getParent());
		String[] linkInfo = {Boolean.toString(l.isDirectory()), l.getName(), Integer.toString(l.getSize()), l.getCreationTime().toString(), l.getTarget().getName()};
		return linkInfo;
	}
	
	@Test
	public void verifyLinksTest() {
		assertFalse(x.isDirectory());
		assertFalse(y.isDirectory());
	}
	
	@Test
	public void verifyTargetEqualityY() {
		String[] expected={"false","y","0",localTime.toString(),"a"};
		assertArrayEquals(expected,LinkToStringArray(y));
	}
	
	@Test
	public void verifyTargetEqualityX() {
		String[] expected={"false","x","0",localTime.toString(),"applications"};
		assertArrayEquals(expected,LinkToStringArray(x));
	}
	
	@Test
	public void verifyParentOfTarget() {
		assertSame("root", x.getTarget().getParent().getName());
		assertSame("applications", y.getTarget().getParent().getName());
	}
	
}
