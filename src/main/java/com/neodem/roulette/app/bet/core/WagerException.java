/* 
 * WagerException.java
 * 
 * Created on Oct 5, 2003 10:54:19 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.bet.core;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class WagerException extends Exception {

	/**
	 * 
	 */
	public WagerException() {
		super();

	}

	/**
	 * @param arg0
	 */
	public WagerException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public WagerException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public WagerException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
