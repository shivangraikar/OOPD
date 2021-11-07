package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	private String[] carToStringArray(Car c) {
		String[] CarInfo = {c.getMake(), c.getModel(), Integer.toString(c.getYear())};
		return CarInfo;
	}
	
	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"BMW", "M5 competition", "2020"};
		Car actual = new Car("BMW", "M5 competition", 2020);
		assertArrayEquals(expected, carToStringArray(actual));
	}
	
	@Test
	public void verifyNotEqualCarWithMakeModelYear() {
		String[] expected = {"BMW", "M5 competition", "2020"};
		Car actual = new Car("Audi", "RS5", 2020);
		assertNotEquals(expected, carToStringArray(actual));
	}

}
