/* 
 * BetProcessor.java
 * 
 * Created on Oct 5, 2003 8:40:42 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.bet;

import java.util.Collection;
import java.util.Iterator;

import com.neodem.roulette.app.bet.core.Bet;
import com.neodem.roulette.app.bet.core.Placement;
import com.neodem.roulette.app.spin.SpinResultIF;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class BetProcessor {

	/**
	 * 
	 */
	public BetProcessor() {
		super();
	}

	/**
	 * @param spinResult
	 * @param bet
	 * @return
	 */
	public static int getPlayerNet(SpinResultIF spinResult, Bet bet) {
		if(bet == null) return 0;
		
		Collection placements = bet.getPlacements();
		Iterator i = placements.iterator();
		
		int playerNet = 0;
		
		while(i.hasNext()) {
			Placement placement = (Placement)i.next();
			if(placement.isWinner(spinResult)) {
				playerNet += placement.getWinnings();
			}
			else playerNet -= placement.getBetAmount();	
		}

		return playerNet;
	}

}
