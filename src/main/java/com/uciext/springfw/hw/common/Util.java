package com.uciext.springfw.hw.common;

import java.util.Random;

public class Util {

	private static Random random = new Random();
	
    public static void waitMS(long ms) {
    	try {
    		Thread.sleep(ms);
    	}
    	catch (Exception e) {}
    }

    public static int getRandomInt() {
    	return random.nextInt(1000000);
    }
}
