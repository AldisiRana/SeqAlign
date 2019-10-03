package de.bit.pl2.group5.cl_interface;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import de.bit.pl2.group5.sequencelib.AffineGapAlignment;
import de.bit.pl2.group5.sequencelib.FittingAlignment;
import de.bit.pl2.group5.sequencelib.GlobalAlignment;
import de.bit.pl2.group5.sequencelib.LocalAlignment;
import de.bit.pl2.group5.sequencelib.OverlapAlignment;
import de.bit.pl2.group5.sequencelib.ScoringMatrices;
import de.bit.pl2.group5.sequencelib.SemiglobalAlignment;

/**
 * This is a class that implements a commandline interface for the sequence alignment library
 *
 *@author Rana Aldisi
 *@version 1.0
 */
public class CommandLine 
{
	final CLIParameters parameters = new CLIParameters();
	private JCommander jcommander = new JCommander(parameters);
	
	GlobalCommand global = new GlobalCommand();
	LocalCommand local = new LocalCommand();
	AffineGapCommand affine = new AffineGapCommand();
	FittingCommand fitting = new FittingCommand();
	OverlapCommand overlap = new OverlapCommand();
	SemiglobalCommand semiglobal = new SemiglobalCommand();
	private Map<String, Integer> scoringMatrix;
	
	enum alignmentType {
		GLOBAL,
		LOCAL,
		SEMIGLOBAL,
		AFFINEGAP,
		OVERLAP,
		FITTING;
	}
	
	enum Matrix{
		BLOSUM62,
		PAM250,
		PAM120,
		BLOSUM80,
		PAM30,
		BLOSUM50;
	}
	/**
	 * This main method gets the commandline arguments then run the program to get results
	 * @param args a list of arguments depending on the type of alignment
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		CommandLine cl = new CommandLine();
		cl.handleInputArgs(args);
		cl.run();
	}
	
	/**
	 * This method parses the commandline arguments
	 * @param args
	 * @exception ParameterException
	 */
	void handleInputArgs(String[] args) {
		jcommander.addCommand("Global", global);
		jcommander.addCommand("Local", local);
		jcommander.addCommand("Fitting", fitting);
		jcommander.addCommand("AffineGap", affine);
		jcommander.addCommand("Overlap", overlap);
		jcommander.addCommand("Semiglobal", semiglobal);
				
		try {
			jcommander.parse(args);
		} catch (ParameterException ex) {
			System.out.println(ex.getMessage());
			showUsage(jcommander);
		}
		
		if(parameters.isHelp()) {
			showUsage(jcommander);
		}
	}
	
	/**
	 * This function shows the usage of the commandline before exiting
	 * @param jcommander
	 */
	void showUsage(JCommander jcommander) {
		jcommander.usage();
		System.exit(0);
	}
	
	/**
	 * This method uses the parsed parameters to get the alignment results and print them to the commandline 
	 * @throws IOException
	 */
	void run() throws IOException {
		File fasta = parameters.getFasta();
		List<String> matrix = parameters.getScoringMatrix();
		scoringMatrix = new HashMap<String, Integer>();
		
		int gap;
		int mismatch;
		
		System.out.println("Your Alignment results :");
		
		int score = 0;
		String seq01 = null;
		String seq02 = null;
		String connect = null;
		
		if (matrix.size() <= 1) {
			switch(Matrix.valueOf(matrix.get(0))) {
			case PAM250:
				scoringMatrix = new ScoringMatrices().getPAM250();
				break;
			case BLOSUM62:
				scoringMatrix = new ScoringMatrices().getBLOSUM62();
				break;
			case BLOSUM80:
				scoringMatrix = new ScoringMatrices().getBLOSUM80();
				break;
			case PAM120:
				scoringMatrix = new ScoringMatrices().getPAM120();
				break;
			case BLOSUM50:
				scoringMatrix = new ScoringMatrices().getBLOSUM50();
				break;
			case PAM30:
				scoringMatrix = new ScoringMatrices().getPAM30();
				break;
			default:
				break;
			}
		}
		else if (matrix.isEmpty()){
			scoringMatrix = new ScoringMatrices().getBLOSUM62();
		}
		else {
			int i=0;
			while(i<matrix.size()-2){
				if (isNumber(matrix.get(i+1)))
					scoringMatrix.put(matrix.get(i), Integer.parseInt(matrix.get(i+1)));
				i=i+2;
			}		
		}

		
		switch(alignmentType.valueOf(jcommander.getParsedCommand().toUpperCase())) {
		case GLOBAL:
			gap = global.getGap();
			GlobalAlignment ga = new GlobalAlignment();
			ga.setSequences(fasta);
			ga.setAlignmentResults(gap, scoringMatrix);
			score = ga.getScore();
			seq01 = ga.getFinalSeq01();
			seq02 = ga.getFinalSeq02();
			connect = ga.getConnectionSeq();
			break;
			
		case LOCAL:
			gap = local.getGap();
			LocalAlignment la = new LocalAlignment();
			la.setSequences(fasta);
			la.setAlignmentResults(gap, scoringMatrix);
			score = la.getScore();
			seq01 = la.getFinalSeq01();
			seq02 = la.getFinalSeq02();
			connect = la.getConnectionSeq();

			break;
			
		case AFFINEGAP:
			gap = affine.getGap();
			AffineGapAlignment aa = new AffineGapAlignment();
			aa.setSequences(fasta);
			aa.setAlignmentResults(gap, scoringMatrix);
			score = aa.getScore();
			seq01 = aa.getFinalSeq01();
			seq02 = aa.getFinalSeq02();
			connect = aa.getConnectionSeq();
			break;
			
		case OVERLAP:
			gap = overlap.getGap();
			mismatch = overlap.getMismatch();
			OverlapAlignment oa = new OverlapAlignment();
			oa.setSequences(fasta);
			oa.setAlignmentResults(mismatch, gap);
			score = oa.getScore();
			seq01 = oa.getFinalSeq01();
			seq02 = oa.getFinalSeq02();
			connect = oa.getConnectionSeq();
			break;
			
		case FITTING:
			gap = fitting.getGap();
			mismatch = fitting.getMismatch();
			FittingAlignment fa = new FittingAlignment();
			fa.setSequences(fasta);
			fa.setAlignmentResults(mismatch, gap);
			score = fa.getScore();
			seq01 = fa.getFinalSeq01();
			seq02 = fa.getFinalSeq02();
			connect = fa.getConnectionSeq();
			break;
			
		case SEMIGLOBAL:
			gap = semiglobal.getGap();
			mismatch = semiglobal.getMismatch();
			SemiglobalAlignment sa = new SemiglobalAlignment();
			sa.setSequences(fasta);
			sa.setAlignmentResults(mismatch, gap);
			score = sa.getScore();
			seq01 = sa.getFinalSeq01();
			seq02 = sa.getFinalSeq02();
			connect = sa.getConnectionSeq();
			break;
			
		default:
			System.out.println("You need to choose a valid type of alignment");
			showUsage(jcommander);
		}
		System.out.println("Optimal Sequence Alignment Score = " +score);
		System.out.println(seq01);
		System.out.println(connect);
		System.out.println(seq02);
	}
	
	/**
	 * This function checks of the String is a number
	 * @param str a String that needs to be checked
	 * @return boolean, true if its a number, false if it is not
	 */
	public static boolean isNumber(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}
