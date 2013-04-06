/* 
 * BetIF.java
 * 
 * Created on Oct 5, 2003 10:23:01 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.bet.core;

import java.util.Collection;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public interface Bet {
	void addPlacement(Placement placement);
	Collection getPlacements();	
}
