/* 
 * RedBlack1.java
 * 
 * Created on Oct 5, 2003 12:25:55 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.reporting;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neodem.roulette.app.bet.core.Bet;
import com.neodem.roulette.app.bet.core.Placement;
import com.neodem.roulette.app.bet.core.PlacementLocation;
import com.neodem.roulette.app.bet.core.PlacementType;
import com.neodem.roulette.app.entity.Entity;
import com.neodem.roulette.app.entity.Player;
import com.neodem.roulette.app.spin.SpinResultIF;


/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class RedBlack1Report implements ReportService {
	
	private static Log _log = LogFactory.getLog(RedBlack1Report.class);

	/**
	 * 
	 */
	public RedBlack1Report() {
		super();
		//_log.info("report service initialized");
	}

	/**
	 * @param player
	 * @param spin
	 */
	public void log(Entity entity, SpinResultIF spin) {

		Player player = (Player)entity;
		Bet bet = player.getBet();

		StringBuffer string = new StringBuffer("Spin ");
		DecimalFormat format = new DecimalFormat("00");
		String number = format.format(spin.getSpinNumber());
		string.append(number);
		string.append(":");

		String spinColor;
		if (spin.isBlack())
			spinColor = "Black";
		else if (spin.isRed())
			spinColor = "Red";
		else
			spinColor = "Green";

		string.append(pad(spinColor,5));

		if (bet != null) {

			Collection placements = bet.getPlacements();
			//there is only one placement in a RedBlack1 bet
			Iterator i = placements.iterator();
			Placement placement = (Placement)i.next();

			PlacementType placementType = placement.getPlacementType();
			PlacementLocation placementLocation = placement.getPlacementLocation();

			String betColor = placementLocation.getColor();
			String betAmount = placement.getAmountString();

			String result;
			if (spinColor.equals(betColor))
				result = "WIN ";
			else
				result = "LOSS";
				
			string.append(" : ");
			string.append("Bet was ");
			string.append(betAmount);
			string.append(" on ");
			string.append(betColor);
			string.append(" : ");
			string.append(result);
			string.append(" : ");
		}

		else {
			string.append(" : no bet : ");
		}

		string.append("Bankroll = ");
		string.append(player.getBankrollString());

		_log.debug(string.toString());
	}
	
	private String pad(String string, int size) {
		char[] buffer = new char[size];
		int len = string.length();
		for(int i = 0; i< size; i++) {
			char ch = ' ';
			if(i < len) ch = string.charAt(i);
			buffer[i] = ch;
		}
		
		return new String(buffer);
	}
	
}
