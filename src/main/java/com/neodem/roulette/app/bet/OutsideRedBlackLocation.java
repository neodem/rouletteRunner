/* 
 * OutsideRedBlackLocation.java
 * 
 * Created on Oct 5, 2003 10:43:15 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.bet;

import com.neodem.roulette.app.bet.core.PlacementLocation;
import com.neodem.roulette.app.bet.core.WagerException;
import com.neodem.roulette.app.spin.SpinResultIF;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class OutsideRedBlackLocation implements PlacementLocation {

	private final int DEFAULT_VALUE = -1;



	private int _location;
	
	public String toString() {
	return getColor();
	}
	
	public String getColor() {
		if(_location == BLACK) return "Black";
		if(_location == RED) return "Red";
		return "undetermined";
	}
	/**
	 * 
	 */
	public OutsideRedBlackLocation() {
		super();
		_location = DEFAULT_VALUE;
	}
	/* (non-Javadoc)
	 * @see roulette.app.bet.core.PlacementLocation#setValue(int)
	 */
	public void setLocation(int location) throws WagerException {
		if ((location == BLACK) || (location == RED)){
			_location = location;
			return;
		}

		throw new WagerException("value must be red or black");
	}
	/* (non-Javadoc)
	 * @see roulette.app.bet.core.PlacementLocation#getValue()
	 */
	public int getLocation() {
		return _location;
	}

	/* (non-Javadoc)
	 * @see roulette.app.bet.core.PlacementLocation#isMatch()
	 */
	public boolean isMatch(SpinResultIF spinResult) {
		if(spinResult.isGreen()) return false;
		if((_location == BLACK) && (spinResult.isBlack())) return true;
		if((_location == RED) && (spinResult.isRed())) return true;
		return false;
	}
}
