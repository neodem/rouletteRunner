/* 
 * Banker.java
 * 
 * Created on Oct 5, 2003 7:41:09 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.entity;

import com.neodem.roulette.app.bet.core.Bet;
import com.neodem.roulette.app.reporting.ReportService;
import com.neodem.roulette.app.spin.SpinResultIF;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class Banker implements Entity {
	
	private int _paidOut;
	private int _totalIncome;
	ReportService _reportService;
	/**
	 * 
	 */
	public Banker() {
		super();
		_paidOut = 0;
		_totalIncome = 0;
		_reportService = null;
	}

	/**
	 * @param bankRS
	 */
	public void setReportService(ReportService bankRS) {
		_reportService = bankRS;
		
	}


	/* (non-Javadoc)
	 * @see roulette.app.entity.Entity#assessResult(roulette.spin.SpinResultIF)
	 */
	public void assessResult(SpinResultIF spinResult, Bet bet) {
		
	}

}
