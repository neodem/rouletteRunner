/* 
 * OutputPanel.java
 * 
 * Created on Oct 23, 2003 11:30:05 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.gui.panels;



import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class OutputPanel extends JPanel {


	private JTextArea outputArea;
	
	/**
	 * 
	 */
	public OutputPanel() {
		super();
		
		outputArea = new JTextArea();
		
		outputArea.setColumns(30);
		outputArea.setRows(20);
		add(outputArea);
	}

	/**
	 * @param string
	 */
	public void setOutput(String string) {
		outputArea.setText(string);
	}
}
