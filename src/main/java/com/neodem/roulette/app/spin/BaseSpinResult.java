/* 
 * BaseSpinResult.java
 * 
 * Created on Oct 5, 2003 11:30:34 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.spin;

import java.util.HashSet;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public abstract class BaseSpinResult implements SpinResultIF {
	protected static HashSet _redSet;
	protected static HashSet _blackSet;
	/**
	 * 
	 */
	public BaseSpinResult() {
		super();
		setupSets();
	}
	
	private static void setupSets() {
		_redSet = new HashSet();
		_blackSet = new HashSet();
		
		_redSet.add(new Integer(1));
		_blackSet.add(new Integer(2));	
		_redSet.add(new Integer(3));
		_blackSet.add(new Integer(4));	
		_redSet.add(new Integer(5));
		_blackSet.add(new Integer(6));	
		_redSet.add(new Integer(7));
		_blackSet.add(new Integer(8));	
		_redSet.add(new Integer(9));
		_blackSet.add(new Integer(10));	
		_blackSet.add(new Integer(11));	
		_redSet.add(new Integer(12));
		_blackSet.add(new Integer(13));	
		_redSet.add(new Integer(14));
		_blackSet.add(new Integer(15));	
		_redSet.add(new Integer(16));
		_blackSet.add(new Integer(17));	
		_redSet.add(new Integer(18));
		_redSet.add(new Integer(19));
		_blackSet.add(new Integer(20));	
		_redSet.add(new Integer(21));
		_blackSet.add(new Integer(22));	
		_redSet.add(new Integer(23));
		_blackSet.add(new Integer(24));	
		_redSet.add(new Integer(25));
		_blackSet.add(new Integer(26));	
		_redSet.add(new Integer(27));
		_blackSet.add(new Integer(28));	
		_blackSet.add(new Integer(29));	
		_redSet.add(new Integer(30));
		_blackSet.add(new Integer(31));	
		_redSet.add(new Integer(32));
		_blackSet.add(new Integer(33));	
		_redSet.add(new Integer(34));	
		_blackSet.add(new Integer(35));	
		_redSet.add(new Integer(36));
	}
}
