/* 
 * Roulette.java
 * 
 * Created on Oct 5, 2003 12:18:18 PM
 *
 */
package com.neodem.roulette.app;

import java.util.Collection;

import javax.swing.JFrame;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neodem.roulette.app.reporting.RedBlack1Report;
import com.neodem.roulette.gui.RouletteMainFrame;



/**
 * @author Vincent Fumo
 * @version 1.0
 */
public class Roulette {
	

	/**
	 * @param frame
	 */
	public Roulette(RouletteMainFrame frame) {
		setParentFrame(frame);
		reset();

	}

	private Collection betSeries;

	private JFrame parent;

	private static Log _log = LogFactory.getLog(RedBlack1Report.class);

	int spins;
	int sessions;
	int runningTotal;
	int max;
	int busts;
	private int bankroll;

	public Roulette() {
		reset();
	}
	
	public void setParentFrame(JFrame parent) {
		this.parent = parent;
	}

	public void reset() {
		spins = 0;
		sessions = 0;
		max = 0;
		runningTotal = 0;
		busts = 0;
		bankroll = 0;
		betSeries = null;
	}

	public void run() {
		
		if(sessions <= 0) return;
		if(spins <= 0) return;
		
		max = 0;
		runningTotal = 0;
		busts = 0;

		Session session = new Session();

		for (int i = 1; i <= sessions; i++) {
			_log.debug("----------------------------------------------------------");
			_log.debug("--| SESSION " + i + " BEGINNING |---------------------------------");
			_log.debug("----------------------------------------------------------");

			session.setup(bankroll, betSeries);
			session.run(spins);

			int result = session.getEndingBankroll();
			runningTotal += result;
			if (result > max)
				max = result;
			if (result == 0)
				busts++;
			_log.debug("----------------------------------------------------------");
			_log.debug("--| SESSION " + i + " COMPLETE |----------------------------------");
			_log.debug("------------------------->bankroll : " + result);
			_log.debug("----------------------------------------------------------");
			
			RouletteMainFrame mf = (RouletteMainFrame)parent;
			mf.sessionDone();
		}

		double average = (double)runningTotal / sessions;
		double averageBust = (double)busts / sessions;

		_log.info("sessions run : " + sessions);
		_log.info("average bankroll : " + average);
		_log.info("max win : " + max);
		_log.info("number of busts : " + busts);
		_log.info("average bust : " + averageBust);

	}
	
	public double getAverage() {
		return (double)runningTotal / sessions;
	}
	
	public double getAverageBust() {
		return (double)busts / sessions;
	}

	/**
	 * @return
	 */
	public int getBusts() {
		return busts;
	}

	/**
	 * @return
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @return
	 */
	public int getSessions() {
		return sessions;
	}

	/**
	 * @return
	 */
	public int getSpins() {
		return spins;
	}

	/**
	 * @param i
	 */
	public void setSessions(int i) {
		sessions = i;
	}

	/**
	 * @param i
	 */
	public void setSpins(int i) {
		spins = i;
	}

	/**
	 * @param i
	 */
	public void setBankRoll(int i) {
		bankroll = i;
	}
	
	public void setBetSeries(Collection series) {
		betSeries = series;
	}

}
