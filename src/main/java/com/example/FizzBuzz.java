package com.example;

/**
 * Created by miszymcz on 23/03/2018
 *
 * - Print a comma-separated numbers from 1 to input inclusive
 * - If number is divisible by three, it's replaced by the word fizz
 * - If divisible by five by the word buzz.
 * - Numbers divisible by both become 'fizz buzz'
 */
public class FizzBuzz {

    public String play(int input) {
    	String res = "";
    	try {
    		if (input <= 0) {
        		return "Invalid Input";
        	}
        	for (int i = 1; i <= input; i++) {
        		if (i % 15 == 0) {
        			res += "fizz buzz,";
        		}else if (i % 5 == 0) {
        			res += "buzz,";
        		}else if (i % 3 == 0) {
        			res += "fizz,";
        		}else {
        			res += i + ",";
        		}
        	}
            
    	}catch(Exception ex) {
    		System.out.println(ex.getStackTrace());
    	}
    	return res.equals("") ? "" : res.substring(0, res.length() - 1);
    }
}
