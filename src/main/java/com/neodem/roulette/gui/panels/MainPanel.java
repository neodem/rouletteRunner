/* 
 * MainPanel.java
 * 
 * Created on Oct 23, 2003 11:50:29 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.gui.panels;


import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.neodem.roulette.gui.handlers.MainHandler;


/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class MainPanel extends JPanel {


	private MainHandler mainHandler;
	/**
	 * @param mainHandler
	 */
	public MainPanel(MainHandler mainHandler) {
		super();
		this.mainHandler = mainHandler;
		setLayout(new BorderLayout());
		addChildren();
	}

	private InputPanel inputPanel;
	private OutputPanel outputPanel;
	private StatusPanel statusPanel;
	private BetPanel betPanel;
	
	/**
	 * 
	 */
	public MainPanel() {

	}
	
	private void addChildren() {
		inputPanel = new InputPanel();
		add(inputPanel, BorderLayout.WEST);
		
		outputPanel = new OutputPanel();
		add(outputPanel, BorderLayout.EAST);
		
		statusPanel = new StatusPanel(mainHandler);
		add(statusPanel, BorderLayout.SOUTH);
		
		betPanel = new BetPanel(mainHandler);
		add(betPanel, BorderLayout.CENTER);	
	}
	/**
	 * @return
	 */
	public BetPanel getBetPanel() {
		return betPanel;
	}

	/**
	 * @return
	 */
	public InputPanel getInputPanel() {
		return inputPanel;
	}

	/**
	 * @return
	 */
	public OutputPanel getOutputPanel() {
		return outputPanel;
	}

	/**
	 * @return
	 */
	public StatusPanel getStatusPanel() {
		return statusPanel;
	}

}
