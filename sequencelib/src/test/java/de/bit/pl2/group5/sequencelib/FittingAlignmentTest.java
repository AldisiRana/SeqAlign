package de.bit.pl2.group5.sequencelib;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FittingAlignmentTest {
	 @Test
	    public void checkFittingAlignment(){
	    	FittingAlignment test = new FittingAlignment();

	    	try {
				test.setSequences(new File("src/test/resources/test.fasta"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	test.setAlignmentResults(1, 1);
	    	assertEquals(test.getScore(), 1);
	    }
}
