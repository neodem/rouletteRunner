/* 
 * Bet.java
 * 
 * Created on Oct 5, 2003 10:38:30 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.bet;

import java.util.Collection;
import java.util.HashSet;

import com.neodem.roulette.app.bet.core.Bet;
import com.neodem.roulette.app.bet.core.Placement;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class RouletteBet implements Bet {
	HashSet _placements;

	/**
	 * 
	 */
	public RouletteBet() {
		super();
		_placements = new HashSet();

	}

	/* (non-Javadoc)
	 * @see roulette.BetIF#addPlacement(roulette.Placement)
	 */
	public void addPlacement(Placement placement) {
		_placements.add(placement);
	}

	/* (non-Javadoc)
	 * @see roulette.BetIF#getPlacements()
	 */
	public Collection getPlacements() {	
		return _placements;
	}

}
