package de.bit.pl2.group5.sequencelib;

import java.util.Arrays;
/**
 * A class that implements the overlap alignment of two protein sequences .
 * 
 * @author Rana Aldisi
 * @version 1.0
 *
 */
 
public class OverlapAlignment extends Alignment {
    /**
	 * This is a method that modifies the Smith-Waterman implementation to calculate the overlap alignment
	 * Overlap alignment happens when a suffix of a sequence aligns with a prefix of the other sequence
	 * @param mismatch This is the penalty of having two different letters aligned
	 * @param gap This is the penalty of having a letter aligned with a gap
	 */
	 
	public void setAlignmentResults(int mismatch, int gap) {
		int numberRows = seq01.getSeqLength()+1;
    	int numberColumns = seq02.getSeqLength()+1;
    	int[][] calculatedScoreMatrix = new int[numberRows][numberColumns];
    	int[][] tracebackMatrix = new int[numberRows][numberColumns];
    	ColoredScores[][] coloredScoresMatrix = new ColoredScores[numberRows][numberColumns];
    	
    	String firstSequence = seq01.getSequence();
    	String secondSequence = seq02.getSequence();
    	
    	for (int i=0; i<seq01.getSeqLength(); i++) {
    		calculatedScoreMatrix[i][0] = defaultCalculatedScoreMatInitilization;
    		tracebackMatrix[i][0] = defaultTracebackMatInitilization;
    		ColoredScores coloredscore = new ColoredScores();
        	coloredscore.setScore(defaultCalculatedScoreMatInitilization);
    		coloredScoresMatrix[i][0] = coloredscore;
    	}
    	for (int j=0; j<seq02.getSeqLength(); j++) {
    		calculatedScoreMatrix[0][j] = defaultCalculatedScoreMatInitilization;
    		tracebackMatrix[0][j] = defaultTracebackMatInitilization;
    		ColoredScores coloredscore = new ColoredScores();
        	coloredscore.setScore(defaultCalculatedScoreMatInitilization);
    		coloredScoresMatrix[0][j] = coloredscore;
    	}
    	tracebackMatrix[0][0] = -1;
    	int maxscore = Integer.MIN_VALUE;
    	int mi = 0;
    	int mj = 0;
    	for (int i =1; i<numberRows; i++) {
    		for (int j =1; j<numberColumns; j++) {
    			int leftscore = calculatedScoreMatrix[i][j-1] - gap;
    			int upscore = calculatedScoreMatrix[i-1][j] - gap;
    			int matchscore;
    			if (firstSequence.charAt(i-1)==secondSequence.charAt(j-1)) {
    				matchscore = calculatedScoreMatrix[i-1][j-1] +1;
    			}
    			else
    				matchscore = calculatedScoreMatrix[i-1][j-1] - mismatch;
    			int[] max = {matchscore,upscore,leftscore};
        		Arrays.sort(max);
        		calculatedScoreMatrix[i][j] = max[max.length-1];
        		ColoredScores coloredscore = new ColoredScores();
        		coloredscore.setScore(max[max.length-1]);
        		coloredScoresMatrix[i][j] = coloredscore;
        		if (calculatedScoreMatrix[i][j] == matchscore) {
        			tracebackMatrix[i][j] = match;
        		}
        		else if (calculatedScoreMatrix[i][j] == leftscore) {
        			tracebackMatrix[i][j] = left;
        		}
        		else if(calculatedScoreMatrix[i][j] == upscore)
        			tracebackMatrix[i][j] = up;
        		if (i == firstSequence.length() || j == secondSequence.length()) {
        			if (calculatedScoreMatrix[i][j]>=maxscore) {
        				maxscore = calculatedScoreMatrix[i][j];
        				mi = i;
        				mj = j;
        			}

        			
        		}

    		}
    	
    	}
    	StringBuilder firstSequenceAligned = new StringBuilder();
        StringBuilder secondSequenceAligned = new StringBuilder();
        StringBuilder connectionLines = new StringBuilder();
    	String[] tracebackResults = super.traceback(tracebackMatrix, coloredScoresMatrix, mi, mj, firstSequence, secondSequence, firstSequenceAligned, secondSequenceAligned, connectionLines);
    	super.setFinalSeq01(tracebackResults[0]);
    	super.setFinalSeq02(tracebackResults[1]);
    	super.setConnectionSeq(tracebackResults[2]);
    	super.setScore(calculatedScoreMatrix[mi][mj]);
	}
}
