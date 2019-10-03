package de.bit.pl2.group5.sequencelib;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class AlignmentTest {

	@Test
    public void checkAlignmentSettings(){
    	Alignment test = new Alignment();
    	int score = 1;
    	test.setScore(score);
    	String finalSeq01 = "AACC";
    	test.setFinalSeq01(finalSeq01);
    	try {
			test.setSequences(new File("src/test/resources/test.fasta"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	assertEquals(score, test.getScore());
    	assertEquals(test.getFinalSeq01(), finalSeq01);
    }
    
	@Test(expected = IOException.class)
    public void testFasta() throws IOException{
    	Alignment test = new Alignment();
		test.setSequences(new File("src/test/resources/test_notfasta.txt"));
    }
}
