/* 
 * SpinResult.java
 * 
 * Created on Oct 5, 2003 11:23:29 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.spin;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class SpinResult extends BaseSpinResult implements SpinResultIF {

	private int _value;
	private int spinNumber;

	/**
	 * 
	 */
	public SpinResult() {
		super();
	}
	
	/**
	 * 
	 */
	public SpinResult(int spinValue) {
		super();
		setValue(spinValue);
	}

	/* (non-Javadoc)
	 * @see roulette.spin.SpinResultIF#getValue()
	 */
	public int getValue() {
		return _value;
	}

	/* (non-Javadoc)
	 * @see roulette.spin.SpinResultIF#setValue(int)
	 */
	public void setValue(int value) {
		_value = value;
	}

	/* (non-Javadoc)
	 * @see roulette.spin.SpinResultIF#isGreen()
	 */
	public boolean isGreen() {
		return ((_value == 0) || (_value == DOUBLEZERO));
	}

	/* (non-Javadoc)
	 * @see roulette.spin.SpinResultIF#isEven()
	 */
	public boolean isEven() {
		if(isGreen()) return false;
		int remainder = _value % 2;
		return (remainder == 0);
	}
	
	/* (non-Javadoc)
	 * @see roulette.spin.SpinResultIF#isOdd()
	 */
	public boolean isOdd() {
		if(isGreen()) return false;
		int remainder = _value % 2;
		return (remainder != 0);
	}

	/* (non-Javadoc)
	 * @see roulette.spin.SpinResultIF#isBlack()
	 */
	public boolean isBlack() {
		if(isGreen()) return false;
		return _blackSet.contains(new Integer(_value));
	}

	/* (non-Javadoc)
	 * @see roulette.spin.SpinResultIF#isRed()
	 */
	public boolean isRed() {
		if(isGreen()) return false;
		return _redSet.contains(new Integer(_value));
	}

	/* (non-Javadoc)
	 * @see roulette.spin.SpinResultIF#setSpinNumber(int)
	 */
	public void setSpinNumber(int number) {
		spinNumber = number;
	}

	/* (non-Javadoc)
	 * @see roulette.spin.SpinResultIF#getSpinNumber()
	 */
	public int getSpinNumber() {
		return spinNumber;
	}
}
