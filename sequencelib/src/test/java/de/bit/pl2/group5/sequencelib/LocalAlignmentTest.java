package de.bit.pl2.group5.sequencelib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.Test;

public class LocalAlignmentTest {
	
	@Test
    public void checkLocalAlignment(){
    	LocalAlignment test = new LocalAlignment();
    	LocalAlignment test02 = new LocalAlignment();
    	Map<String, Integer> PAM250 = new ScoringMatrices().getPAM250();
    	Map<String, Integer> PAM30 = new ScoringMatrices().getPAM30();
    	try {
			test.setSequences(new File("src/test/resources/test.fasta"));
			test02.setSequences(new File("src/test/resources/test.fasta"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	test.setAlignmentResults(1, PAM250);
    	test02.setAlignmentResults(1, PAM30);
    	assertEquals(test.getScore(), 15);
    	assertNotSame(test.getScore(), test02.getScore());
    }

}
