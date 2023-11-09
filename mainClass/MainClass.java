package mainClass;
/*
	Author: Stavros Stathopoulos
	Date: 10/11/2023
	Purpose: This class generates random numbers using two different methods
	Place: Patras, Greece
	Version: 1.0
	Last Update: 10/11/2023
	All rights reserved
	
	This is the main class of the program
	It creates an object of the RandomNumber class and prints 20 random numbers
	Between each number there is a 1 second pause using the Thread.sleep() method
	This is done to ensure that when the method nextInt_linear() is called
	The System.currentTimeMillis() method returns a different value
	
	The seed of the RandomNumber object is the current time in milliseconds
	The method nextInt_linear() is used to generate the random numbers

*/

import randomNumberGenerator.RandomNumber;

public class MainClass {
	
	public static void main (String[] args) {
		
			RandomNumber rand = new RandomNumber(System.currentTimeMillis());
			
			for(int i = 0; i < 20; i++) {
				try {
		            // Pause the program for 1 seconds
		            Thread.sleep(1000);
					//
					//System.out.println(rand.nextInt(100));
					//
		            System.out.println(rand.nextInt_LFSR());
		        } catch (InterruptedException e) {
		            // Handle the exception if needed
		            e.printStackTrace();
		        }
				
			}
		
		
	}

}
