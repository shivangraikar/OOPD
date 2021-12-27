package edu.umb.cs680.hw11;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {		
		return o2.getMileage()-o1.getMileage();
	}

}
