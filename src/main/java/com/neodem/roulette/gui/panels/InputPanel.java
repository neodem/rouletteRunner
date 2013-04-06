/* 
 * InputPanel.java
 * 
 * Created on Oct 23, 2003 11:29:48 AM
 *
 * copyright 2003 acs-inc.
 * This code is confidential and may not be used without express written permission.
 */
package com.neodem.roulette.gui.panels;


import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class InputPanel extends JPanel {

	private JTextField sessionsField;
	private JLabel sessionsLabel;
	private JTextField spinsField;
	private JLabel spinsLabel;
	private JTextField bankrollField;
	private JLabel bankrollLabel;
	
	private JPanel labelsPanel;
	private JPanel fieldsPanel;	
	
	/**
	 * 
	 */
	public InputPanel() {
		super();

		addLabels();
		addFields();
	}

	private void addLabels() {
		labelsPanel = new JPanel();
		sessionsLabel = new JLabel();
		spinsLabel = new JLabel();
		bankrollLabel = new JLabel();
		
		labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
		
		sessionsLabel.setText("Sessions");
		labelsPanel.add(sessionsLabel);

		spinsLabel.setText("Spins");
		labelsPanel.add(spinsLabel);

		bankrollLabel.setText("Bankroll");
		labelsPanel.add(bankrollLabel);

		add(labelsPanel);
	}

	private void addFields() {
		fieldsPanel = new JPanel();
		sessionsField = new JTextField();
		spinsField = new JTextField();
		bankrollField = new JTextField();		

		fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));

		sessionsField.setColumns(8);
		sessionsField.setText("1000");
		fieldsPanel.add(sessionsField);

		spinsField.setColumns(8);
		spinsField.setText("60");
		fieldsPanel.add(spinsField);

		bankrollField.setColumns(8);
		bankrollField.setText("5000");
		fieldsPanel.add(bankrollField);

		add(fieldsPanel);
	}
	
	public int getSessions() {
		int value = Integer.parseInt(sessionsField.getText());
		return value;
	}
	
	public int getSpins() {
		int value = Integer.parseInt(spinsField.getText());
		return value;	
	}
	
	public int getBankroll() {
		int value = Integer.parseInt(bankrollField.getText());
		return value;	
	}
}
