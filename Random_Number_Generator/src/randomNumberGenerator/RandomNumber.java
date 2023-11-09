package randomNumberGenerator;
/*
	Author: Stavros Stathopoulos
	Date: 10/11/2023
	Purpose: This class generates random numbers using two different methods
	Place: Patras, Greece
	Version: 1.0
	Last Update: 10/11/2023
	All rights reserved

	This class generates random numbers using two different methods
	The first method is a Linear Congruential Generator
	The second method is a Linear Feedback Shift Register
	sample usage: RandomNumber random = new RandomNumber(123456789);
					int number = random.nextInt(100);
					int number2 = random.nextInt_linear();
					System.out.println(number);
					System.out.println(number2);

	The Linear Congruential Generator is a method of generating random numbers that is defined by the recurrence relation:
		Xn+1 = (a * Xn + c) mod m
				where X is the sequence of pseudorandom values, and
				m, 0 < m - the "modulus"
				a, 0 < a < m - the "multiplier"
				c, 0 <= c < m - the "increment"
				X0, 0 <= X0 < m - the "seed" or "start value"
	The Linear Feedback Shift Register is a method of generating random numbers that is defined by the recurrence relation:
		Xn+1 = Xn << 1 XOR Xn >> 1
				where X is the sequence of pseudorandom values, and
				X0 - the "seed" or "start value"
				Xn << 1 - the "left shift" of Xn
				Xn >> 1 - the "right shift" of Xn
				XOR - the "exclusive or" of Xn << 1 and Xn >> 1
	As seed, the current time in milliseconds is used
	Both methods are not cryptographically secure
*/

public class RandomNumber {
	private long seed;
	
	public RandomNumber(long seed) {
		this.seed = seed;
	}
	//Linear Congruential Generator
	public int nextInt(int max_number) {
		//a, c, m are constants
		//a is the multiplier
		long a = 1664525L;
		//c is the increment
	    long c = 1013904223L;
		//m is the modulus
		//m = 2^32
		long m = (long) Math.pow(2, 32);
		//Xn+1 = (a * Xn + c) mod m
		seed = (a * seed * c) % m;
		//Convert seed to int
		int temp = (int)seed;
			//Return the absolute value of the remainder of temp divided by max_number
			//This is done to ensure that the number is between 0 and max_number
			return Math.abs(temp % max_number);
		
		
	}
	//Linear Feedback Shift Register
	public int nextInt_LFSR() {
		//The initial value is the current time in milliseconds
		byte initial = (byte) System.currentTimeMillis();

		byte number = 0;
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
				//If i is even, then shift left
				//The shift is the remainder of the current time in milliseconds divided by 10
				//This is done to ensure that the shift is between 0 and 9
				number = (byte) (initial << (byte) Math.abs(System.currentTimeMillis() % 10));
				//XOR the number with the initial value
				number = (byte) (number ^ initial);
			}
			else {
				//If i is odd, then shift right
				//The shift is the remainder of the current time in milliseconds divided by 10
				//This is done to ensure that the shift is between 0 and 9
				//This is random, you can use any number you want instead of System.currentTimeMillis() % 10
				//number = (byte) (initial >> 5);
				//we recoment to use the System.currentTimeMillis() % WHTATEVER_NUMBER_YOU_WANT
				number = (byte) (initial >> (byte) Math.abs(System.currentTimeMillis() % 10));
				//XOR the number with the initial value
				number = (byte) (number ^ initial);
			}
		}
		
		
		return (int) number;
		
		
	}

}
