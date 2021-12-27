package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PriceComparatorTest {

	private static LinkedList<Car> cars = new LinkedList<Car>();
	
	private String[] CarToString(Car c) {
		String[] info = {c.getModel(), c.getMake(), Integer.toString(c.getYear()) , Float.toString(c.getPrice()), Integer.toString(c.getMileage())};
		return info;
	}
	
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
		Collections.sort(cars,(Car C1, Car C2) -> (int)C1.getPrice()-(int)C2.getPrice());
	}
	
	@Test
	public void testForFirstCar() {
		String[] expected = {"Tacoma", "Toyota", "2012", "4000.0", "6000"};
		String[] actual = CarToString(cars.get(0));
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testForSecondCar() {
		String[] expected = {"RAV-4", "Toyota", "2014", "10000.0", "8000"};
		String[] actual = CarToString(cars.get(1));
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testForThirdCar() {
		String[] expected = {"M5", "BMW", "2016", "18000.0", "2000"};
		String[] actual = CarToString(cars.get(2));
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testForFourthCar() {
		String[] expected = {"M5", "BMW", "2016", "18000.0", "2000"};
		String[] actual = CarToString(cars.get(2));
		assertArrayEquals(expected, actual);
	}
}
