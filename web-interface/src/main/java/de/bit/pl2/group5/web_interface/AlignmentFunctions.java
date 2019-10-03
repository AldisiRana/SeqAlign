package de.bit.pl2.group5.web_interface;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import de.bit.pl2.group5.sequencelib.AffineGapAlignment;
import de.bit.pl2.group5.sequencelib.FittingAlignment;
import de.bit.pl2.group5.sequencelib.GlobalAlignment;
import de.bit.pl2.group5.sequencelib.LocalAlignment;
import de.bit.pl2.group5.sequencelib.OverlapAlignment;
import de.bit.pl2.group5.sequencelib.ScoringMatrices;
import de.bit.pl2.group5.sequencelib.SemiglobalAlignment;

/**
 * this class contains the functions needed to do the alignments
 * @author RanaAldisi
 *
 */
public class AlignmentFunctions {

	enum alignmentType {
		GLOBAL,
		LOCAL,
		SEMIGLOBAL,
		AFFINEGAP,
		OVERLAP,
		FITTING;	
	}
    
    enum scoring{
    	BLOSUM62,
    	BLOSUM80,
    	PAM120,
    	PAM250,
    	PAM30,
    	BLOSUM50,
    	NONE;
    }
    
    /**
     * this function takes the align class with all input parameters and the fasta file then inputs the results in the same align object
     * @param align
     * @param fasta
     * @throws IOException
     */
    public static void AddAlignment(Align align, File fasta) throws IOException {
		String scoreMat = align.getScoringMatrix().toUpperCase();
		String alignment = align.getAlignment().toUpperCase();
		int mismatch = align.getMismatch();
		int gap = align.getGap();
		int[] customMatrixScores = align.getCustomScoringMatrix();
		Map<String, Integer> scoringMatrix = new HashMap<String, Integer>();
		
		switch(scoring.valueOf(scoreMat)) {
			case BLOSUM62:
				scoringMatrix = new ScoringMatrices().getBLOSUM62();
				break;
			case BLOSUM50:
				scoringMatrix = new ScoringMatrices().getBLOSUM50();
				break;
			case PAM250:
				scoringMatrix = new ScoringMatrices().getPAM250();
				break;
			case BLOSUM80:
    			scoringMatrix = new ScoringMatrices().getBLOSUM80();
    			break;
			case PAM120:
				scoringMatrix = new ScoringMatrices().getPAM120();
				break;
			case PAM30:
				scoringMatrix = new ScoringMatrices().getPAM30();
				break;
			default:
				scoringMatrix = createCustomMatrix(customMatrixScores, scoringMatrix);
				break;
		}
		
    	switch(alignmentType.valueOf(alignment)) {
			case GLOBAL:
				GlobalAlignment ga = new GlobalAlignment();
				ga.setSequences(fasta);
				ga.setAlignmentResults(gap, scoringMatrix);
				align.setFirstSeq(ga.getSequences().getSequences().get(0).getSequence());
				align.setSecondSeq(ga.getSequences().getSequences().get(1).getSequence());
				align.setScore(ga.getScore());
				align.setFinalSeq01(ga.getFinalSeq01());
				align.setFinalSeq02(ga.getFinalSeq02());
				align.setSeqConnections(ga.getConnectionSeq());
				align.setCalculatedScoreMatrix(ga.getCalculatedScoreMat());
				break;
			case LOCAL:
				LocalAlignment la = new LocalAlignment();
				la.setSequences(fasta);
				la.setAlignmentResults(gap, scoringMatrix);
				align.setFirstSeq(la.getSequences().getSequences().get(0).getSequence());
				align.setSecondSeq(la.getSequences().getSequences().get(1).getSequence());
				align.setScore(la.getScore());
				align.setFinalSeq01(la.getFinalSeq01());
				align.setFinalSeq02(la.getFinalSeq02());
				align.setSeqConnections(la.getConnectionSeq());
				align.setCalculatedScoreMatrix(la.getCalculatedScoreMat());
				break;
			case AFFINEGAP:
				AffineGapAlignment aa = new AffineGapAlignment();
				aa.setSequences(fasta);
				aa.setAlignmentResults(gap, scoringMatrix);
				align.setFirstSeq(aa.getSequences().getSequences().get(0).getSequence());
				align.setSecondSeq(aa.getSequences().getSequences().get(1).getSequence());
				align.setScore(aa.getScore());
				align.setFinalSeq01(aa.getFinalSeq01());
				align.setFinalSeq02(aa.getFinalSeq02());
				align.setSeqConnections(aa.getConnectionSeq());
				align.setCalculatedScoreMatrix(aa.getCalculatedScoreMat());
				break;
			case OVERLAP:
				OverlapAlignment oa = new OverlapAlignment();
				oa.setSequences(fasta);
				oa.setAlignmentResults(gap, mismatch);
				align.setFirstSeq(oa.getSequences().getSequences().get(0).getSequence());
				align.setSecondSeq(oa.getSequences().getSequences().get(1).getSequence());
				align.setScore(oa.getScore());
				align.setFinalSeq01(oa.getFinalSeq01());
				align.setFinalSeq02(oa.getFinalSeq02());
				align.setSeqConnections(oa.getConnectionSeq());
				align.setCalculatedScoreMatrix(oa.getCalculatedScoreMat());
				break;
			case FITTING:
				FittingAlignment fa = new FittingAlignment();
				fa.setSequences(fasta);
				fa.setAlignmentResults(gap, mismatch);
				align.setFirstSeq(fa.getSequences().getSequences().get(0).getSequence());
				align.setSecondSeq(fa.getSequences().getSequences().get(1).getSequence());
				align.setScore(fa.getScore());
				align.setFinalSeq01(fa.getFinalSeq01());
				align.setFinalSeq02(fa.getFinalSeq02());
				align.setSeqConnections(fa.getConnectionSeq());
				align.setCalculatedScoreMatrix(fa.getCalculatedScoreMat());
				break;
			case SEMIGLOBAL:
				SemiglobalAlignment sa = new SemiglobalAlignment();
				sa.setSequences(fasta);
				sa.setAlignmentResults(gap, mismatch);
				align.setFirstSeq(sa.getSequences().getSequences().get(0).getSequence());
				align.setSecondSeq(sa.getSequences().getSequences().get(1).getSequence());
				align.setScore(sa.getScore());
				align.setFinalSeq01(sa.getFinalSeq01());
				align.setFinalSeq02(sa.getFinalSeq02());
				align.setSeqConnections(sa.getConnectionSeq());
				align.setCalculatedScoreMatrix(sa.getCalculatedScoreMat());
				break;
    	}
    }
    
    /**
     * this method takes scores given by the user and inputs them into a matrix for alignment scoring
     * @param scores
     * @param CustomMatrix
     * @return a map that contains an aligned pair and their score
     */
    public static Map<String, Integer> createCustomMatrix(int[] scores, Map<String, Integer> CustomMatrix){
    	String [] AA = {"AA", "AC", "AD", "AE", "AF", "AG","AH","AI","AK","AL","AM","AN","AP","AQ","AR","AS","AT","AV","AW","AY",
				"CC", "CD", "CE", "CF", "CG","CH","CI","CK","CL","CM","CN","CP","CQ","CR","CS","CT","CV","CW","CY",
				"DD", "DE", "DF", "DG","DH","DI","DK","DL","DM","DN","DP","DQ","DR","DS","DT","DV","DW","DY",
				"EE", "EF", "EG","EH","EI","EK","EL","EM","EN","EP","EQ","ER","ES","ET","EV","EW","EY",
				"FF", "FG","FH","FI","FK","FL","FM","FN","FP","FQ","FR","FS","FT","FV","FW","FY",
				"GG","GH","GI","GK","GL","GM","GN","GP","GQ","GR","GS","GT","GV","GW","GY",
				"HH","HI","HK","HL","HM","HN","HP","HQ","HR","HS","HT","HV","HW","HY",
				"II","IK","IL","IM","IN","IP","IQ","IR","IS","IT","IV","IW","IY",
				"KK","KL","KM","KN","KP","KQ","KR","KS","KT","KV","KW","KY",
				"LL","LM","LN","LP","LQ","LR","LS","LT","LV","LW","LY",
				"MM","MN","MP","MQ","MR","MS","MT","MV","MW","MY",
				"NN","NP","NQ","NR","NS","NT","NV","NW","NY",
				"PP","PQ","PR","PS","PT","PV","PW","PY",
				"QQ","QR","QS","QT","QV","QW","QY",
				"RR","RS","RT","RV","RW","RY",
				"SS","ST","SV","SW","SY",
				"TT","TV","TW","TY",
				"VV","VW","VY",
				"WW","WY",
				"YY"};
    	for (int i=0; i<AA.length; i++) {
			CustomMatrix.put(AA[i], scores[i]);
		}
    	return CustomMatrix;
    }
}
