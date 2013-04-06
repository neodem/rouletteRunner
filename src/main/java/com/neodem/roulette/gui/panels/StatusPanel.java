/* 
 * StatusPanel.java
 * 
 * Created on Oct 23, 2003 11:37:36 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.gui.panels;



import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.neodem.roulette.gui.handlers.MainHandler;



/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class StatusPanel extends JPanel {
	/**
	 * @param mainHandler
	 */
	public StatusPanel(MainHandler mainHandler) {
		super();
		this.mainHandler = mainHandler;
		index = 0;
		addButton();
		addProgressBar();
	}

	private void addButton() {
		runButton = new JButton();
		runButton.setText("Run");

		runButton.addActionListener(mainHandler);
		add(runButton);
	}
	
	private void addProgressBar() {
		progressBar = new JProgressBar(0,1000);
		progressBar.setPreferredSize(new Dimension(300, 30));
		progressBar.setStringPainted(true);
		add(progressBar);
	}
	
	public void updateBar() {
		progressBar.setValue(++index);
	}

	/**
	 * @param sessions
	 */
	public void resetBar(int sessions) {
		index = 0;	
		progressBar.setMaximum(sessions);
	}
	
	private ActionListener mainHandler;
	private JProgressBar progressBar;
	private JButton runButton;
	private int index;

}
