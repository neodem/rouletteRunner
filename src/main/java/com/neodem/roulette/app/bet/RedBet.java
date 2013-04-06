/* 
 * RedBet.java
 * 
 * Created on Oct 22, 2003 3:22:52 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.bet;

import com.neodem.roulette.app.bet.core.Placement;
import com.neodem.roulette.app.bet.core.PlacementLocation;
import com.neodem.roulette.app.bet.core.WagerException;


/** This is a test class that repeatedly bets $10 on red
 * @author Vincent Fumo
 * @version 1.0
 */
public class RedBet extends RouletteBet {

	/**
	 * 
	 */
	public RedBet() {
		// create only one placement ( a $10 bet on Red )
		
		Placement placement = new Placement();
		placement.setBetAmount(10);
		placement.setPlacementType(new OutsideRedBlackPlacement());
		
		PlacementLocation location = new OutsideRedBlackLocation();
		try {
			location.setLocation(OutsideRedBlackLocation.RED);
		}
		catch (WagerException e) {
			e.printStackTrace();
		}

		placement.setPlacementLocation(location);
		
		addPlacement(placement);
	}
}
