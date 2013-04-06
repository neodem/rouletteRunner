/* 
 * PlacementType.java
 * 
 * Created on Oct 5, 2003 10:17:06 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.bet.core;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public abstract class PlacementType {
	
	String _name;
	int _payout;
	
	public void setName(String name) {
		_name = name;
	}
	public String getName() {
		return _name;
	}
	
	public void setPayout(int payout) {
		_payout = payout;
	}
	public int getPayout() {
		return _payout;
	}
	
	
}
