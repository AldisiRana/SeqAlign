package de.bit.pl2.group5.cl_interface;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=", commandDescription = "Affine Gap Alignment")
public class AffineGapCommand {

	@Parameter(names = {"--gap","-g"},
			description = "input the penality of a gap in the alignment")
	private int gap = 10;
	
	public int getGap() {
		return gap;
	}
}
