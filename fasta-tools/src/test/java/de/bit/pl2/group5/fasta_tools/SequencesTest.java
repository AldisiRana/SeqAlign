package de.bit.pl2.group5.fasta_tools;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class SequencesTest 
    extends TestCase
{
	public void testSequences() throws IOException {
		File file = new File("src/test/resources/test.fasta");
        assertTrue(file.exists());
		Sequences test = new Sequences();
		test.setSequences(file);
		assertNotNull(test.getSequences());
		assertNotSame(test.getSequences().size(), 1);
		assertEquals(test.getSequences().get(0).getHeader(), ">_45");
		//check for presence of sequences
	}
	
	@Test(expected = java.io.IOException.class)
	public void testFasta() {
		File file = new File("src/test/resources/test_notfasta.txt");
		Sequences test = new Sequences();
		try {
			test.readFasta(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
		
}
