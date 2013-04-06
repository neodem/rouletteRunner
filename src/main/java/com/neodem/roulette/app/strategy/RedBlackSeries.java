/* 
 * RedBlackSeries.java
 * 
 * Created on Oct 5, 2003 9:03:28 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.app.strategy;

import java.util.ArrayList;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public abstract class RedBlackSeries implements Strategy {

	final int RED = 1;
	final int BLACK = 2;
	final int GREEN = 0;

	final int SERIES_LENGTH = 100;
	
	protected ArrayList _series;
	protected int index;
	/**
	 * 
	 */
	public RedBlackSeries() {
		super();
		_series = new ArrayList(SERIES_LENGTH);
		index = 0;
	}
	
	protected void addColor(int value) {
		_series.add(new Integer(value));
		index++;
	}
	
	protected int getColor(int index) {
		Integer integer = (Integer)_series.get(index);
		return integer.intValue();
	}
	
	protected int oppositeColor(int color) {
		if(color == RED) return BLACK;
		if(color == BLACK) return RED;
		return GREEN;
	}
}
