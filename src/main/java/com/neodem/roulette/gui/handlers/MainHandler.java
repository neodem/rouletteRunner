/* 
 * MainHandler.java
 * 
 * Created on Oct 23, 2003 12:45:13 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.neodem.roulette.gui.RouletteMainFrame;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class MainHandler implements ActionListener {

	private RouletteMainFrame parent;

	/**
	 * 
	 */
	public MainHandler(JFrame parent) {
		super();
		this.parent = (RouletteMainFrame)parent;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent evt) {
		// so far the only registerd action is the button so 
		// we just deal with it
		
		parent.runButtonPressed();

	}

}
