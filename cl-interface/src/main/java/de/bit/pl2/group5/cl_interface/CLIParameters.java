package de.bit.pl2.group5.cl_interface;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.converters.FileConverter;

/**
 * This class contains the main parameters that are used by all or most alignments
 * @author Rana Aldisi
 * @version 1.0
 *
 */

@Parameters(separators = "=")
public class CLIParameters {
	@Parameter(names={"--FastaFile", "-F"}, 
			converter = FileConverter.class, 
			description = "The path to the fasta file with the sequences", 
			validateWith = FileParameterValidator.class,
			required = true)
	private File fasta;
	
	@Parameter(names = {"--scoringMatrix","-s"}, variableArity = true, 
			description = "Write the name of a popular scoring matrix,"
					+ "alternatively, you can input letter pairs with their score (e.g AA 1)"
					+ " (only applied on global, local and affine gap alignments)")
	public List<String> scoringMatrix = new ArrayList<String>();
	
	@Parameter(names = {"--help","-H"}, 
			help = true, 
			description = "Display help information")
	private boolean help;
	
	public boolean isHelp() {
        return help;
    }
	
	public File getFasta() {
		return fasta;
	}
	
	public List<String> getScoringMatrix() {
		return scoringMatrix;
	}
}
