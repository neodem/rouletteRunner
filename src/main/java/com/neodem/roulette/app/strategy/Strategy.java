/* 
 * Strategy.java
 * 
 * Created on Oct 5, 2003 11:14:01 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.strategy;

import com.neodem.roulette.app.bet.core.Bet;
import com.neodem.roulette.app.spin.SpinResultIF;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public interface Strategy {
	Bet getNextBet(int bankroll);
	/**
	 * @param spinResult
	 */
	void reportSpin(SpinResultIF spinResult);
}
