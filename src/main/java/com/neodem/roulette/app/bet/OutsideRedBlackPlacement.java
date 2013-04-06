/* 
 * OutsideRedBlackPlacement.java
 * 
 * Created on Oct 5, 2003 8:06:33 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.bet;

import com.neodem.roulette.app.bet.core.PlacementType;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class OutsideRedBlackPlacement extends PlacementType {

	private final String DEFAULT_NAME = "RedBlack";
	private final int DEFAULT_PAYOUT = 1; // pays 1 to one

	/**
	 * 
	 */
	public OutsideRedBlackPlacement() {
		setName(DEFAULT_NAME);
		setPayout(DEFAULT_PAYOUT);
	}
}
