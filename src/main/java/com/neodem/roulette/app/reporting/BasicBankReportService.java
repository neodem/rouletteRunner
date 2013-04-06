/* 
 * BasicBankReportService.java
 * 
 * Created on Oct 5, 2003 7:41:24 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.reporting;

import com.neodem.roulette.app.entity.Entity;
import com.neodem.roulette.app.spin.SpinResultIF;



/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class BasicBankReportService implements ReportService {

	/**
	 * 
	 */
	public BasicBankReportService() {
		super();
	}


	/* (non-Javadoc)
	 * @see roulette.reporting.ReportService#log(roulette.app.entity.Entity, roulette.spin.SpinResultIF)
	 */
	public void log(Entity entity, SpinResultIF spin) {	
	}

}
