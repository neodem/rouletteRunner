/* 
 * MainFrame.java
 * 
 * Created on Oct 22, 2003 9:03:06 PM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


import com.neodem.roulette.app.Roulette;
import com.neodem.roulette.gui.handlers.MainHandler;
import com.neodem.roulette.gui.panels.BetPanel;
import com.neodem.roulette.gui.panels.InputPanel;
import com.neodem.roulette.gui.panels.MainPanel;
import com.neodem.roulette.gui.panels.OutputPanel;
import com.neodem.roulette.gui.panels.StatusPanel;


/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class RouletteMainFrame extends JFrame {
	private static final String appName = "Roulette Runner";
	private MainPanel mainPanel;
	private Roulette theApp;
	private MainHandler mainHandler;
	private int sessions;

	public RouletteMainFrame() {
		initApp();
		initHandler();
		initGUI();
		show();
	}

	private void initHandler() {
		mainHandler = new MainHandler(this);
	}

	private void initApp() {
		theApp = new Roulette(this);
	}

	private void initGUI() {
		setTitle(appName);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});
		mainPanel = new MainPanel(mainHandler);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		pack();
	}

	private void exitForm(java.awt.event.WindowEvent evt) {
		System.exit(0);
	}

	public static void main(String[] args) {
		new RouletteMainFrame();
	}

	/**
	 * 
	 */
	public void runButtonPressed() {
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		setUpApp();
		runApp();
	}

	private void outputResults() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("sessions run : " + theApp.getSessions());
		buffer.append("\n");
		buffer.append("average bankroll : " + theApp.getAverage());
		buffer.append("\n");
		buffer.append("max win : " + theApp.getMax());
		buffer.append("\n");
		buffer.append("number of busts : " + theApp.getBusts());
		buffer.append("\n");
		buffer.append("average bust : " + theApp.getAverageBust());

		OutputPanel outputPanel = mainPanel.getOutputPanel();
		outputPanel.setOutput(buffer.toString());
	}

	private void runApp() {

		final SwingWorker worker = new SwingWorker() {
			public Object construct() {
				theApp.run();
				outputResults();
				setCursor(null);
				return null;
			}
		};
		worker.start(); //required for SwingWorker 3
	}

	private void setUpApp() {

		InputPanel inputs = mainPanel.getInputPanel();
		sessions = inputs.getSessions();
		theApp.setSessions(sessions);
		theApp.setSpins(inputs.getSpins());
		theApp.setBankRoll(inputs.getBankroll());
		
		StatusPanel panel = mainPanel.getStatusPanel();
		panel.resetBar(sessions);

		BetPanel bets = mainPanel.getBetPanel();
		theApp.setBetSeries(bets.getSeries());
	}

	/**
	 * 
	 */
	public void sessionDone() {
		StatusPanel panel = mainPanel.getStatusPanel();
		panel.updateBar();
	}

}
