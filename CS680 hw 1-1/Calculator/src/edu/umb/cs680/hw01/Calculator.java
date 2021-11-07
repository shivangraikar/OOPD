package edu.umb.cs680.hw01;

public class Calculator {

	public float multiply(float x, float y){

		float mul =  x * y;
		return mul;

	}

	public float divide (float x, float y) {
		if(y==0){
			throw new IllegalArgumentException("Division by zero");
		}
		return x/y;
	}
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println(calc.multiply(5, 3));
		System.out.println(calc.divide(10, 2));
	}
}
