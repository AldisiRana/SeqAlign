package de.bit.pl2.group5.sequencelib;

import java.util.HashMap;
import java.util.Map;

/**
 * A class used to implement the different kinds of  Matrices used by the local and global alignment algorithms to calculate the best allignment score between sequences
 * (PAM250, PAM120,PAM30,PAM70, BLOSUM80 ,BLOSUM62 AND BLOSUM50) TO get its respective score of each string in the matrices)
 * @author Rana Aldisi
 * @version 1.0
 *
 */


public class ScoringMatrices {
	/**
	 * A function to get the scoring for each string in the matrices
	 * 
	 * @return a bash map between strings and integer objects
	 */
	 
	public Map<String, Integer> getPAM250(){
		Map<String, Integer> PAM250 = new HashMap<String, Integer>();
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
		int [] scores = {2,-2,0,0,-4,1,-1,-1,-1,-2,-1,0,1,0,-2,1,1,0,-6,-3,
					12,-5,-5,-4,-3,-3,-2,-5,-6,-5,-4,-3,-5,-4,0,-2,-2,-8,0,
					4,3,-6,1,1,-2,0,-4,-3,2,-1,2,-1,0,0,-2,-7,-4,
					4,-5,0,1,-2,0,-3,-2,1,-1,2,-1,0,0,-2,-7,-4,
					9,-5,-2,1,-5,2,0,-4,-5,-5,-4,-3,-3,-1,0,7,
					5,-2,-3,-3,-4,-3,0,-1,-1,-3,1,0,-1,-7,-5,
					6,-2,0,-2,-2,2,0,3,2,-1,-1,-2,-3,0,
					5,-2,2,2,-2,-2,-2,-2,-1,0,4,-5,-1,
					5,-3,0,1,-1,1,3,0,0,-2,-3,-4,
					6,4,-3,-3,-2,-3,-3,-2,2,-2,-1,
					6,-2,-2,-1,0,-2,-1,2,-4,-2,
					2,-1,1,0,1,0,-2,-4,-2,
					6,0,0,1,0,-1,-6,-5,
					4,1,-1,-1,-2,-5,-4,
					6,0,-1,-2,2,-4,
					2,1,-1,-2,-3,
					3,0,-5,-3,
					4,-6,-2,
					17,0,
					10};
		for (int i=0; i<AA.length; i++) {
			PAM250.put(AA[i], scores[i]);
		}
		return PAM250;
	}
    /**
    * A function to get the scoring for each string in the matrices
    * 
    * @return a bash map between strings and integer objects
    */
 
    public Map<String, Integer> getPAM30(){
	    Map<String, Integer> PAM30 = new HashMap<String, Integer>();
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
	    int [] scores = {6,-6,-3,-2,-2,-7,-5,-5,-7,-2,-7,0,-1,0,-2,1,1,0,-13,-8,
				    10,-14,-14,-13,-9,-7,-6,-14,-15,-13,-11,-14,-8,-4,0,-2,-6,-15,-4,
				    8,2,-15,-3,-4,-4,-20,-11,2,-8,-2,2,-10,-5,0,-8,-15,-11,
				    8,-14,-4,-5,-5,-5,-3,-2,1,-1,-5,1,-9,-4,-6,-17,-8,
				    9,-9,-6,-3,-14,-3,-4,-9,-10,-6,-9,-6,-9,-8,-4,2,
				    6,-9,-11,-7,-10,-8,-3,-7,-9,-2,1,-5,-1,-15,-14,
				    9,-9,-6,-6,-10,0,1,-6,-7,-1,-6,-2,-7,-3,
				    8,-6,-1,-1,-5,-8,-8,-5,-7,-2,2,-14,-6,
				    -2,-8,-1,-6,-3,0,-4,-3,0,-7,-12,-9,
				    7,1,-7,-7,-5,-8,-7,-2,2,-6,-7,
				    11,-9,-8,-4,-4,-5,-13,-1,-13,-11,
				    8,-6,-3,-6,0,-2,-8,-8,-4,
				    8,-3,-4,-2,-4,-6,-14,-13,
				    8,-2,-5,-5,-7,-13,-12,
				    8,-3,-6,-8,-2,-10,
				    6,0,-6,-5,-7,
				    7,-3,-13,-6,
				    7,-15,-7,
				    13,-5,
				    10};
	    for (int i=0; i<AA.length; i++) {
		    PAM30.put(AA[i], scores[i]);
	}
	    return PAM30;
	
}

	/**
	 * A function to get the scoring for each string in the matrices
	 * 
	 * @return a bash map between strings and integer objects
	 */
	 
	public Map<String, Integer> getPAM120(){
		Map<String, Integer> PAM120 = new HashMap<String, Integer>();
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
		int [] scores = {3,-3,0,0,-4,1,-3,-1,-2,-3,-2,0,1,-1,-3,1,1,0,-7,-4,
					9,-7,-7,-6,-5,-4,-3,-7,-6,-5,-3,-7,-4,-3,-2,-8,-2,-8,-1,
					5,3,-7,0,1,-2,0,-4,-3,2,-1,2,-1,0,-1,-3,-8,-5,
					5,-6,-1,-1,-3,-1,-4,-3,0,-2,1,-2,-1,-2,-3,-8,-4,
					8,-5,-2,0,-6,0,-1,-4,-5,-5,-4,-3,-4,-3,-1,4,
					5,-4,-4,-3,-5,-3,0,-1,-1,-3,1,-1,-2,-8,-6,
					7,-4,-2,-3,-2,2,0,3,2,-1,-3,-3,-5,-1,
					6,-2,1,1,-2,-2,-2,-2,-1,0,3,-7,-2,
					5,-4,0,1,-1,1,3,0,-1,-4,-5,-6,
					5,3,-4,-3,-2,-3,-3,-2,1,-5,-3,
					8,-3,-3,-1,0,-2,-1,1,-7,-4,
					4,-2,0,-1,1,0,-3,-5,-2,
					6,0,-1,1,0,-2,-7,-6,
					6,1,-2,-1,-3,-6,-5,
					6,-1,-1,-2,1,-6,
					3,2,-1,-2,-3,
					4,0,-6,-3,
					5,-8,-3,
					12,-1,
					8};
		for (int i=0; i<AA.length; i++) {
			PAM120.put(AA[i], scores[i]);
		}
		return PAM120;
	}
	
	
	
	/**
	 * A function to get the scoring for each string in the matrices
	 * 
	 * @return a bash map between strings and integer objects
	 */
	 
	 
	 public Map<String, Integer> getPAM70(){
	    Map<String, Integer> PAM70 = new HashMap<String, Integer>();
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
	    int [] scores = {5,-4,-1,-1,-6,0,-4,-2,-4,-3,-2,0,0,-2,-4,1,1,-1,-9,-5,
				    9,-9,-9,-8,-6,-5,-4,-9,-10,-9,-7,-5,-9,-5,-1,-5,-4,-11,-2,
				    6,3,-10,-1,-1,-5,-2,-8,-7,3,-4,0,-6,-1,-2,-5,-10,-7,
				    6,-9,-2,-2,-4,-2,-6,-4,0,-3,2,-5,-2,-3,-4,-11,-6,
				    8,-7,-4,0,-9,-1,-2,-6,-7,-9,-7,-4,-6,-5,-2,4,
				    6,-6,-6,-5,-7,-6,-1,-3,-4,-6,0,-3,-3,-10,-9,
				    8,-6,-3,-4,-6,1,2,2,0,3,-4,-4,-5,-1,
				    7,-4,1,1,-3,-5,-5,-3,-4,-1,3,-9,-4,
				    6,-5,0,0,-4,-1,2,-2,-1,-6,-7,-7,
				    6,2,-5,-5,-3,-6,-6,-4,0,-4,-4,
				    10,-5,-5,-2,-2,-3,-2,0,-8,-7,
				    6,-3,-1,-3,1,0,-5,-6,-3,
				    7,-1,-2,0,-2,-3,-9,-9,
				    7,0,-3,-3,-4,-8,-8,
				    8,-1,-4,-5,0,-7,
				    5,2,-3,-3,-5,
				    6,-1,-8,-4,
				    6,-10,-5,
                    13,-3,
				    9};
	    for (int i=0; i<AA.length; i++) {
		    PAM70.put(AA[i], scores[i]);
	}
	    return PAM70;
	
}

	
	public Map<String, Integer> getBLOSUM80(){
		Map<String, Integer> BLOSUM80 = new HashMap<String, Integer>();
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
		int [] scores = {7,-1,-3,-2,-4,0,-3,-3,-1,-3,-2,-3,-1,-2,-3,2,0,-1,-5,-4,
				13,-3,-7,-4,-6,-7,-2,-6,-3,-3,-5,-6,-5,-6,-1,-2,-2,-5,-2,
				6,2,-3,-1,-1,-3,-1,-4,-3,1,-1,0,-2,0,-1,-3,-4,-3,
				9,2,-6,-2,-7,-2,-7,-6,2,-3,-1,-3,-1,-2,-2,-3,-2,
				12,-6,-2,-1,0,-6,0,-6,-4,-3,-3,-4,-2,-2,0,4,
				7,-2,-4,-2,-4,-3,0,-2,-2,-2,0,-2,-3,-2,-3,
				8,-3,-1,-3,-2,1,-2,0,0,-1,-2,-3,-2,2,
				6,-3,2,1,-3,-3,-3,-3,-2,-1,3,-3,-1,
				9, -4,-4,-1,-3,-3,2,-3,-1,1,-3,-3,
				4,2,-3,-3,-2,-2,-2,-1,1,-2,-1,
				9,-4,0,-1,1,-1,0,-5,-7,-4,
				6,-2,0,0,1,0,-3,-4,-2,
				12,-3,-3,-2,-3,-4,-7,-6,
				9,1,-1,-1,-4,-4,-3,
				9,-2,-2,-4,-4,-5,
				7,2,-3,-6,-3,
				5,0,-5,-3,
				7,-5,-3,
				16,3,
				11};
		for (int i=0; i<AA.length; i++) {
			BLOSUM80.put(AA[i], scores[i]);
		}
		return BLOSUM80;
	}

	/**
	 * A function to get the scoring for each string in the matrices
	 * 
	 * @return a bash map between strings and integer objects
	 */

	
	public Map<String, Integer> getBLOSUM50(){
		Map<String, Integer> BLOSUM50 = new HashMap<String, Integer>();
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
		int [] scores = {5,-1,-2,-1,-3,0,-2,-1,-1,-2,-1,-1,-1,-1,-2,1,0,0,-3,-2,
				13,-4,-3,-2,-3,-3,-2,-3,-2,-2,-2,-4,-3,-2,-1,-1,-1,-5,-3,
				8,2,-5,-1,-1,-4,-1,-4,-4,-4,2,-1,0,-2,0,-1,-4,-5,
				6,-3,0,0,-1,1,-3,-2,0,-1,2,0,0,-1,-1,-3,-3,
				8,-4,-1,0,-4,1,0,-4,-4,-4,-3,-3,-2,-1,1,4,
				6,-2,-4,-2,-4,-3,0,-2,-2,-2,0,-2,-3,-2,-3,
				8,-2,-4,-2,-4,0,-2,-2,-3,0,-2,-4,-3,-3,
				10,-4,0,-3,-1,1,-2,1,0,-1,-2,-4,-3,
				5,-3,2,-3,-3,-3,-3,-1,4,-2,-3,-1,
				6,-3,-2,-0,-1,2,-2,3,0,-1,-3,
				5,3,-4,-4,-3,-3,-1,1,-2,-1,
				7,-2,-3,0,-2,0,-2,-1,1,
				7,-2,0,-1,1,0,-3,-4,
				7,1,0,-1,-3,-1,-1,
				7,-1,-1,-3,-3,-1,
				5,2,-2,-4,-2,
				5,0,-3,-2,
				5,-3,-1,
				15,2,
				8};
		for (int i=0; i<AA.length; i++) {
			BLOSUM50.put(AA[i], scores[i]);
		}
		return BLOSUM50;
	}


        /**
	 * A function to get the scoring for each string in the matrices
	 * 
	 * @return a bash map between strings and integer objects
	 */



    public Map<String, Integer> getBLOSUM62(){
		Map<String, Integer> BLOSUM62 = new HashMap<String, Integer>();
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
		int [] scores = {4,0,-2,-1,-2,0,-2,-1,-1,-1,-1,-2,-1,-1,-1,1,0,0,-3,-2,
				9,-3,-4,-2,-3,-3,-1,-3,-1,-1,-3,-3,-3,-3,-1,-1,-1,-2,-2,
				6,2,-3,-1,-1,-3,-1,-4,-3,1,-1,0,-2,0,-1,-3,-4,-3,
				5,-3,-2,0,-3,1,-3,-2,0,-1,2,0,0,-1,-2,-3,-2,
				6,-3,-1,0,-3,0,0,-3,-4,-3,-3,-2,-2,-1,1,3,
				6,-2,-4,-2,-4,-3,0,-2,-2,-2,0,-2,-3,-2,-3,
				8,-3,-1,-3,-2,1,-2,0,0,-1,-2,-3,-2,2,
				4,-3,2,1,-3,-3,-3,-3,-2,-1,3,-3,-1,
				5, -2,-1,0,-1,1,2,0,-1,-2,-3,-2,
				4,2,-3,-3,-2,-2,-2,-1,1,-2,-1,
				5,-2,-2,0,-1,-1,-1,1,-1,-1,
				6,-2,0,0,1,0,-3,-4,-2,
				7,-1,-2,-1,-1,-2,-4,-3,
				5,1,0,-1,-2,-2,-1,
				5,-1,-1,-3,-3,-2,
				4,1,-2,-3,-2,
				5,0,-2,-2,
				4,-3,-1,
				11,2,
				7};
		for (int i=0; i<AA.length; i++) {
			BLOSUM62.put(AA[i], scores[i]);
		}
		return BLOSUM62;
	}
}
