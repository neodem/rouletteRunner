/* 
 * SpinService.java
 * 
 * Created on Oct 5, 2003 12:12:11 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.spin;

import com.neodem.random.Random;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class SpinService implements SpinServiceIF {
	Random _random;
	
	/**
	 * 
	 */
	public SpinService() {
		super();
		_random = new Random();
	}

	/* (non-Javadoc)
	 * @see roulette.spin.SpinServiceIF#doSpin()
	 */
	public SpinResult doSpin(int spinNumber) {
		int spinValue = _random.intInRange(0,37);
		SpinResult result = new SpinResult(spinValue);
		result.setSpinNumber(spinNumber);
		return result;
	}
}
