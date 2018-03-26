package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by miszymcz on 23/03/2018
 */
public class FizzBuzzTest {

	@Test
	public void multiplesOfThreeButNotFiveAreFizz() {
		FizzBuzz solution = new FizzBuzz();
		assertEquals("1,2,fizz", solution.play(3));
	}

	@Test
	public void multiplesOfFiveButNotThreeAreBuzz() {
		FizzBuzz solution = new FizzBuzz();
		assertEquals("1,2,fizz,4,buzz", solution.play(5));
	}

	@Test
	public void multiplesOfThreeAndFiveAreFizzBuzz() {
		FizzBuzz solution = new FizzBuzz();
		assertEquals("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizz buzz", solution.play(15));
	}
	
	@Test
	public void invalidInput() {
		FizzBuzz solution = new FizzBuzz();
		assertEquals("Invalid Input", solution.play(-1));
	}
}