package it.uniba.tdd.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniba.tdd.StringCalculator;
import it.uniba.tdd.StringCalculatorException;

public class StringCalculatorTest {

	@Test
	public void testStringIsEmpy() throws StringCalculatorException {
		//arrange
		String numberString = "";
		//act
		int calculator = StringCalculator.add(numberString);
		//assert
		assertEquals(0, calculator);
	}

	@Test
	public void testStringIsOneNumber() throws StringCalculatorException {
		//arrange
		String numberString = "20";
		//act
		int calculator = StringCalculator.add(numberString);
		//assert
		assertEquals(20, calculator);
	}
	@Test
	public void testStringIsTwoNumbers() throws StringCalculatorException {
		//arrange
		String numberString = "20,50";
		//act
		int calculator = StringCalculator.add(numberString);
		//assert
		assertEquals(70, calculator);
	}
	@Test
	public void testStringIsFiveNumbers() throws StringCalculatorException {
		//arrange
		String numberString = "20,50,3,2,90";
		//act
		int calculator = StringCalculator.add(numberString);
		//assert
		assertEquals(165, calculator);
	}
	@Test
	public void testStringIsNewLine() throws StringCalculatorException{
		//arrange
		String numberString = "1\n2,3";
		//act
		int calculator = StringCalculator.add(numberString);
		//assert
		assertEquals(6, calculator);
	}
	@Test(expected = StringCalculatorException.class)
	public void testStringIsNewLineWRONG() throws StringCalculatorException   {
		//arrange
		String numberString = "1,\n"; //non accettato
		//act
		int calculator = StringCalculator.add(numberString);
		//assert
	}
	@Test
	public void testStringIsNewLineWRONG2() throws StringCalculatorException   {
		//arrange
		String numberString = "2,1003"; //non accettato
		//act
		int calculator = StringCalculator.add(numberString);
		//assert
		assertEquals(2, calculator);
	}
		 
	@Test
	public void testStringIsNewDelimiter() throws StringCalculatorException{
		//arrange
		String numberString = "//;\n1;2";
		//act
		int calculator = StringCalculator.add(numberString);
		//assert
		assertEquals(3, calculator);
	}
	@Test
	public void testStringIsNewDelimiter2() throws StringCalculatorException{
		//arrange
		String numberString = "//-\n1-2-20-30";
		//act
		int calculator = StringCalculator.add(numberString);
		//assert
		assertEquals(53, calculator);
	}
}
