package de.bit.pl2.group5.sequencelib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class OverlapAlignmentTest {

	@Test
    public void checkOverlap(){
    	OverlapAlignment test = new OverlapAlignment();
    	try {
			test.setSequences(new File("src/test/resources/test.fasta"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	test.setAlignmentResults(3, 5);
    	assertEquals(test.getScore(), -3);
    }
}
