package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	public void multiply3And4() {
		Calculator cal = new Calculator() ;
		float expected = 12f;
		float actual = cal.multiply(3, 4);
		assertEquals(expected,actual);
	}	
	
	@Test
	public void divide5By4() {
		Calculator cal = new Calculator();
		float expected = 1.25f;
		float actual = cal.divide(5, 4);
		assertEquals(expected,actual);
	}
	
	@Test
	public void divideByZeroTest() {
		Calculator cal = new Calculator();
		try {
			float ans = cal.divide(10,0);
		}
		catch(Exception exp) {
			assertEquals("division by zero",exp.getMessage());
		}
	}

}
