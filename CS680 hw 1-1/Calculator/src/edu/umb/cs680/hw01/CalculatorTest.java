package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	public void multiply3By4() {
		Calculator cut = new Calculator();
		float exp = 12;
		float act = cut.multiply(3,4);
		assertTrue(cut instanceof Calculator);
		assertEquals(exp, act);
	}
	@Test
	public void divide5By2(){
		Calculator cut = new Calculator();
		float expected = 2.5f;
		float actual = cut.divide(5,2);
		assertEquals(expected, actual);
	}
	@Test
	public void divide5By0withTryCatch(){
		Calculator cut = new Calculator();
		try{
			cut.divide(5, 0);
			fail("Division by zero");
		}
		catch(IllegalArgumentException ex){
			assertEquals("Division by zero", ex.getMessage());
		}
	}
}
