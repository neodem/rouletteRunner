/* 
 * Player.java
 * 
 * Created on Oct 5, 2003 12:20:37 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.entity;

import java.util.Collection;
import java.util.Iterator;

import com.neodem.roulette.app.TallyService;
import com.neodem.roulette.app.bet.BetProcessor;
import com.neodem.roulette.app.bet.core.Bet;
import com.neodem.roulette.app.bet.core.Placement;
import com.neodem.roulette.app.bet.core.PlacementLocation;
import com.neodem.roulette.app.reporting.ReportService;
import com.neodem.roulette.app.spin.SpinResultIF;
import com.neodem.roulette.app.strategy.Strategy;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class Player implements Entity {
	TallyService _tallyService;
	ReportService _reportService;
	Strategy _strategy;
	int _bankroll;
	Bet _currentBet;
	
	public void setReportService(ReportService reportService) {
		_reportService = reportService;
	}
	
	/**
	 * 
	 */
	public Player() {
		super();
	}
	
	/** get the current bet
	 * @return
	 */
	public Bet getBet() {
		return _currentBet;
	}
	
	public String getNextBetString() {
		if(_currentBet == null) return "no bet";
		Collection placements = _currentBet.getPlacements();
		Iterator i = placements.iterator();
		Placement placement = (Placement)i.next();
		
		PlacementLocation location = placement.getPlacementLocation();
		
		return location.toString();
	}
	
	public String getBankrollString() {
		String result = "" + _bankroll;
		return result;
	}

	/**
	 * @param strategy
	 */
	public void setStrategy(Strategy strategy) {
		_strategy = strategy;
		
	}

	/**
	 * @param i
	 */
	public void setBankroll(int bankroll) {
		_bankroll = bankroll;
		
	}
	
	public int getBankroll() {
		return _bankroll;
	}

	/* (non-Javadoc)
	 * @see roulette.app.entity.Entity#assessResult(roulette.spin.SpinResultIF, roulette.app.bet.core.Bet)
	 */
	public void assessResult(SpinResultIF spinResult, Bet bet) {
		//process winnings
		int net = BetProcessor.getPlayerNet(spinResult, bet);
		
		_bankroll += net;

		//log
		_reportService.log(this, spinResult);
		
		//tally
		//_tallyService.update(this, spinResult);
		
		//update strategy
		_strategy.reportSpin(spinResult);
	}

	/**
	 * this gets called before every bet
	 */
	public void think() {
		_currentBet = _strategy.getNextBet(_bankroll);
	}
}
