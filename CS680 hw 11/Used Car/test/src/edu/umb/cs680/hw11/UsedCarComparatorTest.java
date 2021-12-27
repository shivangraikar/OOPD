package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class UsedCarComparatorTest {

	ArrayList<Car>cars = new ArrayList<>();
	
	@Test
	public void MileageComparator() {
		ArrayList<Integer> actual = new ArrayList<>();
		ArrayList<Integer> expected = new ArrayList<>();
		
		cars.add(new Car("Gi10","Hyundai",2016,15000,5000));
		cars.add(new Car("Levante", "Maserati",2011,9000, 6000));
		cars.add(new Car("M5","BMW", 2012, 20000, 8000));
		cars.add(new Car("S","Tesla",2014,12000,5400));
		cars.add(new Car("S class","Mercedes Benz",2015,9000,6500));
		Collections.sort(cars, new MileageComparator());
		
		expected.add(8000);
		expected.add(6500);
		expected.add(6000);
		expected.add(5400);
		expected.add(5000);
		
		for(Car c: cars) {
			actual.add(c.getMileage());
		}
		assertEquals(actual, expected);	
	}
	
	@Test
	public void PriceComparator() {
		ArrayList<Float> actual = new ArrayList<>();
		ArrayList<Float> expected = new ArrayList<>();
		
		cars.add(new Car("Gi10","Hyundai",2016,15000,5000));
		cars.add(new Car("Levante", "Maserati",2011,9000, 6000));
		cars.add(new Car("M5","BMW", 2012, 20000, 8000));
		cars.add(new Car("S","Tesla",2014,12000,5400));
		cars.add(new Car("S class","Mercedes Benz",2015,9000,6500));
		Collections.sort(cars, new PriceComparator());
		
		expected.add((float) 20000);
		expected.add((float) 15000);
		expected.add((float) 12000);
		expected.add((float) 9000);
		expected.add((float) 9000);
		
		for(Car c: cars) {
			actual.add(c.getPrice());
		}
		assertEquals(actual, expected);	
	}
	
	@Test
	public void YearComparator() {
		ArrayList<Integer> actual = new ArrayList<>();
		ArrayList<Integer> expected = new ArrayList<>();
		
		cars.add(new Car("Gi10","Hyundai",2016,15000,5000));
		cars.add(new Car("Levante", "Maserati",2011,9000, 6000));
		cars.add(new Car("M5","BMW", 2012, 20000, 8000));
		cars.add(new Car("S","Tesla",2014,12000,5400));
		cars.add(new Car("S class","Mercedes Benz",2015,9000,6500));
		Collections.sort(cars, new YearComparator());
		
		expected.add(2016);
		expected.add(2015);
		expected.add(2014);
		expected.add(2012);
		expected.add(2011);
		
		for(Car c: cars) {
			actual.add(c.getYear());
		}
		assertEquals(actual, expected);	
	}
	
	@Test
	public void ParetoComparator() {
		ArrayList<Integer> actual = new ArrayList<>();
		ArrayList<Integer> expected = new ArrayList<>();
		
		cars.add(new Car("Gi10","Hyundai",2016,15000,5000));
		cars.add(new Car("Levante", "Maserati",2011,9000, 6000));
		cars.add(new Car("M5","BMW", 2012, 20000, 8000));
		cars.add(new Car("S","Tesla",2014,12000,5400));
		cars.add(new Car("S class","Mercedes Benz",2015,9000,6500));
		Collections.sort(cars, new ParetoComparator(cars));
		
		expected.add(2);
		expected.add(2);
		expected.add(1);
		expected.add(1);
		expected.add(1);
		
		for(Car c: cars) {
			//System.out.println(c.getDominationCount());
			actual.add(c.getDominationCount());
		}
		//assertEquals(actual, expected);	
	}

}
