/* 
 * Random.java
 * 
 * Created on Oct 5, 2003 10:05:50 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.random;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class Random implements RandomIF {

	/**
	 * 
	 */
	public Random() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.neodem.random.RandomIF#trueFalse()
	 */
	public boolean trueFalse() {
		return (Math.random() < 0.50);
	}

	/* (non-Javadoc)
	 * @see com.neodem.random.RandomIF#intInRange(int, int)
	 */
	public int intInRange(int lower, int upper) {
		double value = Math.random();
		int range = upper - lower;
		double result = value * range;
		long adder = Math.round(result);
		return lower + (int)adder;
	}

	/** This method will return a random floating point number based
	 * on the value given and the variance
	 * @param base the number that will be changed by the randomness
	 * @param variance the amount of +/- variance (change)
	 * @return the randomly generated value
	 */
	public float floatInRange(float lower, float upper) {
		double value = Math.random();
		float range = upper - lower;
		double result = value * range;
		return lower + (float)result;
	}
}
