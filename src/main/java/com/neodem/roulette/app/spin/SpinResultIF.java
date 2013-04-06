/* 
 * SpinResult.java
 * 
 * Created on Oct 5, 2003 11:17:56 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.spin;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public interface SpinResultIF {
	public int DOUBLEZERO = 37;
	
	public void setSpinNumber(int number);
	
	int getValue();
	void setValue(int value);

	boolean isGreen();

	boolean isEven();
	boolean isOdd();
	boolean isBlack();
	boolean isRed();

	/**
	 * @return
	 */
	public int getSpinNumber();
}
