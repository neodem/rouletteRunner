/* 
 * Entity.java
 * 
 * Created on Oct 5, 2003 7:49:04 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.entity;

import com.neodem.roulette.app.bet.core.Bet;
import com.neodem.roulette.app.spin.SpinResultIF;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public interface Entity {
	public void assessResult(SpinResultIF spinResult, Bet bet);
}
