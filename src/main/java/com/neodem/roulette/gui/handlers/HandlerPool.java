/* 
 * HandlerPool.java
 * 
 * Created on Oct 23, 2003 12:16:48 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.gui.handlers;

import java.awt.event.ActionListener;
import java.util.HashMap;


/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class HandlerPool {
	
	private HandlerFactory factory;
	private HashMap map;
	
	/**
	 * 
	 */
	public HandlerPool() {
		super();
		factory = new HandlerFactory();
		map = new HashMap();
	}

	/**
	 * @param string
	 * @return
	 */
	public ActionListener makeButtonHandler(String string) {
		//check
		if(map.containsKey(string)) return null;
		
		// get the handler
		ActionListener handler = factory.getHandler("Button");
		
		// register the handler
		map.put(string, handler);
		
		// send it back
		return handler;
	}


}
