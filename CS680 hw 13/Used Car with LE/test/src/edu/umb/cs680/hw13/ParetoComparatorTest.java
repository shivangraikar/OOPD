package edu.umb.cs680.hw13;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ParetoComparatorTest {
	
	private static LinkedList<Car> cars = new LinkedList<Car>();
	
	
	@BeforeAll
	private static void setUpOfCars() {
		
		Car c1 = new Car("M5", "BMW", 2016, 18000, 2000);
		cars.add(c1);
		Car c2 = new Car("RSQ8", "Audi", 2020, 25000, 5000);
		cars.add(c2);
		Car c3 = new Car("RAV-4", "Toyota", 2014, 10000, 8000);
		cars.add(c3);
		Car c4 = new Car("Tacoma", "Toyota", 2012, 4000, 6000);
		cars.add(c4);
		for(int i=0;i<4;i++) {
			cars.get(i).setDominationCount(i);
		}
		Collections.sort(cars,(Car C1, Car C2) -> (int)C1.getDominationCount()-(int)C2.getDominationCount());
	}
	
	@Test
	public void testForFirstCar() {
		assertEquals(0, cars.get(0).getDominationCount());
	}
	
	@Test
	public void testForSecondCar() {
		assertEquals(1, cars.get(1).getDominationCount());
	}
	
	@Test
	public void testForthirdCar() {
		
		assertEquals(2, cars.get(2).getDominationCount());
	}
	
	@Test
	public void testForFourthCar() {
		
		assertEquals(3, cars.get(3).getDominationCount());
	}
	
}
