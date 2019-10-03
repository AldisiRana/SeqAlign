package de.bit.pl2.group5.sequencelib;

/**
 * ColoredScores.java - a class that has a score and a boolean which attributes to giving it a color
 * @version 1.0
 * @author Rana Aldisi
 */
public class ColoredScores {
	protected int score = 0 ;
	protected boolean colored =false;
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isColored() {
		return colored;
	}
	public void setColored(boolean colored) {
		this.colored = colored;
	}
}
