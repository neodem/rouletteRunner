/* 
 * RedBlack1.java
 * 
 * Created on Oct 5, 2003 12:19:30 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.strategy;

import com.neodem.roulette.app.bet.OutsideRedBlackLocation;
import com.neodem.roulette.app.bet.OutsideRedBlackPlacement;
import com.neodem.roulette.app.bet.RouletteBet;
import com.neodem.roulette.app.bet.core.Bet;
import com.neodem.roulette.app.bet.core.Placement;
import com.neodem.roulette.app.bet.core.PlacementLocation;
import com.neodem.roulette.app.bet.core.WagerException;
import com.neodem.roulette.app.spin.SpinResultIF;

/** uses a progression of wagers
 * -> 5 – 15 – 45 – 135 – 350 – 800 – 2000
 * @author Vincent Fumo
 * @version 1.0
 */
public class RedBlack2 extends RedBlackSeries {

	boolean inSeries;	
	int betWager;
	int betColor;	
	int wagerIndex;
	int[] wagerSeries = new int[] {5,15,45,135,350,800,2000};
	int seriesMax; 

	public RedBlack2() {
		super();
		inSeries = false; 
		wagerIndex = 0;
		seriesMax = wagerSeries.length - 1;
	}

	/* (non-Javadoc)
	 * @see roulette.strategy.Strategy#getNextBet()
	 */
	public Bet getNextBet(int bankroll) {
		if (index < 2) return null;
		
		if(bankroll == 0) return null;

		Bet nextBet = null;
		
		// first rule of strategy is that there must be 2 of the same color in a row, lets check that
		int lastColor = getColor(index - 1);	
		
		if(inSeries) {
			if(lastColor == betColor) { // we won
				inSeries = false; 
			}
			else  { // we lost
				wagerIndex++;
				if(wagerIndex > seriesMax) wagerIndex = seriesMax;
				betWager = wagerSeries[wagerIndex];
				
				// can we afford the bet?
				if(betWager > bankroll) betWager = bankroll;
				
				// make the bet
				nextBet = placeBet(betColor, betWager);
			}	
		}
		else { // we are not in a series .. ie. not betting on anything
			int twoBackColor = getColor(index - 2);
			if (lastColor == twoBackColor) { // we have a pair so we go into action
				inSeries = true;
				betColor = oppositeColor(lastColor); // this is the color we are going to bet
				wagerIndex = 0;
				betWager = wagerSeries[wagerIndex];
				
				// make the bet
				nextBet = placeBet(betColor, betWager);	
			}
		}
		
		return nextBet;
	}
	
	private Bet placeBet(int color, int wager) {
		Bet bet = new RouletteBet();
		Placement placement = new Placement();

		placement.setBetAmount(wager);
		placement.setPlacementType(new OutsideRedBlackPlacement());
		PlacementLocation location = new OutsideRedBlackLocation();

		try {
			if (color == RED)
				location.setLocation(PlacementLocation.RED);
			else
				location.setLocation(PlacementLocation.BLACK);
		}
		catch (WagerException e) {
			e.printStackTrace();
		}

		placement.setPlacementLocation(location);
		bet.addPlacement(placement);
		
		return bet;
	}

	/* (non-Javadoc)
	 * @see roulette.strategy.Strategy#reportSpin(roulette.spin.SpinResultIF)
	 */
	public void reportSpin(SpinResultIF spinResult) {
		
		// update the spin tally
		int color;

		if (spinResult.isBlack())
			color = BLACK;
		else if (spinResult.isRed())
			color = RED;
		else
			color = GREEN;
			
		addColor(color);
	}
}
