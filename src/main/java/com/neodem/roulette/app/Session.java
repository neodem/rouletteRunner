/* 
 * Session.java
 * 
 * Created on Oct 22, 2003 5:24:58 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app;

import java.util.Collection;

import com.neodem.roulette.app.bet.core.Bet;
import com.neodem.roulette.app.entity.Banker;
import com.neodem.roulette.app.entity.Player;
import com.neodem.roulette.app.reporting.BasicBankReportService;
import com.neodem.roulette.app.reporting.RedBlack1Report;
import com.neodem.roulette.app.reporting.ReportService;
import com.neodem.roulette.app.spin.SpinResult;
import com.neodem.roulette.app.spin.SpinService;
import com.neodem.roulette.app.strategy.RedBlack1;
import com.neodem.roulette.app.strategy.RedBlackVariable;
import com.neodem.roulette.app.strategy.Strategy;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class Session {
	final int DEFAULT_BANKROLL = 5000;
	int endBankRoll;

	SpinService service;
	Player player;
	ReportService reportService;
	Strategy strategy;
	Banker banker;
	ReportService bankRS;

	public Session() {
		super();
		//setup(DEFAULT_BANKROLL);
	}

	public void run(int spins) {
		for (int i = 0; i < spins; i++) {
			player.think();
			Bet bet = player.getBet();
			SpinResult spin = service.doSpin(i);
			player.assessResult(spin, bet);
			banker.assessResult(spin, bet);
		}

		endBankRoll = player.getBankroll();
	}

	public int getEndingBankroll() {
		return endBankRoll;
	}

	/**
	 * @param bankroll
	 */
	public void setup(int bankroll) {
		setup(bankroll, null);
	}

	/**
	 * @param bankroll
	 * @param betSeries
	 */
	public void setup(int bankroll, Collection betSeries) {
		if (betSeries == null) {
			strategy = new RedBlack1();
		}
		else {
			strategy = new RedBlackVariable(betSeries);
		}
		service = new SpinService();
		player = new Player();
		reportService = new RedBlack1Report();
		banker = new Banker();
		bankRS = new BasicBankReportService();

		player.setReportService(reportService);
		player.setStrategy(strategy);
		player.setBankroll(bankroll);
		banker.setReportService(bankRS);

	}
}
