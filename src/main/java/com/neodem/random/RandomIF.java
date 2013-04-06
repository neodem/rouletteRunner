/* 
 * Random.java
 * 
 * Created on Oct 5, 2003 10:03:24 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.random;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public interface RandomIF {
	boolean trueFalse();
	int intInRange(int lower, int upper);
	float floatInRange(float lower, float upper);
}
