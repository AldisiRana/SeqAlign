package de.bit.pl2.group5.fasta_tools;

import junit.framework.TestCase;

public class SequenceTest extends TestCase {
	public void testSequence(){
	     Sequence test = new Sequence();
	     test.setSequence("AATTCC");
	     test.setSeqLength(test.getSequence().length());
	     assertEquals(test.getSequence(), "AATTCC");
	     assertEquals(test.getSeqLength(), 6);
	   }
}
