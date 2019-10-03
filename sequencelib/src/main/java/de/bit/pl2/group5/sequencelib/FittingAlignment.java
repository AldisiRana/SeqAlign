package de.bit.pl2.group5.sequencelib;

import java.util.Arrays;

/**
 * This class implements the fitting alignment of two sequences
 * 
 * @author Rana Aldisi
 * @version 1.0
 */
 
public class FittingAlignment extends Alignment {
	/**
	 * This is a method that modifies Smith-Waterman algorithm to implement fitting alignment
	 * fitting alignment happen when a long sequence is aligned with a much smaller one
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
    	//Fill in the Score and Backtrack matrices.
    	tracebackMatrix[0][0] = -1;
    	int maxscore = Integer.MIN_VALUE;
    	int iAtMaxScore = 0;
    	int jAtMaxScore = 0;
    	for (int i =1; i<numberRows; i++) {
    		for (int j =1; j<numberColumns; j++) {
    			int leftscore = calculatedScoreMatrix[i][j-1] -gap;
    			int upscore = calculatedScoreMatrix[i-1][j] -gap;
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
        				iAtMaxScore = i;
        				jAtMaxScore = j;
        			}
        		}

    		}
    	
    	}

    	StringBuilder firstSequenceAligned = new StringBuilder();
        StringBuilder secondSequenceAligned = new StringBuilder();
        StringBuilder connectionLines = new StringBuilder();
        super.setScore(calculatedScoreMatrix[iAtMaxScore][jAtMaxScore]);
        while(iAtMaxScore>0 && jAtMaxScore>0) {
        	coloredScoresMatrix[iAtMaxScore][jAtMaxScore].setColored(true);
        	if(tracebackMatrix[iAtMaxScore][jAtMaxScore] == match) {
        		firstSequenceAligned.append(firstSequence.charAt(iAtMaxScore-1));
        		secondSequenceAligned.append(secondSequence.charAt(jAtMaxScore-1));
        		if (firstSequence.charAt(iAtMaxScore-1) == secondSequence.charAt(jAtMaxScore-1))
        			connectionLines.append("|");
        		else
        			connectionLines.append(":");
        		iAtMaxScore-=1;
        		jAtMaxScore-=1;
        	}
        	else if (tracebackMatrix[iAtMaxScore][jAtMaxScore]==left) {
        		firstSequenceAligned.append("-");
        		secondSequenceAligned.append(secondSequence.charAt(jAtMaxScore-1));
        		connectionLines.append(" ");
        		jAtMaxScore-=1;
        	}
        	else if (tracebackMatrix[iAtMaxScore][jAtMaxScore] ==up) {
        		firstSequenceAligned.append(firstSequence.charAt(iAtMaxScore-1));
        		secondSequenceAligned.append("-");
        		connectionLines.append(" ");
        		iAtMaxScore-=1;
        	}
        }
        
        super.setFinalSeq01(firstSequenceAligned.reverse().toString());
    	super.setFinalSeq02(secondSequenceAligned.reverse().toString());
    	super.setConnectionSeq(connectionLines.reverse().toString());
    	super.setCalculatedScoreMat(coloredScoresMatrix);
	}
}
