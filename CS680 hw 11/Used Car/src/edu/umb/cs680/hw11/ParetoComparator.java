package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Comparator;

public class ParetoComparator implements Comparator<Car>{
	
	public ParetoComparator(ArrayList<Car> cars) {
		for(Car c: cars){
		 c.setCarList(cars);
		}
	}
	@Override
	public int compare(Car o1, Car o2) {
		o1.dominationCount();
		o2.dominationCount();
		return o2.getDominationCount() - o1.getDominationCount();
	}
		
}
