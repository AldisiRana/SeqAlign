package de.bit.pl2.group5.sequencelib;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import de.bit.pl2.group5.fasta_tools.Sequence;
import de.bit.pl2.group5.fasta_tools.Sequences;

/**
 * Alignment.java - A super class consisting of all the needed common methods for all different alignment methods
 * @author Rana Aldisi
 * @version 1.0
 */
 
public class Alignment {

	
	protected Sequences sequences = new Sequences();
	protected Sequence seq01;
	protected Sequence seq02;
	
	protected int match = 0;
	protected int left = 1;
	protected int up = 2;
	protected ColoredScores[][] calculatedScoreMat;
	protected int defaultCalculatedScoreMatInitilization = 0;
	protected int defaultTracebackMatInitilization = -1;
	
	protected int score = 0;
	protected String finalSeq01;
	protected String finalSeq02;
	protected String ConnectionSeq;
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getFinalSeq01() {
		return finalSeq01;
	}
	public void setFinalSeq01(String finalSeq01) {
		this.finalSeq01 = finalSeq01;
	}
	
	public String getFinalSeq02() {
		return finalSeq02;
	}
	public void setFinalSeq02(String finalSeq02) {
		this.finalSeq02 = finalSeq02;
	}
	
	public String getConnectionSeq() {
		return ConnectionSeq;
	}
	public void setConnectionSeq(String ConnectionSeq) {
		this.ConnectionSeq = ConnectionSeq;
	}
	
	/**
	 * A function to extract all fastas from a file and store them into sequences
	 * it uses the class Sequences from fasta-tools library to extract the sequences
	 * 
	 * @param a file containing fasta
	 * @throws IOException
	 */
	
	
	public void setSequences(File fasta) throws IOException {
		sequences.setSequences(fasta);
		seq01 = sequences.getSequences().get(0);
		seq02 = sequences.getSequences().get(1);
	}
	
	/**
	 * A getter for the protected sequences
	 * 
	 * @return the list of sequences
	 */
	
	public Sequences getSequences() {
		return sequences;
	}
	
	public void setCalculatedScoreMat(ColoredScores[][] CalculatedScoreMat) {
		this.calculatedScoreMat = CalculatedScoreMat;
	}
	
	public ColoredScores[][] getCalculatedScoreMat() {
		return calculatedScoreMat;
	}
	
	/**
	 * a function that gets the indices of the maximum score in a 2-dimentional array
	 * 
	 * @param mat this is a 2d array of integers 
	 * @return int[] of the indices of the max score in the 2d array
	 */

	public int[] getMax(int[][] mat) {
    	int mi=0;
    	int mj = 0;
    	int mv = mat[0][0];
    	for (int i=0; i<mat.length; i++) {
    		for(int j=0; j<mat[i].length; j++) {
    			if (mat[i][j] > mv) {
    				mv = mat[i][j];
    				mi = i;
    				mj = j;
    			}
    		}
    	}
    	int [] max = {mi,mj};
		return max;
    }
	
	/**
	 * A function to traceback the match with a 2d array and prints the resulted reversed strings
	 * 
	 * @param tracebackMatrix This is a 2d array that contains the directions for the optimal alignment
	 * @param coloredScoreMatrix This is a 2d array that contains a class that saves the score and marks the optimal alignment scores
	 * @param int i this is the vertical matrix index
	 * @param int j this is the horizontal matrix index
	 * @param firstSequence This is the first sequence provided to be aligned
	 * @param secondSequence This is the second sequence provided to be aligned 
	 * @param firstSequenceAliged This is the StringBuilder that will be used to input the alignment of the first sequence
	 * @param secondSequenceAliged This is the StringBuilder that will be used to input the alignment of the second sequence
	 * @param connectionLines This is a StringBuilder that will input : in a mismatched position and a | in a matched position
	 * 
	 * @return String[] This contains the Strings to be build, the alignment of the first sequence, the alignment of the second sequence, and the lines to match them
 	 */

	public String[] traceback(int[][] tracebackMatrix, ColoredScores[][] coloredScoreMatrix, int i, int j, String firstSequence, String secondSequence, StringBuilder firstSequenceAligned, StringBuilder secondSequenceAligned, StringBuilder connectionLines) {
        while(i>0 && j>0) {
    		coloredScoreMatrix[i][j].setColored(true);
        	if(tracebackMatrix[i][j] == match) {
        		firstSequenceAligned.append(firstSequence.charAt(i-1));
        		secondSequenceAligned.append(secondSequence.charAt(j-1));
        		if (firstSequence.charAt(i-1) == secondSequence.charAt(j-1))
        			connectionLines.append("|");
        		else
        			connectionLines.append(":");
        		i-=1;
        		j-=1;
        	}
        	else if (tracebackMatrix[i][j]==left) {
        		firstSequenceAligned.append("-");
        		secondSequenceAligned.append(secondSequence.charAt(j-1));
        		connectionLines.append(" ");
        		j-=1;
        	}
        	else if (tracebackMatrix[i][j] ==up) {
        		firstSequenceAligned.append(firstSequence.charAt(i-1));
        		secondSequenceAligned.append("-");
        		connectionLines.append(" ");
        		i-=1;
        	}
        }
        if(i==0) {
        	while (j>0) {
        		coloredScoreMatrix[i][j].setColored(true);
        		firstSequenceAligned.append("-");
        		secondSequenceAligned.append(secondSequence.charAt(j-1));
        		connectionLines.append(" ");
        		j-=1;
        	}
        } else if (j==0) {
        	while (i>0) {
        		coloredScoreMatrix[i][j].setColored(true);
        		firstSequenceAligned.append(firstSequence.charAt(i-1));
        		secondSequenceAligned.append("-");
        		connectionLines.append(" ");
        		i-=1;
        	}
        }
        setCalculatedScoreMat(coloredScoreMatrix);
        return new String[]{firstSequenceAligned.reverse().toString(), secondSequenceAligned.reverse().toString(), connectionLines.reverse().toString()};
    }
	
}
