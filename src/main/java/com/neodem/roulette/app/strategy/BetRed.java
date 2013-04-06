/* 
 * BetRed.java
 * 
 * Created on Oct 22, 2003 3:19:08 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.strategy;

import com.neodem.roulette.app.bet.RedBet;
import com.neodem.roulette.app.bet.core.Bet;
import com.neodem.roulette.app.spin.SpinResultIF;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class BetRed implements Strategy {

	/**
	 * 
	 */
	public BetRed() {
		super();
	}

	/* (non-Javadoc)
	 * @see roulette.strategy.Strategy#getNextBet()
	 */
	public Bet getNextBet(int bankroll) {
		RedBet bet = new RedBet();		
		return bet;
	}

	/* (non-Javadoc)
	 * @see roulette.strategy.Strategy#reportSpin(roulette.spin.SpinResultIF)
	 */
	public void reportSpin(SpinResultIF spinResult) {
	}

}
