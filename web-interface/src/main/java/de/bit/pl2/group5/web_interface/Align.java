package de.bit.pl2.group5.web_interface;

import de.bit.pl2.group5.sequencelib.ColoredScores;

/**
 * This is a class that gets the input parameters as well as the output results for the alignments
 * @author Rana Aldisi
 * @version 1.0
 *
 */
class Align {
	
    private String alignment = "Global";
    private int score;
    private String finalSeq01;
    private String finalSeq02;
    private String firstSeq;
    private String secondSeq;
    private String seqConnections;
    private int gap = 1;
    private int mismatch =2;
    private String scoringMatrix;
    private int[] customScoringMatrix = new int [210];
    private ColoredScores[][] calculatedScoreMatrix;

    public String getAlignment() {
    	return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
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
    
    public String getSeqConnections() {
        return seqConnections;
    }

    public void setSeqConnections(String seqConnections) {
        this.seqConnections = seqConnections;
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }
    
    public int getMismatch() {
        return mismatch;
    }

    public void setMismatch(int mismatch) {
        this.mismatch = mismatch;
    }
    
    public String getScoringMatrix() {
        return scoringMatrix;
    }

    public void setScoringMatrix(String scoringMatrix) {
        this.scoringMatrix = scoringMatrix;
    }
    
    public int[] getCustomScoringMatrix() {
        return customScoringMatrix;
    }

    public void setCustomScoringMatrix(int[] customScoringMatrix) {
        this.customScoringMatrix = customScoringMatrix;
    }
    
    public ColoredScores[][] getCalculatedScoreMatrix() {
        return calculatedScoreMatrix;
    }

    public void setCalculatedScoreMatrix(ColoredScores[][] calculatedScoreMatrix) {
        this.calculatedScoreMatrix = calculatedScoreMatrix;
    }

	public String getFirstSeq() {
		return firstSeq;
	}

	public void setFirstSeq(String firstSeq) {
		this.firstSeq = firstSeq;
	}

	public String getSecondSeq() {
		return secondSeq;
	}

	public void setSecondSeq(String secondSeq) {
		this.secondSeq = secondSeq;
	}

}