package de.bit.pl2.group5.sequencelib;

import java.util.Arrays;
import java.util.Map;

/**
 * AffineGapAlignment.java - A class to implement the Affine Gap penalty Alignment
 * @version 1.0
 * @author Rana Aldisi
 * @see Alignment
 */

public class AffineGapAlignment extends Alignment {
    /**
     * this class gives affine gap alignment which scores mismatch and match based on
     * a scoring matrix. It has a high opening gap penalty, but the extension of the gap
     * has a penalty of 1 (so creating the gap is not preferred but the extension doesn't
     * cause much of a difference
     * In this implementation, the algorithm from this pdf was used: 
     * https://www.cs.cmu.edu/~ckingsf/bioinfo-lectures/gaps.pdf
     * 
     * @param gap_opening This is the high penalty for starting a gap
     * @param scoringMatrix This is the matrix that contains the AA pairs and their scores
	 */
	 
	public void setAlignmentResults(int gap_opening, Map<String, Integer> scoringMatrix) {
    	
		int gap_extention = -1;
		if (gap_opening > 0) {
			gap_opening = gap_opening*-1;
		}
    	
        int numberRows = seq01.getSeqLength()+1;
        int numberColumns = seq02.getSeqLength()+1;
        
        String firstSequence = seq01.getSequence();
        String secondSequence = seq02.getSequence();
        
        int[][] M = new int[numberRows][numberColumns];
        int[][] X = new int[numberRows][numberColumns];
        int[][] Y = new int[numberRows][numberColumns];
        int[][] finalScoreMatrix = new int[numberRows][numberColumns];
        int[][] traceback = new int[numberRows][numberColumns];
        ColoredScores[][] ColoredScoresMatrix = new ColoredScores[numberRows][numberColumns];
        
        for (int i=0; i<numberRows; i++) {
        	Y[i][0] = gap_extention+(gap_opening*i);
        	ColoredScores coloredscore = new ColoredScores();
        	coloredscore.setScore(gap_extention+(gap_opening*i));
    		ColoredScoresMatrix[i][0] = coloredscore;
        }
        for (int j=0; j<numberColumns; j++) {
        	ColoredScores coloredscore = new ColoredScores();
        	coloredscore.setScore(gap_extention+(gap_opening*j));
    		ColoredScoresMatrix[0][j] = coloredscore;
        	X[0][j] = gap_extention+(gap_opening*j);
        }
        M[0][0]=0;
        traceback[0][0] = -1;
        for (int i=1; i<numberRows; i++) {
        	for (int j=1; j<numberColumns; j++) {
        		int matchscore = 0;
        		String aminoAcidPair=Character.toString(firstSequence.charAt(i-1)) +Character.toString(secondSequence.charAt(j-1));
				String aminoAcidPairReversed = Character.toString(secondSequence.charAt(j-1))+ Character.toString(firstSequence.charAt(i-1));
				if (scoringMatrix.containsKey(aminoAcidPair))
					matchscore = scoringMatrix.get(aminoAcidPair);
				else if (scoringMatrix.containsKey(aminoAcidPairReversed))   				
					matchscore = scoringMatrix.get(aminoAcidPairReversed);
        		int[] max_m = {M[i-1][j-1], X[i-1][j-1], Y[i-1][j-1]};
        		Arrays.sort(max_m);
        		M[i][j] = max_m[max_m.length-1]+matchscore;
        		//filling Y
        		int[] max_y = {M[i-1][j]+gap_extention, Y[i-1][j]+gap_opening};
        		Arrays.sort(max_y);
        		Y[i][j] = max_y[max_y.length-1];
        		//filling X
        		int[] max_x = {M[i][j-1]+gap_extention, X[i][j-1] +gap_opening};
        		Arrays.sort(max_x);
        		X[i][j]=max_x[max_x.length-1];
        		int[] max = {M[i][j], Y[i][j], X[i][j]};
        		Arrays.sort(max);
        		finalScoreMatrix[i][j] = max[max.length-1];
        		ColoredScores coloredscore = new ColoredScores();
        		coloredscore.setScore(max[max.length-1]);
        		ColoredScoresMatrix[i][j] = coloredscore;
        		if (max[max.length-1] == M[i][j])
        			traceback[i][j] = match;
        		if (max[max.length-1] == Y[i][j])
        			traceback[i][j] = up;
        		if (max[max.length-1] == X[i][j])
        			traceback[i][j] = left;
        		
        	}
        }
        
        
        int i = numberRows-1;
        int j = numberColumns-1;
        int score = finalScoreMatrix[i][j];
        StringBuilder firstSequenceAligned = new StringBuilder();
        StringBuilder secondSequenceAligned = new StringBuilder();
        StringBuilder connectionLines = new StringBuilder();
        
        String[] tracebackResults = super.traceback(traceback, ColoredScoresMatrix, i, j, firstSequence, secondSequence, firstSequenceAligned, secondSequenceAligned, connectionLines);
        super.setFinalSeq01(tracebackResults[0]);
    	super.setFinalSeq02(tracebackResults[1]);
    	super.setConnectionSeq(tracebackResults[2]);
    	super.setScore(score);
    }  
}
