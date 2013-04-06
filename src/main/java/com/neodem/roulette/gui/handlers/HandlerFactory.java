/* 
 * HandlerFactory.java
 * 
 * Created on Oct 23, 2003 12:29:14 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.gui.handlers;

import java.awt.event.ActionListener;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class HandlerFactory {

	/**
	 * 
	 */
	public HandlerFactory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ActionListener getHandler(String type) {
		if("Button".equals(type)) return new ButtonHandler();
		return null;
	}

}
