package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {
		
	@Test
	public void PrimeTest() {
		PrimeGenerator g = new PrimeGenerator(1,10);
		g.generatePrimes();
		Long[] expectedValues = {2L,3L,5L,7L};
		assertArrayEquals(expectedValues, g.getPrimes().toArray());
	}
	
	@Test
	public void PrimeTestTwo() {
		PrimeGenerator g = new PrimeGenerator(10,30);
		g.generatePrimes();
		Long[] expectedValues = {11L,13L,17L,19L,23L,29L};
		assertArrayEquals(expectedValues, g.getPrimes().toArray());
	}

	@Test
	public void NegativeTest() {
		try {
			PrimeGenerator g = new PrimeGenerator(-15,4);
		}
		catch(Exception exp){
			assertEquals("Wrong input values: from=-15 to=4" ,exp.getMessage());
		}
	}
}
