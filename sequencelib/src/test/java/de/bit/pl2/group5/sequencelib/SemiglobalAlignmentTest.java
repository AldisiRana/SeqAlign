package de.bit.pl2.group5.sequencelib;

import static org.junit.Assert.assertNotSame;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class SemiglobalAlignmentTest {
	 @Test
	    public void checkSemiglobal(){
	    	SemiglobalAlignment test01 = new SemiglobalAlignment();
	    	SemiglobalAlignment test02 = new SemiglobalAlignment();

	    	try {
				test01.setSequences(new File("src/test/resources/test.fasta"));
				test02.setSequences(new File("src/test/resources/test.fasta"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	test01.setAlignmentResults(1, 2);
	    	test02.setAlignmentResults(3, 10);
	    	assertNotSame(test01.getScore(), test02.getScore());
	    }

}
