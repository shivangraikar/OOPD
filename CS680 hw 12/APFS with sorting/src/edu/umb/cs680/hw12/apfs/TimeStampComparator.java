package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<ApfsElement>{

	@Override
	public int compare(ApfsElement o1, ApfsElement o2) {
		return o1.getCreationTime().toString().compareTo(o2.getCreationTime().toString());
	}

}
