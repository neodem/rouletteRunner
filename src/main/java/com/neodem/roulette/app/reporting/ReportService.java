/* 
 * ReportService.java
 * 
 * Created on Oct 5, 2003 12:32:21 PM
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
public interface ReportService {
	/**
	 * @param player
	 * @param spin
	 */
	public abstract void log(Entity entity, SpinResultIF spin);
}