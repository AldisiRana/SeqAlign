package de.bit.pl2.group5.sequencelib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.Test;

public class AffineGapTest {
	@Test
    public void checkAffineGap(){
    	AffineGapAlignment test = new AffineGapAlignment();
    	AffineGapAlignment test02 = new AffineGapAlignment();
    	try {
			test.setSequences(new File("src/test/resources/test.fasta"));
			test02.setSequences(new File("src/test/resources/test.fasta"));
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	Map<String, Integer> BLOSUM62 = new ScoringMatrices().getBLOSUM62();
    	test.setAlignmentResults(10, BLOSUM62);
    	test02.setAlignmentResults(1, BLOSUM62);
    	assertEquals(test.getScore(), 15);
    	assertEquals(test02.getScore(), 15);
    	//assertNotSame(test.getScore(), test02.getScore());
    }

}
