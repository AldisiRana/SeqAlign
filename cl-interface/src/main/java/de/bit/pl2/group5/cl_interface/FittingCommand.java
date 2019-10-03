package de.bit.pl2.group5.cl_interface;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=", commandDescription = "Fitting Alignment")
public class FittingCommand {
	@Parameter(names = {"--gap","-g"},
			description = "input the penality of a gap in the alignment")
	private int gap = 1;
	
	@Parameter(names = {"--mismatch","-m"},
			description = "input the penality of a mismatch in the alignment")
	private int mismatch = 1;
	
	public int getGap() {
		return gap;
	}
	public int getMismatch() {
		return mismatch;
	}
}
