/* 
 * BetPanel.java
 * 
 * Created on Oct 23, 2003 11:24:39 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.gui.panels;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.neodem.roulette.gui.handlers.MainHandler;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class BetPanel extends JPanel {

	private MainHandler mainHandler;
	/**
	 * @param mainHandler
	 */
	public BetPanel(MainHandler mainHandler) {
		super();
		this.mainHandler = mainHandler;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setMinimumSize(new Dimension(28, 100));
		setPreferredSize(new Dimension(59, 100));

		addElements();
	}

	private final int numFields = 7;
	private JTextField[] betFields;
	private JLabel betLabel;

	private void addElements() {
		betLabel = new JLabel();
		betLabel.setText("Bets");
		add(betLabel);

		betFields = new JTextField[numFields];

		int val = 1;

		for (int i = 0; i < numFields; i++) {
			betFields[i] = new JTextField();
			betFields[i].setColumns(5);
			betFields[i].setText(new Integer(val).toString());
			add(betFields[i]);
			val = val * 3;
		}
	}
	/**
	 * @return
	 */
	public Collection getSeries() {
		ArrayList list = new ArrayList();

		for (int i = 0; i < numFields; i++) {
			list.add(new Integer(betFields[i].getText()));
		}

		return list;
	}
}
