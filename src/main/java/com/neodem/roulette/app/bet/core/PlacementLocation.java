/* 
 * PlacementLocation.java
 * 
 * Created on Oct 5, 2003 10:25:49 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.bet.core;

import com.neodem.roulette.app.spin.SpinResultIF;

/** Each bet type will have to set and get a value using an int.
 * for example if it's a number, that's easy, but if it's an even
 * odd bet, that would need say a 1 for odd and a 2 for even.
 * @author Vincent Fumo
 * @version 1.0
 */
public interface PlacementLocation {
	void setLocation(int location) throws WagerException;
	int getLocation();
	String toString();
	String getColor();
	
	boolean isMatch(SpinResultIF spinResult);
	
	public static int BLACK = 1;
	public static int RED = 0;
}
