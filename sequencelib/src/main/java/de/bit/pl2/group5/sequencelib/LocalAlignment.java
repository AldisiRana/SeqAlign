package de.bit.pl2.group5.sequencelib;

import java.util.Arrays;
import java.util.Map;

/**
 * this class implements local alignment of two sequences
 * 
 * @author Rana Aldisi
 * @version 1.0
 */
 
public class LocalAlignment extends Alignment {
    /**
     * This method uses the Smith-Waterman algorithm to find the optimal local alignment between two sequences
     * @param gap this is the penalty of aligning a letter with a gap
	 * @param scoringMatrix This is the matrix that contains the AA pairs and their scores 
	 */
	 
	public void setAlignmentResults(int gap, Map<String, Integer> scoringMatrix) {
		
		int numberRows = seq01.getSeqLength()+1;
		int numberColumns = seq02.getSeqLength() +1;
		String firstSequence = seq01.getSequence();
		String secondSequence = seq02.getSequence();
		int[][] calculatedScoreMatrix = new int[numberRows][numberColumns];
		int[][] tracebackMatrix = new int[numberRows][numberColumns];
    	ColoredScores[][] coloredScoresMatrix = new ColoredScores[numberRows][numberColumns];

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
		
		for (int i =1; i<numberRows; i++) {
			for (int j =1; j<numberColumns; j++) {
				int leftscore = calculatedScoreMatrix[i][j-1] -gap;
				int upscore = calculatedScoreMatrix[i-1][j] -gap;
				int score_penalty = 0;
				String aminoAcidPair=Character.toString(firstSequence.charAt(i-1)) +Character.toString(secondSequence.charAt(j-1));
				String aminoAcidPairReversed = Character.toString(secondSequence.charAt(j-1))+ Character.toString(firstSequence.charAt(i-1));
				if (scoringMatrix.containsKey(aminoAcidPair))
					score_penalty = scoringMatrix.get(aminoAcidPair);
				else if (scoringMatrix.containsKey(aminoAcidPairReversed))   				
    				score_penalty = scoringMatrix.get(aminoAcidPairReversed);
				int matchscore = calculatedScoreMatrix[i-1][j-1] + score_penalty;
				int[] max = {matchscore,upscore,leftscore, 0};
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
	
	
			}
		
		}
	
		int [] max = super.getMax(calculatedScoreMatrix);
		int i = max[0];
		int j = max[1];
		int score = calculatedScoreMatrix[i][j];
		
		StringBuilder firstSequenceAligned = new StringBuilder();
	    StringBuilder secondSequenceAligned = new StringBuilder();
	    StringBuilder connectionLines = new StringBuilder();
	    String[] tracebackResults = super.traceback(tracebackMatrix, coloredScoresMatrix,i,j,firstSequence,secondSequence, firstSequenceAligned, secondSequenceAligned, connectionLines);
	    super.setFinalSeq01(tracebackResults[0]);
    	super.setFinalSeq02(tracebackResults[1]);
    	super.setConnectionSeq(tracebackResults[2]);
    	super.setScore(score);
	}
}


