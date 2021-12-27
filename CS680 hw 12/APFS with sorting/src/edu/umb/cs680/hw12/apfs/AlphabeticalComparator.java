package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement>{

	@Override
	public int compare(ApfsElement APFS1, ApfsElement APFS2) {
		return APFS1.getName().toString().compareToIgnoreCase(APFS2.getName().toString());
	}

}
