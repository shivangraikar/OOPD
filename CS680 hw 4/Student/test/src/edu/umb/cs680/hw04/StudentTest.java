package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	private String[] InStateStudentToArray(Student student) {
		String[] studentData = {student.getName(), student.getUSAddr(), Integer.toString(student.getYrsInState())};
		return studentData;
	}
	
	private String[] OutStateStudentToArray(Student student) {
		String[] studentData = {student.getName(), student.getUSAddr(), Integer.toString(student.getYrsInState())};
		return studentData;
	}
	
	private String[] IntlStudentToArray(Student student) {
		String[] studentData = {student.getName(), student.getUSAddr(), Integer.toString(student.geti20Num()), student.getForeignAddr()};
		return studentData;
	}
	
	@Test
	public void InStateStudentVerification() {
		String[] expected = {"Mark", "Boston Downtown", "20" };
		Student actual= StudentFactory.createInStateStudent("Mark", "Boston Downtown", 20);
		assertArrayEquals(expected, InStateStudentToArray(actual));
	}
	
	@Test
	public void IntlStudentVerification() {
		String[] expected = {"Meet", "Boston Downtown", "1234", "India" };
		Student actual= StudentFactory.createIntlStudent("Meet", "Boston Downtown", 1234, "India");
		assertArrayEquals(expected, IntlStudentToArray(actual));
	}
	
	@Test
	public void OutStateStudentVerification() {
		String[] expected = {"Charlie", "Boston Downtown", "22"};
		Student actual= StudentFactory.createOutStateStudent("Charlie", "Boston Downtown", 22);
		assertArrayEquals(expected, OutStateStudentToArray(actual));	
	}
	
	

}
