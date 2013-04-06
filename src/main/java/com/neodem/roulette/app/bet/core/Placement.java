/* 
 * Placement.java
 * 
 * Created on Oct 5, 2003 10:45:44 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.bet.core;

import com.neodem.roulette.app.spin.SpinResultIF;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class Placement {
	
	PlacementType _placementType;
	PlacementLocation _placementLocation;
	
	int _betAmount;

	
	public void setBetAmount(int betAmount) {
		_betAmount = betAmount;
	}
	
	/**
	 * @param location
	 */
	public void setPlacementLocation(PlacementLocation location) {
		_placementLocation = location;
	}	

	/**
	 * @param location
	 */
	public void setPlacementType(PlacementType placementType) {
		_placementType = placementType;
	}	
	
	/**
	 * @return
	 */
	public PlacementType getPlacementType() {
		return _placementType;
	}

	/**
	 * @param spinResult
	 * @return
	 */
	public boolean isWinner(SpinResultIF spinResult) {
		return _placementLocation.isMatch(spinResult);
	}

	/**
	 * @return
	 */
	public int getWinnings() {
	
		int payout = _placementType.getPayout();
		
		// winnings = original bet + original bet * payout
		//int winnings = _betAmount + (_betAmount * payout);
		
		// temp change to math:
		int winnings = _betAmount * payout;		
		
		
		return winnings;
	}	
	
	
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		string.append(_placementLocation.toString());
		string.append(",");
		string.append(_betAmount);
		
		return string.toString();
	}
	
	public String getAmountString() {
		String amount = "" + _betAmount;
		return amount;
	}
	
	public int getBetAmount() {
		return _betAmount;
	}
	
	
	/**
	 * @return
	 */
	public PlacementLocation getPlacementLocation() {
		return _placementLocation;
	}
	
}
	
	
	
